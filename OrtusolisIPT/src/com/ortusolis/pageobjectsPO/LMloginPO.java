package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ortusolis.utilities.TestBase;
import com.ortusolis.utilities.CommonUtilities;
import com.ortusolis.utilities.SeleniumUtilities;

public class LMloginPO extends TestBase
{

	By New_Rgstr,fname,lname,email,Daimlr,role,Rgstr_Usr,Rgstr_Sucess,
	USER_NAME,PASSWRD,SIGN_IN,
	Srh_fld,New_Shi,Chng_Shi,Progr_Shi,PrtRcvd_Shi,
	User_Profile,logout,Switch_Admin,Admn_Scr,
	Add_NewUsr,Pndg_Rqst,Updt_Role,
	Add_Usr,fname1,lname1,email1,Daimlr1,role1,Sub_Usr,
      updt_btn, d_idFld, Get_dtl, rol_rol , sbmt;
	 

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg1 = new JSONObject();
	public static JSONObject oJsTD_Reg1 = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	
	public void loadLMuserLocators() throws Exception
	{
		log.info("login as LM user");
		oJsOR_Reg1 = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_LMuserScreen.json");
		oJsTD_Reg1 = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_LMusrscr.json");
		oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/dataValidationLMuser.json");
	    
		lmloginpageobjects(oJsOR_Reg1);
	}

	private void lmloginpageobjects(JSONObject oJsOR_Reg1)
	{
		New_Rgstr = oSelUtil.loadWithBy(oJsOR_Reg1.getString("New_Rgstr"));
		fname = oSelUtil.loadWithBy(oJsOR_Reg1.getString("fname"));
		lname = oSelUtil.loadWithBy(oJsOR_Reg1.getString("lname"));
		email = oSelUtil.loadWithBy(oJsOR_Reg1.getString("email"));
		Daimlr = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Daimlr"));
		role = oSelUtil.loadWithBy(oJsOR_Reg1.getString("role"));
		Rgstr_Usr =oSelUtil.loadWithBy(oJsOR_Reg1.getString("Rgstr_Usr"));
		Rgstr_Sucess = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Rgstr_Sucess"));
		
		USER_NAME= oSelUtil.loadWithBy(oJsOR_Reg1.getString("USER_NAME"));
		PASSWRD= oSelUtil.loadWithBy(oJsOR_Reg1.getString("PASSWRD"));
		SIGN_IN= oSelUtil.loadWithBy(oJsOR_Reg1.getString("SIGN_IN"));
		
		Srh_fld = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Srh_fld"));
		New_Shi = oSelUtil.loadWithBy(oJsOR_Reg1.getString("New_Shi"));
		Chng_Shi = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Chng_Shi"));
		Progr_Shi = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Progr_Shi"));
		PrtRcvd_Shi = oSelUtil.loadWithBy(oJsOR_Reg1.getString("PrtRcvd_Shi"));

		User_Profile = oSelUtil.loadWithBy(oJsOR_Reg1.getString("User_Profile"));
		logout = oSelUtil.loadWithBy(oJsOR_Reg1.getString("logout"));
		Switch_Admin = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Switch_Admin"));		
		Admn_Scr = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Admn_Scr"));
		
		Add_NewUsr = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Add_NewUsr"));
		Pndg_Rqst = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Pndg_Rqst"));
		Updt_Role = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Updt_Role"));

		Add_Usr = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Add_Usr"));
		fname1 = oSelUtil.loadWithBy(oJsOR_Reg1.getString("fname1"));
		lname1 = oSelUtil.loadWithBy(oJsOR_Reg1.getString("lname1"));
		email1 = oSelUtil.loadWithBy(oJsOR_Reg1.getString("email1"));
		Daimlr1 = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Daimlr1"));
		role1 = oSelUtil.loadWithBy(oJsOR_Reg1.getString("role1"));
		Sub_Usr =oSelUtil.loadWithBy(oJsOR_Reg1.getString("Sub_Usr"));
		
        updt_btn = oSelUtil.loadWithBy(oJsOR_Reg1.getString("updt_btn"));
        d_idFld = oSelUtil.loadWithBy(oJsOR_Reg1.getString("d_idFld"));
        Get_dtl = oSelUtil.loadWithBy(oJsOR_Reg1.getString("Get_dtl"));
        rol_rol = oSelUtil.loadWithBy(oJsOR_Reg1.getString("rol_rol"));
        sbmt = oSelUtil.loadWithBy(oJsOR_Reg1.getString("sbmt"));
	}
	
	public boolean RgstrLMUsr() throws Exception
	{
		boolean rgstrusr=false;
		try
		{
			oSelUtil.ufClick(driver, New_Rgstr);
			oSelUtil.ufClear(driver, fname);
			oSelUtil.ufSendKeys(driver, fname, oJsTD_Reg1.getString("f_name"));
			oSelUtil.ufClear(driver, lname);
			oSelUtil.ufSendKeys(driver, lname, oJsTD_Reg1.getString("l_name"));
			oSelUtil.ufClear(driver, email);
			oSelUtil.ufSendKeys(driver, email, oJsTD_Reg1.getString("email"));
			oSelUtil.ufClear(driver, Daimlr);
			oSelUtil.ufSendKeys(driver, Daimlr, oJsTD_Reg1.getString("Daimler"));
			WebElement roll=driver.findElement(role);
			Select sc = new Select(roll);
			sc.selectByVisibleText("");
		    oSelUtil.ufClick(driver, Rgstr_Usr);
		    oSelUtil.ufGetTextValidation(driver, Rgstr_Sucess, oJsDataVal.getString("Rgstr_success"));
		}
		catch(Exception ea)
		{
			log.info("Error at registering as LM user"+ea);
			rgstrusr=false;
		}
		return rgstrusr;
		
	}
	public boolean LogLMUsrVerfyfld() throws Exception
	{
		boolean lmlogin_flag=false;
		try{
			oSelUtil.ufClear(driver, 		USER_NAME);
			oSelUtil.ufSendKeys(driver, USER_NAME, oJsTD_Reg1.getString("User"));
			oSelUtil.ufClear(driver, PASSWRD);
			oSelUtil.ufSendKeys(driver, PASSWRD, oJsTD_Reg1.getString("Pwd"));
			oSelUtil.ufClick(driver, SIGN_IN);
			oSelUtil.ufIsDisplayed(driver, Srh_fld);
			oSelUtil.ufIsDisplayed(driver, New_Shi);
			oSelUtil.ufIsDisplayed(driver, Chng_Shi);
			oSelUtil.ufIsDisplayed(driver, Progr_Shi);
			oSelUtil.ufIsDisplayed(driver, PrtRcvd_Shi);
			}
		catch(Exception e)
		{
			log.info("Exception in login flow"+e);
			lmlogin_flag=false;
		}
		
		return lmlogin_flag;
	}
	public boolean LMusrByAdmn() throws Exception
	{
		boolean usrByAdmn=false;
		try
		{
			oSelUtil.ufClick(driver, User_Profile);
			oSelUtil.ufClick(driver, Switch_Admin);
			oSelUtil.ufGetTextValidation(driver, Admn_Scr, oJsDataVal.getString("LM_Admin"));
			oSelUtil.ufIsDisplayed(driver, Add_NewUsr);
			oSelUtil.ufIsDisplayed(driver, Pndg_Rqst);
			oSelUtil.ufIsDisplayed(driver, Updt_Role);
			
			oSelUtil.ufClick(driver, Add_NewUsr);
			oSelUtil.ufClear(driver, fname1);
			oSelUtil.ufSendKeys(driver, fname1, oJsTD_Reg1.getString("f_name1"));
			oSelUtil.ufClear(driver, lname1);
			oSelUtil.ufSendKeys(driver, lname1, oJsTD_Reg1.getString("l_name1"));
			oSelUtil.ufClear(driver, email1);
			oSelUtil.ufSendKeys(driver, email1, oJsTD_Reg1.getString("email1"));
			oSelUtil.ufClear(driver, Daimlr1);
			oSelUtil.ufSendKeys(driver, Daimlr1, oJsTD_Reg1.getString("Daimler1"));
			WebElement rol=driver.findElement(role);
			Select sc = new Select(rol);
			sc.selectByVisibleText("LMUSER");
		    oSelUtil.ufClick(driver, Sub_Usr);
		  oSelUtil.ufClick(driver, User_Profile);
		  oSelUtil.ufClick(driver, logout);
			
			
		}
		catch(Exception ec)
		{
			log.info("Exception in registering LM user by LM Admin"+ec);
			usrByAdmn=false;
		}
		return usrByAdmn;
	}
	
	public boolean UpdtRolByAdmn() throws Exception
	{
		boolean updt_role=false;
		try
		{
			oSelUtil.ufClear(driver, 		USER_NAME);
			oSelUtil.ufSendKeys(driver, USER_NAME, oJsTD_Reg1.getString("User"));
			oSelUtil.ufClear(driver, PASSWRD);
			oSelUtil.ufSendKeys(driver, PASSWRD, oJsTD_Reg1.getString("Pwd"));
			oSelUtil.ufClick(driver, SIGN_IN);
			oSelUtil.ufClick(driver, User_Profile);
			oSelUtil.ufClick(driver, Switch_Admin);
			oSelUtil.ufClick(driver, Updt_Role);
			oSelUtil.ufClick(driver, updt_btn);
			oSelUtil.ufClear(driver, d_idFld);
			oSelUtil.ufSendKeys(driver, d_idFld, oJsTD_Reg1.getString("D_ID"));
			oSelUtil.ufClick(driver, Get_dtl);
			WebElement rr= driver.findElement(rol_rol);
		    Select scl=new Select(rr);
		    scl.selectByVisibleText("User");
		    oSelUtil.ufClick(driver, sbmt);
		}
		catch(Exception ee)
		{
			log.info("Error in updating role of user"+ee.getMessage());
			updt_role=false;
		}
		return updt_role;
	}
	
}
