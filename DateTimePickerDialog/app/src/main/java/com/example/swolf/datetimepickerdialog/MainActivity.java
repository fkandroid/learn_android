package com.example.swolf.datetimepickerdialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView show;
    int[] data = new int[100];
    int progressStatus = 0;
    int currentIndex = 0;
    ProgressDialog pd;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what == 0x123){
                pd.setProgress(progressStatus);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView) findViewById(R.id.show);
    }

    public void showDatePickerDialog(View v) {
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                show.setText("您选择了" + year + "年" + (monthOfYear+1) + "月" + dayOfMonth + "日");
            }
        },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void showTimePickerDialog(View v) {
        Calendar c = Calendar.getInstance();
        new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                     @Override
                     public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        show.setText("你选择了" + hourOfDay + "时" + minute + "分");
                    }
                },
                c.get(Calendar.HOUR),
                c.get(Calendar.MINUTE),
                true).show();
    }

    public void showSimpleProgressDialog(View v) {
        try {
            ProgressDialog.show(
                    this,
                    "简单的progress dialog",
                    "这是一个简单的Progress Dialog",
                    false,
                    true
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showIndeterminateDialog(View v) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Indaterminate Dialog");
        progressDialog.setMessage("任务正在执行中,请稍后...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    public void showComplexProgressDialog(View v) {
        pd = new ProgressDialog(this);
        pd.setMax(100);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setTitle("执行任务百分比");
        pd.setMessage("执行任务显示");
        pd.setCancelable(false);
        pd.setIndeterminate(false);
        pd.show();

        new Thread() {

            public void run() {
                while(progressStatus < 100){
                    progressStatus = doWork();
                    // pd.setProgress(progressStatus);
                    handler.sendEmptyMessage(0x123);
                }
                if(progressStatus >= 100){
                    pd.dismiss();
                }
            }
        }.start();
    }

    public int doWork(){
        int n = (int) (Math.random()*100);
        data[currentIndex++] = n;
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return currentIndex;
    }
}
