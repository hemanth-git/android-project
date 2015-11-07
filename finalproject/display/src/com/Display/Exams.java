package com.Display;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Exams extends Activity{
	ListView ls;
	String request,response;
	static String[] exam_id=null;
	static String[] exam_name=null;
	 static String[] exam_date=null;
	static String[] exam_typeid=null;
	static String[] exam_details=null;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_layout);
        
      ls=(ListView)findViewById(R.id.listViewexam);
    		/*name=(TextView) findViewById(R.id.name);
    		date=(TextView)findViewById(R.id.date);
    		place=(TextView)findViewById(R.id.place);
    		details=(TextView)findViewById(R.id.details);*/
       
        request=ConnectionUtil.url+"sample?action=exams";
        response=ConnectionUtil.getConnection(request);
        
        JSONArray subarr;
        try{
        subarr = new JSONArray(response);
		exam_id=new String[subarr.length()];
		exam_name=new String[subarr.length()];
		exam_date=new String[subarr.length()];
		exam_details = new String[subarr.length()];
		exam_typeid= new String[subarr.length()];
		for(int i=0;i<subarr.length();i++){
			exam_name[i]=subarr.getJSONObject(i).optString("name");
			exam_date[i]=subarr.getJSONObject(i).optString("date");
			exam_details[i]=subarr.getJSONObject(i).optString("details");
			exam_typeid[i]=subarr.getJSONObject(i).optString("typeid");
			
			//name=setText(event_name[i]);
			/*System.out.println(event_name[i]);
			System.out.println(event_name[i]);
			System.out.println(event_date[i]);
			System.out.println(event_details[i]);
			System.out.println(event_place[i]);*/
		}
		
		System.out.println(exam_name);
		//ArrayAdapter adapterlistview=new ArrayAdapter(Exams.this, android.R.layout.simple_list_item_1,exam_name);
		ExamsAdapter edp=new ExamsAdapter(Exams.this,exam_name,exam_date,exam_details,exam_typeid);
		ls.setAdapter(edp);					
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
}
	

