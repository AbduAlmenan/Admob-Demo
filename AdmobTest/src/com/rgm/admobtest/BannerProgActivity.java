package com.rgm.admobtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

//TODO: imports needed.
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;


public class BannerProgActivity extends Activity {

	private AdView adView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_prog);
        
        // TODO: Create adView, add adUnitId here.
        adView = new AdView(this);
        adView.setAdUnitId(Config.BANNER_AD_UNIT_ID);
        adView.setAdSize(AdSize.BANNER);
        
        // TODO: Add adView to layout
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.banner_prog_layout);
        layout.addView(adView);
        
        // TODO: Request banners
        AdRequest adRequest = new AdRequest.Builder()
        							.addTestDevice(Config.TEST_DEVICE_ID).build();
        adView.loadAd(adRequest);
        
	}
	
	// TODO: Add AdView.onPause(), AdView.resume() and AdView.destroy().
	@Override
	protected void onPause() {
		adView.pause();
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		adView.resume();
	}
	
	@Override
	protected void onDestroy() {
		adView.destroy();
		super.onDestroy();
	}
}
