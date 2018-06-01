package com.example.leaps.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button bt1, bt2, bt3;
    EditText ed1, ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.btn1);
        bt2 = findViewById(R.id.btn2);
        bt3 = findViewById(R.id.btn3);

        ed1 = findViewById(R.id.dt1);
        ed2 = findViewById(R.id.dt2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putData();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
                ed2.setText("");

            }
        });
    }
    public void putData(){
        SharedPreferences sp = getSharedPreferences("LAB6", MODE_PRIVATE);
        SharedPreferences.Editor toEdit = sp.edit();
        toEdit.putString("ID", ed1.getText().toString());
        toEdit.putString("NAME", ed2.getText().toString());
        toEdit.commit();
    }
    public void getData(){
        SharedPreferences sp = getSharedPreferences("LAB6", MODE_PRIVATE);
        if(sp!=null && sp.contains("ID")){
            ed1.setText(sp.getString("ID", "NONE_ID"));
            ed2.setText(sp.getString("NAME", "NONE_NAME"));
        }
    }

}
