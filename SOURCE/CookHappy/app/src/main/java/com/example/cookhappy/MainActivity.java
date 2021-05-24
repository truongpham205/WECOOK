package com.example.cookhappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonlogin;
    Button buttonsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListener();

    }
    private void init(){
       buttonlogin = (Button) findViewById(R.id.buttonlogin);
       buttonsignup = (Button) findViewById(R.id.buttonsignup);
    }
    private void addListener(){
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,Login.class);
                startActivity(i);
            }
        });
        buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent();
                y.setClass(MainActivity.this,Signup.class);
                startActivity(y);
            }
        });
    }

}