package com.example.swolf.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText editText;
    ProgressDialog pdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void download(View v) throws MalformedURLException {
        DownTask task = new DownTask(this);
        String url = "http://" + editText.getText().toString();
        task.execute(new URL(url));
    }

    class DownTask extends AsyncTask<URL, Integer, String> {

        int hasRead = 0;
        Context mContext;

        public DownTask(Context ctx) {
            mContext = ctx;
        }

        @Override
        protected String doInBackground(URL... params) {
            StringBuilder sb = new StringBuilder();
            try {
                URLConnection conn = params[0].openConnection();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                    publishProgress(++hasRead);
                    Thread.sleep(10);
                }
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            pdialog = new ProgressDialog(MainActivity.this);
            pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pdialog.setTitle("下载进度条");
            pdialog.setMessage("任务进行中, 请稍后...");
            pdialog.setIndeterminate(false);
            pdialog.setMax(500);
            pdialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            text.setText(s);
            pdialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            text.setText("已经处理" + values[0] + "行");
            pdialog.setProgress(values[0]);
        }
    }
}
