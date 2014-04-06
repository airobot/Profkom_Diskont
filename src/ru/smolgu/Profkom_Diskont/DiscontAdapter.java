package ru.smolgu.Profkom_Diskont;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class DiscontAdapter extends BaseAdapter {
	Context cont;
	LayoutInflater lInflater;
	ArrayList<ListData> objects;

	DiscontAdapter(Context context, ArrayList<ListData> mylist) {
		cont = context;
		objects = mylist;
		lInflater = (LayoutInflater) cont
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return objects.size();
	}

	public Object getItem(int position) {
		return objects.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// используем созданные, но не используемые view
		View view = convertView;
		if (view == null) {
			// получаем LayoutInflater для работы с layout-ресурсами
			view = lInflater.inflate(R.layout.discont_list_item, parent, false);
		}

		ListData p = ((ListData) getItem(position));
		((ImageView) view.findViewById(R.id.iv1)).setImageResource(p.image);
		return view;
	}
}