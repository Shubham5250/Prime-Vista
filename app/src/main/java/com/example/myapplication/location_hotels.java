package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class location_hotels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_hotels);


    }

    public void goaRooms(View view){
        Intent intent = new Intent(this,goa_room_booking.class);
        startActivity(intent);

    }
}