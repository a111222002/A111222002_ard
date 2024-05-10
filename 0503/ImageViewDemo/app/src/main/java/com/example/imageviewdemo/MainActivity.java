package com.example.imageviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView) findViewById(R.id.imgOutput);
        RadioGroup rg=(RadioGroup) findViewById(R.id.rgImages);
        rg.setOnCheckedChangeListener(this);
    }





    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(checkedId==R.id.rdbDog){
            img.setImageResource(R.mipmap.dog);
        }
        else if(checkedId==R.id.rdbMouse){
            img.setImageResource(R.mipmap.mouse);
        }
        else if(checkedId==R.id.rdbRabbit){
            img.setImageResource(R.mipmap.rabbit);
        }
        else if(checkedId==R.id.rdbElephant){
            img.setImageResource(R.mipmap.elephant);
        }
        else{
            Log.v("Error","No image selected");
        }
    }
}