package com.faishalbadri.fragmentrecyclerviewmvp.ui.Kategori;

import com.faishalbadri.fragmentrecyclerviewmvp.base.BasePresenter;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori;
import java.util.List;

/**
 * Created by faishal on 9/28/17.
 */

public class KategoriContract {
  public interface View {
    void onSucces(List<PojoKategori.KategoriBean> data, String msg);
    void onError(String msg);
  }

  public interface Presenter extends BasePresenter<KategoriContract.View> {
    void getData();
  }
}
