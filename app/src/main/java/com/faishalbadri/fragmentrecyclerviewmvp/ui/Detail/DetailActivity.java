package com.faishalbadri.fragmentrecyclerviewmvp.ui.Detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.util.ActivityUtil;
import com.faishalbadri.fragmentrecyclerviewmvp.util.Server;
import com.gw.swipeback.SwipeBackLayout;

public class DetailActivity extends AppCompatActivity {

  String img, nama, ket;
  @BindView(R.id.imgDetail)
  ImageView imgDetail;
  @BindView(R.id.wvDetail)
  WebView wvDetail;
  @BindView(R.id.swipeBackLayout)
  SwipeBackLayout swipeBackLayout;
  @BindView(R.id.toolbar)
  Toolbar toolbar;
  ActivityUtil activityUtil;
  DetailFragment detailFragment;
  Slide slide;
  @BindView(R.id.containerDetail)
  FrameLayout containerDetail;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    ButterKnife.bind(this);
    containerDetail.setVisibility(View.GONE);
    swipeBackLayout.setDirectionMode(SwipeBackLayout.KEEP_SCREEN_ON);
    activityUtil = ActivityUtil.getInstance(getApplicationContext());
    img = getIntent().getStringExtra("img");
    nama = getIntent().getStringExtra("nama");
    ket = getIntent().getStringExtra("ket");
    toolbar.setTitle(nama);
    RequestOptions options = new RequestOptions()
        .fitCenter()
        .format(DecodeFormat.PREFER_ARGB_8888)
        .override(100, 100);
    Glide.with(this)
        .load(Server.BASE_IMG + img)
        .apply(options)
        .into(imgDetail);
    imgDetail.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        containerDetail.setVisibility(View.VISIBLE);
        setImageClick();
        toolbar.setVisibility(View.INVISIBLE);
        imgDetail.setVisibility(View.INVISIBLE);
        wvDetail.setVisibility(View.INVISIBLE);
        setVisibleOption();
      }
    });
    wvDetail.loadData(ket, "text/html", "uutf-8");
    setVisibleOption();
  }

  private void setVisibleOption() {
    if (imgDetail.getVisibility() == View.VISIBLE) {
      setSwipeBack();
    } else {
      swipeBackLayout.setDirectionMode(SwipeBackLayout.KEEP_SCREEN_ON);
    }
  }

  private void setImageClick() {
    detailFragment = new DetailFragment();
    slide = new Slide(Gravity.RIGHT);
    slide.setDuration(300);

    ChangeBounds changeBounds = new ChangeBounds();
    changeBounds.setDuration(300);

    detailFragment.setEnterTransition(slide);
    detailFragment.setExitTransition(slide);
    detailFragment.setAllowEnterTransitionOverlap(false);
    detailFragment.setAllowReturnTransitionOverlap(false);
    detailFragment.setSharedElementEnterTransition(changeBounds);
    getSupportFragmentManager().beginTransaction().replace(R.id.containerDetail, detailFragment)
        .addToBackStack(null).addSharedElement(imgDetail, "coba").commit();
  }


  private void setSwipeBack() {
    swipeBackLayout.setDirectionMode(SwipeBackLayout.FROM_LEFT);
    swipeBackLayout.setMaskAlpha(125);
    swipeBackLayout.setSwipeBackFactor(0.5f);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    containerDetail.setVisibility(View.GONE);
    toolbar.setVisibility(View.VISIBLE);
    imgDetail.setVisibility(View.VISIBLE);
    wvDetail.setVisibility(View.VISIBLE);
    overridePendingTransition(R.anim.slide_to_right, R.anim.slide_to_right);
    setVisibleOption();
  }
}
