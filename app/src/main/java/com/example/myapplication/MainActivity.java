package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(registration.PREF_NAME,0);
                boolean hasRegistered = sharedPreferences.getBoolean("hasRegistered",false);


                Intent i;
                if(hasRegistered){

                    i = new Intent(MainActivity.this, location_hotels.class);

                }
                else{
                    i = new Intent(MainActivity.this, registration.class);
                }
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(login.PREFS_NAME,0);
                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn",false);


                Intent i;
                if(hasLoggedIn){

                    i = new Intent(MainActivity.this, location_hotels.class);

                }
                else{
                    i = new Intent(MainActivity.this, login.class);
                }
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);


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

