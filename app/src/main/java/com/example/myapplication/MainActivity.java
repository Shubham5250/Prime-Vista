package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View view){
        Intent intent = new Intent(this,login.class);
        startActivity(intent);

    }




    public void locations(View view){
        Intent intent = new Intent(this,location_hotels.class);
        startActivity(intent);
        Animatoo.INSTANCE.animateSplit(this);
    }
}

