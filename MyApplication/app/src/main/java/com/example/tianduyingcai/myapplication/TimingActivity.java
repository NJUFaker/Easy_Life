package com.example.tianduyingcai.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.os.Vibrator;
import android.app.*;

public class TimingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing);
        final TextView tv=findViewById(R.id.show);
        Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        int minute=Integer.valueOf(data);
        final CountDownTimer timer = new CountDownTimer(minute*60*1000+1000, 1000) {
            // 第一个是设置时间 第二个是每次跳转的间隔
            long second;
            long hour;
            @Override
            public void onTick(long millisUntilFinished) {
                hour=millisUntilFinished/(1000*60*60);
                second = (millisUntilFinished/1000)-hour*3600;
                tv.setText(String.format("%02d",hour)+":"+String.format("%02d",second/60)+":"+String.format("%02d",second%60));//格式好办
            }
            @Override
            public void onFinish() {
                Vibrator vibrator = (Vibrator) getApplication().getSystemService(Service.VIBRATOR_SERVICE);
                long[] patten={100,1000};
                vibrator.vibrate(patten,-1);
                tv.setEnabled(true);
                tv.setText("计时结束"); }
        };
        timer.start();

        Button button3=findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                timer.start();
            }
        });

        Button button4=findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                timer.cancel();
                finish();
            }
        });
    }
 /*    public CountDownTimer timer = new CountDownTimer(minute*60*1000+1000, 1000) {
        // 第一个是设置时间 第二个是每次跳转的间隔
        long second;
        @Override
        public void onTick(long millisUntilFinished) {
            second = (millisUntilFinished/1000);
            tv.setText(String.format("%02d",second/60)+":"+String.format("%02d",second%60));//格式好办
        }

        @Override
        public void onFinish() {
            tv.setEnabled(true);
            tv.setText("计时结束");
        }
    }; */
/*    public void oncancel(View v) {
        timer.cancel();

    } */
    /**
     * 开始倒计时
     * @param v
     */
  /*  public void restart(View v) {
        timer.start();
    }   */
}
