package com.example.explicitintentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factivity);

        convertTemperature(); // 调用温度转换方法

        Button btnBack = findViewById(R.id.btnReturn);
        btnBack.setOnClickListener(v -> {
            finish();
        });
    }

    private void convertTemperature() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int c = bundle.getInt("tempC", 0); // 默认值为0
            String place = bundle.getString("place", ""); // 默认值为空字符串

            double f = (9.0 / 5.0) * c + 32;
            TextView output = findViewById(R.id.lblOutput);
            output.setText(String.format("Temperature in %s is %.2f F", place, f));
        }
    }
}
