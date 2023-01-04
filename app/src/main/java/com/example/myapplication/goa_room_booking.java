package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class goa_room_booking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goa_room_booking);
        Animatoo.INSTANCE.animateSlideUp(this);

    }


    public void login(View view){
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
        Animatoo.INSTANCE.animateSlideUp(this);
    }
}