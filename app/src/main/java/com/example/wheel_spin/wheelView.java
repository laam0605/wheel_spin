package com.example.wheel_spin;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class wheelView extends View {

    private List<String> items;
    private Paint paint;
    private int radius;
    private int centerX, centerY;
    private int wheelColor =Color.RED;


    public wheelView(Context context) {
        super(context);
        init();
    }

    public wheelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        items = new ArrayList<>();
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(40);
    }

    public void setItems(List<String> newItems) {
        items.clear();
        items.addAll(newItems);
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
        radius = Math.min(w, h) / 2 - 50; // Adjust according to your UI
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (items.isEmpty()) {
            return;
        }

        float angle = 360f / items.size();
        float startAngle = 0f;

        for (String item : items) {
            canvas.save();
            canvas.rotate(startAngle, centerX, centerY);
            canvas.drawText(item, centerX, centerY - radius + 40, paint);
            canvas.restore();
            startAngle += angle;
        }
    }

    public void rotateWheel(float v) {
        wheelView wheelView = null;
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(wheelView, "rotation", 0f, 360f);
        rotationAnimator.setDuration(2000); // Set the duration of rotation in milliseconds
        rotationAnimator.start();
    }

}