package com.faishalbadri.fragmentrecyclerviewmvp.ui.Home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome.IsiBean;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.Detail.DetailActivity;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.Detail.DetailFragment;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.Home.HomeAdapter.ViewHolder;
import com.faishalbadri.fragmentrecyclerviewmvp.util.Server;
import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Created by faishal on 9/28/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<ViewHolder> {

  Context context;
  List<IsiBean> data;

  public HomeAdapter(Context context, List<IsiBean> data) {
    this.context = context;
    this.data = data;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    final IsiBean listitem = data.get(position);
    RequestOptions options = new RequestOptions()
        .fitCenter()
        .format(DecodeFormat.PREFER_ARGB_8888)
        .override(100,100);
    Glide.with(context)
        .load(Server.BASE_IMG + listitem.getIsi_gambar())
        .apply(options)
        .into(holder.img);
    holder.txtJudul.setText(listitem.getIsi_nama());
    holder.cv.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

        Bundle bundle = new Bundle();
        bundle.putString("img",listitem.getIsi_gambar());
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);

        v.getContext().startActivity(new Intent(v.getContext(), DetailActivity.class)
        .putExtra("nama",listitem.getIsi_nama())
        .putExtra("img",listitem.getIsi_gambar())
        .putExtra("ket",listitem.getIsi_keterangan()));
        ((Activity)context).overridePendingTransition(R.anim.slide_from_right,R.anim.slide_from_right);
      }
    });
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.txtJudul)
    TextView txtJudul;
    @BindView(R.id.cv)
    CardView cv;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this,itemView);
    }
  }

 
}
