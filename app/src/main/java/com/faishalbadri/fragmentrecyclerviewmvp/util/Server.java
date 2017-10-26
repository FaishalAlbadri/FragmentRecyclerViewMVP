package com.faishalbadri.fragmentrecyclerviewmvp.util;

import android.os.Environment;

/**
 * Created by faishal on 9/28/17.
 */

public class Server {
  public static final String PATH_TO_EXTERNAL_STORAGE = Environment.getExternalStorageDirectory()+"/FAnonymousDownload";
  public final static String BASE_URL = "http://api.santriprogrammer.com/find/library/";
  public final static String BASE_IMG = "http://api.santriprogrammer.com/find/img/";

  public static boolean isExternalStorageWritable() {
    String state = Environment.getExternalStorageState();
    if (Environment.MEDIA_MOUNTED.equals(state)) {
      return true;
    }
    return false;
  }
  public static boolean isExternalStorageReadable() {
    String state = Environment.getExternalStorageState();
    if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
      return true;
    }
    return false;
  }

}