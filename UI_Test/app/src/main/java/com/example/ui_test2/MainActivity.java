package com.example.ui_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.EditText;

import com.example.ui_test2.LayoutDisplayStringActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendString(View view) {
        EditText edtInput = (EditText) findViewById(R.id.editName);
        String string2send = edtInput.getText().toString();

        Intent intent = new Intent(this, LayoutDisplayStringActivity.class);
        intent.putExtra("userInput", string2send);
        startActivity(intent);
    }
}