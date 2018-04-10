package com.example.leaps.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextAge;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editText1);
        editTextAge = findViewById(R.id.editText2);

        btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);

                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();
                intent.putExtra("NAME",name);
                intent.putExtra("AGE",age);

                startActivity(intent);
            }
        });

    }
}
