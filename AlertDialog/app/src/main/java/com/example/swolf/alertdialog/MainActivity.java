package com.example.swolf.alertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView show;
    String[] items = new String[]{"Java", "Python", "Go"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = (TextView) findViewById(R.id.textView);
    }

    public void simple(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("简单对话框")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("简单对话框测试:\n这就是结果");
        setPositiveButton(builder);
        setNegativeButton(builder);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder){
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了确定按钮");
            }
        });
    }

    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder){
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了取消按钮");
            }
        });
    }

    public void simpleList(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Simple List Dialog")
                .setIcon(R.mipmap.ic_launcher)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show.setText(items[which] + "被选中了");
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();
    }

    public void singleChoice(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Single Choice Dialog")
                .setIcon(R.mipmap.ic_launcher)
                .setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show.setText("您选中了" + items[which]);
                    }
                });
        setPositiveButton(builder).create().show();
    }

    public void multiChoice(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Multi Choice Dialog")
                .setMultiChoiceItems(
                        items,
                        new boolean[]{true, true, false},
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    show.setText(items[which] + "被选中了");
                                } else {
                                    show.setText(items[which] + "没被选中了");
                                }
                            }
                        });
        setPositiveButton(builder).create().show();
    }

    public void customList(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("自定义列表(Adaptor)对话框")
                .setAdapter(new ArrayAdapter<String>(MainActivity.this, R.layout.item, items),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                show.setText("Adaptor选中了" + items[which]);
                            }
                        });
        setPositiveButton(builder).create().show();
    }

    public void customView(View v) {
        TableLayout layout = (TableLayout) getLayoutInflater().inflate(R.layout.login, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Custom View Dialog")
                .setView(layout)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show.setText("您已取消登陆");
                    }
                })
                .setPositiveButton("登陆", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show.setText("您已登陆");
                    }
                });
        builder.create().show();

    }
}
