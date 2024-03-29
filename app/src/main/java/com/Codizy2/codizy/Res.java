package com.Codizy2.codizy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

public class Res extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
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

    public void openLink(View view){
        String url;
        if(view.getId() == R.id.codecademy){
            url = "https://www.codecademy.com/catalog/language/python";
        }else if (view.getId()==R.id.sololearn){
            url="https://www.sololearn.com/en/learn/courses/python-introduction";
        } else if (view.getId() == R.id.w3pd) {
            url="https://www.w3schools.com/python/default.asp";
        }else if (view.getId() == R.id.pracpy) {
            url="https://www.practicepython.org/";
        }else if (view.getId() == R.id.w3pe) {
            url="https://www.w3schools.com/python/python_exercises.asp";
        }else if (view.getId() == R.id.hackerrank) {
            url="https://www.hackerrank.com/domains/python";
        }else if (view.getId() == R.id.apg) {
            url="https://github.com/search?q=awesome+python&amp;type=repositories";
        }else if (view.getId() == R.id.pydocs) {
            url="https://docs.python.org/3/";
        }else if (view.getId() == R.id.sof) {
            url="https://stackoverflow.com/questions/tagged/python";
        }else if (view.getId() == R.id.reddit) {
            url="https://www.reddit.com/r/learnpython/";
        }else {
            url = "https://www.reddit.com/r/learnpython/";
        }

        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendRes(View v){
        Toast toast = Toast.makeText(this, "you are in resources already", Toast.LENGTH_LONG);
        toast.show();
    }
    public void sendInte(View v){
        Intent intent = new Intent(this,interprate.class);
        startActivity(intent);
        finish();
    }
    public void sendHome(View v){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
        finish();
    }
    public void sendInfo(View v){
        Intent intent = new Intent(this, info.class);
        startActivity(intent);
        finish();
    }
}