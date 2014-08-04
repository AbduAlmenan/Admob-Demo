package com.rgm.admobtest;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class BannerAdListenerActivity extends Activity {
	private AdView adView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_prog);
        
        adView = new AdView(this);
        adView.setAdUnitId(Config.BANNER_AD_UNIT_ID);
        adView.setAdSize(AdSize.BANNER);
        
        // TODO: Set ad listener.
        adView.setAdListener(new AdListener() {
        	
        	// Called when an ad is received.
        	@Override
        	public void onAdLoaded() {
        		Toast.makeText(BannerAdListenerActivity.this, "On Ad Loaded", Toast.LENGTH_SHORT).show();
        	}
        	
        	// Called when there is an error on the request. ErrorCodes: 
        	// AdRequest.ERROR_CODE_INTERNAL_ERROR
        	// AdRequest.ERROR_CODE_INVALID_REQUEST
        	// AdRequest.ERROR_CODE_NETWORK_ERROR
        	// AdRequest.ERROR_CODE_NO_FILL
        	@Override
        	public void onAdFailedToLoad(int errorCode) {
        		Toast.makeText(BannerAdListenerActivity.this, "On Ad Failed To Load", Toast.LENGTH_SHORT).show();
        	}
        	
        	// Called when an ad is opened.
        	@Override
        	public void onAdOpened() {
        		Toast.makeText(BannerAdListenerActivity.this, "On Ad Opened", Toast.LENGTH_SHORT).show();
        	}
        	
        	// Called when the ad is closed.
        	@Override
        	public void onAdClosed() {
        		Toast.makeText(BannerAdListenerActivity.this, "On Ad Closed", Toast.LENGTH_SHORT).show();
        	}
        	
        	// Called when the ad leaves the application when clicked.
        	@Override
        	public void onAdLeftApplication() {
        		Toast.makeText(BannerAdListenerActivity.this, "On Ad Left Application", Toast.LENGTH_SHORT).show();
        	}
		});
        
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.banner_prog_layout);
        layout.addView(adView);
        
        AdRequest adRequest = new AdRequest.Builder()
        							.addTestDevice(Config.TEST_DEVICE_ID).build();
        adView.loadAd(adRequest);
        
	}
}
