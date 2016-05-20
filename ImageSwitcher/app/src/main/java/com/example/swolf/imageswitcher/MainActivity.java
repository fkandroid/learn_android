package com.example.swolf.imageswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private ImageSwitcher switcher;

    final int[] images = new int[] {
            R.drawable.greatwall,
            R.drawable.camera,
            R.drawable.circle,
            R.drawable.hill,
            R.drawable.moon,
            R.drawable.rime,
            R.drawable.road,
            R.drawable.sky,
            R.drawable.snowcappedmountain,
            R.drawable.sunflower,
            R.drawable.sunset,
            R.drawable.waterfall
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();

        for(int i = 0; i < images.length; i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("image", images[i]);
            items.add(item);

        }

        SimpleAdapter adapter = new SimpleAdapter(
                this, items, R.layout.cell, new String[] {"image"}, new int[] {R.id.imageView});

        switcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));

                return imageView;
            }
        });

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switcher.setImageResource(images[position]);
            }
        });
    }
}
