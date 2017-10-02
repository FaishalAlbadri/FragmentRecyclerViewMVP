package com.faishalbadri.fragmentrecyclerviewmvp.ui.Home;

import com.faishalbadri.fragmentrecyclerviewmvp.base.BasePresenter;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome.IsiBean;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori;
import java.util.List;

/**
 * Created by faishal on 9/28/17.
 */

public class HomeContract {

  public interface View {
    void onSucces(List<IsiBean> data, String msg);
    void onError(String msg);
  }

  public interface Presenter extends BasePresenter<View>{
    void getData();
  }

  public interface ViewHorizontal {
    void onSuccesHorizontall(List<PojoKategori.KategoriBean> data, String msg);
    void onError(String msg);
  }

  public interface PresenterHorizontal extends BasePresenter<ViewHorizontal>{
    void getData();
  }

}
