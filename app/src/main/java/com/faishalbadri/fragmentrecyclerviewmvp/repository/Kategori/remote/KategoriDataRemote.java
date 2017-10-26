package com.faishalbadri.fragmentrecyclerviewmvp.repository.Kategori.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.Kategori.KategoriDataResource;
import com.faishalbadri.fragmentrecyclerviewmvp.util.Server;
import com.google.gson.Gson;

/**
 * Created by faishal on 9/28/17.
 */

public class KategoriDataRemote implements KategoriDataResource {

  Context context;
  private final static String URL = Server.BASE_URL+"getTbKategori.php";


  public KategoriDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getKategoriResult(@NonNull final KategoriCallBack kategoriCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);

    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL),
        new Listener<String>() {
          @Override
          public void onResponse(String response) {
            Log.i("response",response);
            PojoKategori pojoKategori = new Gson().fromJson(response,PojoKategori.class);
            if (pojoKategori == null) {
              kategoriCallBack.onDataEmpty(
                  context.getString(R.string.gagal));
            } else {
                kategoriCallBack.onSucces(pojoKategori.getKategori(), context.getString(R.string.succes));
            }
          }
        }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        kategoriCallBack.onError(String.valueOf(error));
      }
    });
    requestQueue.add(stringRequest);
  }
}
