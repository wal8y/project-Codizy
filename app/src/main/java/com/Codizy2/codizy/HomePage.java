package com.Codizy2.codizy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class HomePage extends AppCompatActivity {
    SharedPrefs sharedPrefs;
    EditText name,age;
    TextView warn;
    Intent intent;
    Button[] steps = new Button[5];
    Button finish;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPrefs = new SharedPrefs(this);
        if (sharedPrefs.getUserName().equals("")){
            setFirstEntry();
        }else {
            setHomePage();
        }
    }

    private void setFirstEntry(){
        setContentView(R.layout.first_entry);
        name=findViewById(R.id.Name);
        age=findViewById(R.id.age);
        warn=findViewById(R.id.warn);
    }
    public void setHomePage(){
        setContentView(R.layout.homepage);
        steps[0]=findViewById(R.id.step1);
        steps[1]=findViewById(R.id.step2);
        steps[2]=findViewById(R.id.step3);
        steps[3]=findViewById(R.id.step4);
        steps[4]=findViewById(R.id.step5);
        finish = findViewById(R.id.finish);
        TextView hey = findViewById(R.id.hey);
        hey.setText("Hello "+sharedPrefs.getUserName()+"!");
        int lvl = sharedPrefs.getLevel();
        for (int i =0;i < steps.length && i <= lvl;i++){
            steps[i].setBackgroundColor(Color.BLUE);
            steps[i].setEnabled(true);
        }
        if(lvl>=5){
            finish.setBackgroundColor(Color.BLUE);
            finish.setEnabled(true);
        }
    }

    public void firstStart(View v){
        if (name.getText().toString().isEmpty()||age.getText().toString().isEmpty()){
            warn.setTextColor(Color.RED);
            warn.setText("Please enter your info !");
        } else {
            sharedPrefs.SaveFirstlog(name.getText().toString(),Integer.parseInt(age.getText().toString()),0);
            setContentView(R.layout.homepage);
            setHomePage();
        }
    }

    public void toQus(View v){
         intent = new Intent(this, question.class);
         int lvl;
        if (v.getId() == steps[0].getId()) {
            lvl = 1;
        } else if (v.getId() == steps[1].getId()) {
            lvl = 2;
        } else if (v.getId() == steps[2].getId()) {
            lvl = 3;
        } else if (v.getId() == steps[3].getId()) {
            lvl = 4;
        } else if (v.getId() == steps[4].getId()) {
            lvl = 5;
        } else {
            lvl = 1;
        }
         intent.putExtra("lvl",lvl);
         startActivity(intent);
    }

    public void sendHome(View v){
        Toast toast = Toast.makeText(this, "you are in homepage already !",Toast.LENGTH_LONG);
        toast.show();
    }
    public void sendInte(View v){
        intent = new Intent(this,interprate.class);
        startActivity(intent);
        finish();
    }
    public void sendRes(View v){
        intent = new Intent(this, Res.class);
        startActivity(intent);
        finish();
    }
    public void sendInfo(View v){
        intent = new Intent(this, info.class);
        startActivity(intent);
        finish();
    }
    public void finish(View v){
        Toast.makeText(this, "you have finished all codizy levels !🎉",Toast.LENGTH_LONG).show();
    }
}