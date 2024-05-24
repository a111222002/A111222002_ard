package com.example.explicitintentdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class OPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opactivity);

        Button btn2 = findViewById(R.id.button2);
        CheckBox chkDivide = findViewById(R.id.chkDivide);
        RadioButton rdoDivide = findViewById(R.id.rdbDivide); // 添加这一行

        // 判断是否启用chkDivide复选框
        if(rdoDivide.isChecked()){
            chkDivide.setEnabled(true);
        } else {
            chkDivide.setEnabled(false);
        }

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opd1 = 0; // 设置默认值
                int opd2 = 0; // 设置默认值
                double result = 0; // 设置默认值

                RadioButton rdbAdd = findViewById(R.id.rdbAdd);
                RadioButton rdbSubtract = findViewById(R.id.rdbSubtract);
                RadioButton rdbMultiply = findViewById(R.id.rdbMultiply);
                RadioButton rdbDivide = findViewById(R.id.rdbDivide);

                // 从Intent获取操作数
                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    opd1 = Integer.parseInt(bundle.getString("opd1", "0"));
                    opd2 = Integer.parseInt(bundle.getString("opd2", "0"));
                } else {
                    // 可以添加错误处理或提醒用户输入数据
                }

                // 根据选择的操作符进行计算
                if (rdbAdd.isChecked()) {
                    result = opd1 + opd2;
                } else if (rdbSubtract.isChecked()) {
                    result = opd1 - opd2;
                } else if (rdbMultiply.isChecked()) {
                    result = opd1 * opd2;
                } else if (rdbDivide.isChecked()) {
                    if (opd2 != 0) {
                        result = (double) opd1 / opd2;
                    } else {
                        // 可以添加错误处理或提醒用户除数不能为零
                    }
                }

                // 创建包含结果的Intent并返回给调用者
                Intent rIntent = new Intent();
                Bundle rBundle = new Bundle();
                rBundle.putString("result", String.valueOf(result));
                rIntent.putExtras(rBundle);
                setResult(RESULT_OK, rIntent);
                finish();
            }
        });

        // 添加单选按钮状态改变监听器，以便动态更新chkDivide的启用状态
        rdoDivide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    chkDivide.setEnabled(true);
                } else {
                    chkDivide.setEnabled(false);
                }
            }
        });
    }
}
