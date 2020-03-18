package com.example.lab2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.example.lab2.R.id.textView;

public class MainActivity extends AppCompatActivity {
    public static int REQUEST_CODE = 100;
    public static int REQUEST_CODE_TIME = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // button for calling a menu view
        Button button = findViewById(R.id.cactusik);

        // listener to call second activity
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });
        //     listener to call third activity
        Button button1 = findViewById(R.id.postmodernik);
        button1.setOnClickListener(v -> {
                    Intent intent = new Intent(this, ThirdActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_TIME);
                });

    }
    // method that gets data from others activities and put info to itself
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Пользователь вышел из SecondActivity", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_OK) {

                // gets chosen menu and put it to textView
                if (data != null) {
                    String text = data.getStringExtra("result");
                    if (text != null) {
                        TextView tv = findViewById(R.id.cactusik);
                        tv.setText(text);
                    }
                }
            }
        }
        // gets date that was chosen by user
        if (requestCode == REQUEST_CODE_TIME) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    String text = data.getStringExtra("result");
                    if (text != null) {
                        TextView tv = findViewById(R.id.postmodernik);
                        tv.setText(text);
                    }
                }
            }
        }
    }
}

