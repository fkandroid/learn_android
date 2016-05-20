package com.example.swolf.windowfeatureprocess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowId;
import android.widget.Button;
import android.view.Window;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            //requestWindowFeature(Window.FEATURE_PROGRESS);
            requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            Button bnShow = (Button) findViewById(R.id.bn1);
            Button bnHide = (Button) findViewById(R.id.bn2);
            bnShow.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //setProgressBarVisibility(true);
                    setProgressBarIndeterminateVisibility(true);
                }
            });

            bnHide.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //setProgressBarVisibility(false);
                    setProgressBarIndeterminateVisibility(false);
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
