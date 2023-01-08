package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class pemier_delhi_book extends AppCompatActivity {

    Dialog myDialog2;
    ViewPager viewPager2;
    int images2[] = {R.drawable.premier_1,R.drawable.premier_2,R.drawable.premier_3,R.drawable.premier_4};
    int currentPagerCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemier_delhi_book);

        myDialog2 = new Dialog(this);
        viewPager2 = findViewById(R.id.viewpager2);
        viewPager2.setAdapter(new Slideradapter_premier_delhi(images2,pemier_delhi_book.this));

        final Handler handler2 = new Handler();
        final Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                if(currentPagerCounter == images2.length){

                    currentPagerCounter = 0;

                }
                viewPager2.setCurrentItem(currentPagerCounter++,true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler2.postAtTime(runnable2,2500);
            }
        },2500,2500);
    }
}