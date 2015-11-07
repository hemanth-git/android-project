package com.Display;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class EventsAdapter extends BaseAdapter {
	
	String[] event_typeid,event_subname,event_id,event_name,event_date,event_place,event_details;
Context context;
	

	public EventsAdapter(Context context, String[] event_name,
			String[] event_date, String[] event_details, String[] event_place) {
		// TODO Auto-generated constructor stub
		
		
		this.event_name=event_name;
		this.event_date=event_date;
		this.event_place=event_place;
		this.event_details=event_details;
		System.out.println(event_name);
		System.out.println(event_date);
		System.out.println(event_place);
		System.out.println(event_details);
		this.context=context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return event_name.length;
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
		//LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		
		LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		
		convertView=inflater.inflate(R.layout.eventsadpter, null);
		TextView tv1=(TextView) convertView.findViewById(R.id.events_name);
		tv1.setText(event_name[position]);
		TextView tv2=(TextView) convertView.findViewById(R.id.events_date);
		tv2.setText(event_date[position]);
		TextView tv3=(TextView) convertView.findViewById(R.id.events_place);
		tv3.setText(event_place[position]);
		TextView tv4=(TextView) convertView.findViewById(R.id.events_details);
		tv4.setText(event_details[position]);

		
		return convertView;
	}

}
