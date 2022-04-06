package com.example.a5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(255,255,255));
        setContentView(baseLayout,params);


        //에디트 텍스트

        editText = new EditText(this);
        editText.setHint("입력하세요.");
        baseLayout.addView(editText);

        //버튼

        button1 = new Button(this);
        button1.setText("버튼 입니다.");
        button1.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str;
                str = editText.getText().toString();
                textView.setText(str);
            }
        });

        //텍스트 뷰

        textView = new TextView(this);
        textView.setTextSize(30);
        textView.setTextColor(Color.RED);
        baseLayout.addView(textView);
    }
}