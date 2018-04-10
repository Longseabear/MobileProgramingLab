package com.example.leaps.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        if(intent!=null){
            String Name = intent.getStringExtra("NAME");
            String Age = intent.getStringExtra("AGE");

            Toast.makeText(getApplicationContext(),"Student info: "+Name+" "+Age,Toast.LENGTH_SHORT).show();
        }
        Button btn = findViewById(R.id.Button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
