package com.faishalbadri.fragmentrecyclerviewmvp.ui.Detail;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.faishalbadri.fragmentrecyclerviewmvp.R;
import com.faishalbadri.fragmentrecyclerviewmvp.util.Server;
import com.faishalbadri.fragmentrecyclerviewmvp.util.TouchImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


  public DetailFragment() {
    // Required empty public constructor
  }

  TouchImageView imgDetailFragment;
  ImageView btnDownload;
  String img;
  Bitmap bitmap;
  private File storageDirectory;
  private static final String TAG = DetailFragment.class.getSimpleName();
  private final int REQUEST_WRITE_PERMISSION = 200;
  private long fileSizeInBytes;
  Context context = getActivity();
  int i = 0;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_detail, container, false);
    imgDetailFragment = (TouchImageView) v.findViewById(R.id.imgDetailFragment);
    btnDownload = (ImageView) v.findViewById(R.id.btnDownload);
    img = getActivity().getIntent().getStringExtra("img");
    RequestOptions options = new RequestOptions()
        .fitCenter()
        .format(DecodeFormat.PREFER_ARGB_8888)
        .override(300, 300);
    Glide.with(this)
        .load(Server.BASE_IMG + img)
        .apply(RequestOptions.centerCropTransform())
        .into(imgDetailFragment);
    btnDownload.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        returnDownloadedImageAsBitmap(Server.BASE_IMG + img);
        Toast.makeText(getActivity(), "Downloading", Toast.LENGTH_SHORT).show();
      }
    });
    return v;
  }

  private void returnDownloadedImageAsBitmap(String pathToImageDownload) {
    Target<Bitmap> target = Glide.with(this).asBitmap().load(Server.BASE_IMG + img).into(
        new SimpleTarget<Bitmap>() {
          @Override
          public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
            bitmap = resource;
            saveBitmapToExternalStorage();
          }
        });
  }

  private void saveBitmapToExternalStorage() {
    if (!Server.isExternalStorageWritable() && !Server.isExternalStorageReadable()) {
      Toast.makeText(getActivity(), "There is no external or writable storage in your device",
          Toast.LENGTH_SHORT).show();
      return;
    }
    storageDirectory = new File(Server.PATH_TO_EXTERNAL_STORAGE);
    if (!storageDirectory.exists()) {
      Log.i(TAG, "Storage directory has been created");
      storageDirectory.mkdir();
    }
    // Add permission for camera and let user grant the permission
    if (ActivityCompat
        .checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(getActivity(),
          new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
      return;
    }
    createAndStoreFileInExternalStorage();
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == REQUEST_WRITE_PERMISSION) {
      if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
        Toast.makeText(getActivity(),
            "Sorry!!!, you can't use this app without granting this permission", Toast.LENGTH_LONG)
            .show();
        ((Activity) context).finish();
      }
    }
  }

  private void createAndStoreFileInExternalStorage() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    String timeStamp = dateFormat.format(new Date());
    String filename = "image-" + timeStamp + ".jpg";
    File createNewFile = new File(storageDirectory, filename);
    if (createNewFile.exists()) {
      createNewFile.delete();
    }
    try {
      createNewFile.createNewFile();
      fileSizeInBytes = createNewFile.length();
      FileOutputStream outStream = new FileOutputStream(createNewFile);
      bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outStream);
      outStream.flush();
      outStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onResume() {
    super.onResume();
    storageDirectory = new File(Server.PATH_TO_EXTERNAL_STORAGE);
    if (!storageDirectory.exists()) {
      storageDirectory.mkdir();
    }
    if (null == storageDirectory.list() && null != bitmap) {
      createAndStoreFileInExternalStorage();
    }
  }
}
