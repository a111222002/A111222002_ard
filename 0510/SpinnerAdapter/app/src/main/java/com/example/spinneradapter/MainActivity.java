package com.example.spinneradapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private String[] courses,desserts;
    private Spinner spinnerCourse,spinnerDessert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses = getResources().getStringArray(R.array.courses);
        desserts = getResources().getStringArray(R.array.desserts);

        spinnerCourse = findViewById(R.id.spinner);
        spinnerDessert = findViewById(R.id.spinner2);

        ArrayAdapter<String> adapterCourse = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        ArrayAdapter<String> adapterDessert = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, desserts);

        spinnerCourse.setAdapter(adapterCourse);
        spinnerDessert.setAdapter(adapterDessert);

        Button btnconfirm = findViewById(R.id.button);

        btnconfirm = (Button) findViewById(R.id.button);
        btnconfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String course = spinnerCourse.getSelectedItem().toString();
                String dessert = spinnerDessert.getSelectedItem().toString();
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText("Course: " + course + "\nDessert: " + dessert);
            }
        });

        Button btnModify = findViewById(R.id.button2);
        btnModify.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                desserts[4]="草莓蛋糕";
                adapterDessert.notifyDataSetChanged();
            }
        });
    }
}