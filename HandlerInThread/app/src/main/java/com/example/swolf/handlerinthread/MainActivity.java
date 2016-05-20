package com.example.swolf.handlerinthread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String key = "Hello";
    CalThread calThread;

    class CalThread extends Thread {
        public Handler myHandler;
        @Override
        public void run() {
            Looper.prepare();

            myHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    if(msg.what == 123) {
                        int number = msg.getData().getInt(key);
                        List<Integer> data = new ArrayList<Integer>();

                        outer:
                        for (int i = 2; i <= number; i++){
                            System.out.println("sqrt i: " + Math.sqrt(i));
                            for (int j = 2; j <= Math.sqrt(i); j++) {
                                if (i != 2 && i % j == 0) {
                                    continue outer;
                                }
                            }
                            data.add(i);
                        }
                        Toast.makeText(MainActivity.this,
                                data.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            };

            Looper.loop();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        calThread = new CalThread();
        calThread.start();
    }

    public void cal(View V) {
        int number = Integer.parseInt(editText.getText().toString());

        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putInt(key, number);
        msg.what = 123;
        msg.setData(bundle);
        calThread.myHandler.sendMessage(msg);
    }
}
