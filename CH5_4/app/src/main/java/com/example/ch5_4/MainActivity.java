package com.example.ch5_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public  boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            EditText txtInput=(EditText) findViewById(R.id.txtInput);
            txtInput.setText("按下返回鍵");
        }
        return  true;
    }
    @Override
    public  boolean onKeyUp(int keyCode, KeyEvent event){

        TextView lbl=(TextView) findViewById(R.id.lblOutput);
        lbl.setText("返回按鍵碼:"+keyCode);
        return  true;
    }
}