package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class delux_delhi_book extends AppCompatActivity {

    Dialog myDialog;

    ViewPager viewPager;
    int images[]={R.drawable.delux_delhi_bath1,R.drawable.delux_delhi_food,R.drawable.delhi_delux_dining1,R.drawable.delux_delhi_view};
    int currentPageCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delux_delhi_book);
        myDialog = new Dialog(this);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new SliderAdapter(images,delux_delhi_book.this));

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(currentPageCounter == images.length){

                    currentPageCounter = 0;

                }
                viewPager.setCurrentItem(currentPageCounter++,true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.postAtTime(runnable,2500);
            }
        },2500,2500);



    }

    public void showPopUp(View view){

        TextView txtclose;
        myDialog.setContentView(R.layout.custompopup);
        txtclose=myDialog.findViewById(R.id.txtclose);
        Button btn1 = myDialog.findViewById(R.id.btn1);
        Button btn2 = myDialog.findViewById(R.id.btn2);
        Button btn3 = myDialog.findViewById(R.id.btn3);
        Button btn4 = myDialog.findViewById(R.id.btn4);
        Button btn5 = myDialog.findViewById(R.id.btn5);
        Button btn6 = myDialog.findViewById(R.id.btn6);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



//                if(btn1.isEnabled()){
//                    btn1.setBackgroundResource(R.drawable.change_bg_on_click);
//                    btn1.setTextColor(Color.parseColor("#FFFFFF"));
//                }
                if(btn1.isPressed()){
                    btn1.setBackgroundResource(R.drawable.change_bg_on_click);
                    btn1.setTextColor(Color.parseColor("#FFFFFF"));
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setBackgroundResource(R.drawable.change_bg_on_click);
                btn2.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn3.setBackgroundResource(R.drawable.change_bg_on_click);
                btn3.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn4.setBackgroundResource(R.drawable.change_bg_on_click);
                btn4.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn5.setBackgroundResource(R.drawable.change_bg_on_click);
                btn5.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn6.setBackgroundResource(R.drawable.change_bg_on_click);
                btn6.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });
    }
}