package com.example.show;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
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
    public  void btn_click(View view){
        EditText edtName=(EditText) findViewById(R.id.edtName);
        TextView txvView =(TextView) findViewById(R.id.txvView);
        String name =edtName.getText().toString();
        txvView.setText("Your name is : "+name);
    }
}