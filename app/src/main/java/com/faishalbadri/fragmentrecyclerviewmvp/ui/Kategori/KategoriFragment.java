package com.faishalbadri.fragmentrecyclerviewmvp.ui.Kategori;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori.KategoriBean;
import com.faishalbadri.fragmentrecyclerviewmvp.di.KategoriInject;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class KategoriFragment extends Fragment implements KategoriContract.View {


  public KategoriFragment() {
    // Required empty public constructor
  }


  public static KategoriFragment instance(){
    return new KategoriFragment();
  }

  RecyclerView rvKat;
  KategoriPresenter kategoriPresenter;
  ArrayList<PojoKategori.KategoriBean> list_data;
  KategoriAdapter kategoriAdapter;
  private static final String simpan = "simpanKat";

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_kategori, container, false);
    rvKat = (RecyclerView)v.findViewById(R.id.rvKat);
    kategoriPresenter = new KategoriPresenter(KategoriInject.provideToKatRepo(getActivity()));
    kategoriPresenter.onAttachView(this);

    list_data = new ArrayList<>();
    kategoriAdapter = new KategoriAdapter(getActivity(),list_data);


    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    rvKat.setLayoutManager(llm);
    rvKat.setAdapter(kategoriAdapter);

    if (savedInstanceState != null){
      ArrayList<PojoKategori.KategoriBean> data = savedInstanceState.getParcelableArrayList(simpan);
      this.list_data.clear();
      this.list_data.addAll(data);
      kategoriAdapter.notifyDataSetChanged();
      Log.i("asd","ini if");
    }else {
      kategoriPresenter.getData();
      Log.i("jsabndkj","ini else");
    }
    return v;
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(simpan,list_data);
  }

  @Override
  public void onSucces(List<KategoriBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    kategoriAdapter.notifyDataSetChanged();
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onError(String msg) {
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }
}
