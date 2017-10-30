package com.faishalbadri.fragmentrecyclerviewmvp.ui.Kategori;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori.KategoriBean;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.ListKategori.ListKategoriActivity;
import com.faishalbadri.fragmentrecyclerviewmvp.util.Server;
import java.util.List;

/**
 * Created by faishal on 9/28/17.
 */

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.ViewHolder> {

  Context context;
  List<KategoriBean> data;
  int color;

  public KategoriAdapter(Context context, List<KategoriBean> data) {
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
  public void onBindViewHolder(ViewHolder holder, int position) {
    final PojoKategori.KategoriBean listitem = data.get(position);
    color = ((Activity) context).getResources().getColor(R.color.colorPrimary);
    if (listitem.getKategori_nama().equalsIgnoreCase("perpustakaan")){
      holder.txtJudul.setTextColor(color);
    }
    Glide.with(context)
        .load(Server.BASE_IMG + listitem.getKategori_gambar())
        .apply(RequestOptions.noAnimation())
        .into(holder.img);
    holder.txtJudul.setText(listitem.getKategori_nama());
    holder.cv.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        v.getContext().startActivity(new Intent(v.getContext(), ListKategoriActivity.class)
        .putExtra("id",listitem.getId_kategori())
        .putExtra("nama",listitem.getKategori_nama()));
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
