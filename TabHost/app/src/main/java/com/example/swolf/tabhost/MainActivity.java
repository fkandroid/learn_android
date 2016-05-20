package com.example.swolf.tabhost;

import android.app.ActionBar;
import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("通话记录")
                .setContent(R.id.linearLayout)
                .setIndicator("Hello");
        tabHost.addTab(tabSpec);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setContent(R.id.linearLayout2);
        tab2.setIndicator("呼入电话", getResources().getDrawable(R.mipmap.ic_launcher));
        tabHost.addTab(tab2);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3")
                .setIndicator("呼出电话")
                .setContent(R.id.linearLayout3);
        tabHost.addTab(tab3);
    }
}
