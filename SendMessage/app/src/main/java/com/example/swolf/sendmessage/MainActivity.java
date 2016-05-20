package com.example.swolf.sendmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView phone = (TextView) findViewById(R.id.phoneNum);
        TextView msgTextView = (TextView) findViewById(R.id.Message);
        Button bn = (Button) findViewById(R.id.sendButton);

        bn.setOnLongClickListener(new SmsListener(this, phone, msgTextView));

    }
}
