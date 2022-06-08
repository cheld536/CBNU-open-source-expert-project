package com.example.api;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class mapActivity extends AppCompatActivity {
    Button btnDaejeon, btnSeoul, btnGyeonggi, btnChungbuk, btnJeolnam, btnJeolbuk, btnChungnam, btnGyeongbuk, btnGyeongnam, btnIncheon, btnGwangju, btnUlsan, btnBusan, btnGangwon, btnJeju;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        btnDaejeon = findViewById(R.id.btnDaejeon);
        btnSeoul = findViewById(R.id.btnSeoul);
        btnGyeonggi = findViewById(R.id.btnGyeonggi);
        btnChungbuk = findViewById(R.id.btnchunbuk);
        btnJeolnam = findViewById(R.id.btnJeolnam);
        btnJeolbuk = findViewById(R.id.btnJeolbuk);
        btnChungnam = findViewById(R.id.btnChungnam);
        btnGyeongbuk = findViewById(R.id.btnGyeongbuk);
        btnGyeongnam = findViewById(R.id.btnGyeongnam);
        btnIncheon = findViewById(R.id.btnIncheon);
        btnGwangju = findViewById(R.id.btnGwangju);
        btnUlsan = findViewById(R.id.btnUlsan);
        btnBusan = findViewById(R.id.btnBusan);
        btnGangwon = findViewById(R.id.btnGangwon);
        btnJeju = findViewById(R.id.btnJeju);
        button = findViewById(R.id.button);

        btnDaejeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 1);
                startActivity(intent);

            }
        });
        btnSeoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 2);
                startActivity(intent);

            }
        });
        btnGyeonggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 3);
                startActivity(intent);

            }
        });
        btnChungbuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 4);
                startActivity(intent);

            }
        });
        btnJeolnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 5);
                startActivity(intent);

            }
        });
        btnJeolbuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 6);
                startActivity(intent);

            }
        });
        btnChungnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 7);
                startActivity(intent);

            }
        });
        btnGyeongbuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 8);
                startActivity(intent);

            }
        });

        btnGyeongnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 9);
                startActivity(intent);

            }
        });
        btnIncheon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 10);
                startActivity(intent);

            }
        });
        btnGwangju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 11);
                startActivity(intent);

            }
        });
        btnUlsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 12);
                startActivity(intent);

            }
        });
        btnBusan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 13);
                startActivity(intent);

            }
        });
        btnGangwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 14);
                startActivity(intent);

            }
        });
        btnJeju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlaceActivity.class);
                intent.putExtra("locaNum", 15);
                startActivity(intent);

            }
        });

        // 대구
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ApiActivity.class);
                startActivity(intent);
            }
        });

    }

}
