package com.example.swolf.customeview;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.content.Context;
import android.util.AttributeSet;

public class DrawView extends View
{
    public float currentX = 40;
    public float currentY = 50;

    Paint p = new Paint();

    public DrawView(Context context)
    {
        super(context);
    }

    public DrawView(Context context, AttributeSet set)
    {
        super(context, set);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        p.setColor(Color.RED);
        canvas.drawCircle(currentX, currentY, 15, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        currentX = event.getX();
        currentY = event.getY();

        invalidate();
        return true;
    }

}