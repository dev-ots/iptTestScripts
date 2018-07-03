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
	By SEARCH_BY,SHIKEISHO_NUM,PART_NUM,KANRI_NUM,EO_NUM,SEARCH_FIELD,SEARCH_BUTTON,NEW_SHIKEISHO,CHANGED_SHIKEISHO,SHIKEISHO_ID,URL,
	PART_CLASSIFICATION,SAVE_URL,ALLSUPPLIERS,SUPPLIER_NAMES,SUPPLIER_SRH_FLD,SUPPLIER_DONE,SAVE_SUPPLIERS;
	
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
		   ALLSUPPLIERS =oSelUtil.loadWithBy(oJsOR_Reg.getString("ALLSUPPLIERS"));
		   SUPPLIER_NAMES =oSelUtil.loadWithBy(oJsOR_Reg.getString("SUPPLIER_NAMES"));
		   SUPPLIER_SRH_FLD = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUPPLIER_SRH_FLD"));
		   SUPPLIER_DONE = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUPPLIER_DONE"));
		   SAVE_SUPPLIERS = oSelUtil.loadWithBy(oJsOR_Reg.getString("SAVE_SUPPLIERS"));
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
				else
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
			List<WebElement> allsuppliers=oSelUtil.ufGetWebElements(driver, ALLSUPPLIERS);
			log.info("number of supplier fields are"+allsuppliers.size());
			for(int i=0;i<allsuppliers.size();i++)
			{
				allsuppliers.get(i).click();
				List<WebElement> supplier = oSelUtil.ufGetWebElements(driver, SUPPLIER_NAMES);
				for(int j=0;j<supplier.size();j++)
				{
					if(i==0)
					{
						supplier.get(2).click();
						supplier.get(3).click();
						supplier.get(4).click();
					}
					else if(i==1)
					{
						supplier.get(5).click();
						supplier.get(6).click();
						supplier.get(7).click();
			
					}
					else if(i==2)
					{
						supplier.get(8).click();
						supplier.get(9).click();
						supplier.get(10).click();
				}
					oSelUtil.ufClick(driver, SUPPLIER_DONE);
				}
				
			}
			oSelUtil.ufClick(driver, SAVE_SUPPLIERS);
			
		}
		catch(Exception se)
		{
			log.info("Fail to select the supplier"+se);
			select_supplier=false;
		}
		return select_supplier;
		
	}
	
	public boolean SendRfq() throws Exception
	{
		boolean send_rfq=false;
		try
		{
			
		}
		catch(Exception sr)
		{
			log.info("Fails to send an RFQ"+sr.getMessage());
			send_rfq=false;
		}
		return send_rfq;
		
	}
	public boolean CancelOrder() throws Exception
	{
		boolean cancel_rfq=false;
		try
		{
			
		}
		catch(Exception cr)
		{
			
		}
		return cancel_rfq;
	}
			
}