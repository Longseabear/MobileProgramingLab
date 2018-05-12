package com.example.leaps.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView vm = new MyView(this);
        setContentView(vm);
    }
    protected static class MyView extends View {
        Paint pnt;
        Path path;
        float pivotX, pivotY;

        public MyView(Context context){
            super(context);
            path = new Path();

            pnt = new Paint();
            pnt.setColor(Color.BLUE);
            pnt.setStrokeWidth(20);
            pnt.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            canvas.drawPath(path, pnt);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                path.moveTo(event.getX(), event.getY());
            }
            if(event.getAction()==MotionEvent.ACTION_MOVE){
                path.lineTo(event.getX(), event.getY());
                invalidate();
            }
            return true;
        }
    }
}
