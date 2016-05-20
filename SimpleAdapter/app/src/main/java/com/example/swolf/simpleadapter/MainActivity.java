package com.example.swolf.simpleadapter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {

    int[] imageIds = new int[] {
            R.drawable.libai,
            R.drawable.nongyu,
            R.drawable.qingzhao,
            R.drawable.tiger
    };

    String[] names = new String[] {
            "李白",
            "弄玉",
            "李清照",
            "打老虎"
    };

    String[] desc = new String[] {
            "风流倜傥,玉树临风的大诗人",
            "秦穆公女,善乐器",
            "易安居士,千古第一才女",
            "森林之王"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String, Object>> myData = new ArrayList<Map<String, Object>>();
        for(int i=0; i<names.length; i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("image", imageIds[i]);
            item.put("name", names[i]);
            item.put("desc", desc[i]);
            myData.add(item);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                myData,
                R.layout.simple_item,
                new String[] {"image", "name", "desc"},
                new int[] {R.id.headmap, R.id.name, R.id.description});

        ListView myview = (ListView) findViewById(R.id.mylist);
        myview.setAdapter(simpleAdapter);

        myview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "被单击了!");
            }
        });

        myview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "被选中了!");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
