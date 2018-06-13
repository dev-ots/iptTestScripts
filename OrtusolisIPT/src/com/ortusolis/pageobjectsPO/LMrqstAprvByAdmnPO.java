package com.ortusolis.pageobjectsPO;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class LMrqstAprvByAdmnPO extends TestBase 
{
  By New_Rgstr, fname, lname, email, Daimlr, role, Rgstr_Usr, Usr,
  Pwd, signup, Usr_pro, swtcadmn, Pndg, ClkUsr, Aprv, signout;
  final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	
	public void  RqstAprvLocators() throws Exception
	{
		log.info("login as LM user");
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_LMrqstAprvByAdmn.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_LMrqstAprvByAdmn.json");
	    oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir")+"/src/dataValidation/dataValidationShiAprvPdnLM.json");
	    
	    RqstAprvPage(oJsOR_Reg);
	}

	private void RqstAprvPage(JSONObject oJsOR_Reg2)
	{
		
		New_Rgstr =oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Rgstr"));
		fname =oSelUtil.loadWithBy(oJsOR_Reg.getString("fname"));
		lname =oSelUtil.loadWithBy(oJsOR_Reg.getString("lname"));
		email =oSelUtil.loadWithBy(oJsOR_Reg.getString("email"));
		Daimlr =oSelUtil.loadWithBy(oJsOR_Reg.getString("Daimlr"));
		role =oSelUtil.loadWithBy(oJsOR_Reg.getString("role"));
		Rgstr_Usr =oSelUtil.loadWithBy(oJsOR_Reg.getString("Rgstr_Usr"));
		//Rgstr_Sucess =oSelUtil.loadWithBy(oJsOR_Reg.getString("Rgstr_Sucess"));
		Usr =oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr"));
		Pwd =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pwd"));
		signup =oSelUtil.loadWithBy(oJsOR_Reg.getString("signup"));
		Usr_pro =oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr_pro"));
		swtcadmn =oSelUtil.loadWithBy(oJsOR_Reg.getString("swtcadmn"));
		Pndg = oSelUtil.loadWithBy(oJsOR_Reg.getString("Pndg"));
		ClkUsr =oSelUtil.loadWithBy(oJsOR_Reg.getString("ClkUsr"));
	    Aprv =oSelUtil.loadWithBy(oJsOR_Reg.getString("Aprv"));
	    signout = oSelUtil.loadWithBy(oJsOR_Reg.getString("signout"));
	    
	}
	public boolean RgstrLMUsr() throws Exception
	{
		boolean rgstrusr=false;
		try
		{
			
			oSelUtil.ufClick(driver, New_Rgstr);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClear(driver, fname);
			oSelUtil.ufSendKeys(driver, fname, oJsTD_Reg.getString("f_name"));
			Thread.sleep(1000);
			oSelUtil.ufClear(driver, lname);
			oSelUtil.ufSendKeys(driver, lname, oJsTD_Reg.getString("l_name"));
			oSelUtil.ufClear(driver, email);
			oSelUtil.ufSendKeys(driver, email, oJsTD_Reg.getString("email"));
			oSelUtil.ufClear(driver, Daimlr);
			oSelUtil.ufSendKeys(driver, Daimlr, oJsTD_Reg.getString("Daimler"));
			//oSelUtil.ufGetWebElement(driver, role);
			Select sc = new Select(driver.findElement(role));
			sc.selectByVisibleText("LM User");
		    oSelUtil.ufClick(driver, Rgstr_Usr);
		    Thread.sleep(2000);
		    Alert al1=driver.switchTo().alert();
		   al1.accept();
		    
		   // Robot r= new Robot();
		   // r.keyPress(KeyEvent.VK_ENTER);
		   
		   // oSelUtil.ufGetTextValidation(driver, Rgstr_Sucess, oJsDataVal.getString("Rgstr_success"));
		}
		catch(Exception ea)
		{
			log.info("Error at registering as LM user"+ea);
			rgstrusr=false;
		}
		return rgstrusr;
		
	}
	
	public boolean UsrLogn() throws Exception
	{
		boolean usr_log=false;
		try
		{
			oSelUtil.ufClear(driver,Usr);
			oSelUtil.ufSendKeys(driver, Usr, oJsTD_Reg.getString("UsrId"));
			oSelUtil.ufClear(driver,Pwd);
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("UsrPwd"));
			oSelUtil.ufClick(driver, signup);
			Thread.sleep(2000);
			Alert all = driver.switchTo().alert();
			all.accept();
		
			
			
		}
		catch(Exception ee)
		{
			log.info("Unable to login"+ee.getMessage());
			usr_log=false;
		}
		return usr_log;
	}
	
	public boolean AdmnLogn() throws Exception
	{
		boolean adm_log=false;
		try
		{
			oSelUtil.ufClear(driver,Usr);
			oSelUtil.ufSendKeys(driver, Usr, oJsTD_Reg.getString("AdmnId"));
			oSelUtil.ufClear(driver,Pwd);
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("AdmnPwd"));
			//Thread.sleep(1000);
			System.out.println("Before signup");
			oSelUtil.ufClick(driver, signup);
			System.out.println("After signup");
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, Usr_pro);
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, swtcadmn);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, Pndg);
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, ClkUsr);
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, Aprv);
			Alert al = driver.switchTo().alert();
			al.accept();
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, Usr_pro);
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, signout);
			
			
			
		}
		catch(Exception ep)
		{
			log.info("Unable to login by Admin"+ep.getMessage());
			adm_log=false;
		}
		return adm_log;
	}


}
