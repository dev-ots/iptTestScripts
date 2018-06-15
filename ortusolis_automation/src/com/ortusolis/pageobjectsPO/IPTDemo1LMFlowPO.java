package com.ortusolis.pageobjectsPO;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.jayway.restassured.response.ResponseBody;
import com.ortusolis.utilities.Constants;
import com.ortusolis.utilities.RestAPIUtilities;
import com.ortusolis.utilities.TestBase;

public class IPTDemo1LMFlowPO extends TestBase {
	
final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());

RestAPIUtilities oRes = new RestAPIUtilities();

	By Sign_Username,Sign_Password,Signin_SignButton,Signin_ForgotPassword,
	Signin_registerForNewUSer,Signin_Success;
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();

	String userRole = null;
	
	public void loadLoginPageLOcators() throws Exception {
		oJsConfig = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/config/config.json");
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_Login.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_RegisterNewUser.json");
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

	public boolean demo1LM_IPTFlow() throws Exception{
		boolean bRes_flag=false;
		boolean bUser_flag=false;
		try {
			
			RegisterIPTUser registerUser = new RegisterIPTUser();
			
			driver.get("http://53.87.137.65/signUp");
			
			registerUser.Register_Uscript();
			boolean breg_flag = registerUser.Register_flow("LM User");
			
			if(breg_flag == true) {
			
				driver.navigate().to(oJsConfig.getString("IPT_Login_URL").toString());
				ngWebDriver.waitForAngularRequestsToFinish();
	
				oSelUtil.ufClear(driver, Sign_Username);
				oSelUtil.ufSendKeys(driver, Sign_Username, oJsTD_Reg.getString("USER_NAME_LM"));
				
				oSelUtil.ufClear(driver, Sign_Password);
				oSelUtil.ufSendKeys(driver, Sign_Password, oJsTD_Reg.getString("PASS_WORD_LM"));
				oSelUtil.ufClick(driver, Signin_SignButton);
				Thread.sleep(3000);
				
				bRes_flag = userValidation(Sign_Username.toString());
				
				
				ngWebDriver.waitForAngularRequestsToFinish();
				
				bUser_flag= validateUserDetails();
			}
		
		} catch(Exception ea) {
			//throw new Exception();
			log.info("Failed Demo1 Test case");
		}
		return bRes_flag;
}
	private boolean validateUserDetails() {
		
		
		// TODO Auto-generated method stub
		return false;
	}
	public boolean userValidation(String Username) throws Exception{
		
		boolean userBelongsTo=checkUserExist();
		boolean bRes_Flag=false;
		
		if(!userBelongsTo)
		{
			System.out.println("The user is not valid");
			bRes_Flag= false;
		}
		else
		{
			System.out.println(userRole);			
			bRes_Flag = true;
			if(userRole.contains(Constants.sRDAdRole))
			{
				driver.navigate().to(oJsConfig.getString("IPT_RD_LANDING"));
				bRes_Flag= getRDRequests();
				Thread.sleep(5000);
				bRes_Flag = getRDAdminRole();	
			}
			else if(userRole.contains(Constants.sSuperUser))
			{
				driver.navigate().to(oJsConfig.getString("IPT_RD_ADMIN"));
				bRes_Flag = getRDAdminRole();
			}
			else if(userRole.contains(Constants.sRDRole))
		{
			driver.navigate().to(oJsConfig.getString("IPT_RD_LANDING"));
			bRes_Flag= getRDRequests();
		}
		
		else if(userRole.contains(Constants.sLMRole))
		{
			driver.navigate().to(oJsConfig.getString("IPT_LM_LANDING"));
			return true;
		}
		else if(userRole.contains(Constants.sLMAdRole))
		{
			driver.navigate().to(oJsConfig.getString("IPT_LM_LANDING"));
			return true;
		}
		
		return bRes_Flag;
		}
		return bRes_Flag;
		
	}
	private boolean getRDAdminRole() {
		boolean bRes_flag = false;
		// TODO Auto-generated method stub
		RDLandingScreenPO rdLanding = new RDLandingScreenPO();
		RDAdminPO rdAdmin = new RDAdminPO();
		
		try {
			rdAdmin.loadLoginPageLOcators();
			
			rdAdmin.rdAdminActivities();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bRes_flag;
	}
	
	private boolean checkUserExist() throws Exception{
		
		try {
		
			HashMap<String, String> param = new HashMap();
			param.put("user_id", "bchinta");
			HashMap <String,String> dummy = new HashMap();
			String sRes = oRes.ufGet("http://d575aapyh039.jpadc.corpintra.net:8080/api/ipt-user/user_sign_in?", param);
			
		
			JSONObject obj = oRes.convertStringToJson(sRes);
		
			JSONObject obj2 = (JSONObject) obj.get("response");
			
			userRole = obj2.getString("designation");
			
			}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	
		return true;
	}
	
	private boolean getRDRequests()
	{
		boolean bRes_flag=false;
		RDLandingScreenPO rdLanding = new RDLandingScreenPO(); 
		try {
			
			rdLanding.loadRegistrationPageLocators();
			bRes_flag= rdLanding.search_ShikeishoDetails();
			ngWebDriver.waitForAngularRequestsToFinish();
			bRes_flag=true;
			
		} catch (Exception e) {
			bRes_flag=false;
			e.printStackTrace();
		}
		return bRes_flag;
		
		
	}
	
	

}
