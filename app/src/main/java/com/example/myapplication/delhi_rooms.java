package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class delhi_rooms extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi_rooms);


    }


    public void delux_delhi_book_room(View view){
        Intent intent = new Intent(this,delux_delhi_book.class);
        startActivity(intent);
        Animatoo.INSTANCE.animateZoom(this);

    }
    public void pemier_delhi_book(View view){
        Intent intent = new Intent(this,pemier_delhi_book.class);
        startActivity(intent);
        Animatoo.INSTANCE.animateZoom(this);

    }


}