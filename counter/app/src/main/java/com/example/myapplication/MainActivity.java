package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn_click(View view){
        int count;
        TextView output = (TextView) findViewById(R.id.textView);
        count = Integer.parseInt(output.getText().toString());
        count++;
        output.setText(Integer.toString(count));
    }
    public void btn_click_2(View view){
        TextView output = (TextView) findViewById(R.id.textView);
        output.setText(R.string.init_value);
    }

    public void btn_click_3(View view){

        TextView output = (TextView) findViewById(R.id.textView);
        count = Integer.parseInt(output.getText().toString());
        count--;
        output.setText(Integer.toString(count));
    }
}