package com.example.wheel_spin;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;

import java.util.ArrayList;
import java.util.List;

public class wheelView extends View {

    private List<String> items;
    private Paint paint;
    private int radius;
    private float rotation =0;
    private RotateAnimation rotateAnimation;
    private float targetAngle =0;

    private int centerX, centerY;



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
        float startAngle = 1;

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
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(wheelView, "rotation", 0.5f, 360f);
        rotationAnimator.setDuration(2000); // Set the duration of rotation in milliseconds
        rotationAnimator.start();
    }

    public void rotate(int i, int i1, int i2) {
    }
    public void spinWheel(float degrees, final OnSpinFinishListener listener) {
        targetAngle = degrees;
        rotateAnimation = new RotateAnimation(rotation, rotation + degrees, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(10000); // Set rotation duration in milliseconds
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { }

            @Override
            public void onAnimationEnd(Animation animation) {
                rotation = targetAngle % 360;
                if (listener != null) {
                    listener.onSpinFinish(rotation);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });
        startAnimation(rotateAnimation);
    }

    public interface OnSpinFinishListener {
        void onSpinFinish(float finalAngle);
    }

}