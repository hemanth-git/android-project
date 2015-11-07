package com.Display;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Homepage extends Activity{
	
	Spinner tables;
	String request;
	String response;
	String[] table_id;
	String[] table_name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		super.onCreate(savedInstanceState);
		
		
		tables= (Spinner) findViewById(R.id.spinner1);
		 request=ConnectionUtil.url+"sample?action=alltables";
	        response=ConnectionUtil.getConnection(request);
	        System.out.println(response);
	        
	        try {
				JSONArray arr=new JSONArray(response);
				table_id=new String[arr.length()+1];
				table_name=new String[arr.length()+1];
				table_id[0]="4001";
				table_name[0]="<select>";
				
				for(int i=0;i<arr.length();i++)
				{
					table_id[i+1]=arr.getJSONObject(i).optString("id");
					table_name[i+1]=arr.getJSONObject(i).optString("tablename");
									
				}
				System.out.println(table_id);
				ArrayAdapter adapter=new ArrayAdapter(Homepage.this, android.R.layout.simple_spinner_dropdown_item,table_name);
				tables.setAdapter(adapter);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
