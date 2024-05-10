package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnconfirm = findViewById(R.id.button);
        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] steak =getResources().getStringArray(R.array.steaks);
                // Get the selected item from the spinner
                Spinner spinner = findViewById(R.id.spinner);
                int index = spinner.getSelectedItemPosition();
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText("steak needs \n"+steak[index]);
                // Display the selected item in a toast

            }
        });
    }
}