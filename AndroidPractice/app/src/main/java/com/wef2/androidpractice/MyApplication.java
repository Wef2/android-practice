package com.wef2.androidpractice;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by BK on 2016-09-20.
 */
public class MyApplication extends Application {

    private static ContentResolver contentResolver;

    @Override
    public void onCreate() {
        super.onCreate();
        contentResolver = getContentResolver();
    }

    public static String getRealPathFromURI(Uri contentUri) {
        String path = null;
        String[] proj = {MediaStore.MediaColumns.DATA};
        Cursor cursor = contentResolver.query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }

    public static String getDatetimeFromUri(Uri uri) {
        String imagePath = getRealPathFromURI(uri);
        String datetime = "";

        try {
            ExifInterface exifInterface = new ExifInterface(imagePath);
            datetime = exifInterface.getAttribute(ExifInterface.TAG_DATETIME);
        } catch (IOException e) {
        }

        return datetime;
    }

    public static int getRotationDegreeFromUri(Uri uri) {
        String imagePath = getRealPathFromURI(uri);
        int exifOrientation = ExifInterface.ORIENTATION_NORMAL;
        int exifDegree = 0;

        try {
            ExifInterface exifInterface = new ExifInterface(imagePath);
            exifOrientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            exifInterface.getAttribute(ExifInterface.TAG_DATETIME);
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

    public static Bitmap getBitmapFromUri(Uri uri){
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bitmap;
    }
}
