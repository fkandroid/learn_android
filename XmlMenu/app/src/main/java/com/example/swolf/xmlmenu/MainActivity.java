package com.example.swolf.xmlmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.textView);
        registerForContextMenu(txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(
            ContextMenu menu, View source, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.context, menu);
        menu.setHeaderTitle("请选择背景");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        if (mi.isCheckable()) {
            mi.setChecked(true);
        }

        switch (mi.getItemId()) {
            case R.id.font10:
                txt.setTextSize(10*2);
                break;
            case R.id.font18:
                txt.setTextSize(18 * 2);
                break;
            case R.id.fontBlue:
                txt.setTextColor(Color.BLUE);
                break;
            case R.id.fontGreen:
                txt.setTextColor(Color.GREEN);
                break;
            case R.id.fontRed:
                txt.setTextColor(Color.RED);
                break;
            case R.id.plainItem:
                Toast.makeText(this, "Plan Menu Item Selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem mi) {
        mi.setChecked(true);
        switch (mi.getItemId()) {
            case R.id.green:
                txt.setBackgroundColor(Color.GREEN);
                break;
            case R.id.red:
                txt.setBackgroundColor(Color.RED);
                break;
            case R.id.blue:
                txt.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }
}
