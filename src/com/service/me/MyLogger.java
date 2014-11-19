package com.service.me;

import org.apache.log4j.Logger;

public class MyLogger {

	public static Logger mylog = Logger.getLogger(MyLogger.class);

	public static void main(String[] args) {
		mylog.debug("====log4j: debug");
		mylog.info("====log4j: info");
		mylog.warn("====log4j: warn");
		mylog.error("====log4j: error");
		mylog.fatal("====log4j: fatal");
	}

}
