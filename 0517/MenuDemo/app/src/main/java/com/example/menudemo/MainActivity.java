package com.example.menudemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView output = findViewById(R.id.lblOutput);
        int tmp;
        double result;
        EditText txtTemp = (EditText) findViewById(R.id.txtTemp);
        tmp = Integer.parseInt(txtTemp.getText().toString());
        int itemId = item.getItemId();
        if(itemId == R.id.toF) {
            result = (tmp * 9 / 5) + 32;
            output.setText("Temperature in Fahrenheit is: " + String.format("%.2f", result));
        }
        else if(itemId == R.id.toC) {
            result = (tmp - 32) * 5 / 9;
            output.setText("Temperature in Celsius is: " + String.format("%.2f", result));
        }
        return super.onOptionsItemSelected(item);
    }

}
