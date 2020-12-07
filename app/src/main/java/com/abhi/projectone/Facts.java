package com.abhi.projectone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Facts extends AppCompatActivity {
    private List<Modelf> modelfList;
    private RecyclerView recyclerView;
    private FactsAdapter factsAdapter;
    private ShimmerFrameLayout shimmerFrameLayout;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);
        recyclerView=findViewById(R.id.recyclerview);
        imageView=findViewById(R.id.back1);
        shimmerFrameLayout=findViewById(R.id.shimmer_view_container);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelfList=new ArrayList<>();
        shimmerFrameLayout.startShimmer();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Facts.this,MainActivity.class);
                startActivity(i);
            }
        });
        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("Facts");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        Modelf la=snapshot.getValue(Modelf.class);
                        modelfList.add(la);
                    }
                    factsAdapter=new FactsAdapter(modelfList,getApplicationContext());
                    recyclerView.setAdapter(factsAdapter);
                    shimmerFrameLayout.stopShimmer();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
