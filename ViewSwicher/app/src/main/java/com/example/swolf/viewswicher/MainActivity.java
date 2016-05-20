package com.example.swolf.viewswicher;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ViewSwitcher viewSwitcher;

    public static final int NUM_PER_SCREEN = 12;

    LayoutInflater inflater;

    int currentScreenNo = -1;
    public int screenCount = 0;

    private class DataItem{
        public String dataName;
        public Drawable drawable;
    }

    public ArrayList<DataItem> items= new ArrayList<DataItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = LayoutInflater.from(MainActivity.this);
        viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return inflater.inflate(R.layout.slidelistview, null);
            }
        });

        for(int i = 0; i < 40; i++){
            DataItem item = new DataItem();
            item.dataName = "label"+Integer.toString(i);
            item.drawable = getResources().getDrawable(R.drawable.icon);
            items.add(item);
        }

        screenCount = items.size() % NUM_PER_SCREEN == 0 ?
                items.size()/NUM_PER_SCREEN: items.size()/NUM_PER_SCREEN + 1;

        next(null);
    }

    public BaseAdapter adapter = new BaseAdapter() {

        @Override
        public int getCount() {
            // TODO calulator icon numbers in the screen.
            if (currentScreenNo == screenCount -1){
                return items.size() % NUM_PER_SCREEN;
            } else {
                return NUM_PER_SCREEN;
            }
        }

        @Override
        public DataItem getItem(int position) {
            return items.get(currentScreenNo*NUM_PER_SCREEN + position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if(view == null){
                view = inflater.inflate(R.layout.labelicon, null);
            }

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageDrawable(getItem(position).drawable);

            TextView textView = (TextView) view.findViewById(R.id.textView);
            textView.setText(getItem(position).dataName);
            return view;
        }
    };

    public void prev(View v){
        if(currentScreenNo > 0){
            currentScreenNo--;
            viewSwitcher.setInAnimation(this, R.anim.slide_in_left);
            viewSwitcher.setInAnimation(this, R.anim.slide_out_right);
            ((GridView) viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showPrevious();
        }
    }

    public void next(View v){
        if(currentScreenNo < screenCount-1) {
            currentScreenNo++;
            viewSwitcher.setInAnimation(this, R.anim.slide_in_right);
            viewSwitcher.setInAnimation(this, R.anim.slide_out_left);
            ((GridView) viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showNext();
        }
    }
}



