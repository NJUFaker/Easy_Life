package com.example.tianduyingcai.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.content.*;
import android.view.*;

public class TimerActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        editText = findViewById(R.id.edit_text);
        final Button button2= findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText=editText.getText().toString();
                if(checkValid(inputText)){
                    String hintText="开始计时："+inputText+"分钟";
                    Toast.makeText(TimerActivity.this,hintText,Toast.LENGTH_SHORT).show();
                    Intent timing=new Intent(TimerActivity.this,TimingActivity.class);
                    timing.putExtra("extra_data",inputText);
                    startActivity(timing);
                }
                else{
                    String hintText="输入格式错误，请输入整数";
                    Toast.makeText(TimerActivity.this,hintText,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public boolean checkValid(String str){
        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}