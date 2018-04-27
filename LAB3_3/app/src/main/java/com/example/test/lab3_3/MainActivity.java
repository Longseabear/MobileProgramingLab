package com.example.test.lab3_3;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Fragment a,b;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TAG","START");
        b1 = findViewById(R.id.TAB1);
        b2 = findViewById(R.id.TAB2);

        a = new FirstFragment();
        b = new SecondFragmetn();
        getSupportFragmentManager().beginTransaction().add(new Fragment(),"FRAGMENT").commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, a).commit();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, a).commit();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, b).commit();
            }
        });
    }
}
