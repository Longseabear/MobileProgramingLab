package com.example.leaps.lab5_1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    TextView editText;
    Button button;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.iv1);
        imageView2 = findViewById(R.id.iv2);
        editText = findViewById(R.id.editText);
        button = (Button)findViewById(R.id.changeMove);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Thread a = new DogThread(getApplicationContext(), handler, 1, imageView1, editText);
                Thread b = new DogThread(getApplicationContext(), handler, 2, imageView2, editText);
                a.start();
                b.start();
            }
        });
    }
}
