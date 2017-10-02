package com.faishalbadri.fragmentrecyclerviewmvp.ui.ListKategori;

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
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome.IsiBean;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.Detail.DetailActivity;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.Kategori.KategoriAdapter;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.Kategori.KategoriAdapter.ViewHolder;
import com.faishalbadri.fragmentrecyclerviewmvp.util.Server;
import java.util.List;

/**
 * Created by faishal on 10/2/17.
 */

public class ListKategoriAdapter extends RecyclerView.Adapter<ListKategoriAdapter.ViewHolder> {

  Activity context;
  List<PojoHome.IsiBean> data;

  public ListKategoriAdapter(Activity context, List<IsiBean> data) {
    this.context = context;
    this.data = data;
  }

  @Override
  public ListKategoriAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    final ListKategoriAdapter.ViewHolder viewHolder = new ListKategoriAdapter.ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ListKategoriAdapter.ViewHolder holder, int position) {
    final PojoHome.IsiBean listitem = data.get(position);
    Glide.with(context)
        .load(Server.BASE_IMG + listitem.getIsi_gambar())
        .apply(RequestOptions.noAnimation())
        .into(holder.img);
    holder.txtJudul.setText(listitem.getIsi_nama());
    holder.cv.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        v.getContext().startActivity(new Intent(v.getContext(), DetailActivity.class)
            .putExtra("id", listitem.getId_isi())
            .putExtra("nama", listitem.getIsi_nama())
            .putExtra("img", listitem.getIsi_gambar()));
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
      ButterKnife.bind(this, itemView);
    }
  }
}
