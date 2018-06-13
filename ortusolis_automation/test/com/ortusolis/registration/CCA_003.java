package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.scanner.Constant;

import com.ortusolis.utilities.Constants;
import com.ortusolis.utilities.TestBase;

public class CCA_003 extends TestBase {

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	String sTestCaseName;
	String sURL;
	

	@Parameters({ "URL_Type"})
	@BeforeTest
	public void getURLSettingEnvironment(String sURL_Type) throws Exception{
		//sExtentReportFormatRequired=Constants.sExtentReportFormatSuite;
		sTestCaseName="\"Enter all valid fields on "+sURL_Type+" sign up page. check whether sighn up success full or not\"";
		sURL = oJsConfig.get(sURL_Type).toString();
		sURL=oComUtil.setEnvironment(sURL);
	}
	
	@Test
	public void CCA_003_Registration_On_AllPages() throws Exception {	
		log.info(sURL);
		driver.get(sURL);
		
		ngWebDriver.waitForAngularRequestsToFinish();
		//poReg.loadRegistrationPageLocators(sURL);
		//poReg.ufFillData_CompleteRegistrationFlow();
	}
}
