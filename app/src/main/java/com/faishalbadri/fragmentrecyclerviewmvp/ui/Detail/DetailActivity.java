package com.faishalbadri.fragmentrecyclerviewmvp.ui.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.HomeActivity;
import com.faishalbadri.fragmentrecyclerviewmvp.util.Server;
import com.gw.swipeback.SwipeBackLayout;
import com.gw.swipeback.SwipeBackLayout.OnSwipeBackListener;

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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    ButterKnife.bind(this);
    img = getIntent().getStringExtra("img");
    nama = getIntent().getStringExtra("nama");
    ket = getIntent().getStringExtra("ket");
    toolbar.setTitle(nama);
    Glide.with(this)
        .load(Server.BASE_IMG + img)
        .apply(RequestOptions.centerCropTransform())
        .into(imgDetail);
    wvDetail.loadData(ket, "text/html", "uutf-8");
    setupWindowAnimations();
    setSwipeBack();
  }

  private void setSwipeBack() {
    swipeBackLayout.setDirectionMode(SwipeBackLayout.FROM_LEFT);
    swipeBackLayout.setMaskAlpha(125);
    swipeBackLayout.setSwipeBackFactor(0.5f);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    overridePendingTransition(R.anim.slide_to_right,R.anim.slide_to_right);
  }

  private void setupWindowAnimations() {
    Fade fade = new Fade();
    fade.setDuration(1000);
    getWindow().setEnterTransition(fade);

    Slide slide = new Slide();
    slide.setDuration(1000);
    getWindow().setReturnTransition(slide);
  }
}
