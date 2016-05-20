package com.example.swolf.activitytest;

import android.app.ExpandableListActivity;
import android.app.LauncherActivity;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends LauncherActivity {
    String[] names = {"设置程序参数", "查看飞机类型"};

    Class<?>[] classes = {
            PreferenceActivityTest.class,
            ExpandableListActivityTest.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(this, classes[position]);
    }
}