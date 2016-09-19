package com.wef2.androidpractice;

import android.content.Intent;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;

public class ImageActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("uri");


        imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageURI(uri);

//        int exifDegree = uriToRotationDegree(uri);
//        imageView.setRotation(exifDegree);
    }

    public String getRealPathFromURI (Uri contentUri) {
        String path = null;
        String[] proj = { MediaStore.MediaColumns.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }


    public int uriToRotationDegree(Uri uri) {
        String imagePath =  getRealPathFromURI(uri);
        int exifOrientation = ExifInterface.ORIENTATION_NORMAL;
        int exifDegree = 0;

        try {
            ExifInterface exifInterface = new ExifInterface(imagePath);
            exifOrientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
        } catch (IOException e) {

        }

        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) {
            exifDegree = 90;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {
            exifDegree = 180;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
            exifDegree = 270;
        }

        return exifDegree;
    }



}
