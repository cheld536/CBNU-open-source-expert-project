package com.example.doitmission_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView, imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(" 2018038014 김윤희");

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);

    }
    public void btnclick(View view){
     switch (view.getId()){
         case R.id.btnup:
             imageView.setImageResource(R.drawable.cat);
             imageView2.setImageResource(0);
             break;
         case R.id.btndown :
             imageView2.setImageResource(R.drawable.cat);
             imageView.setImageResource(0);
     }
    }
}