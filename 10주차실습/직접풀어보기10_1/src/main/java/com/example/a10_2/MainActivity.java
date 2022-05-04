package com.example.a10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2018038014 김윤희");

        final RadioButton rdoSecond = findViewById(R.id.rdoSecond);

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;

                if(rdoSecond.isChecked() == true)
                    intent = new Intent(getApplicationContext(),SecondActivity.class);
                else
                    intent = new Intent(getApplicationContext(),ThirdActivity.class);

                startActivity(intent);
            }
        });










    }
}