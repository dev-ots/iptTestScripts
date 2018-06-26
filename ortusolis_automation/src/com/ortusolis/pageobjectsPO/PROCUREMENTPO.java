package com.ortusolis.pageobjectsPO;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class PROCUREMENTPO extends TestBase
{
	By  SEARCH_BY,SHIKEISHO_NUM,PART_NUM,KANRI_NUM,EO_NUM,SEARCH_FIELD,SEARCH_BUTTON,NEW_SHIKEISHO,CHANGED_SHIKEISHO,SHIKEISHO_ID,URL,PART_CLASSIFICATION,SAVE_URL;
	
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	public void BOMusrLocators() throws Exception
	{
		
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_PROC.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_PROC.json");
		oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/dataValidationPROC.json");
	    
		ProcPageObjects(oJsOR_Reg);
	}
	private void ProcPageObjects(JSONObject oJsOR_Reg)
	{
		URL = oSelUtil.loadWithBy(oJsOR_Reg.getString("URL"));
		PART_CLASSIFICATION = oSelUtil.loadWithBy(oJsOR_Reg.getString("PART_CLASSIFICATION"));
		SAVE_URL=oSelUtil.loadWithBy(oJsOR_Reg.getString("SAVE_URL"));
		 SEARCH_BY = oSelUtil.loadWithBy(oJsOR_Reg.getString("SEARCH_BY"));
		    SHIKEISHO_NUM = oSelUtil.loadWithBy(oJsOR_Reg.getString("SHIKEISHO_NUM"));
		    PART_NUM = oSelUtil.loadWithBy(oJsOR_Reg.getString("PART_NUM"));
		    KANRI_NUM = oSelUtil.loadWithBy(oJsOR_Reg.getString("KANRI_NUM"));
		    EO_NUM = oSelUtil.loadWithBy(oJsOR_Reg.getString("EO_NUM"));
		    SEARCH_FIELD = oSelUtil.loadWithBy(oJsOR_Reg.getString("SEARCH_FIELD"));
		    SEARCH_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("SEARCH_BUTTON"));
		    NEW_SHIKEISHO = oSelUtil.loadWithBy(oJsOR_Reg.getString("NEW_SHIKEISHO"));
		    CHANGED_SHIKEISHO = oSelUtil.loadWithBy(oJsOR_Reg.getString("CHANGED_SHIKEISHO"));
		    SHIKEISHO_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("SHIKEISHO_ID"));
		   
	}
	
	public boolean SearchShikeisho() throws Exception
	{
		boolean srh_shi=false;
		try
		{
			oSelUtil.ufClick(driver, SEARCH_BY);
			oSelUtil.ufClick(driver, SHIKEISHO_NUM);
			oSelUtil.ufSendKeys(driver, SEARCH_FIELD, oJsTD_Reg.getString("SHIKEISHO ID"));
			oSelUtil.ufClick(driver, NEW_SHIKEISHO);
			List<WebElement> allusers =oSelUtil.ufGetWebElements(driver, SHIKEISHO_ID);
			int count= allusers.size();
			int iContainText = oSelUtil.getIndexOfMatchingTextWebElements(allusers,oJsTD_Reg.getString("SHIKEISHO_ID"));
			allusers.get(iContainText).click();
			
		}
		catch(Exception ss)
		{
			log.info("Fails to search the shikeisho by Procurement team"+ss.getMessage());
			srh_shi=false;
		}
		return srh_shi;
	}

	public boolean CheckForDrawingURL() throws Exception
	{
		boolean check_url=false;
		try
		{
				oSelUtil.ufIsDisplayed(driver, URL);
			oSelUtil.ufIsDisplayed(driver, PART_CLASSIFICATION);
			oSelUtil.ufClick(driver, SAVE_URL);
			
		}
		catch(Exception cu)
		{
			log.info("Drawing URL and Part classification are not displaying"+cu.getMessage());
			check_url=false;
		}
		return check_url;
	}
}