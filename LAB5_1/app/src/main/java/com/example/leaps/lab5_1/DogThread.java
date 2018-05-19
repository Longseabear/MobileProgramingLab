package com.example.leaps.lab5_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.logging.Handler;

public class DogThread extends Thread{
    ArrayList<Bitmap> images = new ArrayList<Bitmap>();
    int stateIndex = 0;
    int dogIndex;
    android.os.Handler handler;
    ImageView iv;
    Context context;
    TextView ed;
    public DogThread(Context context, android.os.Handler h, int dogNum, ImageView iv, TextView ed){
        images.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.green));
        images.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.red));
        images.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.blue));

        handler = h;
        dogIndex = dogNum;

        this.iv = iv;
        this.context = context;
        this.ed = ed;
    }
    public int getRandomTime(int min, int max){
        return min+(int)(Math.random() * (max-min));
    }
    @Override
    public void run(){
        stateIndex = 0;
        for (int i=0;i<9;i++){
            final String msg = "dog #" + dogIndex + " state: " + stateIndex+"\n";
            handler.post(new Runnable() {
                @Override
                public void run() {
                    iv.setImageBitmap(images.get(stateIndex));
                    ed.append(msg);
                }
            });
            try{
                int sleepTime = getRandomTime(500,3000);
                Thread.sleep(sleepTime);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                stateIndex = (stateIndex+1)%3;
            }
        }
    }
}
