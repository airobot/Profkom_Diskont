package ru.smolgu.Profkom_Diskont;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ProfkomFragment extends Fragment {

	public ProfkomFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.profkom_fragment, container,
				false);
//		TextView textWebView = (TextView)rootView.findViewById(R.id.o_profkom);
//		textWebView.setText(Html.fromHtml(getString(R.string.o_profkome)));
		
		Button b_s_p = (Button) rootView.findViewById(R.id.btn_site_profkom);
		Button b_vk = (Button) rootView.findViewById(R.id.btn_vk);
		Button b_ins = (Button) rootView.findViewById(R.id.btn_ins);
		Button b_tw = (Button) rootView.findViewById(R.id.btn_tw);
		
		b_s_p.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent myWebLink = new Intent(
						android.content.Intent.ACTION_VIEW);
				myWebLink.setData(Uri.parse("http://www.profcom.pro/"));
				startActivity(myWebLink);
			}
		});
		
		b_vk.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent myWebLink = new Intent(
						android.content.Intent.ACTION_VIEW);
				myWebLink.setData(Uri.parse("http://vk.com/v_profkome"));
				startActivity(myWebLink);
			}
		});
		
		b_ins.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent myWebLink_ins = new Intent(
						android.content.Intent.ACTION_VIEW);
				myWebLink_ins.setData(Uri
						.parse("http://instagram.com/profkomsmolgu"));
				startActivity(myWebLink_ins);
			}
		});
		
		b_tw.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent myWebLink_tw = new Intent(
						android.content.Intent.ACTION_VIEW);
				myWebLink_tw.setData(Uri
						.parse("https://twitter.com/Profkom_SmolGU"));
				startActivity(myWebLink_tw);
			}
		});
		return rootView;
	}
}
