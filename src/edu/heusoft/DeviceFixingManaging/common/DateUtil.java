//MJRT
//MODIFIED BY SLIAN ON 20160729
package edu.heusoft.DeviceFixingManaging.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	//private static Date time = null;
	private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

	public static Date HTMLtoServlet(String ts)
	{
		Date time = null;
		
		try {
			if(ts!=null) time = f.parse(ts);
		} catch (ParseException e) {
			System.out.println("DateUtil: Empty or invaild date.");
		}
		return time;
	}
	
	public static String ServlettoHTML(Date ts){
		String time = null;
		if(ts!=null) time=f.format(ts);
		return time;
	}
}
