package com.example.edittext_temptransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn_click(View view) {
        EditText edtTemp = (EditText) findViewById(R.id.edtTemp);
        TextView txvView = (TextView) findViewById(R.id.txvView);

        String tempStr = edtTemp.getText().toString().trim();
        if (tempStr.isEmpty()) {
            txvView.setText("請輸入正確的溫度");
            return;
        }

        double d_origin_temp = Double.parseDouble(tempStr);

        double transTemp = (d_origin_temp * 9 / 5) + 32;
        txvView.setText("華氏溫度為： " + transTemp);
    }

}