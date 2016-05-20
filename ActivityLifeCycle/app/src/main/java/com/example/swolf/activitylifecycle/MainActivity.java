package com.example.swolf.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "==================MyActivity: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.startButton);
        Button finish = (Button) findViewById(R.id.finishButton);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                startActivity(intent);
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        Toast.makeText(MainActivity.this, "MainActivity  onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(MainActivity.this, "MainActivity onReStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Toast.makeText(MainActivity.this, "MainActivity onReSume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Toast.makeText(MainActivity.this, "MainActivity onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(MainActivity.this, "MainActivity onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(MainActivity.this, "MainActivity onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
