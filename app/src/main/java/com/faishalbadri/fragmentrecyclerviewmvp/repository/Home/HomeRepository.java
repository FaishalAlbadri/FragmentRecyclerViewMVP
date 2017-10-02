package com.faishalbadri.fragmentrecyclerviewmvp.repository.Home;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 9/28/17.
 */

public class HomeRepository implements HomeDataResource {

  private HomeDataResource homeDataResource;

  public HomeRepository(
      HomeDataResource homeDataResource) {
    this.homeDataResource = homeDataResource;
  }

  @Override
  public void getHomeResult(@NonNull HomeGetCallback homeGetCallback) {
    homeDataResource.getHomeResult(homeGetCallback);
  }

  @Override
  public void getHorizontalResult(@NonNull HorizontalGetCallback horizontalGetCallback) {
    homeDataResource.getHorizontalResult(horizontalGetCallback);
  }
}
