package com.example.swolf.planegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by swolf on 16/4/8.
 */
public class PlaneView extends View {
    Bitmap plane;
    public float currentX;
    public float currentY;

    Paint paint;

    public PlaneView(Context context) {
        super(context);
        plane = BitmapFactory.decodeResource(
                context.getResources(), R.drawable.plane);
        paint = new Paint();
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(plane, currentX, currentY, paint);
    }
}
