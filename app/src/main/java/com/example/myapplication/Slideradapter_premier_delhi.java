package com.example.myapplication;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class Slideradapter_premier_delhi extends PagerAdapter {

    int[] images;
    LayoutInflater layoutInflater;
    Context context;
    public Slideradapter_premier_delhi(int[] images, Context context)  {
        this.images = images;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.length;
    }




    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {



        View myImageLayout = layoutInflater.inflate(R.layout.items_premier_delhi,container,false);
        ImageView imageView = myImageLayout.findViewById(R.id.img2);


        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            imageView.setImageDrawable(context.getDrawable(images[position]));
        }
        else{
            imageView.setImageDrawable(context.getResources().getDrawable(images[position]));
        }

        container.addView(myImageLayout);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
