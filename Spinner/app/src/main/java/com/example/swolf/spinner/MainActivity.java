package com.example.swolf.spinner;

import android.database.DataSetObserver;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] array = new String[] {
                "黑龙江",
                "吉林",
                "辽宁",
                "内蒙古"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_multiple_choice, array);

        Spinner  spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);


        final int[] images = new int[] {
                R.drawable.baiyang,
                R.drawable.chunv,
                R.drawable.jinniu,
                R.drawable.juxie,
                R.drawable.mojie,
                R.drawable.sheshou

        };


        BaseAdapter adapterForGallery = new BaseAdapter() {
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

                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new Gallery.LayoutParams(75, 100));
                return imageView;

            }
        };

        final ImageView image = (ImageView) findViewById(R.id.image);
        Gallery gallery = (Gallery) findViewById(R.id.gallery);

        gallery.setAdapter(adapterForGallery);

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                image.setImageResource(images[position]);
            }
        });



    }
}
