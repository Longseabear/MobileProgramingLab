package com.example.leaps.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button GoButton;
    Button BackButton;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent curIntent = getIntent();
        String content = curIntent.getStringExtra("URL").toString();

        textView = findViewById(R.id.TEXT_VIEWER);
        textView.setText(content);

        GoButton = findViewById(R.id.GoButton);
        BackButton = findViewById(R.id.BackButton);

        GoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+textView.getText().toString()));
                startActivity(intent);
            }
        });
        BackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
