package com.itech.iERP.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.struts.upload.FormFile;

public class Util 
{
public static void audioFolder(FormFile myfile,String filePath, String fileName )throws Exception {
		
		//Get the servers upload directory real path name
		
		  // Save file on the server 
		  if(!fileName.equals("")){  
		  System.out.println("Server path:" +filePath);
		  		 
		  //Create file
		  File fileToCreate = new File(filePath, fileName);
		  //If file does not exists create file 
		  FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
		  fileOutStream.write(myfile.getFileData());
		  fileOutStream.flush();
		  fileOutStream.close();
		  }
		  System.out.println("server file path ===="+filePath +"\\" + fileName);
		  //String file = filePath+"/"+fileName;	
	}
	
	
	public static String sqlDateToString(String dateString) {
		String formatDate = "";
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat pattern = new SimpleDateFormat("dd-MMM-yyyy");
			if (dateString != null & dateString != "") {
				date = dateFormat.parse(dateString);
				formatDate = pattern.format(date);
			}
		} catch (Exception e) {
			 //log.error(e.getMessage());
			e.printStackTrace();
		}
		return formatDate;
	}
	
	public static String formatSqlDate(String dateString) {
		String formatDate = "";
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd");
			if (dateString != null & dateString != "") {
				date = dateFormat.parse(dateString);
				formatDate = pattern.format(date);
			}
		} catch (Exception e) {
			 //log.error(e.getMessage());
			e.printStackTrace();
		}
		return formatDate;
	}
	
	
	public static String getCurrentTime(){
		String time="";
		String am_pm="";
		try {
				Calendar calendar=new GregorianCalendar();
				int hour=calendar.get(Calendar.HOUR);
				int minute=calendar.get(Calendar.MINUTE);
				int second=calendar.get(Calendar.SECOND);
				String hours=String.valueOf(hour);
				String minutes=String.valueOf(minute);
				String seconds=String.valueOf(second);
				
				if (calendar.get(Calendar.AM_PM)==0) {
					am_pm= "AM";
				}else {
					am_pm="PM";
				}
				time=hour+":"+minute+":"+seconds+""+am_pm;
				
				
		
		} catch (Exception e) {
				e.printStackTrace();
				}
		return time;
	}

	public static String getCurrentDate() {
		String date =null;
		try {
			
		Date tdate = new Date();
		
			 DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			 Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));   
//			  cal.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));  
			    date =  dateFormat.format(tdate);
			
	} catch (Exception e) {
			e.printStackTrace();
			}
	return date;
}
	
	public static String AddDate(int nofdays) {

		  DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		  Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));   
		  cal.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		  System.out.println(cal.getTime());
		  
		  
		 /*<------------------------Calendar Class Method For Add 15 Day to Present Date--------------------->*/
		  cal.add(Calendar.DATE,nofdays);
		  String date =dateFormat.format(cal.getTime());
		  return date;
	}
}
