package com.faishalbadri.fragmentrecyclerviewmvp.ui.ListKategori;

import com.faishalbadri.fragmentrecyclerviewmvp.base.BasePresenter;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome.IsiBean;
import java.util.List;

/**
 * Created by faishal on 10/2/17.
 */

public class ListKategoriContract {

  public interface View {
    void onSucces(List<IsiBean> isi, String msg);
    void onError(String msg);
  }

  public interface Presenter extends BasePresenter<ListKategoriContract.View>{
    void getData(String id);
  }

}
