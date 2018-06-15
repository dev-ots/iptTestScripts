package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.IPTDemo1FlowPO;
import com.ortusolis.pageobjectsPO.IPTDemo1LMFlowPO;
import com.ortusolis.utilities.TestBase;

public class IPTDemo1LM extends TestBase
{

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	IPTDemo1LMFlowPO demoLMFlow = new IPTDemo1LMFlowPO();
	String sTestCaseName="launch IPT continue for login";
	
	@Test
	public void IPT_User_Demo() throws Exception {
		log.info(oJsConfig.getString("IPT_Login_URL"));
		
		log.info("page load completed");
		demoLMFlow.loadLoginPageLOcators();
		demoLMFlow.demo1LM_IPTFlow();
		
}
	
}
