package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.ortusolis.pageobjectsPO.RegisterIPTUser;
import com.ortusolis.pageobjectsPO.Sample;
import com.ortusolis.utilities.TestBase;

public class RegisterNewUser extends TestBase
{

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	RegisterIPTUser cis= new RegisterIPTUser();

	@Test
	public void User_Story_1_Register() throws Exception
	{
		sTestCaseName="Launch IPT URL in chrome and Enter the User details to register in IPT system";
		log.info(oJsConfig.getString("IPT_USER_REGISTRATION"));
		driver.get("http://53.87.137.65/signUp");
		
	//	sample.login_flowIPT();
		cis.Register_Uscript();
		bTestCase=cis. Register_flow("RD User");
		
	}

}
