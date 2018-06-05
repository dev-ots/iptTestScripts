package com.ortusolis.pageobjectsPO;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.Constants;
import com.ortusolis.utilities.TestBase;


public class IPTLoginPO extends TestBase{
	
final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	
	By Sign_Username,Sign_Password,Signin_SignButton,Signin_ForgotPassword,
	Signin_registerForNewUSer,Signin_Success;
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	
	
	public void loadLoginPageLOcators() throws Exception {
		oJsConfig = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/config/config.json");
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_Login.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_Registration.json");
		loadingPageObjects(oJsOR_Reg);
	}
	private void loadingPageObjects(JSONObject oJsOR_Reg2) 
		
	{
	Sign_Username =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Sign_Username"));
		Sign_Password =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Sign_Password"));
		Signin_SignButton =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Signin_SignButton"));
		Signin_ForgotPassword =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Signin_ForgotPassword"));
		Signin_registerForNewUSer =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Signin_registerForNewUSer"));
		Signin_Success =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Signin_Success"));
		
}

	public boolean login_flowIPT() throws Exception{
		boolean bRes_flag=false;
		try {
				
		
		oSelUtil.ufClear(driver, Sign_Username);
		oSelUtil.ufSendKeys(driver, Sign_Username, oJsTD_Reg.getString("Login_id"));
		
		oSelUtil.ufClear(driver, Sign_Password);
		oSelUtil.ufSendKeys(driver, Sign_Password, oJsTD_Reg.getString("Password"));
		oSelUtil.ufClick(driver, Signin_SignButton);
		bRes_flag = userValidation(Sign_Username.toString());
		
		ngWebDriver.waitForAngularRequestsToFinish();
		//bRes_flag=oSelUtil.ufIsDisplayed(driver, Email_login_success);
		//log.info("is Display welcome page "+bRes_flag);
		
		//bRes_flag= oSelUtil.ufGetTextValidation(driver, Signin_Success, oJsDataVal.getString("Login_success"));
		log.info("Text validation welcome page "+bRes_flag);
		}catch(Exception ea) {
			log.info("Exception in login_flow : "+ea);
			//bRes_flag=false;
		}
		return bRes_flag;
		
	}
	
	public boolean userValidation(String Username) throws Exception{
		String userBelongsTo=checkUserExist();
		boolean bRes_Flag=false;
		
		if(userBelongsTo.equals("false"))
		{
			//implement not Registered here
			bRes_Flag= false;
			//bRes_Flag=oSelUtil.ufGetTextValidation(driver, Signin_Success, oJsDataVal.getString("Login_success"));
		}
		else
		{
			String userRole = getUserRole();
			bRes_Flag = true;
			
		if(userRole.contains(Constants.sRDRole))
		{
			driver.navigate().to(oJsConfig.getString("IPT_RD_LANDING"));
		}
		else if(userRole.contains(Constants.sRDAdRole))
		{
			driver.navigate().to(oJsConfig.getString("IPT_RD_LANDING"));
		}
		else if(userRole.contains(Constants.sLMRole))
		{
			driver.navigate().to(oJsConfig.getString("IPT_LM_LANDING"));
		}
		else if(userRole.contains(Constants.sLMAdRole))
		{
			driver.navigate().to(oJsConfig.getString("IPT_LM_LANDING"));
		}
		else
		{
			
		}
		return bRes_Flag;
		}
		return bRes_Flag;
		
	}
	private String getUserRole() {
		// TODO Auto-generated method stub
		return Constants.sRDRole;
	}
	private String checkUserExist() throws Exception{
		
		return "True";
	}
}
