package com.rgm.admobtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialActivity extends Activity {

	private InterstitialAd interstitial;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_interstitial);
		
		Button btnIsReady = (Button) findViewById(R.id.btnIsReady);
		Button btnDisplay = (Button) findViewById(R.id.btnShowInterstitial);
		
		btnIsReady.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				isReady();				
			}
		});
		
		btnDisplay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				displayInterstitial();				
			}
		});
		
		// TODO: Create interstitial object.
		interstitial = new InterstitialAd(this);
		interstitial.setAdUnitId(Config.INTERSTITIAL_AD_UNIT_ID);
		
		// TODO: Request interstitial ad.
		AdRequest adRequest = new AdRequest.Builder().addTestDevice(Config.TEST_DEVICE_ID).build();
		interstitial.loadAd(adRequest);
		
	}
	
	private void isReady(){
		if(interstitial.isLoaded()){
			Toast.makeText(this, "Ad is ready", Toast.LENGTH_SHORT).show();
			displayInterstitial();
		}else{
			Toast.makeText(this, "Ad is not ready", Toast.LENGTH_SHORT).show();
		}
	}
	
	private void displayInterstitial(){
		if(interstitial.isLoaded()){
			interstitial.show();
		}
	}
}
