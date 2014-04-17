package ru.smolgu.Profkom_Diskont;

import java.util.ArrayList;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragmentViewDiskont extends FragmentActivity implements
		LocationListener {
	GoogleMap googleMap;
	ArrayList<LatLng> dots;
	SupportMapFragment mapFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_view);

		// Создание кнопки назад.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		Intent intent = getIntent();

		LatLng latLng = new LatLng(54.772278, 32.028839);
		mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
		googleMap = mapFragment.getMap();
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		googleMap.getUiSettings().isMyLocationButtonEnabled();
		googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12));
		if (googleMap == null) {
			finish();
			return;
		}
		init();
	}

	private void init() {
		Intent intent = getIntent();
		dots = (ArrayList<LatLng>) ((SharableObject) intent
				.getParcelableExtra("mapDiskont")).getObject();
		for (LatLng item : dots)
			googleMap.addMarker(new MarkerOptions().position(item));
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}