package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class user_profile extends AppCompatActivity {


    TextView inputSetName,inputSetEmail;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        inputSetName =findViewById(R.id.inputSetText);
        inputSetEmail = findViewById(R.id.setEmail);

        Intent i = getIntent();

        String name = i.getStringExtra(registration.EXTRA_NAME);
        String email = i.getStringExtra(registration.EXTRA_EMAIL);

        inputSetName.setText("Hello, "+name);
        inputSetEmail.setText("Email: "+email);

    }
}