package com.Display;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Deptupdate extends Activity{
	ListView ls;
	String request,response;
	static String[] deptupdate_id=null;
	static String[] dept_id=null;
	 static String[] dept_details=null;
	static String[] dept_updatedate=null;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deptupdate_layout);
        
      ls=(ListView)findViewById(R.id.listViewdeptupdate);
    		/*name=(TextView) findViewById(R.id.name);
    		date=(TextView)findViewById(R.id.date);
    		place=(TextView)findViewById(R.id.place);
    		details=(TextView)findViewById(R.id.details);*/
       
        request=ConnectionUtil.url+"sample?action=deptupdate";
        response=ConnectionUtil.getConnection(request);
        
        JSONArray subarr;
        try{
        subarr = new JSONArray(response);
        deptupdate_id=new String[subarr.length()];
        dept_id=new String[subarr.length()];
        dept_details=new String[subarr.length()];
        dept_updatedate = new String[subarr.length()];
		
		for(int i=0;i<subarr.length();i++){
			deptupdate_id[i]=subarr.getJSONObject(i).optString("id");
			dept_id[i]=subarr.getJSONObject(i).optString("deptid");
			dept_details[i]=subarr.getJSONObject(i).optString("details");
			dept_updatedate[i]=subarr.getJSONObject(i).optString("updatedate");
			
			//name=setText(event_name[i]);
			/*System.out.println(event_name[i]);
			System.out.println(event_name[i]);
			System.out.println(event_date[i]);
			System.out.println(event_details[i]);
			System.out.println(event_place[i]);*/
		}
		
		//System.out.println(exam_name);
		//ArrayAdapter adapterlistview=new ArrayAdapter(Deptupdate.this, android.R.layout.simple_list_item_1,dept_details);
		
		//DeptAdapter edp=new DeptAdapter(Deptupdate.this,deptupdate_id,dept_id,dept_details,dept_updatedate);
		//ls.setAdapter(edp);					
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
	}

}