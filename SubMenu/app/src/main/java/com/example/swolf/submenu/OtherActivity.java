package com.example.swolf.submenu;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by swolf on 16/3/29.
 */
public class OtherActivity extends AppCompatActivity{

    final int MENU1 = 0x200;
    final int MENU2 = 0x201;
    final int MENU3 = 0x202;

    private TextView txt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        txt = (TextView) findViewById(R.id.textView);
        registerForContextMenu(txt);
    }

    @Override
    public void onCreateContextMenu(
            ContextMenu menu, View source, ContextMenu.ContextMenuInfo menuInfo){
        menu.add(0, MENU1, 0, "红色");
        menu.add(0, MENU2, 0, "蓝色");
        menu.add(0, MENU3, 0, "绿色");
        menu.setGroupCheckable(0, true, true);
        menu.setHeaderIcon(R.drawable.greatwall);
        menu.setHeaderTitle("Select color");
    }

    @Override
    public boolean onContextItemSelected(MenuItem mi) {
        switch (mi.getItemId()) {
            case MENU1:
                mi.setChecked(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case MENU2:
                mi.setChecked(true);
                txt.setBackgroundColor(Color.BLUE);
                break;
            case MENU3:
                mi.setChecked(true);
                txt.setBackgroundColor(Color.GREEN);
                break;
        }
        return true;
    }
}
