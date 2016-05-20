package com.example.swolf.buttontest;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Chronometer;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        rg = (RadioGroup) findViewById(R.id.radio_group);
        show = (TextView) findViewById(R.id.show);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String tip = checkedId == R.id.female?"您的性别是: 女人":"您的性别是男人";
                show.setText(tip);
            }
        });

        final LinearLayout layout = (LinearLayout) findViewById(R.id.toggle_switch_layout);
        Switch myswitch = (Switch) findViewById(R.id.switcher);
        ToggleButton mytoggle = (ToggleButton) findViewById(R.id.toggle);

        OnCheckedChangeListener listener = new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton button
                        , boolean isChecked){
                if(isChecked){
                    layout.setOrientation(1);  //vertical
                }
                else{
                    layout.setOrientation(0);   //horizontal
                }
            }
        };

        mytoggle.setOnCheckedChangeListener(listener);
        myswitch.setOnCheckedChangeListener(listener);


        final Chronometer timer = (Chronometer) findViewById(R.id.timer);
        final ToggleButton tbutton = (ToggleButton) findViewById(R.id.timer_button);
        final Button nbutton = (Button) findViewById(R.id.nbutton);

        tbutton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    timer.setBase(SystemClock.elapsedRealtime());
                    timer.start();
                }else{
                    timer.stop();
                }
            }
        });

        nbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
                nbutton.setText("正在计时");
                nbutton.setEnabled(false);
            }
        });

        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(SystemClock.elapsedRealtime() - chronometer.getBase() > 20*1000){
                    timer.stop();
                    nbutton.setEnabled(true);
                    nbutton.setText("开始计时");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
