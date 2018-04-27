package com.example.test.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button btn_back;
    TextView tx1, tx2, tx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_back = findViewById(R.id.btn_back);
        tx1 = findViewById(R.id.textViewName);
        tx2 = findViewById(R.id.textViewSex);
        tx3 = findViewById(R.id.textViewSusinkk);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Bundle bundle = getIntent().getExtras();
        tx1.setText(bundle.getString("NAME"));
        tx2.setText(bundle.getString("SEX"));
        String str = (bundle.getBoolean("SMS")?"SMS":"") +(bundle.getBoolean("EMAIL")?" E-MAIL":"");
        tx3.setText(str);
    }
}
