package com.example.explicitlntentdemo2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView output;
    private ActivityResultLauncher<Boolean> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.lblOutput);
        Button button = findViewById(R.id.button);

        // 初始化 ActivityResultLauncher
        launcher = registerForActivityResult(new ResultContract(), result -> {
            output.setText(result);
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 點擊按鈕時啟動 Activity_operator 並等待結果
                launcher.launch(true);
            }
        });
    }

    // 自定義 ActivityResultContract 來處理啟動另一個活動的請求和接收結果
    class ResultContract extends ActivityResultContract<Boolean, String> {

        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, Boolean input) {
            Intent intent = new Intent(MainActivity.this, Activity_operator.class);
            Bundle bundle = new Bundle();
            bundle.putString("OPERAND01", ((EditText) findViewById(R.id.txtOpd1)).getText().toString());
            bundle.putString("OPERAND02", ((EditText) findViewById(R.id.txtOpd2)).getText().toString());
            intent.putExtras(bundle);
            return intent;
        }

        @Override
        public String parseResult(int resultCode, @Nullable Intent intent) {
            // 解析結果並返回字符串
            if (intent != null && intent.getExtras() != null) {
                double result = intent.getExtras().getDouble("RESULT");
                return String.valueOf(result);
            } else {
                return "No result";
            }
        }
    }
}
