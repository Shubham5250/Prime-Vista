package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class delhi_rooms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi_rooms);
    }


    public void login(View view){
        Intent intent = new Intent(this,login.class);
        startActivity(intent);

    }
}