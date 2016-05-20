package com.example.swolf.followball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by swolf on 16/4/11.
 */
public class MyBall extends View {
    private float currentX = 100;
    private float currentY = 100;

    public MyBall(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setColor(Color.GREEN);

        canvas.drawCircle(currentX, currentY, 35, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = event.getX();
        currentY = event.getY();

        this.invalidate();
        return true;
    }
}
