package com.example.a5_5;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button[] numBtn = new Button[10];                               // 숫자
    Integer[] numBtnId = {R.id.but_0,R.id.but_1,R.id.but_2,R.id.but_3,
            R.id.but_4,R.id.but_5,R.id.but_6,R.id.but_7,R.id.but_8,R.id.but_9};

    Button btn_add,btn_sub,btn_div,btn_mul;                         // 계산기능

    EditText edit1,edit2;

    String num1,num2;

    Integer result;
    TextView tView;

    int i;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("2018038014 김윤희 그리드계산기");

        // 에디트텍스트
        edit1 = (EditText) findViewById(R.id.edit_1);
        edit2 = (EditText) findViewById(R.id.edit_2);


        // 계산 버튼
        btn_add =(Button) findViewById(R.id.Add);
        btn_div =(Button) findViewById(R.id.Div);
        btn_mul =(Button) findViewById(R.id.Mul);
        btn_sub =(Button) findViewById(R.id.Sub);

        //계산 결과 텍스트
        tView =(TextView) findViewById(R.id.result);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                tView.setText( result.toString());

            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                tView.setText( result.toString());

            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                tView.setText( result.toString());

            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                tView.setText( result.toString());

            }
        });

        for(i=0; i<numBtnId.length;i++){
            numBtn[i] = (Button) findViewById(numBtnId[i]);

        }
        for(i=0; i<numBtnId.length;i++){
            final int index;
            index = i;

            numBtn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edit1.isFocused() == true){
                        num1 = edit1.getText().toString() + numBtn[index].getText().toString();
                        edit1.setText(num1);
                    }
                    else if(edit2.isFocused() ==true){
                        num2 = edit2.getText().toString() + numBtn[index].getText().toString();
                        edit2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(),"먼져 에디트 텍스트를 선택하세요.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }



    }
}