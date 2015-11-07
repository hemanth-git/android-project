package com.Display;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.StrictMode;

public class ConnectionUtil {
	public static String url="http://10.0.2.2:8080/demoservelet/";
	public static String result;
	public static String getConnection(String Strurl)
	{URL url;
		try {
			
			StrictMode.ThreadPolicy st=new  StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(st);
			url=new URL(Strurl);
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			InputStream is=con.getInputStream();
			StringBuffer sb=new StringBuffer();
			int i=0;
			while((i=is.read())!=-1)
			{
				sb.append((char)i);
			}
			result=sb.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
