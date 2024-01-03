package com.example.wheel_spin;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput;
    private wheelView wheelView;
    private List<String> namesList;
    Button btnSpin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameInput = findViewById(R.id.nameInput);
        Button addButton = findViewById(R.id.addButton);
        btnSpin = findViewById(R.id.spinButton);
        wheelView = findViewById(R.id.wheelView);

        namesList = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNameToList();
            }
        });
    }

    private void addNameToList() {
        String name = nameInput.getText().toString().trim();

        if (!name.isEmpty()) {
            namesList.add(name);
            wheelView.setItems(namesList);
            nameInput.getText().clear();
        }
    }



    private void rotateWheel() {
        wheelView.rotateWheel(45f);
    }

    public void btnSpin(View view) {
        btnSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateWheel();
            }
        });
    }

}
