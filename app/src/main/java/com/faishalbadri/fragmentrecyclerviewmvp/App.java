package com.faishalbadri.fragmentrecyclerviewmvp;

import android.app.Application;
import com.google.android.gms.ads.MobileAds;
import com.gw.swipeback.tools.WxSwipeBackActivityManager;

/**
 * Created by faishal on 10/3/17.
 */

public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    MobileAds.initialize(this, "ca-app-pub-6242493810500826/9429485582");
  }
}
