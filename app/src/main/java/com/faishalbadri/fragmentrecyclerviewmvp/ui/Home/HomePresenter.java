package com.faishalbadri.fragmentrecyclerviewmvp.ui.Home;

import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome.IsiBean;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.Home.HomeDataResource.HomeGetCallback;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.Home.HomeRepository;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.Home.HomeContract.View;
import java.util.List;

/**
 * Created by faishal on 9/28/17.
 */

public class HomePresenter implements HomeContract.Presenter {

  HomeContract.View view;
  HomeRepository homeRepository;

  public HomePresenter(HomeRepository homeRepository) {
    this.homeRepository = homeRepository;
  }

  @Override
  public void onAttachView(View view) {
    this.view = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getData() {
    homeRepository.getHomeResult(new HomeGetCallback() {
      @Override
      public void onSucces(List<IsiBean> data, String msg) {
        view.onSucces(data,msg);
      }

      @Override
      public void onError(String msg) {
        view.onError(msg);
      }

      @Override
      public void onDataEmpty(String msg) {
        view.onError(msg);
      }
    });
  }

}
