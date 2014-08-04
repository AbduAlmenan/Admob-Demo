Admob-Demo
==========

Project that shows how to use Admob for Android

For more information go to https://developers.google.com/mobile-ads-sdk/

In the project, add your Banner ad unit id, interstitial ad unit id and Test device id in the Config.java class and in the activity_banner_xml layout.

Setup

1. Create an account and an ad unit id in Admob. (http://www.google.com/ads/admob/). You will need one for Banners and one for Interstitials.
2. Add Google Play Services to the project. (https://developer.android.com/google/play-services/setup.html)
3. Add the next line to AndroidManifest.xml, under Application: <meta-data android:name="com.google.android.gms.version" android:value="@integer/google_play_services_version" />
4. Add Internet permission in AndroidManifest.xml.
5. Add this activity in AndroidManifest.xml: <activity android:name="com.google.android.gms.ads.AdActivity" android:configChanges="keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize" />

Add banners programmatically

See code example in BannerProgActivity.java

1. Create AdView object.
2. Add adUnitId.
3. Set ad size to banner.
4. Add AdView to the layout.
5. Request banners. (While testing, add a test device. You can find your testDeviceID in the logcat with the Tag: Ads, after you run it the first time).
6. Add AdView.onPause(), AdView.resume() and AdView.destroy().

Add banners using XML

See code example in BannerXmlActivity.java

1. Add xmlns:ads="http://schemas.android.com/apk/res-auto" to parent layout.
2. Add AdView xml code with your AdUnitId.
3. Create AdRequest in the Activity.

Demographics

1. You can add demographic information when creating the AdRequest: AdRequest.Builder().setGender(int gender).

AdListener 

Use an AdListener to follow up different events.
See code example in BannerAdListenerActivity.java.

1. Add a new AdListener() to the adView. 
2. Override one or more of the following methods: onAdLoaded(), onAdFailedToLoad(int errorCode), onAdOpened(), onAdClosed(), onAdLeftApplication().


Interstitial ads

See code example in InterstitialActivity.java

1. Create a new AdUnitId for Interstitial ads.
2. Create the interstitial object.
3. Request interstitial ad.
4. You need to request a new interstitial ad every time after you have displayed it.

Smart Banners

You can use smart banners (banners that will adjust to the screen size automatically). You need to specify the ad size as SMART_BANNER.
