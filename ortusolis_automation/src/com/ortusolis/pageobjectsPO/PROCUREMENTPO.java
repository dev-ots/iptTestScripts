package com.ortusolis.pageobjectsPO;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class PROCUREMENTPO extends TestBase
{
	By SEARCH_BY,SHIKEISHO_NUM,PART_NUM,KANRI_NUM,EO_NUM,SEARCH_FIELD,SEARCH_BUTTON,NEW_SHIKEISHO,CHANGED_SHIKEISHO,SHIKEISHO_ID,URL,
	PART_CLASSIFICATION,SAVE_URL,SUPPLIER_SEARCH_FIELD,ALL_SUPPLIERS,SUPPLIER_DONE,SAVE_SELECTED_SUPPLIERS,RFQ_SECTION,
	SEND_RFQ,SELECT_LANGUAGE,GET_RFQ_BUTTON,SUPPLIER_HEADINGS,LANGUAGE_CLASS,LANGUAGE_DONE,CANCEL_ORDER,COMMENTS_ON_CANCELORDER,
	CANCEL_ORDER_DONE,UNIT_PRICE,MOLD_COST,PREPARATION_COST,TRANSPORTATION_COST,NOTES,SAVE_UNIT_PRICE,PLACE_ORDER,CHECK_MARKS;
	
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
		    SUPPLIER_SEARCH_FIELD = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUPPLIER_SEARCH_FIELD"));
		    ALL_SUPPLIERS = oSelUtil.loadWithBy(oJsOR_Reg.getString("ALL_SUPPLIERS"));
		    SUPPLIER_DONE = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUPPLIER_DONE"));
		    SAVE_SELECTED_SUPPLIERS = oSelUtil.loadWithBy(oJsOR_Reg.getString("SAVE_SELECTED_SUPPLIERS"));
		    RFQ_SECTION = oSelUtil.loadWithBy(oJsOR_Reg.getString("RFQ_SECTION"));
		    SEND_RFQ = oSelUtil.loadWithBy(oJsOR_Reg.getString("SEND_RFQ"));
		    SELECT_LANGUAGE = oSelUtil.loadWithBy(oJsOR_Reg.getString("SELECT_LANGUAGE"));
		    GET_RFQ_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("GET_RFQ_BUTTON"));
		    SUPPLIER_HEADINGS = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUPPLIER_HEADINGS"));
		    LANGUAGE_CLASS = oSelUtil.loadWithBy(oJsOR_Reg.getString("LANGUAGE_CLASS"));
		    LANGUAGE_DONE = oSelUtil.loadWithBy(oJsOR_Reg.getString("SLANGUAGE_DONE"));
		    CANCEL_ORDER = oSelUtil.loadWithBy(oJsOR_Reg.getString("CANCEL_ORDER"));
		    COMMENTS_ON_CANCELORDER = oSelUtil.loadWithBy(oJsOR_Reg.getString("COMMENTS_ON_CANCELORDER"));
		    CANCEL_ORDER_DONE = oSelUtil.loadWithBy(oJsOR_Reg.getString("CANCEL_ORDER_DONE"));
		    UNIT_PRICE = oSelUtil.loadWithBy(oJsOR_Reg.getString("UNIT_PRICE"));
		    MOLD_COST = oSelUtil.loadWithBy(oJsOR_Reg.getString("MOLD_COST"));
		    PREPARATION_COST = oSelUtil.loadWithBy(oJsOR_Reg.getString("PREPARATION_COST"));
		    TRANSPORTATION_COST = oSelUtil.loadWithBy(oJsOR_Reg.getString("TRANSPORTATION_COST"));
		    NOTES = oSelUtil.loadWithBy(oJsOR_Reg.getString("NOTES"));
		    SAVE_UNIT_PRICE = oSelUtil.loadWithBy(oJsOR_Reg.getString("SAVE_UNIT_PRICE"));
		    PLACE_ORDER = oSelUtil.loadWithBy(oJsOR_Reg.getString("PLACE_ORDER"));
		    CHECK_MARKS = oSelUtil.loadWithBy(oJsOR_Reg.getString("CHECK_MARKS"));
		    SUPPLIER_SEARCH_FIELD = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUPPLIER_SEARCH_FIELD"));
		    SUPPLIER_SEARCH_FIELD = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUPPLIER_SEARCH_FIELD"));
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
	/*public boolean SelectsupplierGroupWithCode() throws Exception
	{
		boolean select_supplier=false;
		try
		{
			
				
			List<WebElement> allDropdowns = oSelUtil.ufGetWebElements(driver, ALLDROPDOWNS);
			int count=allDropdowns.size();
			for(int i=0;i<allDropdowns.size();i++)
			{
			
			if(i==0)
			{	
			 allDropdowns.get(i).click();
			 {
				 List<WebElement> allCheckboxes= oSelUtil.ufGetWebElements(driver, ALLCHECKBOXES);
				 int count2=allCheckboxes.size();
				 log.info("number of checkboxes are"+count2);
				 for(int j=0;j<allCheckboxes.size();j++)
				 {
				
					 allCheckboxes.get(i).click();
				 }
			 }
			}
			else if(i==1)
			{
				allDropdowns.get(i).click();
				 {
					 List<WebElement> allCheckboxes= oSelUtil.ufGetWebElements(driver, ALLCHECKBOXES);
					 int count2=allCheckboxes.size();
					 log.info("number of checkboxes are"+count2);
					 for(int j=0;j<allCheckboxes.size();j++)
					 {
						 for(int k=2;k>=j;k++)
						 allCheckboxes.get(j).click();
					 }
				 }
		
			}
			else if(i==2)
			{
				allDropdowns.get(i).click();
				 {
					 List<WebElement> allCheckboxes= oSelUtil.ufGetWebElements(driver, ALLCHECKBOXES);
					 int count2=allCheckboxes.size();
					 log.info("number of checkboxes are"+count2);
					 for(int j=0;j<allCheckboxes.size();j++)
					 {
						 for(int k=2;k>=j;j++)
						 allCheckboxes.get(j).click();
					 }
				 }

				
			}
				
			}
			oSelUtil.ufClick(driver, SAVE_BUTTON);
		//Select based on supplier code to send RFQ.
			List<WebElement> allRadios= oSelUtil.ufGetWebElements(driver, ALLRADIO_BUTTON);
			log.info("Number of supplier group code are"+allRadios.size());
			for(int i=0;i<allRadios.size();i++)
			{
				if(i==0)
				{		
					boolean bvalue;
					bvalue=allRadios.get(i).isSelected();
				
					if(bvalue=false)
					{
						allRadios.get(i).click();
					}
				}
			}
		
		}
		catch(Exception sg)
		{
			log.info("Fails in selecting the supplier for each part and grouping them"+sg.getMessage());
			select_supplier=false;
		}
		return select_supplier;
	}*/
	
	public boolean SelectSupplier() throws Exception
	{
		boolean select_supplier=false;
		try
		{
			List<WebElement> SupplierSearchFields =oSelUtil.ufGetWebElements(driver, SUPPLIER_SEARCH_FIELD);
			log.info("Number of supplier fields are"+SupplierSearchFields.size());
			for(int i=0;i<SupplierSearchFields.size();i++)
			{
				List<WebElement> SelectSuppliers =oSelUtil.ufGetWebElements(driver, ALL_SUPPLIERS);
				for(int j=0;j<SelectSuppliers.size();j++)
				{
					if(i==0)
					{
						SelectSuppliers.get(1).click();
						SelectSuppliers.get(2).click();
						SelectSuppliers.get(3).click();
					}
					else if(i==1)
					{
						SelectSuppliers.get(4).click();
						SelectSuppliers.get(5).click();
						SelectSuppliers.get(6).click();
						
					}
					else if(i==2)
					{
						SelectSuppliers.get(7).click();
						SelectSuppliers.get(8).click();
						SelectSuppliers.get(9).click();
					
					}
				}
				oSelUtil.ufClick(driver, SUPPLIER_DONE);
				
			}
			oSelUtil.ufClick(driver, SAVE_SELECTED_SUPPLIERS);
				
		}
		catch(Exception ss)
		{
			log.info("Fails to select supplier"+ss.getMessage());
		}
		return select_supplier;
	}
	public boolean RFQ() throws Exception
	{
		boolean rfq_basedon_group=false;
		try
		{
			oSelUtil.ufClick(driver, RFQ_SECTION);
			oSelUtil.ufClick(driver, GET_RFQ_BUTTON);
			List<WebElement> SupplierHeadingToShow=oSelUtil.ufGetWebElements(driver, SUPPLIER_HEADINGS);
			int count1=SupplierHeadingToShow.size();
			log.info("Number supplier based on group is"+count1);
			for(int i=0;i<SupplierHeadingToShow.size();i++)
			{
				String supplierNames= SupplierHeadingToShow.get(i).getText();
				log.info("supplier names are"+supplierNames);
				
				List<WebElement> AllCheckmark =oSelUtil.ufGetWebElements(driver, CHECK_MARKS);
				for(int k=0;k<AllCheckmark.size();k++)
				{
					if(i==0)
					{
						boolean bvalue;
				        bvalue=AllCheckmark.get(k).isSelected();
				        if(bvalue=false)
				        {
				        	AllCheckmark.get(k).click();
				        }
					}
				}
				
			   /*ArrayList AlSuppliers= new ArrayList();
			   AlSuppliers.add(SupplierHeadingToShow.get(i).getText());
			   return supplierNames;*/
				
			}
			
		}
		catch(Exception rbg)
		{
			log.info("Fails to send"+rbg.getMessage());
			rfq_basedon_group=false;
		}
		return rfq_basedon_group;
	}
	public boolean selectlanguage() throws Exception
	{
		boolean select_language=false;
		try
		{
			oSelUtil.ufClick(driver, SEND_RFQ);
			Thread.sleep(2000);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, SELECT_LANGUAGE);
            List<WebElement>Language = oSelUtil.ufGetWebElements(driver,LANGUAGE_CLASS);
            for(int i=0;i<Language.size();i++)
            {
            	if(Language.get(0).getText().contains(oJsTD_Reg.getString("ENG")))
            	{
            		Language.get(i).click();
            	}
            	/*if(lanText.contains(oJsTD_Reg.getString("ENG")))
            	{
            		Language.get(i).click();
            	}
            	else
            	{
            		
            	}*/
            	
            }
            oSelUtil.ufClick(driver, LANGUAGE_DONE);
		}
		catch(Exception sl)
		{
			log.info("fails to select language"+sl.getMessage());
			select_language=false;
		}
		return select_language;
	}
	public boolean CancelOrder() throws Exception
	{
		boolean cancel_order=false;
		try
		{
			oSelUtil.ufClick(driver, CANCEL_ORDER);
			Thread.sleep(2000);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufSendKeys(driver, COMMENTS_ON_CANCELORDER, oJsTD_Reg.getString("CANCELORDER"));
			oSelUtil.ufClick(driver, CANCEL_ORDER_DONE);
			
		}
		catch(Exception co)
		{
			log.info("Fails to cancel the order"+co.getMessage());
			 cancel_order=false;
		}
		return cancel_order;
	}
	public boolean Search_Shikeisho() throws Exception
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
			log.info("Fails in searching shikeisho"+ss.getMessage());
			srh_shi=false;
		}
		return srh_shi;
	}
	public boolean UnitPrice_Cost() throws Exception
	{
		boolean unit_price=false;
		try
		{
			oSelUtil.ufSendKeys(driver, UNIT_PRICE, oJsTD_Reg.getString("UNIT_PRICE"));
			oSelUtil.ufSendKeys(driver, MOLD_COST, oJsTD_Reg.getString("MOLD_COST"));
			oSelUtil.ufSendKeys(driver, PREPARATION_COST, oJsTD_Reg.getString("PREPARATION_COST"));
			oSelUtil.ufSendKeys(driver, TRANSPORTATION_COST, oJsTD_Reg.getString("TRANSPORTATION_COST"));
			oSelUtil.ufSendKeys(driver, NOTES, oJsTD_Reg.getString("NOTES"));
			oSelUtil.ufClick(driver, SAVE_UNIT_PRICE);
			
		}
		catch(Exception up)
		{
			log.info("Fails to enter and save Unit price"+up.getMessage());
			unit_price=false;
		}
		return unit_price;
	}
	public boolean PlaceOrderByBOM() throws Exception
	{
		boolean place_order=false;
		try
		{
			oSelUtil.ufClick(driver, PLACE_ORDER);
		}
		catch(Exception po)
		{
			log.info("Fails to place order by BOM"+po.getMessage());
			place_order=false;
		}
		return place_order;
	}
		
			
}