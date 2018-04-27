package com.example.test.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btnRegister;
    EditText name;
    RadioButton rb1;
    RadioButton rb2;
    CheckBox cb1;
    CheckBox cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = findViewById(R.id.btn_reg);
        rb1 = findViewById(R.id.radio1);
        rb2 = findViewById(R.id.radio2);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        name = findViewById(R.id.editText1);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("NAME", name.getText().toString());
                if(rb1.isChecked()){
                    intent.putExtra("SEX", "남");
                }else if(rb2.isChecked()){
                    intent.putExtra("SEX", "여");
                }
                intent.putExtra("SMS",rb1.isChecked());
                intent.putExtra("EMAIL",rb2.isChecked());
                startActivity(intent);
            }
        });
    }
}
