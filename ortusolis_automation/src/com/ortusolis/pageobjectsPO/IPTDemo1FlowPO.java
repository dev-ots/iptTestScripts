package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.Constants;
import com.ortusolis.utilities.TestBase;

public class IPTDemo1FlowPO extends TestBase {
	
final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	
	By Sign_Username,Sign_Password,Signin_SignButton,Signin_ForgotPassword,
	Signin_registerForNewUSer,Signin_Success;
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	
	
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

	public boolean demo1_IPTFlow() throws Exception{
		boolean bRes_flag=false;
		try {
			

			oSelUtil.ufClear(driver, Sign_Username);
			oSelUtil.ufSendKeys(driver, Sign_Username, oJsTD_Reg.getString("USER_NAME_RD"));
			
			oSelUtil.ufClear(driver, Sign_Password);
			oSelUtil.ufSendKeys(driver, Sign_Password, oJsTD_Reg.getString("PASS_WORD_RD"));
			oSelUtil.ufClick(driver, Signin_SignButton);
			bRes_flag = userValidation(Sign_Username.toString());
			
			ngWebDriver.waitForAngularRequestsToFinish();
			
		
		} catch(Exception ea) {
			//throw new Exception();
			log.info("Failed Demo1 Test case");
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
			ngWebDriver.waitForAngularRequestsToFinish();
			System.out.println(userRole);
			System.out.println(Constants.sRDAdRole);
			bRes_Flag = true;
			if(userRole.contains(Constants.sRDAdRole))
			{
				driver.navigate().to(oJsConfig.getString("IPT_RD_LANDING"));
				bRes_Flag= getRDRequests();
				System.out.println("After in Admin else");
				bRes_Flag = getRDAdminRole();	
			}
			else if(userRole.contains(Constants.sRDRole))
		{
			driver.navigate().to(oJsConfig.getString("IPT_RD_LANDING"));
			System.out.println("Inside the RD Landing screen");
			
			bRes_Flag= getRDRequests();
		}
		/*else if(userRole.contains(Constants.sRDAdRole))
		{
			driver.navigate().to(oJsConfig.getString("IPT_RD_LANDING"));
			bRes_Flag= getRDRequests();
			System.out.println("After in Admin else");
			bRes_Flag = getRDAdminRole();
		}*/
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
	private boolean getRDAdminRole() {
		boolean bRes_flag = false;
		// TODO Auto-generated method stub
		RDLandingScreenPO rdLanding = new RDLandingScreenPO();
		RDAdminPO rdAdmin = new RDAdminPO();
		
		try {
			//bRes_flag = rdLanding.switchRoleToAdmin();
			//if(bRes_flag) {
			System.out.println("Before loadn the pagelocators");
			rdAdmin.loadLoginPageLOcators();
			System.out.println("Before or after failing");
			rdAdmin.rdAdminActivities();
			//}
			/*else
			{
				System.out.println("The user is not an Admin user");
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bRes_flag;
	}
	private String getUserRole() {
		// TODO Auto-generated method stub
		return Constants.sRDAdRole;
	}
	private String checkUserExist() throws Exception{
		
		return "True";
	}
	
	private boolean getRDRequests()
	{
		boolean bRes_flag=false;
		RDLandingScreenPO rdLanding = new RDLandingScreenPO(); 
		try {
			System.out.println("Inside the RD Requests method");
			rdLanding.loadRegistrationPageLocators();
			bRes_flag= rdLanding.search_ShikeishoDetails();
			bRes_flag=true;
			System.out.println("After performing the action of the RD Landing screen");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			bRes_flag=false;
			e.printStackTrace();
		}return bRes_flag;
		
	}

}
