package com.wef2.androidpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LocationActivity extends AppCompatActivity {

    private Button indoorButton, outdoorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        indoorButton = (Button) findViewById(R.id.indoor_button);
        outdoorButton = (Button) findViewById(R.id.outdoor_button);

        indoorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LocationActivity.this, IndoorActivity.class));
            }
        });

        outdoorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LocationActivity.this, OutdoorActivity.class));
            }
        });
    }
}
