package com.faishalbadri.fragmentrecyclerviewmvp.repository.Kategori;

import android.support.annotation.NonNull;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori;
import java.util.List;

/**
 * Created by faishal on 9/28/17.
 */

public interface KategoriDataResource {

  interface KategoriCallBack{
    void onSucces(List<PojoKategori.KategoriBean> data,String msg);
    void onError(String msg);
    void onDataEmpty(String msg);
  }

  void getKategoriResult(@NonNull KategoriCallBack kategoriCallBack);

}
