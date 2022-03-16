package com.example.basicapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    EditText editText1;
    ImageView changingImage;
    RadioGroup imageChangingRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);

        editText1 = (EditText)findViewById(R.id.editText1);

        button2 = (Button) findViewById(R.id.button2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),editText1.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(editText1.getText().toString()));
                startActivity(intent);
            }
        });



        changingImage = (ImageView) findViewById(R.id.imageView2);
        imageChangingRadioGroup = (RadioGroup) findViewById(R.id.radioGroup1);

        imageChangingRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                if(checked==R.id.Radiobutton1)
                {
                    changingImage.setImageResource(R.drawable.cat); //11.0
                }
                else
                {
                    changingImage.setImageResource(R.drawable.face);  //12.0
                }
            }
        });
    }
}