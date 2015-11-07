package com.Display;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ExamsAdapter extends BaseAdapter{
	
	String [] exam_name,exam_date,exam_details,exam_typeid;
	Context context;
	public ExamsAdapter(Context context, String[] exam_name,
			String[] exam_date, String[] exam_details,String[] exam_typeid) {
		// TODO Auto-generated constructor stub
		
		
		this.exam_name=exam_name;
		this.exam_date=exam_date;
		this.exam_details=exam_details;
		this.exam_typeid=exam_typeid;
		System.out.println(exam_name);
		System.out.println(exam_date);
		System.out.println(exam_details);
		
		this.context=context;
	}

	
	public int getCount() {
		// TODO Auto-generated method stub
		return exam_name.length;
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
		
		convertView=inflater.inflate(R.layout.exam, null);
		TextView tv1=(TextView) convertView.findViewById(R.id.exam_name);
		tv1.setText(exam_name[position]);
		TextView tv2=(TextView) convertView.findViewById(R.id.exam_date);
		tv2.setText(exam_date[position]);
		TextView tv3=(TextView) convertView.findViewById(R.id.exam_details);
		tv3.setText(exam_details[position]);
		//TextView tv4=(TextView) convertView.findViewById(R.id.exam_typeid);
		//tv1.setText(exam_typeid[position]);
		
		return convertView;
		
	}

}
