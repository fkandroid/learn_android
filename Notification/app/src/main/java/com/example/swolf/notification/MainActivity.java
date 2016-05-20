package com.example.swolf.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager nm;
    static final int NOTIFICATION_ID = 0x123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }

    public void send(View v) {

        Intent intent = new Intent(MainActivity.this, OtherActivity.class);
        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

        Notification notify = new Notification.Builder(this)
            .setAutoCancel(true)
            .setTicker("有新消息")
            .setContentTitle("Hello")
            .setContentText("中华人民共和国")
            .setDefaults(Notification.DEFAULT_SOUND)
        // nb.setVibrate(new long[]{0, 50, 100, 150});
         //   .setWhen(System.currentTimeMillis())
            .setContentIntent(pi)
            .setSmallIcon(R.drawable.sky)
            .build();

        nm.notify(NOTIFICATION_ID, notify);
    }

    public void del(View v) {
        nm.cancel(NOTIFICATION_ID);
    }
}
