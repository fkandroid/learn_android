package com.example.swolf.adaptorview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list2 = (ListView) findViewById(R.id.list2);
        String[] array = {"孙悟空", "唐僧", "猪八戒", "沙僧", "白龙马"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, R.layout.array_item, array
        );
        list2.setAdapter(adapter2);

        Button button = (Button) findViewById(R.id.hellobutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(android.R.id.mainlist);
            }
        });
    }
}
 