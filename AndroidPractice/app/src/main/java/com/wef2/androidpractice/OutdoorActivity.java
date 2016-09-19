package com.wef2.androidpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;


public class OutdoorActivity extends AppCompatActivity implements MapView.MapViewEventListener, MapView.POIItemEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor);

        MapView mapView = new MapView(this);
        mapView.setDaumMapApiKey(getString(R.string.api_key));

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        mapView.setMapViewEventListener(this);
        mapView.setPOIItemEventListener(this);
    }

    @Override
    public void onMapViewInitialized(MapView mapView) {
        MapPoint SPACE_DOT_ONE_POINT = MapPoint.mapPointWithGeoCoord(33.450614, 126.570680);
        MapPoint SPACE_DOT_TWO_POINT = MapPoint.mapPointWithGeoCoord(33.4525410, 126.5708564);

        mapView.setMapCenterPoint(SPACE_DOT_ONE_POINT, true);
        mapView.setZoomLevel(2, true);

        MapPOIItem spaceDotOneMarker = new MapPOIItem();
        spaceDotOneMarker.setItemName("SPACE DOT ONE");
        spaceDotOneMarker.setTag(1);
        spaceDotOneMarker.setMapPoint(SPACE_DOT_ONE_POINT);
        spaceDotOneMarker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        spaceDotOneMarker.setCustomImageResourceId(R.mipmap.ic_launcher);
        spaceDotOneMarker.setCustomImageAutoscale(false);
        spaceDotOneMarker.setCustomImageAnchor(0.5f, 1.0f);

        mapView.addPOIItem(spaceDotOneMarker);

        MapPOIItem spaceDotTwoMarker = new MapPOIItem();
        spaceDotTwoMarker.setItemName("SPACE DOT TWO");
        spaceDotTwoMarker.setTag(1);
        spaceDotTwoMarker.setMapPoint(SPACE_DOT_TWO_POINT);
        spaceDotTwoMarker.setMarkerType(MapPOIItem.MarkerType.RedPin);
        spaceDotTwoMarker.setCustomImageAutoscale(false);
        spaceDotTwoMarker.setCustomImageAnchor(0.5f, 1.0f);

        mapView.addPOIItem(spaceDotTwoMarker);

    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }
}
