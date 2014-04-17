package ru.smolgu.Profkom_Diskont;

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

public class MapFragmentAll extends FragmentActivity implements
LocationListener  {

	GoogleMap googleMap;
	SupportMapFragment mapFragment;
	LatLng latLng = new LatLng(54.772278, 32.028839);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_view);

		// Создание кнопки назад.
		getActionBar().setDisplayHomeAsUpEnabled(true);
		Intent intent = getIntent();

		mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		googleMap = mapFragment.getMap();
		googleMap.getUiSettings().isMyLocationButtonEnabled();
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12));
		if (googleMap == null) {
			finish();
			return;
		}
		init();
	}

	private void init() {
		// Добавляем на карту точки скидок
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.772278, 32.028839)).title("Ле бо бо"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.773195, 32.028978)).title("PUBLICA"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.776142, 32.048997)).title("Принцип компани"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.768682, 32.040348)).title("Принцип компани"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.772278, 32.028839)).title("Чао Италия"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.773035, 32.044156)).title("Полёт"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.770001, 32.075025)).title("Машенька"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.780124, 32.0233)).title("Машенька"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.774276, 32.047766)).title("Машенька"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.771172, 32.053089)).title("Show Time"));

		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.778417, 32.023746)).title("Gross Haus"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.772605, 32.035004)).title("Gross Haus"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.794898, 32.057078)).title("Gross Haus"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.762119, 32.101249)).title("Gross Haus"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.766821, 32.06283)).title("Circus"));

		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.778116, 32.080283)).title("LADAMARKET"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.775096, 32.045875)).title("ЭлитСАН"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.758907, 32.102404)).title("ЭлитСАН"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.775537, 32.044488)).title("Печки-лавочки"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.779127, 32.066372)).title("ГИНЕКОЛОГиЯ"));

		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.794898, 32.057078)).title("Много цветов"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.783657, 32.053345)).title("Много цветов"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.78423, 32.053295)).title("фотостудия Птичка"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.778315, 32.048539)).title("фотостудия Птичка"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.769932, 32.023699)).title("фотостудия Птичка"));

		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.772135, 32.04557)).title("ФОТОПОРТ"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.784399, 32.048325)).title("Букет"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.771941, 32.041774)).title("BRIDGE кафе"));

		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.781975, 32.052528)).title("Тотем"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.784297, 32.043721)).title("Арсенал декор"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.771831, 32.03188)).title("ATLANTIC"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.783082, 32.034262)).title("Союз Тур"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.768203, 32.007774)).title("Центрифуга"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.794255, 32.055643)).title("SILVER синема"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.780303, 32.049354)).title("Много метров"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.769786, 32.044062)).title("Эрудит"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.760758, 32.108882)).title("Эрудит"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.775643, 32.031999)).title("АЭРОБУМ"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.766632, 32.029496)).title("STRELA"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.774762, 32.045757)).title("1 LIMO"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.762643, 32.084286)).title("ДоДо Пицца"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.76866, 32.039241)).title("Евроторг"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.767991, 32.084657)).title("Евроторг"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.77083, 32.05008)).title("Евроторг"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.768516, 32.004303)).title("Евроторг"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.764123, 32.055314)).title("Евроторг"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.769759, 32.022375)).title("Евроторг"));
		googleMap.addMarker(new MarkerOptions().position(
				new LatLng(54.778173, 32.016123)).title("Евроторг"));
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