//package com.example.wheel_spin;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.view.View;
//
//public class RotationWheelView extends View {
//
//    private int sectors = 2; // Default number of sectors
//    private Paint paint;
//
//    public RotationWheelView(Context context) {
//        super(context);
//        paint = new Paint();
//        paint.setAntiAlias(true);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        int width = getWidth();
//        int height = getHeight();
//        int minSize = Math.min(width, height);
//
//        float cx = width / 2f;
//        float cy = height / 2f;
//        float radius = minSize / 2f;
//
//        float angle = 360f / sectors;
//
//        for (int i = 0; i < sectors; i++) {
//            paint.setStyle(Paint.Style.FILL);
//            paint.setColor(getColorForSector(i)); // Get color for each sector
//
//            canvas.drawArc(cx - radius, cy - radius, cx + radius, cy + radius,
//                    i * angle, angle, true, paint);
//        }
//    }
//
//    private int getColorForSector(int sectorIndex) {
//        // Generate or assign colors for each sector here
//        // Example: Return different colors based on the sector index
//        // For simplicity, using a simple color scheme here
//        int[] colors = {0xFFFF0000, 0xFF00FF00, 0xFF0000FF, 0xFFFFFF00,
//                0xFFFF00FF, 0xFF00FFFF, 0xFF9900CC, 0xFFCC9900};
//
//        return colors[sectorIndex % colors.length];
//    }
//
//    public static void setSectors(int numberOfSectors) {
//        this.sectors = numberOfSectors;
//         // Redraw the view when the number of sectors changes
//    }
//}