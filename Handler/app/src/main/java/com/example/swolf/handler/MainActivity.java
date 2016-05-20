package com.example.swolf.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int[] images = new int[] {
            R.drawable.moon,
            R.drawable.rime,
            R.drawable.road,
            R.drawable.sunset
    };

    ImageView imageView;
    int currentImage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);


        final Handler MyHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 123) {
                    imageView.setImageResource(images[currentImage++ % images.length]);
                }
            }
        };

//        final Handler MyHandler1 = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                if (msg.what == 123) {
//                    Toast.makeText(
//                            MainActivity.this, "Image" + currentImage, Toast.LENGTH_SHORT).show();
//                }
//            }
//        };

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                MyHandler.sendEmptyMessage(123);
//                MyHandler1.sendEmptyMessage(123);
            }
        }, 0, 1000);

    }

}
