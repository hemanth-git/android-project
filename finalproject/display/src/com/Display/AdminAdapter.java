package com.Display;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdminAdapter extends BaseAdapter {
	
	String[] update_name,update_info,update_id,update_date;
	Context context;
	
	public AdminAdapter(Context context, String[] update_name,
			String[] update_info, String[] update_id, String[] update_date) {
		// TODO Auto-generated constructor stub
		
		
		this.update_name=update_name;
		this.update_info=update_info;
		this.update_id=update_id;
		this.update_date=update_date;
		System.out.println(update_name);
		System.out.println(update_info);
		System.out.println(update_id);
		System.out.println(update_date);
		this.context=context;
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return update_name.length;
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
		
		convertView=inflater.inflate(R.layout.administration, null);
		TextView tv1=(TextView) convertView.findViewById(R.id.updatename);
		tv1.setText(update_name[position]);
		TextView tv2=(TextView) convertView.findViewById(R.id.update_info);
		tv2.setText(update_info[position]);
		TextView tv3 = (TextView) convertView.findViewById(R.id.textViewsmall);
		tv3.setText(update_date[position]);
		return convertView;
	}

}
