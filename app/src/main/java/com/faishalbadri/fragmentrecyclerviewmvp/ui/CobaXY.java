package com.faishalbadri.fragmentrecyclerviewmvp.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.util.TouchImageView;

public class CobaXY extends AppCompatActivity implements OnTouchListener {


  int x, y;
  @BindView(R.id.layout)
  ConstraintLayout layout;
  @BindView(R.id.btnPindah)
  TouchImageView btnPindah;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_coba_xy);
    ButterKnife.bind(this);
    layout.setOnTouchListener(this);
    btnPindah.setImageResource(R.mipmap.ic_launcher);
  }

  @Override
  public boolean onTouch(View v, MotionEvent event) {
    x = (int) event.getX();
    y = (int) event.getY();
    switch (event.getAction()) {
      case MotionEvent.ACTION_MOVE:
        btnPindah.setX(x - 200);
        btnPindah.setY(y - 200);
        btnPindah.setRotationX(x - 200);
        btnPindah.setRotationY(y - 200);
    }
    return true;
  }
}
