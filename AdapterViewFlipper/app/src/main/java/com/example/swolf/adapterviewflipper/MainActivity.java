package com.example.swolf.adapterviewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] images = new int[] {
                R.drawable.flower,
                R.drawable.house,
                R.drawable.lake,
                // R.drawable.rainbow,
                R.drawable.redflower,
                R.drawable.sky,
                R.drawable.snow,
                R.drawable.tower,
                // R.drawable.tree,
        };

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(images[position]);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                imageView.setLayoutParams(params);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }
        };

        final AdapterViewFlipper flipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        Button prev = (Button) findViewById(R.id.prev);
        Button next = (Button) findViewById(R.id.next);
        Button auto = (Button) findViewById(R.id.auto);

        flipper.setAdapter(adapter);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipper.showPrevious();
                flipper.stopFlipping();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipper.showNext();
                flipper.stopFlipping();
            }
        });

        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipper.startFlipping();
            }
        });
    }
}
