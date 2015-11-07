package com.Display;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DeptAdapter extends BaseAdapter{

	String[] deptupdate_id,dept_notice,dept_updatedate;
	Context context;
	
	public DeptAdapter(Context context,
			String[] deptupdate_id, String[] dept_notice,String[] dept_updatedate) {
		// TODO Auto-generated constructor stub
		
		
		
		this.deptupdate_id=deptupdate_id;
		this.dept_notice=dept_notice;
		this.dept_updatedate=dept_updatedate;
		
		System.out.println(deptupdate_id);
		System.out.println(dept_notice);
		
		this.context=context;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return deptupdate_id.length;
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
		
		convertView=inflater.inflate(R.layout.deptupdate, null);
		//TextView tv1=(TextView) convertView.findViewById(R.id.dept_id);
		//tv1.setText(deptupdate_id[position]);
		TextView tv2=(TextView) convertView.findViewById(R.id.dept_notice);
		tv2.setText(dept_notice[position]);
		TextView tv3=(TextView) convertView.findViewById(R.id.deptupdatedate);
		tv3.setText(dept_updatedate[position]);

		
		return convertView;
		
		
		
	}

}
