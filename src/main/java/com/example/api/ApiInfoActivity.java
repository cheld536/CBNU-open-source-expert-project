package com.example.api;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApiInfoActivity extends AppCompatActivity implements Serializable {
    TextView TxtTrrsrtNm, TxtInfo;
    Button Webview_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apiinfo);

        TxtTrrsrtNm = (TextView) findViewById(R.id.txtTrrsrtNm);
        TxtInfo = (TextView) findViewById(R.id.txtinfo);
        String trrnm = getIntent().getSerializableExtra("trrNM").toString();

        ArrayList<String> value =(ArrayList<String>)getIntent().getSerializableExtra("value");

        TxtTrrsrtNm.setText(trrnm);
        TxtInfo.setText(value.get(2)+"\n"+value.get(16));


/*
    trrsrtNm =관광지명  0
    trrsrtSe = 관광지구분  1
    rdnmadr = 소재지도로명주소  2
    kcal = 소재지지번주소  3
    latitude = 위도  4
    longitude = 경도 5
    ar = 위면적  6
    cnvnncFclty = 공공편익시설정보  7
    stayngInfo= 숙박시설정보  8
    mvmAmsmtFclty    =운동및오락시설정보  9
    recrtClturFclty = 휴양및문화시설정보  10
    hospitalityFclty = 접객시설정보  11
    sportFclty = 지원시설정보  12
    appnDate = 지정일자  13
    aceptncCo = 수용인원수  14
    prkplceCo = 주차가능수  15
    trrsrtIntrcn = 관광지소개  16
    phoneNumber    = 관리기관전화번호  17
    institutionNm = 관리기관명  18
    referenceDate = 데이터기준일자  19
 */
    }
}