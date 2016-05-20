package com.example.swolf.buddletest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.crazy.model.Person;

/**
 * Created by swolf on 16/5/6.
 */
public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        TextView name = (TextView) findViewById(R.id.showName);
        TextView pass = (TextView) findViewById(R.id.showPassword);
        TextView gender = (TextView) findViewById(R.id.showGender);

        Intent intent = getIntent();
        Person p = (Person) intent.getSerializableExtra("person");
        name.setText("您的用户名为: " + p.getName());
        pass.setText("您的密码为: " + p.getPass());
        gender.setText("您的性别为: " + p.getGender());
    }
}
