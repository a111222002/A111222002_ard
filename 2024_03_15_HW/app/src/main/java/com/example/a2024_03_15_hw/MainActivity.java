package com.example.a2024_03_15_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Patterns;
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
    public void btn_click(View view) {
        EditText edtAccount = (EditText) findViewById(R.id.edt_ac);
        EditText edtPassword = (EditText) findViewById(R.id.edt_ps);
        TextView txvResult = (TextView) findViewById(R.id.txv_final);

        String inputAccount = edtAccount.getText().toString().trim();
        String inputPassword = edtPassword.getText().toString().trim();

        // 檢查帳號是否符合信箱格式
        if (!Patterns.EMAIL_ADDRESS.matcher(inputAccount).matches()) {
            txvResult.setText(getString(R.string.the_final) + ": 帳號格式錯誤，請輸入有效的電子郵件地址");
            return;
        }

        // 檢查密碼是否含有非數字字符
        if (!inputPassword.matches(".*\\D.*")) {
            txvResult.setText(getString(R.string.the_final) + ": 密碼格式錯誤，請確保密碼包含至少一個非數字字符");
            return;
        }

        // 帳號和密碼符合格式，顯示通過訊息
        txvResult.setText(getString(R.string.the_final) + ": 帳號密碼格式正確");
    }
}