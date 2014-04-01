package ru.smolgu.Profkom_Diskont;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

public class DiscontFragment extends Activity {

	int Image;
	String Text;
	DiskontData Diskont_Data;
	String Site;

	AlertDialog dialog;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.discont_fragment);
		// Создание кнопки назад. 
		getActionBar().setDisplayHomeAsUpEnabled(true);
		Intent intent = getIntent();

		ImageView imageView = (ImageView) findViewById(R.id.image_discont_fragment);
		int image = intent.getIntExtra("image", 0);
		imageView.setImageResource(image);

		TextView textView = (TextView) findViewById(R.id.text_discont_fragment);
		String text = intent.getStringExtra("text");
		textView.setText(Html.fromHtml(text));
		
//		WebView webWiew = (WebView)findViewById(R.id.text_o_profkom);
//		webWiew.loadData(getString(R.string.o_programme), "text/html", "utf-8");
		
//		WebView view = (WebView)findViewById(R.id.text_o_profkom);
//	    view.loadData(getString(R.string.o_programme), "text/html", "utf-8");
		
		Diskont_Data = (DiskontData) ((SharableObject) intent
				.getParcelableExtra("phone")).getObject();
		Button bnt_phone = (Button) findViewById(R.id.btn_telefon);
		Button bnt_map_diskont = (Button) findViewById(R.id.btn_map_diskont);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final String[] items = new String[Diskont_Data.telnum.size()];
		for (int i = 0; i < Diskont_Data.telnum.size(); i++) {
			items[i] = Diskont_Data.telnum.get(i);
		}
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				String uri = "tel:" + items[item];
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse(uri));
				startActivity(intent);
				return;
			}
		});
		dialog = builder.create();

		bnt_phone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				dialog.show();
			}
		});
		
		bnt_map_diskont.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ShowDiscontMapFragment(Diskont_Data.mapdiskont);
			}
		});

		Site = intent.getStringExtra("sites");
		Button btn_site = (Button) findViewById(R.id.btn_site);
		if (Site.length() == 0) {
			btn_site.setVisibility(View.GONE);
			return;
		}
		btn_site.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String url = Site.trim();
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
				return;
			}
		});	
		
		if (Diskont_Data.telnum.size() == 0) {
			bnt_phone.setVisibility(View.GONE);
			return;
		}		
	}
	
	public void ShowDiscontMapFragment(ArrayList<LatLng> mapD) {
		Intent intent = new Intent(this, MapFragmentViewDiskont.class);
		intent.putExtra("mapDiskont", new SharableObject(mapD));
		startActivity(intent);
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
