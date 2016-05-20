package com.example.swolf.tostandcalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button textButton = (Button) findViewById(R.id.showTextButton);
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 100, 100);
                toast.show();
            }
        });

        Button imageButton = (Button) findViewById(R.id.showImageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout = new LinearLayout(MainActivity.this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                ImageView image = new ImageView(MainActivity.this);
                image.setImageResource(R.drawable.moon);
                image.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
                image.setScaleType(ImageView.ScaleType.FIT_START);

                TextView text = new TextView(MainActivity.this);
                text.setText("早安,中国");

                layout.addView(image);
                layout.addView(text);

                Toast imageToast = new Toast(MainActivity.this);
                imageToast.setView(layout);
                imageToast.setDuration(Toast.LENGTH_LONG);
                imageToast.show();
            }
        });


        CalendarView calendar = (CalendarView) findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast birthToast = Toast.makeText(MainActivity.this,
                        "您的生日是: " + year + "年" + (month+1) + "月" + dayOfMonth + "日", Toast.LENGTH_SHORT);
                birthToast.show();
            }
        });
    }
}
