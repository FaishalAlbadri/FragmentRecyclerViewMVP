package com.faishalbadri.fragmentrecyclerviewmvp.ui.ListKategori;

import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome.IsiBean;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.ListKategori.ListKategoriDataResource.ListKategoriGetCallback;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.ListKategori.ListKategoriRepository;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.ListKategori.ListKategoriContract.View;
import java.util.List;

/**
 * Created by faishal on 10/2/17.
 */

public class ListKategoriPresenter implements ListKategoriContract.Presenter {

  ListKategoriContract.View view;
  ListKategoriRepository listKategoriRepository;

  public ListKategoriPresenter(ListKategoriRepository listKategoriRepository) {
    this.listKategoriRepository = listKategoriRepository;
  }



  @Override
  public void onAttachView(View view) {
    this.view = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getData(String id) {
    listKategoriRepository.getListKategoriResult(id,new ListKategoriGetCallback() {
      @Override
      public void onSucces(List<IsiBean> isi, String msg) {
        view.onSucces(isi,msg);
      }

      @Override
      public void onError(String msg) {
        view.onError(msg);
      }
    });
  }
}
