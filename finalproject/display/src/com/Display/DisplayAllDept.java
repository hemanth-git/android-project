package com.Display;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class DisplayAllDept extends Activity{
	
	Spinner alldepts;
	String request,response;
	
	String[] dept_id,dept_name;
	String[] DEPT_UPDATEID;
	 String[] DEPT_NOTICE;
	 String[] UPDATE_DATE;
	;
	ListView ls;

	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayalldept);
        alldepts=(Spinner) findViewById(R.id.alldepts);
      // spi=(Spinner) findViewById(R.id.events);
      ls=(ListView)findViewById(R.id.display_select);
      
      request=ConnectionUtil.url+"sample?action=department";
      response=ConnectionUtil.getConnection(request);
      System.out.println(response);
  	

      try {
			JSONArray arr=new JSONArray(response);
			dept_id=new String[arr.length()+1];
			dept_name=new String[arr.length()+1];
			dept_id[0]="4001";
			dept_name[0]="<select>";
			
			for(int i=0;i<arr.length();i++)
			{
				dept_id[i+1]=arr.getJSONObject(i).optString("deptid");
				dept_name[i+1]=arr.getJSONObject(i).optString("deptname");
								
			}
			System.out.println(dept_id);
			ArrayAdapter adapter=new ArrayAdapter(DisplayAllDept.this, android.R.layout.simple_spinner_dropdown_item,dept_name);
			alldepts.setAdapter(adapter);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
      alldepts.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				int id=alldepts.getSelectedItemPosition();
				if(id==0)
				{
					
				}else{
				
				//String s=DisplayAllDept.this.dept_name[arg2];
				//System.out.println(s+"???????????????");
				//System.out.println(arg2+"........................");
				//System.out.println(arg3+"..................");
			
				
		        request=ConnectionUtil.url+"sample?action=deptupdate&eid="+id+"";
		        response=ConnectionUtil.getConnection(request);
		        System.out.println(request);
		        System.out.println(response);
		    	JSONArray subarr;
		    /* event_id=null;
		    	 event_name=null;
		    	 event_date=null;
		    	 event_place=null;
		    	event_details=null;*/
		    	
		        try {
		        	  	subarr = new JSONArray(response);
		        	  	DEPT_UPDATEID=new String[subarr.length()];
		        	  	DEPT_NOTICE=new String[subarr.length()];
		        	  	UPDATE_DATE=new String[subarr.length()];
					
					for(int i=0;i<subarr.length();i++){
						DEPT_UPDATEID[i]=subarr.getJSONObject(i).optString("id");
						DEPT_NOTICE[i]=subarr.getJSONObject(i).optString("details");
						UPDATE_DATE[i]=subarr.getJSONObject(i).optString("updatedate");
						
						
						//name=setText(event_name[i]);
						/*System.out.println(event_name[i]);
						System.out.println(event_name[i]);
						System.out.println(event_date[i]);
						System.out.println(event_details[i]);
						System.out.println(event_place[i]);*/
					}
					
					//System.out.println(dept_name);
			//		ArrayAdapter adapterlistview=new ArrayAdapter(DisplayActivity.this, android.R.layout.simple_list_item_1,event_name);
				DeptAdapter edp=new DeptAdapter(DisplayAllDept.this,DEPT_UPDATEID,DEPT_NOTICE,UPDATE_DATE);
					
					ls.setAdapter(edp);					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
	}
      

		
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	
	

     }
	}
