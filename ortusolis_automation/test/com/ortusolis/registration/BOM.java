package com.ortusolis.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ortusolis.pageobjectsPO.BOMPO;
import com.ortusolis.utilities.TestBase;

public class BOM  extends TestBase
{
	
	final Logger log =LoggerFactory.getLogger(getClass().getName()) ;
    BOMPO bp = new BOMPO();
    String sTestCaseName_1="User Registration failure test case";
    String sTestCaseName_2="User Login failure test case";
    String sTestCaseName_3="Admin Login failure test case";
    String sTestCaseName_4="Approving User by Admin failure test case";
    String sTestCaseName_5="User fails to login test case";
    String sTestCaseName_6="User Registration by Admin failure test case";
    String sTestCaseName_7="Update User Role by Admin failure test case";
    String sTestCaseName_8="";
    @Test(priority=1)
    public void BOM_RGSTR() throws Exception
    {
    	log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		bp.BOMusrLocators();	
		bp.RgstrBOMUsr();
    }
    @Test(priority=2)
    public void BOM_USR_LOG() throws Exception
    {
    	log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		bp.BOMusrLocators();	
		bp.BOMlogin();
    }	
    @Test(priority=3)
    public void BOM_AD_LOG() throws Exception
    {
    	log.info(oJsConfig.getString("IPT_Login_URL"));
		driver.get(oJsConfig.getString("IPT_Login_URL"));
		bp.BOMusrLocators();	
		bp.BOMADMINlogin();
		 bp.AdminAproveUser();
    
    }
}
	 /*   bp.RgstrBOMUsr();
	    sa.assertEquals(true, bUserRegistration, "sTestCaseName_1");
	    bp.BOMlogin();
	    boolean bUserLogin =
	    		bp.BOMlogin();
	    sa.assertEquals(true, bUserLogin, sTestCaseName_2);
	    bp.BOMADMINlogin();
	    
	    boolean bAdminLogin=bp.BOMADMINlogin();
	    sa.assertEquals(true, bAdminLogin, sTestCaseName_3);
	    bp.AdminAproveUser();
	    boolean bAdminApprove =bp.AdminAproveUser();
	    sa.assertEquals(true, bAdminApprove, sTestCaseName_4);
	    bp.BOMlogin();
	    boolean bUserlogin2=bp.BOMlogin();
	    sa.assertEquals(true, bUserlogin2, sTestCaseName_5);
	    bp.UserRgstrByAdmn();
	    boolean bRegistrationByAdmin =bp.UserRgstrByAdmn();
	    sa.assertEquals(true, bRegistrationByAdmin, sTestCaseName_6);
	    bp.UpdateRoleByAdmin();
	    boolean bUpdateRole =bp.UpdateRoleByAdmin();
	    sa.assertEquals(true, bUpdateRole, sTestCaseName_7);
	    sa.assertAll();
    }
   @Test
    public void VerifyChangeShikeisho() throws Exception
    {
    	bp.BOMusrLocators();
    	bp.BOMlogin();
    	bp.SearchShikeisho();
    	bp.VerifyChangedVAlues();
    	bp.ChangesApproving();
    	bp.BOMlogout();
    }
    @Test
    public void AssignUserUpdtToEpics() throws Exception
    {
    	bp.BOMusrLocators();
    	bp.BOMlogin();
    	bp.SearchShikeisho();
    	bp.AssignBOMUserforLMAprvShi();
    	bp.BOMlogout();
    	
    }
    @Test
    public void ApproveByBOM() throws Exception
    {
    	login as RD user approve 
    	login as LM user approve
    	bp.BOMlogin();
    	bp.AfterRDLMviewConfirmQuantityByBOM();
    	bp.BOMlogout();
    }*/
    

