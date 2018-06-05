package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class SMSearchPO extends TestBase {

final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	
	By SearchByDropDown, SearchByText, SearchByShikeisho,SearchByEO,SearchByKanri,
	SearchByPart,SearchBySupplier,SearchByPO,SearchButton,SearchInOverSeas,
	SearchInNewOverSeas,SearchInPOSentOS,SearchInPartArrivedOS,SearchInDomestic,
	SearchInNewDom, SearchInPOSentDom,SearchInPartArriveDom,SMTeamDropdown,SearchResultCount;
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	
	
	public void loadRegistrationPageLocators() throws Exception {
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_SMSearchScreen.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_SMScreens.json");
		loadingPageObjects(oJsOR_Reg);
	}
	private void loadingPageObjects(JSONObject oJsOR_Reg) throws Exception {
		SearchByDropDown =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchByDropDown"));
		SearchByText =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchByText"));
		SearchByShikeisho =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchByShikeisho"));
		SearchByEO =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchByEO"));
		SearchByPart =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchByPart"));
		SearchByKanri =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchByKanri"));
		SearchBySupplier =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBySupplier"));
		SearchByPO =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchByPO"));
		SearchInOverSeas =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchInOverSeas"));
		SearchButton =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchButton"));
		SearchInNewOverSeas =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchInNewOverSeas"));
		SearchInPOSentOS =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchInPOSentOS"));
		SearchInPartArrivedOS =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchInPartArrivedOS"));
		SearchInDomestic =  oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchInDomestic"));
		SearchInNewDom =oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchInNewDom"));
		SearchInPOSentDom =oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchInPOSentDom"));
		SearchInPartArriveDom= oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchInPartArriveDom"));
		SMTeamDropdown= oSelUtil.loadWithBy(oJsOR_Reg.getString("SMTeamDropdown"));
		SearchResultCount= oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchResultCount"));
		
}
	
	public boolean search_ShikeishoDetails() throws Exception{
		boolean bRes_flag=false;
		try {
		oSelUtil.ufClear(driver, SearchByText);
		System.out.println("Before click on the dropdown");
		oSelUtil.ufClick(driver, SearchByDropDown);
		System.out.println("After click on to the dropdown");
		
		oSelUtil.ufClick(driver,SearchByEO);
		oSelUtil.ufSendKeys(driver, SearchByText, oJsTD_Reg.getString("SearchBy_Value"));
		oSelUtil.ufClick(driver, SearchButton);
		if(oSelUtil.ufIsDisplayed(driver, SearchResultCount)) 
		{
			oSelUtil.ufClick(driver, SearchByShikeisho);

			//oSelUtil.ufClick(driver,);
			//oSelUtil.ufClick(driver, funding_close);
		}
		
		
		
	/*	if(oSelUtil.ufIsSelected(driver, SearchBy_EO)) {
			System.out.println("Inside the if");
			oSelUtil.ufSendKeys(driver, SearchBy_Text, oJsTD_Reg.getString("shno1"));
			oSelUtil.ufClick(driver, SearchButton);
			oSelUtil.ufIsDisplayed(driver, New_Shikeisho);
		}*/
	/*if(oSelect.getFirstSelectedOption().getText().equalsIgnoreCase("SearchBy_Shikeisho") ) {
			oSelUtil.ufSendKeys(driver, SearchBy_Text, oJsTD_Reg.getString("TP1234"));
			oSelUtil.ufClick(driver, SearchButton);
			oSelUtil.ufIsDisplayed(driver, New_Shikeisho);
		}*/
		/*else if(oSelect.equals("SearchBy_kanri")) 
		{
			oSelUtil.ufSendKeys(driver, SearchBy_Text, "12345");
			oSelUtil.ufClick(driver, SearchButton);
			oSelUtil.ufIsDisplayed(driver, New_Shikeisho);
		}
		else if(oSelect.equals("SearchBy_EO"))
		{
			oSelUtil.ufSendKeys(driver, SearchBy_Text, "12345");
			oSelUtil.ufClick(driver, SearchButton);
			oSelUtil.ufIsDisplayed(driver, New_Shikeisho);
		}
		*/
		
		}catch(Exception ea) {
			log.info("Exception in login_flow : "+ea);
			bRes_flag=false;
		}
		return bRes_flag;
		
	}

	
}
