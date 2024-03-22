package com.example.ui_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LayoutDisplayStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        TextView txvShow = (TextView) findViewById(R.id.txvShow);
        Intent intent = getIntent();
        String userInput = intent.getStringExtra("userInput");
        txvShow.setText("HI: " + userInput+"您好");
    }
}