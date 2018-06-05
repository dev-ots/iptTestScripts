package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class ForgotPwdPO extends TestBase 
{
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	
	By Sign_Username,Sign_Password,Signin_SignButton,Signin_ForgotPassword,
	Signin_registerForNewUSer,Signin_Success;
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();

	public void LoginwithWrgPwd() throws Exception
	{
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_login.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_RegisterNewUser.json");
	 LoginWrgPwd(oJsOR_Reg);
	}

	private void LoginWrgPwd(JSONObject oJsOR_Reg2)
	{
		Sign_Username= oSelUtil.loadWithBy(oJsOR_Reg.getString("Sign_Username"));
		Sign_Password= oSelUtil.loadWithBy(oJsOR_Reg.getString("Sign_Password"));
		Signin_SignButton= oSelUtil.loadWithBy(oJsOR_Reg.getString("Signin_SignButton"));
		Signin_ForgotPassword= oSelUtil.loadWithBy(oJsOR_Reg.getString("Signin_ForgotPassword"));
		Signin_registerForNewUSer=oSelUtil.loadWithBy(oJsOR_Reg.getString("Signin_registerForNewUSer"));
		Signin_Success= oSelUtil.loadWithBy(oJsOR_Reg.getString("Signin_Success"));
		
		
	}
	
	public boolean ForgotPasswordIPT() throws Exception{
		boolean bRes_flag=false;
		try {
		
		oSelUtil.ufClear(driver, Sign_Username);
		oSelUtil.ufSendKeys(driver, Sign_Username, oJsTD_Reg.getString("USER_NAME"));
		
		oSelUtil.ufClear(driver, Sign_Password);
		oSelUtil.ufSendKeys(driver, Sign_Password, oJsTD_Reg.getString("PASS_WORD"));
		oSelUtil.ufClick(driver, Signin_SignButton);
		oSelUtil.sErrorMessage="Invalid Username and password";
		if(oSelUtil.sErrorMessage.contains("Invalid Username and password"))
		{
			oSelUtil.ufClick(driver, Signin_ForgotPassword);
			driver.navigate().to("https://login.e.corpintra.net/password/ad?lang=en");
		}
		
		//bRes_flag=oSelUtil.ufIsDisplayed(driver, Signin_Success);
		//log.info("is Display welcome page "+bRes_flag);
		bRes_flag= oSelUtil.ufGetTextValidation(driver, Signin_Success, oJsDataVal.getString("Login_success"));
		log.info("Text validation welcome page "+bRes_flag);
		}catch(Exception ea) {
			log.info("Exception in login_flow : "+ea);
			bRes_flag=false;
		}
		return bRes_flag;
		
	}
	
}
