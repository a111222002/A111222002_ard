package com.example.ch5_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView output;
    private TextView button_out;
    private float size = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.lblOutput);
        output.setTextSize(size);

        Button btn = findViewById(R.id.button);
        Button btn3 = findViewById(R.id.button_out);
        Button btn2 = findViewById(R.id.button_small);

        btn.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            size++;
        } else if (view.getId()==R.id.button_small) {
            size--;
        }else if(view.getId()==R.id.button_out){
            finish();
        }
        output.setTextSize(size);
    }

}
