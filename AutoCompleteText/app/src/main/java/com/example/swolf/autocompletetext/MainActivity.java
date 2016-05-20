package com.example.swolf.autocompletetext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    final String[] content = new String[] {
            "Hello Beijing",
            "Hello Shanghai",
            "hello 广州",
            "hello 浙江",
            "hello 深圳",
            "hello 南阳",
            "hello 河北省深州市"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter(
                this, android.R.layout.simple_dropdown_item_1line,content);

        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.autotext);
        MultiAutoCompleteTextView mauto = (MultiAutoCompleteTextView) findViewById(R.id.mautotext);
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        auto.setAdapter(adapter);
        mauto.setAdapter(adapter);
    }
}
