package com.example.test.lab3_1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        registerForContextMenu(btn);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.add(0, 0, 0, "RED");
        menu.add(0, 1, 1, "GREEN");
        menu.add(0, 2, 2, "BLUE");
    }
    @Override
    public boolean onContextItemSelected (MenuItem item){
        switch (item.getItemId()){
            case 0:
                btn.setTextColor(Color.RED);
                break;
            case 1:
                btn.setTextColor(Color.GREEN);
                break;
            case 2:
                btn.setTextColor(Color.BLUE);
                break;
        }
        return true;
    }
}