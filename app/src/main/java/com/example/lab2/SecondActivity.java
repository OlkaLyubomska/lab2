package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity<v> extends  AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_second);


        // search checkboxes for menu items
        Button button1 = findViewById(R.id.willReturn);
        CheckBox cactus = findViewById(R.id.checkBox);
        CheckBox cactus1 = findViewById(R.id.checkBox2);
        CheckBox cactus2 = findViewById(R.id.checkBox3);
        // list for menu
        List<String> menuska1 = new ArrayList<>();

        button1.setOnClickListener(v -> {
//getting chosen cactus from checkbox
            if (cactus.isChecked()) {
                menuska1.add("кактус круглый");
            }
            if (cactus1.isChecked()) {
                menuska1.add("кактус квадратный");
            }
            if (cactus2.isChecked()) {
                menuska1.add("кактус высокий");
            }
            if (menuska1.isEmpty()) {
                menuska1.add("вы ничего не выбрали");
            }
            //empty intent
            Intent intent = new Intent();
            intent.putExtra("result", menuToString(menuska1));
            setResult(RESULT_OK, intent);
            finish();

        });
    }

// method to put data from a list to a string
        private String menuToString(List list) {
            String menuska = "";

            for (int i = 0; i < list.size(); i++) {
                menuska = menuska + " " + list.get(i);
            }
            return menuska;
        }


    // method when user click back
    @Override
    public void onBackPressed(){
        super.onBackPressed();

        setResult(RESULT_CANCELED);
    }
}
