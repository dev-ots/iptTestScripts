package com.ortusolis.registration;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.IPTDemo1FlowPO;
import com.ortusolis.pageobjectsPO.IPTLoginPO;
import com.ortusolis.pageobjectsPO.LoginPagePO;

import com.ortusolis.utilities.TestBase;

public class IPTDemo1 extends TestBase
{
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	IPTDemo1FlowPO demoFlow = new IPTDemo1FlowPO();
	String sTestCaseName="launch IPT continue for login";
	
	@Test
	public void IPT_User_Demo() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		
		log.info("page load completed");
		demoFlow.loadLoginPageLOcators();
		demoFlow.demo1_IPTFlow();
		System.out.println("11111");
		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
}
}



