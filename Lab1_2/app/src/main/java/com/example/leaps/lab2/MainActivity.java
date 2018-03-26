package com.example.leaps.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText edit_name;
    public Button btn_clear;
    public Button btn_print;
    public TextView view_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        // Initialization all view object
        btn_clear = (Button)findViewById(R.id.bc);
        btn_print = (Button)findViewById(R.id.bp);
        view_print = (TextView)findViewById(R.id.res);
        edit_name = (EditText)findViewById(R.id.et);
    }
    public void clearClicked(View v){
        edit_name.setText("");
        view_print.setText("contents"); // reinitialization
    }
    public void printClicked(View v){
        String text="";
        text = edit_name.getText().toString();
        view_print.setText(text);
    }
}
