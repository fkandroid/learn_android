package com.example.swolf.imageview;

import android.app.AlertDialog;
import android.graphics.drawable.BitmapDrawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.graphics.Bitmap;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {

    private int alpha = 255;
    int[] images = new int[] {
            R.drawable.ok,
            R.drawable.ok1,
            R.drawable.ok2,
            R.drawable.ok3
    };
    int currentImage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button plusButton = (Button) findViewById(R.id.plus);
        final Button minusButton = (Button) findViewById(R.id.minus);
        Button nextButton = (Button) findViewById(R.id.next);

        final ImageView image1 = (ImageView) findViewById(R.id.image1);
        final ImageView image2 = (ImageView) findViewById(R.id.image2);

        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == plusButton){
                    alpha += 20;
                }
                if(v == minusButton){
                    alpha -= 20;
                }
                if(alpha >= 255){
                    alpha = 255;
                }

                if(alpha <= 0){
                    alpha = 0;
                }
                image1.setImageAlpha(alpha);
            }
        };

        plusButton.setOnClickListener(listener);
        minusButton.setOnClickListener(listener);
        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.setImageResource(images[++currentImage % images.length]);
            }
        });

        image1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                BitmapDrawable drawable = (BitmapDrawable) image1.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                double wscale = bitmap.getWidth() / 320.0;
                double hscale = bitmap.getWidth() / 320.0;
                int x = (int) (event.getX() * wscale);
                int y = (int) (event.getY() * hscale);
                if(x + 120 > bitmap.getWidth()){
                    x = bitmap.getWidth() - 120;
                }

                if (y + 120 > bitmap.getHeight()){
                    y = bitmap.getHeight() - 120;
                }
                image2.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 120, 120));
                image2.setImageAlpha(alpha);

                return false;
            }
        });

        final QuickContactBadge contact = (QuickContactBadge) findViewById(R.id.contact);
        contact.assignContactFromPhone("13269961530", false);
    }
}
