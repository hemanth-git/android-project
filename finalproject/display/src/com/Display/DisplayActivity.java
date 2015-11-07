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
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class DisplayActivity extends Activity {
	Spinner events;
	ListView ls;
	TextView name,date,place,details;
	String request,response;
	String[] event_typeid=null,event_subname=null;
	 String[] event_id;
	 String[] event_name;
	 String[] event_date;
	 String[] event_place;
	String[] event_details;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        events=(Spinner) findViewById(R.id.events);
      
      ls=(ListView)findViewById(R.id.listViewEvents);
    		/*name=(TextView) findViewById(R.id.name);
    		date=(TextView)findViewById(R.id.date);
    		place=(TextView)findViewById(R.id.place);
    		details=(TextView)findViewById(R.id.details);*/
       
        request=ConnectionUtil.url+"sample?action=event";
        response=ConnectionUtil.getConnection(request);
        System.out.println(response);
    	

        try {
			JSONArray arr=new JSONArray(response);
			event_typeid=new String[arr.length()+1];
			event_subname=new String[arr.length()+1];
			event_typeid[0]="4001";
			event_subname[0]="<select>";
			
			for(int i=0;i<arr.length();i++)
			{
				event_typeid[i+1]=arr.getJSONObject(i).optString("eventid");
				event_subname[i+1]=arr.getJSONObject(i).optString("eventname");
								
			}
			System.out.println(event_typeid);
			ArrayAdapter adapter=new ArrayAdapter(DisplayActivity.this, android.R.layout.simple_spinner_dropdown_item,event_subname);
			events.setAdapter(adapter);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        events.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				int eventid=events.getSelectedItemPosition();
				if(eventid==0)
				{
					
				}else{
				
				String s=DisplayActivity.this.event_subname[arg2];
				System.out.println(s+"???????????????");
				System.out.println(arg2+"........................");
				System.out.println(arg3+"..................");
			
				
		        request=ConnectionUtil.url+"sample?action=eventsubcategory&eid="+eventid+"";
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
					event_id=new String[subarr.length()];
					event_name=new String[subarr.length()];
					event_date=new String[subarr.length()];
					event_details = new String[subarr.length()];
					event_place= new String[subarr.length()];
					for(int i=0;i<subarr.length();i++){
						event_name[i]=subarr.getJSONObject(i).optString("name");
						event_date[i]=subarr.getJSONObject(i).optString("date");
						event_details[i]=subarr.getJSONObject(i).optString("details");
						event_place[i]=subarr.getJSONObject(i).optString("place");
						
						//name=setText(event_name[i]);
						/*System.out.println(event_name[i]);
						System.out.println(event_name[i]);
						System.out.println(event_date[i]);
						System.out.println(event_details[i]);
						System.out.println(event_place[i]);*/
					}
					
					System.out.println(event_name);
			//		ArrayAdapter adapterlistview=new ArrayAdapter(DisplayActivity.this, android.R.layout.simple_list_item_1,event_name);
				EventsAdapter edp=new EventsAdapter(DisplayActivity.this,event_name,event_date,event_details,event_place);
					
					ls.setAdapter(edp);					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		    	
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
    }
}