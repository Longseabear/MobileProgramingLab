package com.example.leaps.lab6_3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button bt1, bt2, bt3;
    EditText ed1, ed2;
    ListView lv;
    List<String> list = new ArrayList<>();

    Context context;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.btn1);
        bt2 = findViewById(R.id.btn2);

        ed1 = findViewById(R.id.dt1);
        ed2 = findViewById(R.id.dt2);

        lv = findViewById(R.id.list_view);


        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        lv.setAdapter(adapter);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("") || ed2.getText().toString().equals("") ){
                    Toast.makeText(getApplicationContext(),"모든 항목을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                list.add(ed1.getText().toString() + " " + ed2.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                for(String str : list){
                    String name = str.split(" ")[0];
                    if(name.equals(ed1.getText().toString())){
                        list.remove(str);
                        adapter.notifyDataSetChanged();
                        return;
                    }
                }

            }
        });
    }
}
