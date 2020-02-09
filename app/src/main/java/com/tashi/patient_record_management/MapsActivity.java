package com.tashi.patient_record_management;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            mMap.setMyLocationEnabled(true);
        }
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {}
        } catch (Resources.NotFoundException e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMinZoomPreference(12);
        LatLng defaultmapview= new LatLng(27.706253, 85.330643);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(defaultmapview));

        LatLng boudha = new LatLng(27.720757,85.360949);
        MarkerOptions markerOptions1 = new MarkerOptions().position(boudha).title("Stupa Hospital in boudha pipolbot").snippet("").icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.hospital)));
        mMap.addMarker(markerOptions1);

        LatLng chabel = new LatLng(27.717083,85.346733);
        MarkerOptions markerOptions2 = new MarkerOptions().position(chabel).title("Medicare Hospital in chabel").snippet("").icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.hospital)));
        mMap.addMarker(markerOptions2);

        LatLng gaushala = new LatLng(27.7097063,85.34640941);
        MarkerOptions markerOptions3 = new MarkerOptions().position(gaushala).title("Metro Hospital in gaushala").snippet("").icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.hospital)));
        mMap.addMarker(markerOptions3);

        LatLng gairidhara = new LatLng(27.7177283,85.3278327);
        MarkerOptions markerOptions4 = new MarkerOptions().position(gairidhara).title("Beeraj Baal Hospital in gairidhara").snippet("").icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.hospital)));
        mMap.addMarker(markerOptions4);



    }
}
