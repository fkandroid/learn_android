package com.example.swolf.numberpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int min = 25;
    private int max = 75;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberPicker minPicker = (NumberPicker) findViewById(R.id.minNumberPicker);
        minPicker.setMaxValue(0);
        minPicker.setMaxValue(50);
        minPicker.setValue(min);
        minPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                min = newVal;
                showNumber(min, max);
            }
        });

        NumberPicker maxPicker = (NumberPicker) findViewById(R.id.maxNumberPicker);
        maxPicker.setMinValue(51);
        maxPicker.setMaxValue(100);
        maxPicker.setValue(max);
        maxPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                max = newVal;
                showNumber(min, max);
            }
        });
    }

    public void showNumber(int min, int max) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("你选择的最小值为: " + min + "  最大值为: " + max);
    }
}
