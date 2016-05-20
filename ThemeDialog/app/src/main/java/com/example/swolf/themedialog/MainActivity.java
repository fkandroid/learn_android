package com.example.swolf.themedialog;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        View root = getLayoutInflater().inflate(R.layout.popup, null);
        final PopupWindow popupWindow = new PopupWindow(root, 300, 400);
        Button popupButton = (Button) findViewById(R.id.popupButton);
        popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // popupWindow.showAsDropDown(v);
                popupWindow.showAtLocation(findViewById(R.id.popupButton), Gravity.CENTER, 20, 20);
            }
        });

        root.findViewById(R.id.closePopupBn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}
