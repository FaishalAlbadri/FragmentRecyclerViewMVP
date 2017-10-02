package com.faishalbadri.fragmentrecyclerviewmvp.repository.ListKategori;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 10/2/17.
 */

public class ListKategoriRepository implements ListKategoriDataResource {

  private ListKategoriDataResource listKategoriDataResource;

  public ListKategoriRepository(ListKategoriDataResource listKategoriDataResource) {
    this.listKategoriDataResource = listKategoriDataResource;
  }

  @Override
  public void getListKategoriResult(String id,@NonNull ListKategoriGetCallback listKategoriGetCallback) {
    listKategoriDataResource.getListKategoriResult(id,listKategoriGetCallback);
  }
}
