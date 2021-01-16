package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        Button Mulai = findViewById(R.id.mulai);
        Button bout = findViewById(R.id.bout);

        Mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(a);
            }
        });

        bout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a = new Intent(getApplicationContext(),About.class);
                startActivity(a);
            }
        });
    }
}