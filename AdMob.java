package com.tbd.admobandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;



public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //App AdMob id
        //ca-app-pub-7739983431162311~3609509421

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        //Banner Ad id
        //ca-app-pub-7739983431162311/7944888997

        //Banner Test id
        //ca-app-pub-3940256099942544/6300978111

        //İnterstitial Test id
        //ca-app-pub-3940256099942544/1033173712

        //Interstitial Ad
        //ca-app-pub-7739983431162311/3815385377

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //alttaki kısım opsiyonel koymasan da olur
        //raklam açıldığında kapandığında yapmak istediğin bişeyler varsa alttaki kod bloklarıyla yapabilirsin.

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                // reklam yükledi

                Toast.makeText(getApplicationContext(), "Ad loaded", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
    }

    public void  goToSecond (View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}