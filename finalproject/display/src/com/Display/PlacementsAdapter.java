package com.Display;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PlacementsAdapter extends BaseAdapter {
	String[] update_details;
	Context context;
	
	public PlacementsAdapter(Context context, String[] update_details) {
		// TODO Auto-generated constructor stub
		
		
		this.update_details=update_details;
		
		System.out.println(update_details);
		
		
		this.context=context;
	}

	
	public int getCount() {
		// TODO Auto-generated method stub
		return update_details.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		
		convertView=inflater.inflate(R.layout.placements, null);
		TextView tv1=(TextView) convertView.findViewById(R.id.update_details);
		tv1.setText(update_details[position]);
		
		
		return convertView;
	}

}
