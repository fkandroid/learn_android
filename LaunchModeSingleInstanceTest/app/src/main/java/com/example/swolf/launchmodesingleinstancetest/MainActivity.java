package com.example.swolf.launchmodesingleinstancetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        TextView tv = new TextView(this);
        tv.setText("Activity 为: " + this.toString() + "\n" + ",TaskId 为: " + this.getTaskId());

        Button bn = new Button(this);
        bn.setText("启动Second Activity");

        layout.addView(tv);
        layout.addView(bn);

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.swolf.intent.action.SWOLF_ACTION");
                startActivity(intent);

            }
        });
    }
}
