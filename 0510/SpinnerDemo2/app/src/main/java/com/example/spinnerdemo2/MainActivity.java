package com.example.spinnerdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private EditText op1, op2;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        op1 = findViewById(R.id.txtOpd1);
        op2 = findViewById(R.id.txtOpd2);
        output = findViewById(R.id.lblOutput);
        Spinner sp =(Spinner) findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int v1 , v2;
        double r = 0.0 ;
        try{
            v1 = Integer.parseInt(op1.getText().toString());
            v2 = Integer.parseInt(op2.getText().toString());
            switch (position){
                case 0:
                    r = v1 + v2;
                    break;
                case 1:
                    r = v1 - v2;
                    break;
                case 2:
                    r = v1 * v2;
                    break;
                case 3:
                    r = (double)v1/v2;
                    break;
            }
            output.setText("Result= " + String.format("%.2f", r));
        }
        catch (NumberFormatException e){
            output.setText("Invalid Input");
            return;
        }
        catch (ArithmeticException e){
            output.setText("Divide by Zero");
            return;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}