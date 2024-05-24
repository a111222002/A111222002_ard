package com.example.datetimepickdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView lblOutput;
    private Calendar dt = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblOutput=(TextView) findViewById(R.id.lblOutput);

        Button btnDate = (Button) findViewById(R.id.btn_date);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dlg = new DatePickerDialog(MainActivity.this,MainActivity.this,dt.get(Calendar.YEAR),dt.get(Calendar.MONTH),dt.get(Calendar.DATE));
                dlg.getDatePicker().setMinDate(dt.getTimeInMillis()-1000);
                dlg.show();
            }
        });
        Button btnTime = (Button) findViewById(R.id.btn_choose);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dlg = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                lblOutput.setText("Time: "+hourOfDay+":"+minute);
                            }
                        },
                        dt.get(Calendar.HOUR),dt.get(Calendar.MINUTE),false);
                dlg.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        lblOutput.setText("Date: "+dayOfMonth+"/"+(month+1)+"/"+year);
    }
}