package com.itech.iERP.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggerUtil
{
	private static final LoggerUtil LOGGER_UTIL=null;
	private static Log log=null;
	
	private LoggerUtil(){
		
	}
	public static synchronized LoggerUtil getInstance(){
		if(LOGGER_UTIL==null){
			return new LoggerUtil();
		}
		return LOGGER_UTIL;
	}
	
	public Log getLogger(Class<?> name){
		if(log==null){
			return LogFactory.getLog(name);
		}
		return log;
	}
}
