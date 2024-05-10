package com.example.imageviewdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private ImageView img, img2, img3, img4;
    private int[] rdbID={R.id.rdbDog,R.id.rdbMouse,R.id.rdbRabbit, R.id.rdbElephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView) findViewById(R.id.imgOutput);
        img2=(ImageView) findViewById(R.id.imageView);
        img3=(ImageView) findViewById(R.id.imageView2);
        img4=(ImageView) findViewById(R.id.imageView3);
        RadioGroup rdbGroup=(RadioGroup) findViewById(R.id.rgImages);
        rdbGroup.setOnCheckedChangeListener(this);
    }





    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId==R.id.rdbElephant){
            img.setVisibility(View.VISIBLE);
            img2.setVisibility(View.GONE);
            img3.setVisibility(View.GONE);
            img4.setVisibility(View.GONE);
        }
        else if(checkedId==R.id.rdbMouse){
            img.setVisibility(View.GONE);
            img2.setVisibility(View.GONE);
            img3.setVisibility(View.VISIBLE);
            img4.setVisibility(View.GONE);
        }
        else if(checkedId==R.id.rdbRabbit){
            img.setVisibility(View.GONE);
            img2.setVisibility(View.GONE);
            img3.setVisibility(View.GONE);
            img4.setVisibility(View.VISIBLE);
        }
        else if(checkedId==R.id.rdbDog){
            img.setVisibility(View.GONE);
            img2.setVisibility(View.VISIBLE);
            img3.setVisibility(View.GONE);
            img4.setVisibility(View.GONE);
        }
    }
}