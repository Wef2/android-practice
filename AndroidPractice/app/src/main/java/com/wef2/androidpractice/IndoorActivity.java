package com.wef2.androidpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class IndoorActivity extends AppCompatActivity {

    private ImageView indoorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoor);

        indoorView = (ImageView) findViewById(R.id.indoor_view);
    }
}
