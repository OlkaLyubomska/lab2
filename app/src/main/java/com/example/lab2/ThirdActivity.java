package com.example.lab2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        // search checkboxes for menu items
        Button button1 = findViewById(R.id.willReturn1);
        CheckBox cactus = findViewById(R.id.checkBox4);
        CheckBox cactus1 = findViewById(R.id.checkBox5);
        CheckBox cactus2 = findViewById(R.id.checkBox6);
        // list for menu
        List<String> menuska12 = new ArrayList<>();

        button1.setOnClickListener(v -> {
//getting chosen cactus from checkbox
            if (cactus.isChecked()) {
                menuska12.add("постмодерн");
            }
            if (cactus.isChecked()) {
                menuska12.add("постмодерн1");
            }
            if (cactus.isChecked()) {
                menuska12.add("постмодерн2");
            }
            if (menuska12.isEmpty()) {
                menuska12.add("вы ничего не выбрали");
            }
            //empty intent
            Intent intent = new Intent();
            intent.putExtra("result", menuToString(menuska12));
            setResult(RESULT_OK, intent);
            PackageManager manager = this.getPackageManager();
            List <ResolveInfo> list = manager.queryIntentActivities(intent,0);
            if (list.size()>0){
                startActivities(intent);
            }else{
                Toast.makeText(this,"невозможно обработать намерение!",Toast.LENGTH_LONG).show();
            }
            finish();

        });
    }

    private void startActivities(Intent intent) {
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