package com.abhi.projectone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class EditProfile extends AppCompatActivity {
    ImageView mImg;
    EditText et1,et2,et3;
    Button btn_save,btn_cancel;
    String SHARED_PREFS ="sharedPrefs";
    String SHARED_PREFS2 ="sharedPrefs2";
    String SHARED_PREFS3 ="sharedPrefs3";
    String userName="";
    String getUserName;
    String userEmail="";
    String getUserEmail;
    String userNumber="";
    String getUserNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        mImg=findViewById(R.id.profile);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        btn_save=findViewById(R.id.btn_save);
        btn_cancel=findViewById(R.id.btn_cancel);
        String url="https://image.flaticon.com/icons/png/512/149/149071.png";
        Picasso.get().load(url).fit().into(mImg);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Data 1
                SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(userName,et1.getText().toString());
                editor.apply();
                //Data 2
                SharedPreferences sharedPreferencesII=getSharedPreferences(SHARED_PREFS2,MODE_PRIVATE);
                SharedPreferences.Editor editorII=sharedPreferencesII.edit();
                editorII.putString(userEmail,et2.getText().toString());
                editorII.apply();
                //Data 3
                SharedPreferences sharedPreferencesIII=getSharedPreferences(SHARED_PREFS3,MODE_PRIVATE);
                SharedPreferences.Editor editorIII=sharedPreferencesIII.edit();
                editorIII.putString(userNumber,et3.getText().toString());
                editorIII.apply();
                //Back to Fragment
                Intent x=new Intent(EditProfile.this,MainActivity.class);
                startActivity(x);

            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Back to Fragment
                Intent x=new Intent(EditProfile.this,MainActivity.class);
                startActivity(x);

            }
        });
        loadData();
        updateData();
    }

    public void loadData(){
        SharedPreferences sharedPreferences =getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        getUserName=sharedPreferences.getString(userName,"");
        SharedPreferences sharedPreferencesII =getSharedPreferences(SHARED_PREFS2,MODE_PRIVATE);
        getUserEmail=sharedPreferencesII.getString(userEmail,"");
        SharedPreferences sharedPreferencesIII=getSharedPreferences(SHARED_PREFS3,MODE_PRIVATE);
        getUserNumber=sharedPreferencesIII.getString(userNumber,"");
    }
    public void updateData(){
        et1.setText(getUserName);
        et2.setText(getUserEmail);
        et3.setText(getUserNumber);

    }
}
