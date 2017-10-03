package com.faishalbadri.fragmentrecyclerviewmvp.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.Home.HomeFragment;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.Kategori.KategoriFragment;
import com.faishalbadri.fragmentrecyclerviewmvp.util.ActivityUtil;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class HomeActivity extends AppCompatActivity
    implements OnNavigationItemSelectedListener{

  ActivityUtil activityUtil;
  @BindView(R.id.container)
  FrameLayout container;
  private AdView mAdView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);
    navigationAndToolbar();
    activityUtil = ActivityUtil.getInstance(getApplicationContext());
    activityUtil.addFragment(getSupportFragmentManager(), R.id.container, HomeFragment.instance());
    mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder()
        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        .build();

    mAdView.loadAd(adRequest);

    mAdView.setAdListener(new AdListener() {

      @Override
      public void onAdLoaded() {
        super.onAdLoaded();
        Toast.makeText(HomeActivity.this, "onAdLoaded()", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onAdOpened() {
        super.onAdOpened();
        Toast.makeText(HomeActivity.this, "onAdOpened()", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onAdClosed() {
        super.onAdClosed();
        Toast.makeText(HomeActivity.this, "onAdClosed()", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onAdFailedToLoad(int i) {
        super.onAdFailedToLoad(i);
        Toast.makeText(HomeActivity.this, "onAdFailedToLoad()", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onAdLeftApplication() {
        super.onAdLeftApplication();
        Toast.makeText(HomeActivity.this, "onAdLeftApplication()", Toast.LENGTH_SHORT).show();
      }
    });

  }

  private void navigationAndToolbar() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.home, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_camera) {
      activityUtil.addFragment(getSupportFragmentManager(), R.id.container, HomeFragment.instance());
      setTitle("Home");
    } else if (id == R.id.nav_gallery) {
      activityUtil.addFragment(getSupportFragmentManager(), R.id.container, KategoriFragment.instance());
      setTitle("Kategori");
    } else if (id == R.id.nav_slideshow) {

    } else if (id == R.id.nav_manage) {

    } else if (id == R.id.nav_share) {

    } else if (id == R.id.nav_send) {

    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @Override
  public void onPause() {
    if (mAdView != null) {
      mAdView.pause();
    }
    super.onPause();
  }

  @Override
  public void onResume() {
    super.onResume();
    if (mAdView != null) {
      mAdView.resume();
    }
  }

  @Override
  public void onDestroy() {
    if (mAdView != null) {
      mAdView.destroy();
    }
    super.onDestroy();
  }
}
