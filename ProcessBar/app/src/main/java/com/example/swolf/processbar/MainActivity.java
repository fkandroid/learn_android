package com.example.swolf.processbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;

import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    private int[] data = new int[100];

    int hasData = 0;
    int status = 0;

    ProgressBar bar1, bar2;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what == 0x111){
                bar1.setProgress(status);
                bar2.setProgress(status);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar1 = (ProgressBar) findViewById(R.id.bar1);
        bar2 = (ProgressBar) findViewById(R.id.bar2);

        new Thread(){
            public void run(){
                while(status < 100) {
                    status = doWork();
                    mHandler.sendEmptyMessage(0x111);
                }
            }
        }.start();

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);
        final ImageView imageView = (ImageView) findViewById(R.id.image);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                imageView.setAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingbar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                imageView.setImageAlpha((int)rating*(255/5));
            }
        });


    }

    public int doWork(){
        data[hasData++] = (int)(Math.random() * 100);
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return hasData;
    }
}
