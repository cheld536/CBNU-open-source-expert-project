package com.example.api;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ApiActivity  extends AppCompatActivity implements Serializable{
    private String key = "your_key";
    private String address = "http://api.data.go.kr/openapi/tn_pubr_public_trrsrt_api";
    private String pageNo = "0";
    private String numOfRows = "100";
    private String type = "json";
    private ListView listView;
    private Button btnData;
    ArrayAdapter adapter;

    // 관광명소 이름를 담을 ArrayList 변수(travel) 선언
    ArrayList<String> travelname = new ArrayList<String>();
    // 관광명소정보를 담을 MAP<관광지명, 관광정보 배열> 선언
    Map<String, ArrayList<String>> travel = new HashMap<String, ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        listView = (ListView) findViewById(R.id.listView1);
        // adapter 스타일 선언 및 travel 적용
        adapter = new ArrayAdapter(this, R.layout.listviewfont, travelname);
        // listView에 adapter 적용
        listView.setAdapter(adapter);
        btnData = (Button) findViewById(R.id.btnData);

        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        travelname.clear();
                        String urlAddress = address + "?serviceKey=" + key + "&pageNo=" + pageNo + "&numOfRows=" + numOfRows + "&type=" + type;

                        try {
                            URL url = new URL(urlAddress);

                            InputStream is = url.openStream();
                            InputStreamReader isr = new InputStreamReader(is);
                            BufferedReader reader = new BufferedReader(isr);

                            StringBuffer buffer = new StringBuffer();
                            String line = reader.readLine();
                            while (line != null) {
                                buffer.append(line + "\n");
                                line = reader.readLine();
                            }

                            String jsonData = buffer.toString();

                            // jsonData를 먼저 JSONObject 형태로 바꾼다.
                            JSONObject obj = new JSONObject(jsonData);
                            // obj의 "response"의 JSONObject를 추출
                            JSONObject response = (JSONObject) obj.get("response");
                            // response의 JSONObject에서 "body"의 JSONObject 추출
                            JSONObject body = (JSONObject) response.get("body");
                            // body의 JSONObject에서 "items"의 JSONArray 추출
                            JSONArray items = (JSONArray) body.get("items");

                            for (int i = 0; i < items.length(); i++) {
                                JSONObject temp = items.getJSONObject(i);
                                ArrayList<String> travelinfo = new ArrayList<String>();
                                String trrsrtNm = temp.getString("trrsrtNm");
                                travelinfo.add(temp.getString("trrsrtNm"));
                                travelinfo.add(temp.getString("trrsrtSe"));
                                travelinfo.add(temp.getString("rdnmadr"));
                                travelinfo.add(temp.getString("lnmadr"));
                                travelinfo.add(temp.getString("latitude"));
                                travelinfo.add(temp.getString("longitude"));
                                travelinfo.add(temp.getString("ar"));
                                travelinfo.add(temp.getString("cnvnncFclty"));
                                travelinfo.add(temp.getString("stayngInfo"));
                                travelinfo.add(temp.getString("mvmAmsmtFclty"));
                                travelinfo.add(temp.getString("recrtClturFclty"));
                                travelinfo.add(temp.getString("hospitalityFclty"));
                                travelinfo.add(temp.getString("sportFclty"));
                                travelinfo.add(temp.getString("appnDate"));
                                travelinfo.add(temp.getString("aceptncCo"));
                                travelinfo.add(temp.getString("prkplceCo"));
                                travelinfo.add(temp.getString("trrsrtIntrcn"));
                                travelinfo.add(temp.getString("phoneNumber"));
                                travelinfo.add(temp.getString("institutionNm"));
                                travelinfo.add(temp.getString("referenceDate"));

                                travelname.add(trrsrtNm);
                                travel.put(trrsrtNm, travelinfo);
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.notifyDataSetChanged();
                                }
                            });

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(),InfoActivity.class);
                intent.putExtra("trrNM",data);
                intent.putExtra("value",(Serializable)travel.get(data));
                startActivity(intent);
            }
        });

    }
}/*
    trrsrtNm =관광지명
    trrsrtSe = 관광지구분
    rdnmadr = 소재지도로명주소
    kcal = 소재지지번주소
    latitude = 위도
    longitude = /경도
    ar = 위면적
    cnvnncFclty = 공공편익시설정보
    stayngInfo= 숙박시설정보
    mvmAmsmtFclty    =운동및오락시설정보
    recrtClturFclty = 휴양및문화시설정보
    hospitalityFclty = 접객시설정보
    sportFclty = 지원시설정보
    appnDate = 지정일자
    aceptncCo = 수용인원수
    prkplceCo = 주차가능수
    trrsrtIntrcn = 관광지소개
    phoneNumber    = 관리기관전화번호
    institutionNm = 관리기관명
    referenceDate = 데이터기준일자
*/
