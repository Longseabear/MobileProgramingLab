package com.example.leaps.mobileprogramingtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    int imageIndex = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization object
        imageView = (ImageView)findViewById(R.id.view1);
        imageView2 = (ImageView)findViewById(R.id.view2);

        //First visibility setting
        imageView.setVisibility(View.INVISIBLE);
    }
    public void onButton1Clicked(View v){
        changeImage();
    }
    private void changeImage()
    {
        // image index change
        if(imageIndex==1){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
        }else{
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
        }
        imageIndex = imageIndex*-1;
    }
}
