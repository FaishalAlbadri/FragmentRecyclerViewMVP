package com.faishalbadri.fragmentrecyclerviewmvp.repository.Home.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoHome;
import com.faishalbadri.fragmentrecyclerviewmvp.data.PojoKategori;
import com.faishalbadri.fragmentrecyclerviewmvp.repository.Home.HomeDataResource;
import com.faishalbadri.fragmentrecyclerviewmvp.util.Server;
import com.google.gson.Gson;

/**
 * Created by faishal on 9/28/17.
 */

public class HomeDataRemote implements HomeDataResource {

  Context context;
  private final static String URL_VERTICAL = Server.BASE_URL+"getTbIsiNew.php";
  private final static String URL_HORIZONTAL = Server.BASE_URL+"getTbKategori.php";

  public HomeDataRemote(Context context) {
    this.context = context;
  }


  @Override
  public void getHomeResult(@NonNull final HomeGetCallback homeGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL_VERTICAL),
        new Listener<String>() {
          @Override
          public void onResponse(String response) {
            Log.i("response",response);
            PojoHome pojoHome = new Gson().fromJson(response,PojoHome.class);
            if (pojoHome == null) {
              homeGetCallback.onDataEmpty(
                  context.getString(R.string.gagal));
            } else {
              homeGetCallback.onSucces(pojoHome.getIsi(), context.getString(R.string.succes));
            }
          }
        }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        homeGetCallback.onError(String.valueOf(error));
      }
    });
    requestQueue.add(stringRequest);
  }

  @Override
  public void getHorizontalResult(@NonNull final HorizontalGetCallback horizontalGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL_HORIZONTAL),
        new Listener<String>() {
          @Override
          public void onResponse(String response) {
            Log.i("response",response);
            PojoKategori pojoHome = new Gson().fromJson(response,PojoKategori.class);
            if (pojoHome == null) {
              horizontalGetCallback.onDataEmpty(context.getString(R.string.gagal));
            } else {
              horizontalGetCallback.onSucces(pojoHome.getKategori(), context.getString(R.string.succes));
            }
          }
        }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        horizontalGetCallback.onError(String.valueOf(error));
      }
    });
    requestQueue.add(stringRequest);
  }
}
