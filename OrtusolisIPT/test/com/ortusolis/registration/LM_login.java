package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.LMloginPO;
import com.ortusolis.utilities.TestBase;

public class LM_login extends TestBase 
{

			final Logger log =LoggerFactory.getLogger(getClass().getName()) ;
			LMloginPO lml= new LMloginPO();
			String sTestCaseName="Launch IPT URL in chrome and Enter the User details to register in IPT system";
			@Test
			public void User_Story_1_Register() throws Exception
		
			{
				log.info(oJsConfig.getString("IPT_Login_URL"));
				driver.get("http://53.87.137.65:8080/ipt-app");
				lml.loadLMuserLocators();
				lml.RgstrLMUsr();
				driver.get("http://53.87.137.65:8080/ipt-app");
				lml.LogLMUsrVerfyfld();
				lml.LMusrByAdmn();
			}
			
}
		
