package com.example.swolf.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 30;
            }

            @Override
            public Object getItem(int position) {
                return "hello "+position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout layout = new LinearLayout(MainActivity.this);
                layout.setOrientation(LinearLayout.HORIZONTAL);

                ImageView image = new ImageView(MainActivity.this);
                image.setImageResource(R.mipmap.ic_launcher);

                TextView text = new TextView(MainActivity.this);
                text.setText("Position " + position);
                text.setTextSize(20);

                layout.addView(image);
                layout.addView(text);

                return layout;
            }
        };

        ListView myList = (ListView) findViewById(R.id.listView);
        myList.setAdapter(adapter);
    }
}
