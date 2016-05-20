package com.example.swolf.planegame;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    private int speed = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final PlaneView planeView = new PlaneView(this);
        setContentView(planeView);

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        final DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        planeView.currentX = metrics.widthPixels / 2;
        planeView.currentY = metrics.heightPixels / 2;

        planeView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (event.getKeyCode()) {
                    case KeyEvent.KEYCODE_W: 
                        planeView.currentY -= speed;
                        break;
                    case KeyEvent.KEYCODE_S:
                        planeView.currentY += speed;
                        break;
                    case KeyEvent.KEYCODE_A:
                        planeView.currentX -= speed;
                        break;
                    case  KeyEvent.KEYCODE_D:
                        planeView.currentX += speed;
                        break;
                }
                if (planeView.currentX >= metrics.widthPixels) {
                    planeView.currentX = metrics.widthPixels;
                } else if (planeView.currentX <= 0) {
                    planeView.currentX = 0;
                }
                planeView.invalidate();
                return true;
            }
        });

        planeView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }
}
