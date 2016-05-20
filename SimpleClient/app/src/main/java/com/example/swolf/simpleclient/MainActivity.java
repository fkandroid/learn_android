package com.example.swolf.simpleclient;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    TextView show;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what == 0x100){
                String data = msg.getData().getString("Hello");
                show.setText("来自服务器的消息: " + data);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = (TextView) findViewById(R.id.show);

        new Thread(){
            @Override
            public void run(){
                try{
                    Socket socket = new Socket("192.168.1.100", 30000);

                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(socket.getInputStream())
                    );

                    String line = br.readLine();
                    Bundle bundle = new Bundle();
                    bundle.putString("Hello", line);
                    Message msg = new Message();
                    msg.what=0x100;
                    msg.setData(bundle);
                    mHandler.sendMessage(msg);
                    br.close();
                    socket.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
