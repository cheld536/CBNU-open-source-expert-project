package com.example.api;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity implements Serializable {
    TextView TxtTrrsrtNm,TxtLocation, TxtInfo;
    ImageButton Webview_btn_google, Webview_btn_naver, Webview_btn_daum;

    WebView wView;
    ProgressBar pBar;
    private String url = "https://search.naver.com/search.naver?where=view&sm=tab_jum&query="; ;             // 네이버주소

   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TxtTrrsrtNm = (TextView) findViewById(R.id.txtTrrsrtNm);
        TxtInfo = (TextView) findViewById(R.id.txtinfo);
        TxtLocation = (TextView)findViewById(R.id.txtlocation);
        String trrnm = getIntent().getSerializableExtra("trrNM").toString();

        ArrayList<String> value =(ArrayList<String>)getIntent().getSerializableExtra("value");

        TxtTrrsrtNm.setText(trrnm);

        TxtLocation.setText(value.get(1));
        TxtInfo.setText(value.get(2));

        // 웹뷰
        Webview_btn_google = findViewById(R.id.googlemap);
        Webview_btn_naver = findViewById(R.id.naversearch);
        Webview_btn_daum = findViewById(R.id.daumsearch);


        Webview_btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WebViewActivity.class);
                intent.putExtra("travelNM", trrnm);
                startActivity(intent);
            }
        });
//네이버

       Webview_btn_naver.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),naver.class);
               intent.putExtra("travelNM", trrnm);
               startActivity(intent);
           }
       });

//다음
       Webview_btn_daum.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),daum.class);
               intent.putExtra("travelNM", trrnm);
               startActivity(intent);
           }
       });


/*
   travel_Nm 관광지명 0
   travel_location 주소 1
   travel_info 정보 2
 */
    }
}