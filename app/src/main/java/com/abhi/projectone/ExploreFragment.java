package com.abhi.projectone;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class ExploreFragment extends Fragment implements View.OnClickListener {
    ImageView exp1,exp2;
    CardView excard1,excard2;


    public ExploreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_explore, container, false);
        exp1=v.findViewById(R.id.expimg1);
        exp2=v.findViewById(R.id.expimg2);
        excard1=v.findViewById(R.id.excard1);
        excard2=v.findViewById(R.id.excard2);
        String url="https://i.ibb.co/b5tFCBR/undraw-source-code-xx2e.png";
        String url1="https://i.ibb.co/YcgL2XS/undraw-social-dashboard-k3pt.png";
        Picasso.get().load(url).into(exp1);
        Picasso.get().load(url1).into(exp2);
        excard1.setOnClickListener(this);
        excard2.setOnClickListener(this);
        return v;
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.excard1:
                Intent a=new Intent(getActivity(),Quotes.class);
                startActivity(a);break;
            case R.id.excard2:
                Intent b=new Intent(getActivity(),Facts.class);
                startActivity(b);break;
        }

    }

}
