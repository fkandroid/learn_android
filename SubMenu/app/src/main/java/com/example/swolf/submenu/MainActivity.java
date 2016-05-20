package com.example.swolf.submenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int FONT_10 = 0x111;
    final int FONT_12 = 0x112;
    final int FONT_14 = 0x113;
    final int FONT_16 = 0x114;
    final int FONT_18 = 0x115;

    final int FONT_BLUE = 0x116;
    final int FONT_GREEN = 0x117;
    final int FONT_RED = 0x118;

    final int PLAINT_ITEM = 0x11a;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        editText.setText("Hello World, 精彩世界");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        fontMenu.setIcon(R.drawable.font);
        fontMenu.setHeaderIcon(R.drawable.font);
        fontMenu.setHeaderTitle("请选择字体大小");
        fontMenu.add(0, FONT_10, 0, "10号字体");
        fontMenu.add(0, FONT_12, 0, "12号字体");
        fontMenu.add(0, FONT_14, 0, "14号字体");
        fontMenu.add(0, FONT_16, 0, "16号字体");
        fontMenu.add(0, FONT_18, 0, "18号字体");

        menu.add(0, PLAINT_ITEM, 0, "普通菜单项");

        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setIcon(R.drawable.waterfall);
        colorMenu.setHeaderIcon(R.drawable.waterfall);
        colorMenu.setHeaderTitle("请选择字体颜色");
        colorMenu.add(0, FONT_BLUE, 0, "蓝色");
        colorMenu.add(0, FONT_GREEN, 1, "绿色");
        MenuItem item = colorMenu.add(0, FONT_RED, 0, "红色");
        item.setIntent(new Intent(this, OtherActivity.class));

        SubMenu toMenu = menu.addSubMenu("跳转");
        toMenu.setHeaderIcon(R.drawable.waterfall);
        toMenu.setHeaderTitle("即将跳转");
        MenuItem menuItem = toMenu.add("跳转到other activity");
        menuItem.setIntent(new Intent(this, OtherActivity.class));

        return super.onCreateOptionsMenu(menu);
    }

//    public boolean onOptionsItemSelected(MenuItem mi) {
//        switch (mi.getItemId()) {
//            case FONT_10:
//                editText.setTextSize(10*2);
//                break;
//            case FONT_12:
//                editText.setTextSize(12 * 2);
//                break;
//            case FONT_14:
//                editText.setTextSize(14 * 2);
//                break;
//            case FONT_16:
//                editText.setTextSize(16 * 2);
//                break;
//            case FONT_BLUE:
//                editText.setTextColor(Color.BLUE);
//                break;
//            case FONT_GREEN:
//                editText.setTextColor(Color.GREEN);
//                break;
//            case FONT_RED:
//                editText.setTextColor(Color.RED);
//                break;
//
//            case PLAINT_ITEM:
//                Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show();
//                break;
//        }
//        return true;
//    }

    public void showPopupMenu(View v) {
        final PopupMenu popupMenu = new PopupMenu(this, v);
        getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.exit:
                        popupMenu.dismiss();
                        break;
                    default:
                        Toast.makeText(
                                MainActivity.this,
                                "您单击了" + item.getTitle() + "菜单项",
                                Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        popupMenu.show();
    }
}

