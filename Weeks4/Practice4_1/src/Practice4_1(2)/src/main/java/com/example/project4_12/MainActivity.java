package com.example.project4_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd , btnSub,btnMul,btnDiv ,btnRem;
    TextView textResult;
    String num1, num2;
    Double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("초간단 계산기 계량버전");
        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd =(Button) findViewById(R.id.BtnAdd);
        btnDiv=(Button) findViewById(R.id.BtnDiv);
        btnMul=(Button)findViewById(R.id.BtnMul);
        btnSub=(Button)findViewById(R.id.BtnSub);
        btnRem=(Button)findViewById(R.id.BtnRem);

        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (edit1.getText().toString().length() == 0 || edit2.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    textResult.setText("계산결과: none");
                } else {
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산결과: " + result.toString());
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (edit1.getText().toString().length() == 0 || edit2.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    textResult.setText("계산결과: none");
                } else {
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산결과: " + result.toString());
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (edit1.getText().toString().length() == 0 || edit2.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    textResult.setText("계산결과: none");
                } else {
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산결과: " + result.toString());
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (edit1.getText().toString().length() == 0 || edit2.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    textResult.setText("계산결과: none");
                } else {
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    textResult.setText("계산결과: " + result.toString());
                }
            }
        });
        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (edit1.getText().toString().length() == 0 || edit2.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    textResult.setText("계산결과: none");
                } else {
                    result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    textResult.setText("계산결과: " + result.toString());
                }
            }
        });
    }
}