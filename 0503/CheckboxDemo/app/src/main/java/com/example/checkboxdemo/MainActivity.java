package com.example.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CheckBox.OnCheckedChangeListener {

    private int[] chkID={R.id.chkOriginal,R.id.chkBeef,R.id.chkSeafood};
    private String str="",str2="";
    private CheckBox  chkO,chkBeef,chkSeafood;
    private TextView lblOutput,txtaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkO=(CheckBox) findViewById(R.id.chkOriginal);
        chkBeef=(CheckBox) findViewById(R.id.chkBeef);
        chkSeafood=(CheckBox) findViewById(R.id.chkSeafood);
        lblOutput=(TextView) findViewById(R.id.lblOutput);
        txtaction=(TextView) findViewById(R.id.txtaction);
        chkO.setOnCheckedChangeListener(this);
        chkBeef.setOnCheckedChangeListener(this);
        chkSeafood.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        str="";
        str2="";
        if(isChecked){
            str2+="選取"+buttonView.getText().toString()+"...\n";
        }
        else{
            str2+="取消"+buttonView.getText().toString()+"...\n";
        }

        for (int i=0;i<chkID.length;i++){
            CheckBox chk=(CheckBox) findViewById(chkID[i]);

            if(chk.isChecked()){
                str+=chk.getText().toString()+"\n";
            }
        }
        lblOutput.setText(str);
        txtaction.setText(str2);
    }
}