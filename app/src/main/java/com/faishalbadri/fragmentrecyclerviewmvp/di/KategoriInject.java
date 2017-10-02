package com.faishalbadri.fragmentrecyclerviewmvp.di;

import android.content.Context;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.Kategori.KategoriRepository;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.Kategori.remote.KategoriDataRemote;

/**
 * Created by faishal on 9/28/17.
 */

public class KategoriInject {

  public static KategoriRepository provideToKatRepo(Context context){
    return new KategoriRepository(new KategoriDataRemote(context));
  }
}
