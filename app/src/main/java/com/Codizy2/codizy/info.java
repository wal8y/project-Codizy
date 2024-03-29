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
    private AdView madv;
    Intent intent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        madv = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        madv.loadAd(adRequest);
        madv.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
            }
            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }
            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });
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