package com.example.wheel_spin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput;
    private wheelView wheelView;
    private List<String> namesList;
    float targetX, targetY;
    Button btnSpin;
    ImageView ivTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameInput = findViewById(R.id.nameInput);
        Button addButton = findViewById(R.id.addButton);
        btnSpin = findViewById(R.id.spinButton);
        wheelView = findViewById(R.id.wheelView);
        ivTarget = findViewById(R.id.ivTarget);

        namesList = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addNameToList(nameInput);
                nameInput.setEnabled(true);
            }

        });
    }

    private void addNameToList(EditText nameInput) {
        String name = nameInput.getText().toString().trim();
        if (!name.isEmpty()) {
            namesList.add(name);
            wheelView.setItems(namesList);
            nameInput.getText().clear();
        }
    }


    public void btnSpin(View view) {
        btnSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameInput.setEnabled(false);
                rotateWheel();

            }
        });
    }

    private void rotateWheel() {
        float fromDegrees = 0f;
        float toDegrees = 360f * 4; // Rotating 4 times (can be adjusted)

        Animation rotateAnimation = new RotateAnimation(
                fromDegrees, toDegrees,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotateAnimation.setDuration(10000); // Duration of the animation in milliseconds
        rotateAnimation.setFillAfter(true);

        wheelView.startAnimation(rotateAnimation);
    }

//        wheelView.spinWheel(1500, new wheelView.OnSpinFinishListener() {
//            @Override
//            public void onSpinFinish(float finalAngle) {
//                // Final angle where the wheel stops
//                // Perform any action here based on the final angle
//            }
//        });
//        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                // Animation ended, logic to determine final position and target reached
//                float currentAngle = wheelView.getRotation() % 360;
//                float targetAngle = calculateTarget(); // Implement this method for target calculation
//
//                // Check if the current angle matches the target angle
//                if (Math.abs(currentAngle - targetAngle) < 10) {
//                    displayResultDialog("fjadfjadfada");
//                    // Target reached, perform necessary actions
//                    handleTargetReached();
//                } else {
//                    // Not reached, you might want to allow another spin or show a message
//                    // Add logic for retry or inform the user
//                }
//            }
//            private void displayResultDialog(String message) {
//                // Show a dialog or toast to display the result message
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//    }
//
//    private void handleTargetReached() {
//        // Show a dialog to display the result
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Result")
//                .setMessage("Congratulations! You reached the target.")
//                .setPositiveButton("OK", (dialog, which) -> {
//                    // You can add actions here when the user clicks OK, if needed
//                    dialog.dismiss();
//                })
//                .show();
//    }
//
//    private float calculateTarget() {
//        return 180;
//    }
    // Assuming you have references to your spin wheel, target arrow, and necessary animations


    }












