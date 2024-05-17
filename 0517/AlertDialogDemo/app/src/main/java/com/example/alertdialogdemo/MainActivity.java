package com.example.alertdialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    private String[] items={"Samsung","OPPO","APPLE","XIAOMI"};
    private boolean[] checkedItems = new boolean[items.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAbout = findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("About Book")
                        .setMessage("Android Programming Book\n\n")
                        .setPositiveButton("Submit", null)
                        .setCancelable(true)
                        .show();
            }
        });

        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("確認")
                        .setMessage("Done")
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        Button btnColor = (Button) findViewById(R.id.btnColor);
        btnColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String[] colors = {"Red", "Green", "Blue", "Yellow"}; // 定義color array
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Color");
                builder.setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selectedColor = colors[which];
                        Toast.makeText(MainActivity.this, "You selected: " + selectedColor, Toast.LENGTH_SHORT).show();
                        // 根據選擇的顏色更改按鈕的背景顏色
                        switch (selectedColor) {
                            case "Red":
                                btnColor.setBackgroundColor(Color.RED);
                                break;
                            case "Green":
                                btnColor.setBackgroundColor(Color.GREEN);
                                break;
                            case "Blue":
                                btnColor.setBackgroundColor(Color.BLUE);
                                break;
                            case "Yellow":
                                btnColor.setBackgroundColor(Color.YELLOW);
                                break;
                            default:
                                // 如果顏色無法識別，則不更改按鈕顏色
                                break;
                        }
                    }
                });
                builder.show();
            }
        });
        Button btnSelect = findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Select")
                        .setPositiveButton("check", MainActivity.this)
                        .setNegativeButton("cancel", MainActivity.this)
                        .setMultiChoiceItems(items, checkedItems, null)
                        .show();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                StringBuilder msg = new StringBuilder();
                for (int i = 0; i < items.length; i++) {
                    if (checkedItems[i]) {
                        msg.append(items[i]).append(" ");
                    }
                }
                TextView tv = findViewById(R.id.txvShow);
                tv.setText(msg.toString()); // 移动这行代码到这里
                Toast.makeText(MainActivity.this, msg.toString(), Toast.LENGTH_SHORT).show();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                // Handle negative button click if needed
                break;
        }
    }
}
