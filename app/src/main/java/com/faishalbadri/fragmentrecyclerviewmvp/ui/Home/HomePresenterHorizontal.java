package com.faishalbadri.fragmentrecyclerviewmvp.ui.Home;

import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori.KategoriBean;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.Home.HomeDataResource.HorizontalGetCallback;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.Home.HomeRepository;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.Home.HomeContract.ViewHorizontal;
import java.util.List;

/**
 * Created by faishal on 10/2/17.
 */

public class HomePresenterHorizontal implements HomeContract.PresenterHorizontal {

  HomeContract.ViewHorizontal viewHorizontal;
  HomeRepository homeRepository;

  public HomePresenterHorizontal(HomeRepository homeRepository) {
    this.homeRepository = homeRepository;
  }

  @Override
  public void onAttachView(ViewHorizontal view) {
    this.viewHorizontal = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getData() {
    homeRepository.getHorizontalResult(new HorizontalGetCallback() {
      @Override
      public void onSucces(List<KategoriBean> isi, String msg) {
        viewHorizontal.onSuccesHorizontall(isi,msg);
      }

      @Override
      public void onError(String msg) {
        viewHorizontal.onError(msg);
      }

      @Override
      public void onDataEmpty(String msg) {
        viewHorizontal.onError(msg);
      }
    });
  }
}
