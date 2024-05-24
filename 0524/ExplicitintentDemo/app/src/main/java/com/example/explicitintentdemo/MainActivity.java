package com.example.explicitintentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.explicitintentdemo.FActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtc = findViewById(R.id.txtC);
                int tempC = Integer.parseInt(txtc.getText().toString());
                EditText edtPlace = findViewById(R.id.txtC);
                Intent intent = new Intent(MainActivity.this, FActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("tempC", tempC);
                bundle.putString("place", edtPlace.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}