package com.example.wheel_spin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {
    Button btnplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);

//    @Override
//    public void onStopRotation(String item) {
//        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
//    }
        btnplay = findViewById(R.id.btnPlay);
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(myintent);
            }
        });

    }
}
