package com.example.swolf.textswitcher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    String[] books = new String[] {
            "Ptyhon开发",
            "疯狂Android讲义",
            "深入理解Android系统",
            "Javascript指南",
            "Linux内核深度剖析"
    };

    int[] images = new int[] {
            R.drawable.greatwall,
            R.drawable.hill,
            R.drawable.moon,
            R.drawable.rime,
            R.drawable.road,
            R.drawable.sky,
            R.drawable.snowcappedmountain,
            R.drawable.sunflower,
            R.drawable.sunset,
            R.drawable.waterfall,
            R.drawable.yellowflower
    };

    int current = 0;
    TextSwitcher switcher;
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(MainActivity.this);
                textView.setTextSize(24);
                textView.setTextColor(Color.MAGENTA);
                return textView;
            }
        });

        textNext(null);


        flipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        for(int i = 0; i < images.length; i++){
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(images[i]);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
            flipper.addView(imageView);
        }

    }

    public void next(View v){
        flipper.setInAnimation(MainActivity.this, R.anim.slide_in_right);
        flipper.setOutAnimation(MainActivity.this, R.anim.slide_out_left);
        flipper.stopFlipping();
        flipper.showNext();
    }

    public void prev(View v){
        flipper.setInAnimation(this, R.anim.slide_in_left);
        flipper.setOutAnimation(this, R.anim.slide_out_right);
        flipper.stopFlipping();
        flipper.showPrevious();
    }

    public void auto(View v){
        flipper.startFlipping();
    }

    public void textNext(View v){
        switcher.setText(books[current++ % books.length]);
    }
}
