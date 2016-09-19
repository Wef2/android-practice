package com.wef2.androidpractice;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.jiahuan.svgmapview.SVGMapView;
import com.jiahuan.svgmapview.SVGMapViewListener;
import com.jiahuan.svgmapview.core.data.SVGPicture;
import com.jiahuan.svgmapview.core.helper.ImageHelper;
import com.jiahuan.svgmapview.core.helper.map.SVGBuilder;

public class IndoorActivity extends AppCompatActivity {

    private SVGMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoor);


        mapView = (SVGMapView) findViewById(R.id.map_view);

        mapView.registerMapViewListener(new SVGMapViewListener() {
            @Override
            public void onMapLoadComplete() {
                IndoorActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }

            @Override
            public void onMapLoadError() {
                IndoorActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }

            @Override
            public void onGetCurrentMap(Bitmap bitmap) {
                IndoorActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
        mapView.setBrandBitmap(ImageHelper.drawableToBitmap(new SVGBuilder().readFromString(SVGPicture.ICON_TOILET).build().getDrawable(), 1.0f));
        mapView.loadMap(AssetsHelper.getContent(this, "indoor.svg"));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
