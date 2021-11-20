package com.google.bikehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.bikehelper.sharedPreferences.MyPreference;

public class SwitchActivity extends AppCompatActivity {

    Button user, admin;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        switchActivity();
    }

    private void switchActivity(){
        user = findViewById(R.id.user);
        admin = findViewById(R.id.admin);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPreference myPrefrence = MyPreference.getInstance(context);
                myPrefrence.saveData("object","users");

                String value = myPrefrence.getData("object");
                Intent intent = new Intent(SwitchActivity.this, Login.class);
                startActivity(intent);
                Toast.makeText(SwitchActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });

//        admin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String object = "admin";
//                DataLocalManager.setStringObject(object.toString());
//                Intent intent = new Intent(SwitchActivity.this, Login.class);
//                startActivity(intent);
//            }
//        });
    }
}