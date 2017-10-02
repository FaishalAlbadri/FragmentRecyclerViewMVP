package com.faishalbadri.fragmentrecyclerviewmvp.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by faishal on 9/28/17.
 */

public class PojoKategori {

  /**
   * kategori : [{"id_kategori":"1","kategori_nama":"Perpustakaan","kategori_gambar":"perpus.png"},{"id_kategori":"2","kategori_nama":"Les Privat","kategori_gambar":"privat.png"},{"id_kategori":"3","kategori_nama":"Sekolah Dasar","kategori_gambar":"sd.png"},{"id_kategori":"4","kategori_nama":"SMP","kategori_gambar":"smp.png"},{"id_kategori":"5","kategori_nama":"SMA","kategori_gambar":"sma.png"},{"id_kategori":"6","kategori_nama":"Universitas","kategori_gambar":"univ.png"}]
   * status : 1
   * msg : Data Semua Kategori
   */

  private String status;
  private String msg;
  private List<KategoriBean> kategori;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public List<KategoriBean> getKategori() {
    return kategori;
  }

  public void setKategori(List<KategoriBean> kategori) {
    this.kategori = kategori;
  }

  public static class KategoriBean implements Parcelable {

    /**
     * id_kategori : 1
     * kategori_nama : Perpustakaan
     * kategori_gambar : perpus.png
     */

    private String id_kategori;
    private String kategori_nama;
    private String kategori_gambar;

    protected KategoriBean(Parcel in) {
      id_kategori = in.readString();
      kategori_nama = in.readString();
      kategori_gambar = in.readString();
    }

    public static final Creator<KategoriBean> CREATOR = new Creator<KategoriBean>() {
      @Override
      public KategoriBean createFromParcel(Parcel in) {
        return new KategoriBean(in);
      }

      @Override
      public KategoriBean[] newArray(int size) {
        return new KategoriBean[size];
      }
    };

    public String getId_kategori() {
      return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
      this.id_kategori = id_kategori;
    }

    public String getKategori_nama() {
      return kategori_nama;
    }

    public void setKategori_nama(String kategori_nama) {
      this.kategori_nama = kategori_nama;
    }

    public String getKategori_gambar() {
      return kategori_gambar;
    }

    public void setKategori_gambar(String kategori_gambar) {
      this.kategori_gambar = kategori_gambar;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(id_kategori);
      dest.writeString(kategori_nama);
      dest.writeString(kategori_gambar);
    }
  }
}
