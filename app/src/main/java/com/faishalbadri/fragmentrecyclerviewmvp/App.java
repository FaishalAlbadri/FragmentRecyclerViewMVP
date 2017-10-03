package com.faishalbadri.fragmentrecyclerviewmvp;

import android.app.Application;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by faishal on 10/3/17.
 */

public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");

  }
}
