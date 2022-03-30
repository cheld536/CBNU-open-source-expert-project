package com.example.project4_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd , btnSub,btnMul,btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");
        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd =(Button) findViewById(R.id.BtnAdd);
        btnDiv=(Button) findViewById(R.id.BtnDiv);
        btnMul=(Button)findViewById(R.id.BtnMul);
        btnSub=(Button)findViewById(R.id.BtnSub);
        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener((arg0, arg1) -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) + Integer.parseInt(num2);
            textResult.setText("계산 결과 : " + result);
            return false;
        });

        btnSub.setOnTouchListener((arg0, arg1) -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) - Integer.parseInt(num2);
            textResult.setText("계산 결과 : " + result);
            return false;
        });
        btnMul.setOnTouchListener((arg0, arg1) -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) * Integer.parseInt(num2);
            textResult.setText("계산 결과 : " + result);
            return false;
        });
        btnDiv.setOnTouchListener((arg0, arg1) -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) / Integer.parseInt(num2);
            textResult.setText("계산 결과 : " + result);
            return false;
        });
    }
}