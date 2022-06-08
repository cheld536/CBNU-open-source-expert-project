package com.example.api;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class PlaceActivity extends AppCompatActivity implements Serializable {

    private String address = "http://ec2-13-209-74-60.ap-northeast-2.compute.amazonaws.com:3000/local/";
    private ListView listView;
    ArrayAdapter adapter;
    int num;
    // 관광명소 이름를 담을 ArrayList 변수(travel) 선언
    ArrayList<String> travelname = new ArrayList<String>();
    // 관광명소정보를 담을 MAP<관광지명, 관광정보 배열> 선언
    Map<String, ArrayList<String>> travel = new HashMap<String, ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        String locaNum = getIntent().getSerializableExtra("locaNum").toString();
        String url = address +locaNum;

        listView = (ListView) findViewById(R.id.listView1);
        // adapter 스타일 선언 및 travel 적용
        adapter = new ArrayAdapter(this, R.layout.listviewfont, travelname);
        // listView에 adapter 적용
        listView.setAdapter(adapter);

        new Thread() {
            @Override
            public void run() {
                travelname.clear();
                String urlAddress = url;

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
                    JSONArray obj = new JSONArray(jsonData);
                    // obj의 "response"의 JSONObject를 추출

                    for (int i = 0; i < obj.length(); i++) {
                        JSONObject temp = obj.getJSONObject(i);
                        ArrayList<String> travelinfo = new ArrayList<String>();
                        String trrsrtNm = temp.getString("travel_Nm");
                        travelinfo.add(temp.getString("travel_Nm"));
                        travelinfo.add(temp.getString("travel_location"));
                        travelinfo.add(temp.getString("travel_info"));

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), InfoActivity.class);
                intent.putExtra("trrNM",data);
                intent.putExtra("value",(Serializable)travel.get(data));
                startActivity(intent);
            }
        });

    }
}