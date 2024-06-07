package com.example.explicitintentdemo2;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
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

            }
        });
    }

    class ResultContract extends ActivityResultContract<Boolean,String>{
        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, Boolean input) {
            Intent intent = new Intent(MainActivity.this,OpActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("OPERAND01",((EditText) findViewById(R.id.txtOpd1)).getText().toString());
            bundle.putString("OPERAND02",((EditText) findViewById(R.id.txtOpd2)).getText().toString());
            intent.putExtras(bundle);
            return intent;
        }

        @Override
        public String parseResult(int i, @Nullable Intent intent) {
            Bundle bundle = intent.getExtras();
            Double result = bundle.getDouble("RESULT");
            return result.toString();
        }
    }
}