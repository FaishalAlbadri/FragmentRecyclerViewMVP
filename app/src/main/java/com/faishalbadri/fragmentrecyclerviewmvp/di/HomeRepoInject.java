package com.faishalbadri.fragmentrecyclerviewmvp.di;

import android.content.Context;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.Home.HomeRepository;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.Home.remote.HomeDataRemote;

/**
 * Created by faishal on 9/28/17.
 */

public class HomeRepoInject {
  public static HomeRepository provideToHomeRepo(Context context){
    return new HomeRepository(new HomeDataRemote(context));
  }
}
