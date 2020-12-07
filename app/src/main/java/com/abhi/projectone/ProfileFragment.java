package com.abhi.projectone;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {
    ImageView imageView;
    TextView et1,et2,et3;
    CardView card2,card4,card6,card7,card8;
    String SHARED_PREFS ="sharedPrefs";
    String SHARED_PREFS2 ="sharedPrefs2";
    String SHARED_PREFS3 ="sharedPrefs3";
    String userName="";
    String getUserName;
    String userEmail="";
    String getUserEmail;
    String userNumber="";
    String getUserNumber;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile,container, false);
        imageView =v.findViewById(R.id.profile_image);
        card2=v.findViewById(R.id.card2);
        card4=v.findViewById(R.id.card4);
        card6=v.findViewById(R.id.card6);
        card7=v.findViewById(R.id.card7);
        card8=v.findViewById(R.id.card8);
        et1=v.findViewById(R.id.tv_name);
        et2=v.findViewById(R.id.tv_email);
        et3=v.findViewById(R.id.tv_num);
        card2.setOnClickListener(this);
        card4.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);
        String feedback ="https://play.google.com/store/apps/details?id=com.abhi.projectone";
        loadData();
        updateData();
        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card2:
                String feedback="https://play.google.com/store/apps/details?id=com.abhi.projectone";
                Intent i2= new Intent(Intent.ACTION_VIEW);i2.setData(Uri.parse(feedback));
                startActivity(i2);break;
            case R.id.card4:
//                Intent shareIntent =new Intent();
//                shareIntent.setAction(Intent.ACTION_SEND);
//                shareIntent.putExtra(Intent.EXTRA_TEXT,"Hey!! Check out the Maximo app at :https://play.google.com/store/apps/details?id=com.abhi.projectone");
//                shareIntent.setType("text/plain");
//                startActivity(shareIntent);break;
                Intent shareIntent =   new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Spread the love by sharing Maximo");
                String app_url = "https://play.google.com/store/apps/details?id=com.abhi.projectone";
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
                break;
            case R.id.card7:
                Intent i7= new Intent(getActivity(),DeveloperActivity.class);
                startActivity(i7);break;
            case R.id.card6:
                String urlone="https://abhiflashpoint.blogspot.com/p/privacy-policy-effective-date-january-1.html";
                Intent i6= new Intent(Intent.ACTION_VIEW);i6.setData(Uri.parse(urlone));
                startActivity(i6);break;
            case R.id.card8:
                Intent i8=new Intent(getActivity(),EditProfile.class);
                startActivity(i8);break;
//

        }

    }
    public void loadData(){
        SharedPreferences sharedPreferences =this.getActivity().getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        getUserName=sharedPreferences.getString(userName,"");
        SharedPreferences sharedPreferencesII =this.getActivity().getSharedPreferences(SHARED_PREFS2,MODE_PRIVATE);
        getUserEmail=sharedPreferencesII.getString(userEmail,"");
        SharedPreferences sharedPreferencesIII=this.getActivity().getSharedPreferences(SHARED_PREFS3,MODE_PRIVATE);
        getUserNumber=sharedPreferencesIII.getString(userNumber,"");
    }
    public void updateData(){
        et1.setText(getUserName);
        et2.setText(getUserEmail);
        et3.setText(getUserNumber);

    }
}
