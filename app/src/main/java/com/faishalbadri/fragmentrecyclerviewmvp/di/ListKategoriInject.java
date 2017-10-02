package com.faishalbadri.fragmentrecyclerviewmvp.di;

import android.content.Context;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.ListKategori.ListKategoriRepository;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.ListKategori.remote.ListKategoriDataRemote;

/**
 * Created by faishal on 10/2/17.
 */

public class ListKategoriInject {

  public static ListKategoriRepository provideToListKatRepo(Context context){
    return new ListKategoriRepository(new ListKategoriDataRemote(context));
  }

}
