package com.faishalbadri.fragmentrecyclerviewmvp.ui.Detail;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.util.Server;
import com.faishalbadri.fragmentrecyclerviewmvp.util.TouchImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


  public DetailFragment() {
    // Required empty public constructor
  }

  TouchImageView imgDetailFragment;
  String img;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_detail, container, false);
    imgDetailFragment = (TouchImageView) v.findViewById(R.id.imgDetailFragment);
    img = getActivity().getIntent().getStringExtra("img");
    RequestOptions options = new RequestOptions()
        .fitCenter()
        .format(DecodeFormat.PREFER_ARGB_8888)
        .override(100,100);
    Glide.with(this)
        .load(Server.BASE_IMG + img)
        .apply(RequestOptions.centerCropTransform())
        .into(imgDetailFragment);
    return v;
  }
}
