package com.example.arrayadapterspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner drink, temp;
    private TextView textView;
    private String[] drinks = {"Coffee", "Tea", "Soda", "Juice"};
    private String[] tempSet1 = {"Hot", "Cold", "Warm"};
    private String[] tempSet2 = {"Cold", "Frozen"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.order);
        drink = findViewById(R.id.drink);
        temp = findViewById(R.id.temp);

        ArrayAdapter<String> drinkAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, drinks);
        drink.setAdapter(drinkAdapter);

        drink.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] tempSet;
                if (position == 2) // If "Soda" is selected
                    tempSet = tempSet2;
                else
                    tempSet = tempSet1;

                ArrayAdapter<String> tempAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, tempSet);
                tempAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // 设置下拉菜单布局
                temp.setAdapter(tempAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button orderButton = findViewById(R.id.btnOrder);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String drinkOrder = drinks[drink.getSelectedItemPosition()]; // 获取所选饮料的名称
                String tempOrder = temp.getSelectedItem().toString(); // 获取所选温度的名称
                String order = drinkOrder + " " + tempOrder;
                textView.setText("Order: " + order);
            }
        });
    }
}
