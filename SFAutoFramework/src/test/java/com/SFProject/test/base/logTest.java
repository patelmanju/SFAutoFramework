package com.SFProject.test.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class logTest {
	private static Logger logger = LogManager.getLogger(logTest.class) ;
	@Test 
	public void performSomeTask() {
		logger.debug("debug message");
		logger.info("info message");
		logger.error("error message");
		logger.fatal("fatal message");
		
		

}
}
