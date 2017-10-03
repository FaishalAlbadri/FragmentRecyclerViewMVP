package com.faishalbadri.fragmentrecyclerviewmvp.ui.Home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome.IsiBean;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori.KategoriBean;
import com.faishalbadri.fragmentrecyclerviewmvp.di.HomeRepoInject;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeContract.View,HomeContract.ViewHorizontal {


  RecyclerView rvIsi,rvIsi_Horizontal;

  public HomeFragment() {
    // Required empty public constructor
  }

  public static HomeFragment instance(){
    return new HomeFragment();
  }
  HomePresenterHorizontal homePresenterHorizontal;
  HomePresenter homePresenter;
  ArrayList<IsiBean> list_data;
  ArrayList<PojoKategori.KategoriBean> list_horizontal;
  HomeAdapter homeAdapter;
  HomeAdapterHorizontal homeAdapterHorizontal;
  private static final String simpan = "simpan";
  private static final String simpan_h = "simpan_h";

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_home, container, false);

    rvIsi = (RecyclerView)v.findViewById(R.id.rvIsi);
    rvIsi_Horizontal = (RecyclerView)v.findViewById(R.id.rvIsi_Horizontal);
    rvIsi.setNestedScrollingEnabled(false);
    rvIsi_Horizontal.setNestedScrollingEnabled(false);

    homePresenterHorizontal = new HomePresenterHorizontal(HomeRepoInject.provideToHomeRepo(getActivity()));
    homePresenterHorizontal.onAttachView(this);

    homePresenter = new HomePresenter(HomeRepoInject.provideToHomeRepo(getActivity()));
    homePresenter.onAttachView(this);

    list_data = new ArrayList<>();
    homeAdapter = new HomeAdapter(getActivity(),list_data);

    list_horizontal = new ArrayList<>();
    homeAdapterHorizontal = new HomeAdapterHorizontal(getActivity(),list_horizontal);

    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    rvIsi.setLayoutManager(llm);
    rvIsi.setAdapter(homeAdapter);

    LinearLayoutManager llmH = new LinearLayoutManager(getActivity());
    llmH.setOrientation(LinearLayoutManager.HORIZONTAL);
    rvIsi_Horizontal.setLayoutManager(llmH);
    rvIsi_Horizontal.setAdapter(homeAdapterHorizontal);

    if (savedInstanceState != null){
      ArrayList<PojoHome.IsiBean> dataa = savedInstanceState.getParcelableArrayList(simpan);
      this.list_data.clear();
      this.list_data.addAll(dataa);
      homeAdapter.notifyDataSetChanged();

      ArrayList<PojoKategori.KategoriBean> data_horizontal = savedInstanceState.getParcelableArrayList(simpan_h);
      this.list_horizontal.clear();
      this.list_horizontal.addAll(data_horizontal);
      homeAdapterHorizontal.notifyDataSetChanged();
      Log.i("asd","ini if");
    }else {
      homePresenterHorizontal.getData();
      homePresenter.getData();
      Log.i("asd","ini else");
    }
    return v;
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(simpan,list_data);
    outState.putParcelableArrayList(simpan_h,list_horizontal);
  }

  @Override
  public void onSucces(List<IsiBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    homeAdapter.notifyDataSetChanged();
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onSuccesHorizontall(List<KategoriBean> data, String msg) {
    list_horizontal.clear();
    list_horizontal.addAll(data);
    homeAdapterHorizontal.notifyDataSetChanged();
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onError(String msg) {
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }

}
