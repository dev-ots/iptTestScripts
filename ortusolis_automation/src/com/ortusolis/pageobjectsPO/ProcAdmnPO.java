package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class ProcAdmnPO  extends TestBase
{
  By Usr_ID,Pwd_pwd,signIn,ProcScrAdmn,Add_NewBuyer,New_BuyerGroup,New_Assistant,Edit;
  
  final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	
	public void ProcAdmnlocators() throws Exception
	{
		log.info("login as Admin Add New User");
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_ProcAdmn.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_ProcAdmn.json");
		oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/dataValidationProcAdmn.json");
	   ProcAdmnPageObjects(oJsOR_Reg);
	}

	private void ProcAdmnPageObjects(JSONObject oJsOR_Reg) 
	{
       Usr_ID =oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr_ID"));
       Pwd_pwd =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pwd_pwd"));

       signIn =oSelUtil.loadWithBy(oJsOR_Reg.getString("signIn"));

       ProcScrAdmn =oSelUtil.loadWithBy(oJsOR_Reg.getString("ProcScrAdmn"));

       Add_NewBuyer =oSelUtil.loadWithBy(oJsOR_Reg.getString("Add_NewBuyer"));

       New_BuyerGroup =oSelUtil.loadWithBy(oJsOR_Reg.getString("New_BuyerGroup"));

       New_Assistant =oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Assistant"));
       
       Edit =oSelUtil.loadWithBy(oJsOR_Reg.getString("Edit"));

      	}
	
    public  boolean ProcAdmnlogin() throws Exception
    {
    	boolean padmn_login = false;
    	try
    	{
    		oSelUtil.ufClear(driver, Usr_ID);
    		oSelUtil.ufSendKeys(driver, Usr_ID, oJsTD_Reg.getString("Proc_Admn"));
    		oSelUtil.ufClear(driver, Pwd_pwd);
    		oSelUtil.ufSendKeys(driver, Pwd_pwd, oJsTD_Reg.getString("Pwd_pwd"));
    		oSelUtil.ufClick(driver, signIn);
    		oSelUtil.ufGetTextValidation(driver, ProcScrAdmn, oJsDataVal.getString("Admin_Scr"));
    		oSelUtil.ufIsDisplayed(driver, Add_NewBuyer);
    		oSelUtil.ufIsDisplayed(driver, New_BuyerGroup);
    		oSelUtil.ufIsDisplayed(driver, New_Assistant);
    		oSelUtil.ufIsDisplayed(driver, Edit);
    	}
    	catch(Exception ex)
    	{
    		log.info("error at the Procurement admin login in IPT system"+ex);
    		padmn_login = false;
    	}
    	return padmn_login;
    }
}
