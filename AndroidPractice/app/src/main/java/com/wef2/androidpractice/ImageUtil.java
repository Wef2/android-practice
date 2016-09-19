package com.wef2.androidpractice;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Created by BK on 2016-09-20.
 */
public class ImageUtil {

    public static Bitmap rotateBitmap(Bitmap src, float degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
    }
}
