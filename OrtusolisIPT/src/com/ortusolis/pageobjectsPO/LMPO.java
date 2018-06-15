package com.ortusolis.pageobjectsPO;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class LMPO extends TestBase 
{
	By New_Rgstr, fname, lname, email, Daimlr, role, Rgstr_Usr,
	 Usr, Pwd, signup, signout, Usr_pro, swtcadmn, Pndg, ClkUsr,
	 Aprv,  Reject,  Add_New_User,  UpdateROle,  updt_btn, d_idFld,
	 Get_dtl, rol_rol, sbmt, SearchBy, Shi_, EO, Knri_, PrtNo,
	 SrhFld, Srh_Clk, New_Shi, Chng_Shi, Pro_Shi, PrtRcvd, Value,
	  LOc, DlvrDt, Quant, Digit, Sv_Updt_Btn, Updated_Msg,
	 fundLink, fundClose;
	
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();
	
	public void  LMPageLocators() throws Exception
	{
		log.info("login as LM user");
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_LM.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_LM.json");
	    oJsDataVal = oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir")+"/src/dataValidation/dataValidationShiAprvPdnLM.json");
	    
	    Loadlmpagelocators(oJsOR_Reg);
	}

	private void Loadlmpagelocators(JSONObject oJsOR_Reg2)
	{
		New_Rgstr =oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Rgstr"));
		fname =oSelUtil.loadWithBy(oJsOR_Reg.getString("fname"));
		lname =oSelUtil.loadWithBy(oJsOR_Reg.getString("lname"));
		email =oSelUtil.loadWithBy(oJsOR_Reg.getString("email"));
		Daimlr =oSelUtil.loadWithBy(oJsOR_Reg.getString("Daimlr"));
		role =oSelUtil.loadWithBy(oJsOR_Reg.getString("role"));
		Rgstr_Usr =oSelUtil.loadWithBy(oJsOR_Reg.getString("Rgstr_Usr"));
		Usr =oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr"));
		Pwd =oSelUtil.loadWithBy(oJsOR_Reg.getString("Pwd"));
		signup =oSelUtil.loadWithBy(oJsOR_Reg.getString("signup"));
		Usr_pro =oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr_pro"));
		swtcadmn =oSelUtil.loadWithBy(oJsOR_Reg.getString("swtcadmn"));
		Pndg = oSelUtil.loadWithBy(oJsOR_Reg.getString("Pndg"));
		ClkUsr =oSelUtil.loadWithBy(oJsOR_Reg.getString("ClkUsr"));
	    Aprv =oSelUtil.loadWithBy(oJsOR_Reg.getString("Aprv"));
	    signout = oSelUtil.loadWithBy(oJsOR_Reg.getString("signout"));
	    Reject = oSelUtil.loadWithBy(oJsOR_Reg.getString("Reject"));
	    Add_New_User =oSelUtil.loadWithBy(oJsOR_Reg.getString("Add_New_User"));
	    UpdateROle = oSelUtil.loadWithBy(oJsOR_Reg.getString("UpdateROle"));
	    updt_btn = oSelUtil.loadWithBy(oJsOR_Reg.getString("updt_btn"));
	    d_idFld = oSelUtil.loadWithBy(oJsOR_Reg.getString("d_idFld"));
	    Get_dtl = oSelUtil.loadWithBy(oJsOR_Reg.getString(" Get_dtl"));
	    rol_rol = oSelUtil.loadWithBy(oJsOR_Reg.getString("rol_rol"));
	    sbmt = oSelUtil.loadWithBy(oJsOR_Reg.getString("sbmt"));
	    SearchBy = oSelUtil.loadWithBy(oJsOR_Reg.getString("SearchBy"));
	    Shi_ = oSelUtil.loadWithBy(oJsOR_Reg.getString("Shi_"));
	    EO = oSelUtil.loadWithBy(oJsOR_Reg.getString("EO"));
	    Knri_ = oSelUtil.loadWithBy(oJsOR_Reg.getString("Knri_"));
	    PrtNo = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtNo"));
	    SrhFld = oSelUtil.loadWithBy(oJsOR_Reg.getString("SrhFld"));
	    Srh_Clk = oSelUtil.loadWithBy(oJsOR_Reg.getString("Srh_Clk"));
	    New_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Shi"));
	    Chng_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("Chng_Shi"));
	    Pro_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtRcvd"));
	    PrtRcvd = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtRcvd"));
	    Pro_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtRcvd"));
	    Pro_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtRcvd"));
	    Pro_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtRcvd"));
	    Pro_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtRcvd"));
	    Pro_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtRcvd"));
	    Pro_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtRcvd"));
	    Pro_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtRcvd"));
	    Pro_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtRcvd"));
	    Pro_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtRcvd"));
	    Pro_Shi = oSelUtil.loadWithBy(oJsOR_Reg.getString("PrtRcvd"));
	}  
	 


}
