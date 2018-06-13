package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class UsrRgstrByAdmnPO  extends TestBase
{
	
	By Admn_id,Admn_pwd,signIN,Admn_Scr,Add_Nw_Usr,Nw_Usr,Nw_Contact,Daimler_id,Dept,role,Submit;

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	
	public void NewUsrByAdmnlocators() throws Exception
	{
		log.info("login as Admin Add New User");
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_UsrRgstrByAdmn.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_UsrRgstrByAdmn.json");
		oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/dataValidationUsrRgstrByAdmn.json");
		
		NewUsrObjects(oJsOR_Reg);
	}

	private void NewUsrObjects(JSONObject oJsOR_Reg) 
	{
		Admn_id = oSelUtil.loadWithBy(oJsOR_Reg.getString("Admn_id"));
		Admn_pwd = oSelUtil.loadWithBy(oJsOR_Reg.getString("Admn_pwd"));
		signIN = oSelUtil.loadWithBy(oJsOR_Reg.getString("signIN"));
		Admn_Scr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Admn_Scr"));
		
		Add_Nw_Usr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Add_Nw_Usr"));
		Nw_Usr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Nw_Usr"));
		Nw_Contact = oSelUtil.loadWithBy(oJsOR_Reg.getString("Nw_Contact"));
		Daimler_id = oSelUtil.loadWithBy(oJsOR_Reg.getString("Daimler_id"));
		Dept = oSelUtil.loadWithBy(oJsOR_Reg.getString("Dept"));
		role = oSelUtil.loadWithBy(oJsOR_Reg.getString("role"));

		Submit = oSelUtil.loadWithBy(oJsOR_Reg.getString("Submit"));
	}
	
	public boolean NewUsrRgstr() throws Exception
	{
		boolean new_usr=false;
		try
		{
			oSelUtil.ufClear(driver, Admn_id);
			oSelUtil.ufSendKeys(driver, Admn_id, oJsTD_Reg.getString("Admin_id"));
			oSelUtil.ufClear(driver, Admn_pwd);
			oSelUtil.ufSendKeys(driver, Admn_pwd, oJsTD_Reg.getString("Ad_pwd"));
			oSelUtil.ufClick(driver, signIN);
			oSelUtil.ufIsDisplayed(driver, Admn_Scr);
			oSelUtil.ufClick(driver, Add_Nw_Usr);
			oSelUtil.ufClear(driver, Nw_Usr);
			oSelUtil.ufSendKeys(driver, Nw_Usr, oJsTD_Reg.getString("User_name"));
			oSelUtil.ufClear(driver, Nw_Contact);
			oSelUtil.ufSendKeys(driver, Nw_Contact, oJsTD_Reg.getString("Contact_no"));
			oSelUtil.ufClear(driver, Daimler_id);
			oSelUtil.ufSendKeys(driver, Daimler_id, oJsTD_Reg.getString("Daimler_id"));
			oSelUtil.ufClear(driver, Dept);
			oSelUtil.ufSendKeys(driver, Dept, oJsTD_Reg.getString("Dept"));
			/*WebElement role1 = driver.findElement(By.id(role));
			Select sc = new Select(role1);
			
			sc.selectByVisibleText("role");*/
			
			oSelUtil.ufClick(driver, Submit);
			
		}
		
		catch(Exception ex)
		{
			log.info("Error in Registering the new user"+ex);
		}
		return new_usr;
	}
}