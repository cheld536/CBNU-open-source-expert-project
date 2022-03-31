package com.example.practice4_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    TextView text1,text2;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    CheckBox checkBox;
    Switch swiAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog,rdoCat,rdoRabbit;
    Button btnOK ;
    ImageView imgPet;

    


    @SuppressLint({"WrongViewCast", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("내가 좋아하는 동물사진 2018038014 김윤희");

        text1 = (TextView) findViewById(R.id.Text1);
        checkBox = (CheckBox) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoDog = (RadioButton) findViewById(R.id.Dog);
        rdoCat = (RadioButton) findViewById(R.id.cat);
        rdoRabbit = (RadioButton) findViewById(R.id.Lesser_panda);

        btnOK = (Button) findViewById(R.id.button);


        imgPet = (ImageView) findViewById(R.id.Imgpet);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBox.isChecked() ==true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }
                else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        rGroup1.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (rGroup1.getCheckedRadioButtonId()) {
                case R.id.Dog:
                    imgPet.setImageResource(R.drawable.dog);
                    imgPet.setVisibility(View.INVISIBLE);
                    break;
                case R.id.cat:
                    imgPet.setImageResource(R.drawable.cat);
                    imgPet.setVisibility(View.INVISIBLE);
                    break;
                case R.id.Lesser_panda:
                    imgPet.setImageResource(R.drawable.rat);
                    imgPet.setVisibility(View.INVISIBLE);
                    break;
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPet.setVisibility(View.VISIBLE);
            }
        });
        
    }
}