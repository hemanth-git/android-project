package com.Display;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Placements extends Activity{
	
	ListView ls;
	String request,response;
	static String[] update_id=null;
	static String[] update_details=null;
	 static String[] update_typeid=null;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placements_layout);
        
      ls=(ListView)findViewById(R.id.listViewplacements);
    		/*name=(TextView) findViewById(R.id.name);
    		date=(TextView)findViewById(R.id.date);
    		place=(TextView)findViewById(R.id.place);
    		details=(TextView)findViewById(R.id.details);*/
       
        request=ConnectionUtil.url+"sample?action=placements";
        response=ConnectionUtil.getConnection(request);
        JSONArray subarr;
        try{
        subarr = new JSONArray(response);
		update_id=new String[subarr.length()];
		update_details=new String[subarr.length()];
		update_typeid=new String[subarr.length()];
		
		for(int i=0;i<subarr.length();i++){
			update_id[i]=subarr.getJSONObject(i).optString("name");
			update_details[i]=subarr.getJSONObject(i).optString("date");
			update_typeid[i]=subarr.getJSONObject(i).optString("details");
			
			
			//name=setText(event_name[i]);
			/*System.out.println(event_name[i]);
			System.out.println(event_name[i]);
			System.out.println(event_date[i]);
			System.out.println(event_details[i]);
			System.out.println(event_place[i]);*/
		}
		
		System.out.println(update_details);
		//ArrayAdapter adapterlistview=new ArrayAdapter(Placements.this, android.R.layout.simple_list_item_1,update_details);
		PlacementsAdapter edp = new PlacementsAdapter(Placements.this, update_details);
		ls.setAdapter(edp);					
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
