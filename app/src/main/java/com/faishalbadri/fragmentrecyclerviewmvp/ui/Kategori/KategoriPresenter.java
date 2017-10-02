package com.faishalbadri.fragmentrecyclerviewmvp.ui.Kategori;

import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori.KategoriBean;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.Kategori.KategoriDataResource.KategoriCallBack;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.Kategori.KategoriRepository;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.Kategori.KategoriContract.View;
import java.util.List;

/**
 * Created by faishal on 9/28/17.
 */

public class KategoriPresenter implements KategoriContract.Presenter {

  KategoriContract.View view;
  KategoriRepository kategoriRepository;

  public KategoriPresenter(KategoriRepository kategoriRepository) {
    this.kategoriRepository = kategoriRepository;
  }

  @Override
  public void onAttachView(View view) {
    this.view = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getData() {
    kategoriRepository.getKategoriResult(new KategoriCallBack() {
      @Override
      public void onSucces(List<KategoriBean> data, String msg) {
        view.onSucces(data,msg);
      }

      @Override
      public void onError(String msg) {
        view.onError(msg);
      }

      @Override
      public void onDataEmpty(String msg) {
        view.onError(msg);
      }
    });
  }
}
