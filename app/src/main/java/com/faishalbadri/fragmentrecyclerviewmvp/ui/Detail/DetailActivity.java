package com.faishalbadri.fragmentrecyclerviewmvp.ui.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.HomeActivity;
import com.faishalbadri.fragmentrecyclerviewmvp.util.Server;

public class DetailActivity extends AppCompatActivity {

  String img, nama, ket;
  @BindView(R.id.imgDetail)
  ImageView imgDetail;
  @BindView(R.id.wvDetail)
  WebView wvDetail;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    ButterKnife.bind(this);

    img = getIntent().getStringExtra("img");
    nama = getIntent().getStringExtra("nama");
    ket = getIntent().getStringExtra("ket");
    setTitle(nama);
    Glide.with(this)
        .load(Server.BASE_IMG + img)
        .apply(RequestOptions.centerCropTransform())
        .into(imgDetail);
    wvDetail.loadData(ket,"text/html","uutf-8");
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
  }
}
