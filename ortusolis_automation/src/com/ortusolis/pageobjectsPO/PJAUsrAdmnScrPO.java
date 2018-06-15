package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class PJAUsrAdmnScrPO extends TestBase
{
	By New_Register,fname, lname, contact, email, role, PJAUsr, PJAdmn, Rgstr, Usr_Scr,
	search_Scr, Overseas, domestic,  SrhBy_Shi,SrhBy_Prt, SrhBy_EO, SrhBy_Kanri,
	  SrhBy_suplyCode,  SrhBy_PO,  SEARCH,  Usr_Pro,  Swt_Admn,  Over_seas,  New,  
	  PO_Sent,  Part_Arrived,  Dashboard,  Domestic;
	
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	public void PJAusrAdmnLocators() throws Exception
	{
		log.info("Register as PJA user switch to Admin and create new user");
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_PJAUsr&ByAmn.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_PJAUsr&Byadmn.json");
		oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/dataValidationPJAUsr&Byadmn.json");
		  LoadPjaObjects(oJsOR_Reg);
		
	}

	private void LoadPjaObjects(JSONObject oJsOR_Reg) 
	{
	 New_Register = oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Register"));
	 fname =oSelUtil.loadWithBy(oJsOR_Reg.getString("fname"));
	 lname =oSelUtil.loadWithBy(oJsOR_Reg.getString("lname"));
	 contact = oSelUtil.loadWithBy(oJsOR_Reg.getString("contact"));
	 email = oSelUtil.loadWithBy(oJsOR_Reg.getString("email"));
	 role = oSelUtil.loadWithBy(oJsOR_Reg.getString("role"));
	 PJAUsr = oSelUtil.loadWithBy(oJsOR_Reg.getString("PJAUsr"));//select from drop down
	 PJAdmn = oSelUtil.loadWithBy(oJsOR_Reg.getString("PJadmn"));//select from drop down
	 Rgstr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Rgstr"));
	 
	 Usr_Scr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr_Scr"));
	 
	 search_Scr = oSelUtil.loadWithBy(oJsOR_Reg.getString("search_Scr"));
	 Overseas = oSelUtil.loadWithBy(oJsOR_Reg.getString("Overseas"));
	 domestic = oSelUtil.loadWithBy(oJsOR_Reg.getString("domestic"));
	 SrhBy_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("SrhBy_Shi"));
	 SrhBy_Prt = oSelUtil.loadWithBy(oJsOR_Reg.getString("SrhBy_Prt"));
	 SrhBy_EO = oSelUtil.loadWithBy(oJsOR_Reg.getString("SrhBy_EO"));
	 SrhBy_Kanri = oSelUtil.loadWithBy(oJsOR_Reg.getString("SrhBy_Kanri"));
	 SrhBy_suplyCode = oSelUtil.loadWithBy(oJsOR_Reg.getString("SrhBy_suplyCode"));
	 SrhBy_PO = oSelUtil.loadWithBy(oJsOR_Reg.getString("SrhBy_PO"));
	 SEARCH = oSelUtil.loadWithBy(oJsOR_Reg.getString("SEARCH"));
	 
	 Usr_Pro = oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr_Pro"));
	 Swt_Admn = oSelUtil.loadWithBy(oJsOR_Reg.getString("Swt_Admn"));
	 Over_seas = oSelUtil.loadWithBy(oJsOR_Reg.getString("Over_seas"));
	 New = oSelUtil.loadWithBy(oJsOR_Reg.getString("New"));
	 PO_Sent = oSelUtil.loadWithBy(oJsOR_Reg.getString("PO_Sent"));
	 Part_Arrived = oSelUtil.loadWithBy(oJsOR_Reg.getString("Part_Arrived"));
	 Dashboard = oSelUtil.loadWithBy(oJsOR_Reg.getString("Dashboard"));
	 Domestic = oSelUtil.loadWithBy(oJsOR_Reg.getString("Domestic"));
	 
	}
	
	public boolean RegPja_flow() throws Exception
	{ boolean regPJ=false;
	  try
	  {
		oSelUtil.ufClick(driver, New_Register);
		oSelUtil.ufClear(driver, fname);
		oSelUtil.ufSendKeys(driver, fname, oJsTD_Reg.getString("f_name"));
		oSelUtil.ufClear(driver, lname);
		oSelUtil.ufSendKeys(driver, lname, oJsTD_Reg.getString("l_name"));
		oSelUtil.ufClear(driver, contact);
		oSelUtil.ufSendKeys(driver, contact, oJsTD_Reg.getString("contact"));
		oSelUtil.ufClear(driver, email);
		oSelUtil.ufSendKeys(driver, email, oJsTD_Reg.getString("email"));
		/*Select rv = new Select();
		rv.deselectByVisibleText("");
		*/
		oSelUtil.ufClick(driver, Rgstr);
		oSelUtil.ufGetTextValidation(driver, Usr_Scr, oJsDataVal.getString("Register_success"));
		oSelUtil.ufIsDisplayed(driver, search_Scr);
		oSelUtil.ufIsDisplayed(driver, Overseas);
		oSelUtil.ufIsDisplayed(driver, domestic);
	  }
	  catch(Exception ea)
	  {
		  log.info("Error in the PJA user Register"+ea);
		  regPJ=false;
	  }
	return regPJ;
		
	}
	
	public boolean Swtch2Admn() throws Exception
	{
		boolean swtch_admin=false;
		try
		{
			oSelUtil.ufClick(driver, Usr_Pro);
			oSelUtil.ufClick(driver, Swt_Admn);
			oSelUtil.ufIsDisplayed(driver, New);
			oSelUtil.ufIsDisplayed(driver, Over_seas);
			oSelUtil.ufIsDisplayed(driver, PO_Sent);
			oSelUtil.ufIsDisplayed(driver, Part_Arrived);
			oSelUtil.ufIsDisplayed(driver, Dashboard);
			oSelUtil.ufIsDisplayed(driver, Domestic);
			
			
		}
		catch(Exception ex)
		{
			log.info("Error in the switch to admin role"+ex);
			swtch_admin=false;
		}
		return swtch_admin;
	}

}
