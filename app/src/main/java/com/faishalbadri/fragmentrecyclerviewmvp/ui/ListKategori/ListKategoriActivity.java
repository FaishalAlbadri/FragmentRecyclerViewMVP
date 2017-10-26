package com.faishalbadri.fragmentrecyclerviewmvp.ui.ListKategori;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome.IsiBean;
import com.faishalbadri.fragmentrecyclerviewmvp.di.ListKategoriInject;
import java.util.ArrayList;
import java.util.List;

public class ListKategoriActivity extends AppCompatActivity implements ListKategoriContract.View {

  @BindView(R.id.rvIsiKategori)
  RecyclerView rvIsiKategori;
  ListKategoriPresenter listKategoriPresenter;
  ArrayList<PojoHome.IsiBean> list_data;
  ListKategoriAdapter listKategoriAdapter;
  private static final String simpan = "simpanKat";
  String id,nama;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_kategori);
    ButterKnife.bind(this);

    id = getIntent().getStringExtra("id");
    nama = getIntent().getStringExtra("nama");
    Log.i("id",id);
    setTitle(nama);
    listKategoriPresenter = new ListKategoriPresenter(ListKategoriInject.provideToListKatRepo(getApplicationContext()));
    listKategoriPresenter.onAttachView(this);

    list_data = new ArrayList<>();
    listKategoriAdapter = new ListKategoriAdapter(ListKategoriActivity.this,list_data);
    LinearLayoutManager llm = new LinearLayoutManager(this);
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    rvIsiKategori.setLayoutManager(llm);
    rvIsiKategori.setAdapter(listKategoriAdapter);

    if (savedInstanceState != null){
      ArrayList<IsiBean> data = savedInstanceState.getParcelableArrayList(simpan);
      this.list_data.clear();
      this.list_data.addAll(data);
      listKategoriAdapter.notifyDataSetChanged();
      Log.i("save","Ini Dari If");
    }else {
      listKategoriPresenter.getData(id);
      Log.i("Save","Ini dari else");
    }
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(simpan,list_data);
  }

  @Override
  public void onSucces(List<IsiBean> isi, String msg) {
    list_data.clear();
    list_data.addAll(isi);
    listKategoriAdapter.notifyDataSetChanged();
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onError(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
  }
}
