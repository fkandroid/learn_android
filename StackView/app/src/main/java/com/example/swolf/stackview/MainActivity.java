package com.example.swolf.stackview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] images = new int[] {
                R.drawable.greatwall,
                // R.drawable.hill,
                R.drawable.moon,
                R.drawable.rime,
                R.drawable.road,
                R.drawable.snowcappedmountain,
                R.drawable.sunflower,
                R.drawable.sunset,
                R.drawable.waterfall,
                R.drawable.yellowflower
        };

        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        for(int i=0; i<images.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id", images[i]);
            data.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(
                MainActivity.this,
                data,
                R.layout.cell,
                new String[] {"id"},
                new int[] {R.id.cell});

        final StackView stackView = (StackView) findViewById(R.id.stack);
        stackView.setAdapter(adapter);

        Button prev = (Button) findViewById(R.id.prev);
        Button next = (Button) findViewById(R.id.next);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stackView.showPrevious();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stackView.showNext();
            }
        });
    }

}
