package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DayTime {
	public static String getCurrentDayTime(){
		long time =System.currentTimeMillis();
		SimpleDateFormat dayTime =
				new SimpleDateFormat("yyyyMMdd-HH-mm-ss",Locale.KOREA);
		return dayTime.format(new Date(time));
		
	}
	public static void main(String args[]){
		System.out.print(getCurrentDayTime());;
	}

}
