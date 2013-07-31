package com.ngshah.googlemapv2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {
	
	private GoogleMap googleMap;
	private final LatLng HAMBURG = new LatLng(53.558, 9.927);
	private final LatLng KIEL = new LatLng(53.551, 9.993);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                .getMap();
        
        if ( googleMap != null ) {
        	  Marker hamburg = googleMap.addMarker(new MarkerOptions().position(HAMBURG)
        		        .title("Hamburg"));
        	  Marker kiel = googleMap.addMarker(new MarkerOptions()
        		        .position(KIEL)
        		        .title("Kiel")
        		        .snippet("Kiel is cool")
        		        .icon(BitmapDescriptorFactory
        		            .fromResource(R.drawable.ic_launcher)));

        	  googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));
        	  googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        }
    }
}
