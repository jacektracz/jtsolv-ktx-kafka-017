package com.jtsolv.jtsolvcurr.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class LkdGenericLogger {

	private final static Logger log = LoggerFactory.getLogger(LkdGenericLogger.class);
	
	public static void logGenericInfo(String pss) {
		log.info("GENERIC_LOGGER:" + pss);
	}
	
	public static void logInfo(String pss) {
		log.info("GENERIC_LOGGER:" + pss);
	}
	
	public static void logGenericException(Exception ex,String pss) {
		try {
		log.info("GENERIC_LOGGER_EX:" + pss);
		log.error("GENERIC_LOGGER_EX:" + ex.getMessage());
		log.error("GENERIC_LOGGER_EX:" + Arrays.toString(ex.getStackTrace()));
		}catch(Exception exin) {
			
		}
	}

	public static String getStackTraceAsString(Throwable throwable) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		throwable.printStackTrace(printWriter);
		return stringWriter.toString();
	}

}
