package com.Vtiger.generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	
public int getRandomNumber()
{
	Random r=new Random();
	int random = r.nextInt(100000);
	return random;
}

public String getSystemDateYYYYMMDD()
{
	Date dateObj=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	String date = sim.format(dateObj);
	return date;
}

public String getRequiredDateYYYYMMDD(int days)
{
	Date dateObj=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	String date = sim.format(dateObj);
	
	Calendar cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,days);
	String reqDate = sim.format(cal.getTime());
	return reqDate;
}

}
