package com.wef2.androidpractice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("uri");
        int degree = intent.getIntExtra("degree", 0);

        Bitmap bitmap = MyApplication.getBitmapFromUri(uri);
        Bitmap rotatedImage = ImageUtil.rotateBitmap(bitmap, degree);

        imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageBitmap(rotatedImage);
    }

}
