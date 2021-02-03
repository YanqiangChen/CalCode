package com.example.myapplication.image;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;


public class ImageActivity extends Activity {
    private ImageView iv_image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        init();


    }
    public void init(){
        iv_image=findViewById(R.id.iv_image);
        Picasso.with(ImageActivity.this).load("https://cdn.journaldev.com/wp-content/uploads/2016/11/android-image-picker-project-structure.png").into(iv_image);

    }
}
