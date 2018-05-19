package com.example.leaps.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tv2;
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.bt);
        e = findViewById(R.id.id_str);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("");
                new Task(Integer.parseInt(e.getText().toString())).execute();
            }
        });

        tv = findViewById(R.id.tv);
        tv2 = findViewById(R.id.tv2);
    }


    protected class Task extends AsyncTask<Void,Integer,Void>{
        int n = 0;
        long fact = 1;

        String str;
        public Task(int v){
            n = v;
        }
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            for(int i=n;i>=1;i--){
                fact *= i;
                publishProgress(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tv.append(""+values[0]+ " ");
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            tv2.setText("=\t"+fact+ " ");
        }
    }
}
