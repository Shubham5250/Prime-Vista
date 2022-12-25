package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
    public void createAccount(View view){
        Intent intent = new Intent(this, create_account.class);
        startActivity(intent);
    }

    public void locations(View view){
        Intent intent = new Intent(this,location_hotels.class);
        startActivity(intent);
    }
}