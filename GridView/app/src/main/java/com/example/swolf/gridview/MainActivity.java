package com.example.swolf.gridview;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.GridView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] images = new int[] {
                R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7, R.drawable.bomb8,
                R.drawable.bomb9, R.drawable.bomb10, R.drawable.bomb11, R.drawable.bomb12,
                R.drawable.bomb13, R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16
        };

        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();

        for(int i=0; i<images.length; i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("image", images[i]);
            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                items,
                R.layout.cell, new String[] {"image"},
                new int[] {R.id.cell});

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(images[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(images[position]);
            }
        });
    }
}
