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

public class SliderAdapter extends PagerAdapter {

    int images[];
    LayoutInflater layoutInflater;
    Context context;
    public SliderAdapter(int[] images, Context context)  {
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



            View myImageLayout = layoutInflater.inflate(R.layout.item_delux_delhi,container,false);
            ImageView imageView = myImageLayout.findViewById(R.id.imageViewMain);


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
