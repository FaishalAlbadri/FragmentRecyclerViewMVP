package com.faishalbadri.fragmentrecyclerviewmvp.repository.ListKategori;

import android.support.annotation.NonNull;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome.IsiBean;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori.KategoriBean;
import java.util.List;

/**
 * Created by faishal on 10/2/17.
 */

public interface ListKategoriDataResource {

  interface ListKategoriGetCallback {
    void onSucces(List<IsiBean> isi, String msg);
    void onError(String msg);
  }

  void getListKategoriResult(String id,@NonNull ListKategoriGetCallback listKategoriGetCallback);

}
