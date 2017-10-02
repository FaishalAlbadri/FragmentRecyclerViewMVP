package com.faishalbadri.fragmentrecyclerviewmvp.repository.Kategori;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 9/28/17.
 */

public class KategoriRepository implements KategoriDataResource {

  private KategoriDataResource kategoriDataResource;

  public KategoriRepository(KategoriDataResource kategoriDataResource) {
    this.kategoriDataResource = kategoriDataResource;
  }

  @Override
  public void getKategoriResult(@NonNull KategoriCallBack kategoriCallBack) {
    kategoriDataResource.getKategoriResult(kategoriCallBack);
  }
}
