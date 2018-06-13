package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ortusolis.utilities.TestBase;

public class CCA_001 extends TestBase {

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	
	String sTestCaseName="Check that on entering https://my.naviit.com/coldstone takes the user to registration page";
	@Parameters({ "URL_Type"})
	@Test
	public void CCA_001(String sURL_Type) {
		
		
	}
}
