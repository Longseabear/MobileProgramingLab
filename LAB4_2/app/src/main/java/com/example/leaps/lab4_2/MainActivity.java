package com.example.leaps.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout line;
    boolean on;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        line = findViewById(R.id.line2);
        on = false;

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(on){
                    on = false;
                    Animation anim = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.right);
                    line.startAnimation(anim);
                    line.setVisibility(View.INVISIBLE);

                    btn.setText("OPEN SLIDE");
                }else{
                    on = true;
                    Animation anim = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.left);
                    line.setVisibility(View.VISIBLE);
                    line.startAnimation(anim);
                    btn.setText("CLOSE SLIDE");
                }
            }
        });
    }
}
