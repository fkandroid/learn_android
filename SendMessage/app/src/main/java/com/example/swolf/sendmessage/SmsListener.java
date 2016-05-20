package com.example.swolf.sendmessage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by swolf on 16/4/10.
 */
public class SmsListener implements View.OnLongClickListener {
    private AppCompatActivity act;
    private TextView phone;
    private TextView message;
    public SmsListener (AppCompatActivity act, TextView phone, TextView message) {
        this.act = act;
        this.phone = phone;
        this.message = message;
    }

    @Override
    public boolean onLongClick(View v) {
        String toPhone = phone.getText().toString();
        String toMessage = message.getText().toString();

        PendingIntent intent = PendingIntent.getBroadcast(act, 0, new Intent(), 0);
        Toast.makeText(act, "即将发送", Toast.LENGTH_SHORT).show();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(toPhone, null, toMessage, intent, null);

        Toast.makeText(act, "短信已发送", Toast.LENGTH_SHORT).show();
        return false;
    }
}
