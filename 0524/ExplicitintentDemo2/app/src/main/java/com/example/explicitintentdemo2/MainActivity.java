package com.example.explicitintentdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Output;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Output = (TextView) findViewById(R.id.lblOutput);
        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtOpd1,txtOpd2;
                txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
                txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
                Intent intent = new Intent(MainActivity.this, OPActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("opd1", txtOpd1.getText().toString());
                bundle.putString("opd2", txtOpd2.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (1): {
                if (resultCode == RESULT_OK) {
                    String result = data.getStringExtra("result");
                    TextView Output = (TextView) findViewById(R.id.lblOutput);
                    Output.setText(result);
                }
                break;
            }
        }
    }
}