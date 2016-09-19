package com.wef2.androidpractice;

import android.graphics.Bitmap;
import android.net.Uri;

/**
 * Created by BK on 2016-09-20.
 */
public class Information {

    private Uri uri;
    private String datetime;
    private int rotationDegree;

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getRotationDegree() {
        return rotationDegree;
    }

    public void setRotationDegree(int rotationDegree) {
        this.rotationDegree = rotationDegree;
    }


}
