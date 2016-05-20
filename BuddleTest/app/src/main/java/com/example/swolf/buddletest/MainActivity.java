package com.example.swolf.buddletest;

import com.crazy.model.Person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText) findViewById(R.id.user);
        final EditText password = (EditText) findViewById(R.id.password);
        final RadioButton male = (RadioButton) findViewById(R.id.male);

        Button registerButton = (Button) findViewById(R.id.register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender = male.isChecked() ? "男":"女";
                Person person = new Person(name.getText().toString(),
                        password.getText().toString(), gender);
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("person", person);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
