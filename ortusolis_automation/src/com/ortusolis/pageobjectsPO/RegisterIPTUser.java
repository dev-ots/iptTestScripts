package com.ortusolis.pageobjectsPO;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.json.JSONObject;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
//import org.openqa.selenium.Alert;
import com.ortusolis.utilities.TestBase;

public class RegisterIPTUser extends TestBase {


final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());

By Register_FirstName,Register_LastName,Register_Email,Register_UserID,
Register_button, Register_UserRole, Register_Success;
public static JSONObject oJsOR_Reg = new JSONObject();
public static JSONObject oJsTD_Reg = new JSONObject();
public static JSONObject oJsConfig = new JSONObject();


public void Register_Uscript() throws Exception {
	oJsConfig = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/config/config.json");
	oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_RegisterNewUser.json");
	oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_RegisterNewUser.json");
	
	Register_User(oJsOR_Reg);
}
private void Register_User(JSONObject oJsOR_Reg) 

{
	Register_FirstName =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Register_FirstName"));
	Register_LastName=  oSelUtil.loadWithBy(oJsOR_Reg.getString("Register_LastName"));
	Register_Email =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Register_Email"));
	Register_UserID =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Register_UserID"));

	Register_button =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Register_button"));
	Register_UserRole =  oSelUtil.loadWithBy(oJsOR_Reg.getString("Register_UserRole"));
	Register_Success= oSelUtil.loadWithBy(oJsOR_Reg.getString("Register_Success"));
	
	
}

public boolean Register_flow(String strFlowName) throws Exception{
	boolean rGst_flag=false;
	try {
		System.out.println(strFlowName);
		
		Select oSelect = null;
		if(strFlowName == "RD User")
		{
			oSelUtil.ufClear(driver, 	Register_FirstName);
			oSelUtil.ufSendKeys(driver,	Register_FirstName, oJsTD_Reg.getString("iptFirst_Name2"));
			
			oSelUtil.ufClear(driver, Register_LastName);
			oSelUtil.ufSendKeys(driver, Register_LastName, oJsTD_Reg.getString("iptlast_Name2"));
			oSelUtil.ufClear(driver, Register_Email);
			oSelUtil.ufSendKeys(driver, Register_Email, oJsTD_Reg.getString("iptEmail_email2"));
			oSelUtil.ufClear(driver, Register_UserID);
			oSelUtil.ufSendKeys(driver, Register_UserID, oJsTD_Reg.getString("iptID_id2"));
			
			oSelect = new Select(driver.findElement(Register_UserRole));
			oSelect.selectByValue("R02");
		}
		else if(strFlowName == "RD Admin")
		{
			oSelUtil.ufClear(driver, 	Register_FirstName);
			oSelUtil.ufSendKeys(driver,	Register_FirstName, oJsTD_Reg.getString("iptFirst_Name"));
			
			oSelUtil.ufClear(driver, Register_LastName);
			oSelUtil.ufSendKeys(driver, Register_LastName, oJsTD_Reg.getString("iptlast_Name"));
			oSelUtil.ufClear(driver, Register_Email);
			oSelUtil.ufSendKeys(driver, Register_Email, oJsTD_Reg.getString("iptEmail_email"));
			oSelUtil.ufClear(driver, Register_UserID);
			oSelUtil.ufSendKeys(driver, Register_UserID, oJsTD_Reg.getString("iptID_id"));
			
			oSelect = new Select(driver.findElement(Register_UserRole));
			oSelect.selectByValue("R01");
		}
		else if(strFlowName == "LM Admin")
		{
			oSelUtil.ufClear(driver, 	Register_FirstName);
			oSelUtil.ufSendKeys(driver,	Register_FirstName, oJsTD_Reg.getString("iptFirst_Name1"));
			
			oSelUtil.ufClear(driver, Register_LastName);
			oSelUtil.ufSendKeys(driver, Register_LastName, oJsTD_Reg.getString("iptlast_Name1"));
			oSelUtil.ufClear(driver, Register_Email);
			oSelUtil.ufSendKeys(driver, Register_Email, oJsTD_Reg.getString("iptEmail_email1"));
			oSelUtil.ufClear(driver, Register_UserID);
			oSelUtil.ufSendKeys(driver, Register_UserID, oJsTD_Reg.getString("iptID_id1"));
			
			oSelect = new Select(driver.findElement(Register_UserRole));
			oSelect.selectByValue("R03");
		}
		else if(strFlowName == "LM User")
		{
			oSelUtil.ufClear(driver, 	Register_FirstName);
			oSelUtil.ufSendKeys(driver,	Register_FirstName, oJsTD_Reg.getString("iptFirst_Name2"));
			
			oSelUtil.ufClear(driver, Register_LastName);
			oSelUtil.ufSendKeys(driver, Register_LastName, oJsTD_Reg.getString("iptlast_Name2"));
			oSelUtil.ufClear(driver, Register_Email);
			oSelUtil.ufSendKeys(driver, Register_Email, oJsTD_Reg.getString("iptEmail_email2"));
			oSelUtil.ufClear(driver, Register_UserID);
			oSelUtil.ufSendKeys(driver, Register_UserID, oJsTD_Reg.getString("iptID_id2"));
			
			oSelect = new Select(driver.findElement(Register_UserRole));
			oSelect.selectByValue("R04");
		}
	oSelUtil.ufClick(driver, Register_button);
	
	Robot rb= new Robot();
	Thread.sleep(4000);
	rb.keyPress(KeyEvent.VK_ENTER);
	

	if(oSelect.getFirstSelectedOption().getText().equalsIgnoreCase("RD Designer"))
	{
		rGst_flag=true;
		//driver.navigate().to(oJsConfig.getString("IPT_RD_LANDING").toString());
	}
	else if(oSelect.getFirstSelectedOption().getText().equalsIgnoreCase("RD Admin"))
	{
		//driver.navigate().to(oJsConfig.getString("IPT_RD_ADMIN").toString());
		rGst_flag=true;
	}
	else if(oSelect.getFirstSelectedOption().getText().equalsIgnoreCase("LM Admin"))
	{
		//driver.navigate().to(oJsConfig.getString("IPT_LM_ADMIN").toString());
		rGst_flag=true;
	}
	else if(oSelect.getFirstSelectedOption().getText().equalsIgnoreCase("LM User"))
	{
		//driver.navigate().to(oJsConfig.getString("IPT_LM_LANDING").toString());
		rGst_flag=true;
	}
	else {
		rGst_flag=false;
		throw new Exception("Invalid user");
	}
	
	}catch(Exception ea) {
		log.info("Exception in Register_flow : "+ea);
		rGst_flag=false;
	}
	return rGst_flag;
	
}
}


