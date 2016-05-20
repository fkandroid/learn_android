package com.example.swolf.phoneconfiguration;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String[] names = new String[] {
            "屏幕方向",
            "触摸屏",
            "导航类型",
            "移动信号国家码",
            "移动信号网络码",
            "屏幕宽度",
            "屏幕高度",
            "分辨率"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration sysConfig = getResources().getConfiguration();
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(sysConfig.toString());

        final ListView listView = (ListView) findViewById(R.id.listView);

        Button showButton = (Button) findViewById(R.id.showButton);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuration config = getResources().getConfiguration();

                String orientation = config.orientation == Configuration.ORIENTATION_LANDSCAPE?
                        "横向屏幕":"竖向屏幕";
                String touch = config.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH?
                        "无触摸屏":"有触摸屏";
                String navigation = config.navigation + "";
                String countyCode = config.mcc + "";
                String networkCode = config.mnc + "";
                String width = config.screenWidthDp + "dp";
                String height = config.screenHeightDp + "dp";
                String dpi = config.densityDpi + "dpi";

                String[] values = new String[] {
                        orientation, touch, navigation,
                        countyCode, networkCode, width, height, dpi};

                List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

                for (int i=0; i<names.length; i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("name", names[i]);
                    map.put("value", values[i]);
                    dataList.add(map);
                }

                SimpleAdapter adapter = new SimpleAdapter(
                        MainActivity.this,
                        dataList,
                        R.layout.cell,
                        new String[] {"name", "value"},
                        new int[] {R.id.name, R.id.value}
                );

                listView.setAdapter(adapter);

            }
        });
    }

    public void changeConfigByButton(View v) {
        Configuration config = getResources().getConfiguration();
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Toast.makeText(this, "Configuration Change", Toast.LENGTH_SHORT).show();
    }
}
