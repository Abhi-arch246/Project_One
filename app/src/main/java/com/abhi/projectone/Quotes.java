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

public class Quotes extends AppCompatActivity {
    private List<Modelq> modelqList;
    private RecyclerView recyclerView;
    private QuotesAdapter quotesAdapter;
    private ShimmerFrameLayout shimmerFrameLayout;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        recyclerView=findViewById(R.id.recyclerview);
        imageView=findViewById(R.id.back2);
        shimmerFrameLayout=findViewById(R.id.shimmer_view_container);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelqList=new ArrayList<>();
        shimmerFrameLayout.startShimmer();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Quotes.this,MainActivity.class);
                startActivity(i);
            }
        });
        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("Quotes");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        Modelq la=snapshot.getValue(Modelq.class);
                        modelqList.add(la);
                    }
                    quotesAdapter=new QuotesAdapter(modelqList,getApplicationContext());
                    recyclerView.setAdapter(quotesAdapter);
                    shimmerFrameLayout.stopShimmer();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
