package com.faishalbadri.fragmentrecyclerviewmvp.repository.Home;

import android.support.annotation.NonNull;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome.IsiBean;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori.KategoriBean;
import java.util.List;

/**
 * Created by faishal on 9/28/17.
 */

public interface HomeDataResource {

  interface HomeGetCallback{
    void onSucces(List<PojoHome.IsiBean>data,String msg);
    void onError(String msg);
    void onDataEmpty(String msg);
  }

  void getHomeResult(@NonNull HomeGetCallback homeGetCallback);

  interface HorizontalGetCallback{
    void onSucces(List<KategoriBean> isi, String msg);
    void onError(String msg);
    void onDataEmpty(String msg);
  }

  void getHorizontalResult(@NonNull HorizontalGetCallback horizontalGetCallback);

}
