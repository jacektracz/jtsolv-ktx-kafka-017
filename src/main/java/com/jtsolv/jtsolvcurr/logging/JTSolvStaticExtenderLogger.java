package com.jtsolv.jtsolvcurr.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class JTSolvStaticExtenderLogger {

	private final static Logger currentLogger = LoggerFactory.getLogger(JTSolvStaticExtenderLogger.class);
	
	public static void logGenericInfo(Logger logger, String pss) {
		systemOut(pss);
		logger.info("GENERIC_LOGGER:" + pss);
		logger.trace("GENERIC_LOGGER:" + pss);
		logger.debug("GENERIC_LOGGER:" + pss);
	}

	public static void systemOut(String pss){
		System.out.println(pss);
	}


	public static String logGenericException(Logger logger, Exception ex,String pss) {
		try {
			String strOut = "";
			logger.info("GENERIC_LOGGER_EX:" + pss);
			systemOut("GENERIC_LOGGER_EX:" + pss);
			strOut = "ERR-CONTEXT-INFO:" + pss;
			String message = "";
			if(ex != null) {
				message = ex.getMessage();
			}
			logger.error("GENERIC_LOGGER_EX:" + message);
			systemOut("GENERIC_LOGGER_EX:" + message);
			strOut = strOut + "ERR-MESSAGE-INFO:" ;
			strOut = strOut + message;
			logger.error("GENERIC_LOGGER_EX:" + getStackTraceAsString(ex));
			systemOut("GENERIC_LOGGER_EX:" + getStackTraceAsString(ex));
			strOut = strOut + "ERR-STACK-INFO:" ;
			strOut = strOut + getStackTraceAsString(ex);
			return strOut;

		}catch(Exception exin) {
			systemOut("GENERIC_LOGGER_EX_IN:" + exin.getMessage());
			return "GENERIC_LOGGER_EX_IN:" + exin.getMessage();
		}
	}

	public static String getStackTraceAsString(Throwable throwable) {
		if( throwable == null){
			return "";
		}
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		throwable.printStackTrace(printWriter);
		return stringWriter.toString();
	}

}
