package com.Display;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Administration extends Activity{
	
	ListView ls;
	String request,response;
	static String[] update_id;
	static String[] update_name;
	 static String[] update_info;
	static String[] update_date;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminstration_layout);
        Intent intent = new Intent(Administration.this,ServiceClass.class);
        startService(intent);
        
      ls=(ListView)findViewById(R.id.listViewAdmin);
    		/*name=(TextView) findViewById(R.id.name);
    		date=(TextView)findViewById(R.id.date);
    		place=(TextView)findViewById(R.id.place);
    		details=(TextView)findViewById(R.id.details);*/
       
        request=ConnectionUtil.url+"sample?action=administration";
        response=ConnectionUtil.getConnection(request);
        
        JSONArray subarr;
        try{
        subarr = new JSONArray(response);
        update_id=new String[subarr.length()];
        update_name=new String[subarr.length()];
        update_info=new String[subarr.length()];
        update_date = new String[subarr.length()];
		for(int i=0;i<subarr.length();i++){
			update_id[i]=subarr.getJSONObject(i).optString("id");
			update_name[i]=subarr.getJSONObject(i).optString("name");
			update_info[i]=subarr.getJSONObject(i).optString("info");
			update_date[i]=subarr.getJSONObject(i).optString("date");
			
			//name=setText(event_name[i]);
			/*System.out.println(event_name[i]);
			System.out.println(event_name[i]);
			System.out.println(event_date[i]);
			System.out.println(event_details[i]);
			System.out.println(event_place[i]);*/
		}
		
		System.out.println(update_name);
		//ArrayAdapter<String> adapterlistview=new ArrayAdapter<String>(Administration.this, android.R.layout.simple_list_item_1,update_name);
		AdminAdapter edp = new AdminAdapter(Administration.this, update_name, update_info, update_id, update_date);
		ls.setAdapter(edp);					
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	

}
