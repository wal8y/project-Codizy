package com.Codizy2.codizy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class info extends AppCompatActivity {
    Intent intent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void sendHome(View v){
        intent = new Intent(this, HomePage.class);
        startActivity(intent);
        finish();
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
      Toast toast = Toast.makeText(this, "you are in infopage already !",Toast.LENGTH_LONG);
      toast.show();
    }
}