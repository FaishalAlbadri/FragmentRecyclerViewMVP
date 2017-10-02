package com.faishalbadri.fragmentrecyclerviewmvp.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by faishal on 9/28/17.
 */

public class PojoHome {

  /**
   * isi : [{"id_isi":"10","id_provinsi":"4","id_kota":"12","id_kategori":"4","isi_nama":"Sekolah Menengah Pertama Negeri 111 Jkt","provinsi_nama":"Jakarta Barat","kota_nama":"Palang Merah","kategori_nama":"SMP","isi_alamat":"Jalan Bakti VII No. 2, RT. 1 / RW. 9, Kemanggisan, Palmerah, RT.1/RW.9, Kemanggisan, Palmerah, Kota Jakarta Barat, Daerah Khusus Ibukota Jakarta 11480","isi_notlp":"0215482423","isi_web":"smpn111-jkt.sch.id","isi_keterangan":"\nUntuk Info Lebih Lanjut Silahkan Cek WebSite Kami<\/p>\r\n","isi_kunjungan":"4","isi_gambar":"asdads.png","isi_lat":"-6.1920629","isi_long":"106.783255","isi_status":"Ada"},{"id_isi":"9","id_provinsi":"2","id_kota":"11","id_kategori":"4","isi_nama":"SMP Negeri 4 Jkt","provinsi_nama":"Jakarta Pusat","kota_nama":"Sawah Besar","kategori_nama":"SMP","isi_alamat":"Jl. Perwira No.10, Ps. Baru, Sawah Besar, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10710","isi_notlp":"0213844414","isi_web":"smpnegeri4jakarta.esy.es","isi_keterangan":"\n\nUntuk info lebih lanjutnya silahkan buka website kami<\/p>\r\n","isi_kunjungan":"3","isi_gambar":"asd.png","isi_lat":"-6.1720154","isi_long":"106.8324626","isi_status":"Ada"},{"id_isi":"8","id_provinsi":"3","id_kota":"9","id_kategori":"4","isi_nama":"SMP Negeri 154 Jakarta","provinsi_nama":"Jakarta Selatan","kota_nama":"Pancoran","kategori_nama":"SMP","isi_alamat":"Jl. Pengadegan Barat XIII No.46, RT.7/RW.4, Cikoko, Pancoran, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12770","isi_notlp":"0217991643","isi_web":"smpn154jkt.com","isi_keterangan":"\n\nUntuk info lebih lanjutnya silahkan dicek di website kami<\/p>\r\n","isi_kunjungan":"6","isi_gambar":"sss.png","isi_lat":"-6.2505442","isi_long":"106.8528002","isi_status":"Ada"},{"id_isi":"7","id_provinsi":"4","id_kota":"5","id_kategori":"1","isi_nama":"Library and Knowledge Center","provinsi_nama":"Jakarta Barat","kota_nama":"Kebon Jeruk","kategori_nama":"Perpustakaan","isi_alamat":"Jl. Kb. Jeruk Raya No.27, RT.1/RW.9, Kb. Jeruk, Kota Jakarta Barat, Daerah Khusus Ibukota Jakarta 11530","isi_notlp":"0215345830","isi_web":"library.binus.ac.id","isi_keterangan":"\n\nJam Buka<\/strong><\/span><\/p>\r\n\r\n\n\nSenin - Jumat : 08:00 - 19:30<\/span><\/p>\r\n\r\n\n\nSabtu : 08:00 - 17:00<\/span><\/p>\r\n\r\n\n\nMinggu : Tutup<\/span><\/p>\r\n","isi_kunjungan":"7","isi_gambar":"binus.jpg","isi_lat":"-6.2019827","isi_long":"106.7815332","isi_status":"Ada"},{"id_isi":"6","id_provinsi":"5","id_kota":"6","id_kategori":"1","isi_nama":"Perpustakaan Islamic Centre","provinsi_nama":"Jakarta Utara","kota_nama":"Koja","kategori_nama":"Perpustakaan","isi_alamat":"Kelurahan, Gg. Mawarrt, RW.1, Tugu Utara, Koja, Kota Jakarta Utara, Daerah Khusus Ibukota Jakarta 14270","isi_notlp":"0214413069","isi_web":"","isi_keterangan":"\n\nJam Buka <\/strong><\/span><\/p>\r\n\r\n\n\nSenin - Minggu : 09:00 - 16:00<\/span><\/p>\r\n","isi_kunjungan":"4","isi_gambar":"pic.jpg","isi_lat":"-6.1203059","isi_long":"106.917792","isi_status":"Ada"},{"id_isi":"5","id_provinsi":"1","id_kota":"4","id_kategori":"1","isi_nama":"Perpustakaan Universitas Negeri Jakarta","provinsi_nama":"Jakarta Timur","kota_nama":"Pulo Gadung","kategori_nama":"Perpustakaan","isi_alamat":"Jl. Pemuda No.41, RT.11/RW.14, Rawamangun, Pulo Gadung, Kota Jakarta Timur, Daerah Khusus Ibukota Jakarta 13220","isi_notlp":"0214894221","isi_web":"lib.unj.ac.id","isi_keterangan":"\n\nJam Buka <\/p>\r\n\r\n\n\nSenin - Jumat : 08:00 - 16:00 WIB<\/p>\r\n\r\n\n\nSabtu & Minggu : Tutup<\/p>\r\n","isi_kunjungan":"4","isi_gambar":"upt.png","isi_lat":"-6.1941555","isi_long":"106.8782606","isi_status":"Ada"},{"id_isi":"3","id_provinsi":"2","id_kota":"3","id_kategori":"1","isi_nama":"Perpustakaan Nasional Republik Indonesia","provinsi_nama":"Jakarta Pusat","kota_nama":"Senen","kategori_nama":"Perpustakaan","isi_alamat":"Jalan Salemba No.28 A, RT.5/RW.6, Kenari, Senen, Jakarta Pusat, 10430","isi_notlp":"0213101411","isi_web":"www.perpusnas.go.id","isi_keterangan":"Jam Buka <\/strong><\/span>\n\nSenin - Jumat : 08:00 - 18:00\n\nSabtu : 09:00 - 16:00\n\n\n\nMinggu : Tutup<\/p>\n\n\n\nInfo Sejarah Klik Disini<\/a><\/span><\/strong><\/u><\/p>\n\n\n\n <\/p>\n","isi_kunjungan":"5","isi_gambar":"perpusRI.jpg","isi_lat":"-6.1992089","isi_long":"106.8515055","isi_status":"Ada"},{"id_isi":"2","id_provinsi":"3","id_kota":"2","id_kategori":"1","isi_nama":"Perpustakaan Rimba Baca","provinsi_nama":"Jakarta Selatan","kota_nama":"Cilandak","kategori_nama":"Perpustakaan","isi_alamat":"Jl. Intan RSPP No.21B, RT.11/RW.2, Cilandak Bar., Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12430","isi_notlp":"0217664517","isi_web":"www.rimbabaca.com","isi_keterangan":"\n\nTumbuh dengan buku anak-anak yang bagus, telah menginspirasi kami untuk berbagi pengalaman membaca yang tak terlupakan dengan anak-anak saat ini. Rimba Baca adalah sebuah perpustakaan kecil yang terletak di daerah perumahan Cilandak Jakarta Selatan dengan koleksi buku lokal dan internasional yang terus berkembang. Suasana nyaman yang dikombinasikan dengan fasilitas pendukung seperti komputer, wi-fi, area membaca, sudut snack dan aktivitas akan membuat membaca lebih menyenangkan.<\/p>\r\n","isi_kunjungan":"12","isi_gambar":"rimbabaca.jpg","isi_lat":"-6.300442","isi_long":"106.798293","isi_status":"Ada"},{"id_isi":"1","id_provinsi":"1","id_kota":"1","id_kategori":"4","isi_nama":"SMP Ibnu Hajar Boarding School","provinsi_nama":"Jakarta Timur","kota_nama":"Cipayung","kategori_nama":"SMP","isi_alamat":"Jl. Mushola Fathul Ulum No.11, RT.9/RW.1, Munjul, Cipayung, Kota Jakarta Timur, Daerah Khusus Ibukota Jakarta 13850","isi_notlp":"02184312279","isi_web":"www.ihbs.or.id/smpputra/","isi_keterangan":"\n\nKurikulum yang diterapkan di SMP Ibnu Hajar terdiri dari<\/strong><\/span><\/p>\n\n\n\n\n\t\nKurikulum KTSP, kurikulum operasional yang disusun, dikembangkan, dan dilaksanakan oleh setiap satuan pendidikan dengan memperhatikan standar kompetensi dan kompetensi dasar yang dikembangkan Badan Standar Nasional Pendidikan ( BSNP ).<\/li>\n\t\nKurikulum Kurtilas, Kurikulum 2013 (K-13)<\/strong> adalah kurikulum yang berlaku dalam Sistem Pendidikan Indonesia. Kurikulum ini merupakan kurikulum tetap diterapkan oleh pemerintah untuk menggantikan Kurikulum-2006 (yang sering disebut sebagai Kurikulum Tingkat Satuan Pendidikan) yang telah berlaku selama kurang lebih 6 tahun. Kurikulum 2013 masuk dalam masa percobaanya pada tahun 2013 dengan menjadikan beberapa sekolah menjadi sekolah rintisan.<\/li>\n\t\nKurikulum diniyah SMP Ibnu Hajar terdiri dari Aqidah, Fiqih, Akhlaq, B. Arab, Sirah, Tafsir, Hadist, Tahfidz (Min 3 Juzz) Berlandaskan manhaj ahlussunnah wal jamaah.<\/li>\n<\/ol>\n\n\nProgram Unggulan<\/strong><\/span><\/p>\n\n\n\n1. Tahfizh Al-Qur\u2019an 3 Juz\n\n2. Ekstra Kurikuler Wajib Panahan\n\n3. Ekstra Kurikuler Wajib Taekwondo\n\n4. Ekstra Kurikuler Kedisiplinan\n\n5. Market Day\n\n6. Class Outing & Filed Trip\n\n7. Bimbingan & Konseling\n\n8. Parenting\n\n9. Homestay Makkah-Madinah\n\n10. Program Siswa Berprestasi<\/p>\n\n\n\nEkskul Pilihan<\/strong><\/span><\/p>\n\n\n\n1. Klub Sains & Matematik\n\n2. Futsal\n\n3. Bulu Tangkis\n\n4. Renang\n\n5. Tenis Meja\n\n6. Basket\n\n7. English Club & Arabic\n\n8. Khitabah Club\n\n9. Disain Grafis\n\n10. Web Design<\/p>\n","isi_kunjungan":"2","isi_gambar":"ihbs.png","isi_lat":"-6.351835","isi_long":"106.8968295","isi_status":"Ada"}]
   * status : 1
   * msg : Data Semua Isi
   */

  private String status;
  private String msg;
  private List<IsiBean> isi;

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

  public List<IsiBean> getIsi() {
    return isi;
  }

  public void setIsi(List<IsiBean> isi) {
    this.isi = isi;
  }

  public static class IsiBean implements Parcelable {

    /**
     * id_isi : 10
     * id_provinsi : 4
     * id_kota : 12
     * id_kategori : 4
     * isi_nama : Sekolah Menengah Pertama Negeri 111 Jkt
     * provinsi_nama : Jakarta Barat
     * kota_nama : Palang Merah
     * kategori_nama : SMP
     * isi_alamat : Jalan Bakti VII No. 2, RT. 1 / RW. 9, Kemanggisan, Palmerah, RT.1/RW.9, Kemanggisan, Palmerah, Kota Jakarta Barat, Daerah Khusus Ibukota Jakarta 11480
     * isi_notlp : 0215482423
     * isi_web : smpn111-jkt.sch.id
     * isi_keterangan :
     Untuk Info Lebih Lanjut Silahkan Cek WebSite Kami</p>

     * isi_kunjungan : 4
     * isi_gambar : asdads.png
     * isi_lat : -6.1920629
     * isi_long : 106.783255
     * isi_status : Ada
     */

    private String id_isi;
    private String id_provinsi;
    private String id_kota;
    private String id_kategori;
    private String isi_nama;
    private String provinsi_nama;
    private String kota_nama;
    private String kategori_nama;
    private String isi_alamat;
    private String isi_notlp;
    private String isi_web;
    private String isi_keterangan;
    private Double isi_kunjungan;
    private String isi_gambar;
    private Double isi_lat;
    private Double isi_long;
    private String isi_status;

    protected IsiBean(Parcel in) {
      id_isi = in.readString();
      id_provinsi = in.readString();
      id_kota = in.readString();
      id_kategori = in.readString();
      isi_nama = in.readString();
      provinsi_nama = in.readString();
      kota_nama = in.readString();
      kategori_nama = in.readString();
      isi_alamat = in.readString();
      isi_notlp = in.readString();
      isi_web = in.readString();
      isi_keterangan = in.readString();
      isi_gambar = in.readString();
      isi_status = in.readString();
    }

    public static final Creator<IsiBean> CREATOR = new Creator<IsiBean>() {
      @Override
      public IsiBean createFromParcel(Parcel in) {
        return new IsiBean(in);
      }

      @Override
      public IsiBean[] newArray(int size) {
        return new IsiBean[size];
      }
    };

    public String getId_isi() {
      return id_isi;
    }

    public void setId_isi(String id_isi) {
      this.id_isi = id_isi;
    }

    public String getId_provinsi() {
      return id_provinsi;
    }

    public void setId_provinsi(String id_provinsi) {
      this.id_provinsi = id_provinsi;
    }

    public String getId_kota() {
      return id_kota;
    }

    public void setId_kota(String id_kota) {
      this.id_kota = id_kota;
    }

    public String getId_kategori() {
      return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
      this.id_kategori = id_kategori;
    }

    public String getIsi_nama() {
      return isi_nama;
    }

    public void setIsi_nama(String isi_nama) {
      this.isi_nama = isi_nama;
    }

    public String getProvinsi_nama() {
      return provinsi_nama;
    }

    public void setProvinsi_nama(String provinsi_nama) {
      this.provinsi_nama = provinsi_nama;
    }

    public String getKota_nama() {
      return kota_nama;
    }

    public void setKota_nama(String kota_nama) {
      this.kota_nama = kota_nama;
    }

    public String getKategori_nama() {
      return kategori_nama;
    }

    public void setKategori_nama(String kategori_nama) {
      this.kategori_nama = kategori_nama;
    }

    public String getIsi_alamat() {
      return isi_alamat;
    }

    public void setIsi_alamat(String isi_alamat) {
      this.isi_alamat = isi_alamat;
    }

    public String getIsi_notlp() {
      return isi_notlp;
    }

    public void setIsi_notlp(String isi_notlp) {
      this.isi_notlp = isi_notlp;
    }

    public String getIsi_web() {
      return isi_web;
    }

    public void setIsi_web(String isi_web) {
      this.isi_web = isi_web;
    }

    public String getIsi_keterangan() {
      return isi_keterangan;
    }

    public void setIsi_keterangan(String isi_keterangan) {
      this.isi_keterangan = isi_keterangan;
    }

    public Double getIsi_kunjungan() {
      return isi_kunjungan;
    }

    public void setIsi_kunjungan(Double isi_kunjungan) {
      this.isi_kunjungan = isi_kunjungan;
    }

    public String getIsi_gambar() {
      return isi_gambar;
    }

    public void setIsi_gambar(String isi_gambar) {
      this.isi_gambar = isi_gambar;
    }

    public Double getIsi_lat() {
      return isi_lat;
    }

    public void setIsi_lat(Double isi_lat) {
      this.isi_lat = isi_lat;
    }

    public Double getIsi_long() {
      return isi_long;
    }

    public void setIsi_long(Double isi_long) {
      this.isi_long = isi_long;
    }

    public String getIsi_status() {
      return isi_status;
    }

    public void setIsi_status(String isi_status) {
      this.isi_status = isi_status;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
      parcel.writeString(id_isi);
      parcel.writeString(id_provinsi);
      parcel.writeString(id_kota);
      parcel.writeString(id_kategori);
      parcel.writeString(isi_nama);
      parcel.writeString(provinsi_nama);
      parcel.writeString(kota_nama);
      parcel.writeString(kategori_nama);
      parcel.writeString(isi_alamat);
      parcel.writeString(isi_notlp);
      parcel.writeString(isi_web);
      parcel.writeString(isi_keterangan);
      parcel.writeString(isi_gambar);
      parcel.writeString(isi_status);
    }
  }
}
