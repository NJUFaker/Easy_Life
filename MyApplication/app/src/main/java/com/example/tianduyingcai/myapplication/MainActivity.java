/*package com.example.tianduyingcai.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}*/
package com.example.tianduyingcai.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.*;
import java.io.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,TimerActivity.class);
                startActivity(intent);
            }
        });

        int line=5;
        TextView tv1=findViewById(R.id.textView);
        try{
            FileReader fr=new FileReader("com.example.tianduyingcai.myapplication/source.txt");
            BufferedReader br=new BufferedReader(fr);
            int x=new Random().nextInt(line);
            String temp=null;
            for(int i=1;i<line;i++){
                temp=br.readLine();
            }
            String sentence=br.readLine();
            tv1.setText(sentence);
        }catch(Exception e){};
    }
}

