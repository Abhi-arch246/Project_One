package com.abhi.projectone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    ImageView img2;
    TextView title2,desc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        img2=findViewById(R.id.img2);
        title2=findViewById(R.id.title2);
        desc2=findViewById(R.id.desc2);

        String image =getIntent().getStringExtra("detail_img");
        String title=getIntent().getStringExtra("detail_title");
        String desc=getIntent().getStringExtra("detail_desc");

        title2.setText(title);
        desc2.setText(desc);
        Picasso.get().load(image).into(img2);

    }
}
