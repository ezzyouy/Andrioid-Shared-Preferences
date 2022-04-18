package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     SharedPreferences sharedPreferences;
     TextView name;
     TextView email;
     public static  final String mypreference="mypref";
     public static final String Name="nameKey";
    public static final String Email="emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= findViewById(R.id.etName);
        email= findViewById(R.id.etEmail);

        sharedPreferences=getSharedPreferences("mypref", MODE_PRIVATE);
        if(sharedPreferences.contains(Name)){
            name.setText(sharedPreferences.getString(Name,""));
        }
        if(sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email,""));
        }
    }
    public void Save(View view){
        String n=name.getText().toString();
        String e=email.getText().toString();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.commit();
    }
    public void clear(View view){
        name= findViewById(R.id.etName);
        email= findViewById(R.id.etEmail);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.remove("nameKey");
        editor.remove("emailKey");
        editor.commit();
        name.setText("");
        email.setText("");
    }

    public void Get(View view){
        name= findViewById(R.id.etName);
        email= findViewById(R.id.etEmail);
        sharedPreferences=getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Name)){
            name.setText(sharedPreferences.getString(Name,""));
        }
        if(sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email,""));
    }
    }
}