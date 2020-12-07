package com.abhi.projectone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class DeveloperActivity extends AppCompatActivity {
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        cardView=findViewById(R.id.insta);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.instagram.com/imabhi246/?hl=en";
                Intent i= new Intent(Intent.ACTION_VIEW);i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
