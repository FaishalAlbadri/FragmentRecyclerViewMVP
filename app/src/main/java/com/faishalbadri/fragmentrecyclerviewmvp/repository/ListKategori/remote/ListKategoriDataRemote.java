package com.faishalbadri.fragmentrecyclerviewmvp.repository.ListKategori.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
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
import com.faishalbadri.fragmentrecyclerviewmvp.repository.ListKategori.ListKategoriDataResource;
import com.faishalbadri.fragmentrecyclerviewmvp.ui.ListKategori.ListKategoriActivity;
import com.faishalbadri.fragmentrecyclerviewmvp.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 10/2/17.
 */

public class ListKategoriDataRemote implements ListKategoriDataResource {

  Context context;
  private static final String URL = Server.BASE_URL + "getTbPerKategori.php";

  public ListKategoriDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getListKategoriResult(final String id,@NonNull final ListKategoriGetCallback listKategoriGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL), new Listener<String>() {
      @Override
      public void onResponse(String response) {
        try {
          if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Isi")) {
            try {
              Log.i("response",response);
              final PojoHome pojoHome = new Gson().fromJson(response,PojoHome.class);
              listKategoriGetCallback.onSucces(pojoHome.getIsi(), context.getString(R.string.succes));
            } catch (Exception e) {
              e.printStackTrace();
            }
          } else {
            Toast.makeText(context, "Data Kosong", Toast.LENGTH_SHORT).show();
          }
        } catch (JSONException e) {

        } catch (Exception e) {

        }

      }
    }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        listKategoriGetCallback.onError(String.valueOf(error));
      }
    }){
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id_kategori",id);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}

