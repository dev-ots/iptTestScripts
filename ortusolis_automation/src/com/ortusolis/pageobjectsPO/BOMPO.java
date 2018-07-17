package com.ortusolis.pageobjectsPO;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import com.ortusolis.utilities.Constants;
import com.ortusolis.utilities.TestBase;

public class BOMPO extends TestBase {
	By NEW_REGISER, fname, lname, email, Daimlr, role, Rgstr_Usr, Usr, Pwd, signup, Usr_pro, swtcadmn, Pndg, ClkUsr,
			ADMIN2TEAM, ADMIN_LOGOUT, SEARCH_BY, SHIKEISHO_NUM, PART_NUM, KANRI_NUM, EO_NUM, SEARCH_FIELD,
			SEARCH_BUTTON, NEW_SHIKEISHO, CHANGED_SHIKEISHO, SHIKEISHO_ID, PART_ID, KANRI_ID, EO_ID, APPROVE, REJECT,
			FUNDING_LINK, FUNDING_CLOSE, ADD_NEW_USER, CONTACT_NUMBER, DAIMLER_DAIMLER, NEW_USER_BUTTON, USER_NAME,
			DEPARTMENT, ROLE_ROLE, SUBMIT_AND_ADDUSER, UPDATE_USER_ROLE_SECTION, UPDATE_BUTTON, DAIMLER_SEARCH_FIELD,
			GET_DETAILS, SELECT_ROLE, UPDATE_ROLE_BUTTON, Admn_Pro, PART_RECIEVED, IN_PROGRESS, QUANTITIES, VERIFY,
			SAVE_BUTTON, ASSIGN_BOM, SAVE_BOMUSER, ASSIGN_BUYERGROUP, PL_PART, APPROVE_BYBOM, LOGOUT, USER_ID_POPUP,
			POP_UP_CLOSE, BOM_DLIVERY_DATE, PART_DETAILS, SELECT_BUYER_GROUP, VERIFY_YES_BUTTON;

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	// public static JSONObject oJsDataVal = new JSONObject();

	public void BOMusrLocators() throws Exception {

		oJsOR_Reg = oComUtil
				.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/objectRepo/locators_BOM.json");

		oJsTD_Reg = oComUtil
				.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_BOM.json");
		// oJsDataVal =oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir")
		// +"/src/TestData/dataValidationBOM.json");

		BOMloginpageobjects(oJsOR_Reg);
	}

	private void BOMloginpageobjects(JSONObject oJsOR_Reg) {
		NEW_REGISER = oSelUtil.loadWithBy(oJsOR_Reg.getString("NEW_REGISER"));
		fname = oSelUtil.loadWithBy(oJsOR_Reg.getString("fname"));
		lname = oSelUtil.loadWithBy(oJsOR_Reg.getString("lname"));
		email = oSelUtil.loadWithBy(oJsOR_Reg.getString("email"));
		Daimlr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Daimlr"));
		role = oSelUtil.loadWithBy(oJsOR_Reg.getString("role"));
		Rgstr_Usr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Rgstr_Usr"));
		Usr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr"));
		Pwd = oSelUtil.loadWithBy(oJsOR_Reg.getString("Pwd"));
		signup = oSelUtil.loadWithBy(oJsOR_Reg.getString("signup"));
		Usr_pro = oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr_pro"));
		swtcadmn = oSelUtil.loadWithBy(oJsOR_Reg.getString("swtcadmn"));
		Pndg = oSelUtil.loadWithBy(oJsOR_Reg.getString("Pndg"));
		ClkUsr = oSelUtil.loadWithBy(oJsOR_Reg.getString("ClkUsr"));
		ADMIN_LOGOUT = oSelUtil.loadWithBy(oJsOR_Reg.getString("ADMIN_LOGOUT"));
		ADMIN2TEAM = oSelUtil.loadWithBy(oJsOR_Reg.getString("ADMIN2TEAM"));
		Admn_Pro = oSelUtil.loadWithBy(oJsOR_Reg.getString("Admn_Pro"));
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
		PART_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("PART_ID"));
		KANRI_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("KANRI_ID"));
		EO_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("EO_ID"));
		APPROVE = oSelUtil.loadWithBy(oJsOR_Reg.getString("APPROVE"));
		REJECT = oSelUtil.loadWithBy(oJsOR_Reg.getString("REJECT"));
		FUNDING_LINK = oSelUtil.loadWithBy(oJsOR_Reg.getString("FUNDING_LINK"));
		FUNDING_CLOSE = oSelUtil.loadWithBy(oJsOR_Reg.getString("FUNDING_CLOSE"));
		PART_RECIEVED = oSelUtil.loadWithBy(oJsOR_Reg.getString("PART_RECIEVED"));
		ADD_NEW_USER = oSelUtil.loadWithBy(oJsOR_Reg.getString("ADD_NEW_USER"));
		NEW_USER_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("NEW_USER_BUTTON"));
		USER_NAME = oSelUtil.loadWithBy(oJsOR_Reg.getString("USER_NAME"));
		CONTACT_NUMBER = oSelUtil.loadWithBy(oJsOR_Reg.getString("CONTACT_NUMBER"));
		DAIMLER_DAIMLER = oSelUtil.loadWithBy(oJsOR_Reg.getString("DAIMLER_DAIMLER"));
		DEPARTMENT = oSelUtil.loadWithBy(oJsOR_Reg.getString("DEPARTMENT"));
		ROLE_ROLE = oSelUtil.loadWithBy(oJsOR_Reg.getString("ROLE_ROLE"));
		SUBMIT_AND_ADDUSER = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUBMIT_AND_ADDUSER"));
		UPDATE_USER_ROLE_SECTION = oSelUtil.loadWithBy(oJsOR_Reg.getString("UPDATE_USER_ROLE_SECTION"));
		UPDATE_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("UPDATE_BUTTON"));
		USER_ID_POPUP = oSelUtil.loadWithBy(oJsOR_Reg.getString("USER_ID_POPUP"));
		POP_UP_CLOSE = oSelUtil.loadWithBy(oJsOR_Reg.getString("POP_UP_CLOSE"));
		ASSIGN_BUYERGROUP = oSelUtil.loadWithBy(oJsOR_Reg.getString("ASSIGN_BUYERGROUP"));
		QUANTITIES = oSelUtil.loadWithBy(oJsOR_Reg.getString("QUANTITIES"));
		DAIMLER_SEARCH_FIELD = oSelUtil.loadWithBy(oJsOR_Reg.getString("DAIMLER_SEARCH_FIELD"));
		GET_DETAILS = oSelUtil.loadWithBy(oJsOR_Reg.getString("GET_DETAILS"));
		SELECT_ROLE = oSelUtil.loadWithBy(oJsOR_Reg.getString("SELECT_ROLE"));
		VERIFY = oSelUtil.loadWithBy(oJsOR_Reg.getString("VERIFY"));
		// SAVE_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("SAVE_BUTTON"));
		ASSIGN_BOM = oSelUtil.loadWithBy(oJsOR_Reg.getString("ASSIGN_BOM"));
		SAVE_BOMUSER = oSelUtil.loadWithBy(oJsOR_Reg.getString("SAVE_BOMUSER"));
		// PL_PART = oSelUtil.loadWithBy(oJsOR_Reg.getString("PL_PART"));
		// APPROVE_BYBOM = oSelUtil.loadWithBy(oJsOR_Reg.getString("APPROVE_BYBOM"));
		LOGOUT = oSelUtil.loadWithBy(oJsOR_Reg.getString("LOGOUT"));
		IN_PROGRESS = oSelUtil.loadWithBy(oJsOR_Reg.getString("IN_PROGRESS"));
		UPDATE_ROLE_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("UPDATE_ROLE_BUTTON"));
		BOM_DLIVERY_DATE = oSelUtil.loadWithBy(oJsOR_Reg.getString("BOM_DLIVERY_DATE"));
		PART_DETAILS = oSelUtil.loadWithBy(oJsOR_Reg.getString("PART_DETAILS"));
		SELECT_BUYER_GROUP = oSelUtil.loadWithBy(oJsOR_Reg.getString("SELECT_BUYER_GROUP"));
		VERIFY_YES_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("VERIFY_YES_BUTTON"));
	}

	public boolean BOMlogin() throws Exception {
		boolean BOM_login = false;
		try {
			oSelUtil.ufClear(driver, Usr);
			oSelUtil.ufSendKeys(driver, Usr, Constants.sDaimlerIDForBOMFlow);
			// oSelUtil.ufSendKeys(driver, Usr, oJsTD_Reg.getString("UsrId"));
			oSelUtil.ufClear(driver, Pwd);
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("UsrPwd"));
			oSelUtil.ufClick(driver, signup);
			oSelUtil.AlertHandling(ngWebDriver, driver);
			oComUtil.getScreenShot();
		} catch (Exception ex) {
			log.info("Login error in BOM page" + ex.getMessage());
			BOM_login = false;
		}
		return BOM_login;

	}

	public boolean BOMlogin1() throws Exception {
		boolean BOM_login1 = false;
		try {
			oSelUtil.ufClear(driver, Usr);
			oSelUtil.ufSendKeys(driver, Usr, oJsTD_Reg.getString("UsrId1"));
			oSelUtil.ufClear(driver, Pwd);
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("UsrPwd1"));
			oSelUtil.ufClick(driver, signup);
			oSelUtil.AlertHandling(ngWebDriver, driver);
			oComUtil.getScreenShot();
		} catch (Exception ex) {
			log.info("Login error in BOM page" + ex.getMessage());
			BOM_login1 = false;
		}
		return BOM_login1;

	}

	public boolean BOMADMINlogin() throws Exception {
		boolean BOM_Adminlogin = false;
		try {
			oSelUtil.ufSendKeys(driver, Usr, oJsTD_Reg.getString("AdmnId"));
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("AdmnPwd"));
			oSelUtil.ufClick(driver, signup);
			oSelUtil.AlertHandling(ngWebDriver, driver);

			if (!oSelUtil.ufIsDisplayed(driver, Usr_pro))
				oSelUtil.AlertHandling(ngWebDriver, driver);
			oSelUtil.ufClick(driver, Usr_pro);
			oSelUtil.ufClick(driver, swtcadmn);
			ngWebDriver.waitForAngularRequestsToFinish();
			oComUtil.getScreenShot();

		} catch (Exception ex) {
			log.info("Login error in BOM page" + ex);
			BOM_Adminlogin = false;
		}
		return BOM_Adminlogin;

	}

	public boolean RgstrBOMUsr() throws Exception {
		boolean rgstrusr = false;
		try {
			oCons.sDaimlerIDForBOMFlow = oComUtil.generateUnixTimeStamp();
			oSelUtil.ufClick(driver, NEW_REGISER);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClear(driver, fname);
			oSelUtil.ufSendKeys(driver, fname, oJsTD_Reg.getString("f_name"));
			Thread.sleep(1000);
			oSelUtil.ufClear(driver, lname);
			oSelUtil.ufSendKeys(driver, lname, oJsTD_Reg.getString("l_name"));
			oSelUtil.ufClear(driver, email);
			oSelUtil.ufSendKeys(driver, email, oJsTD_Reg.getString("email"));
			oSelUtil.ufClear(driver, Daimlr);
			oSelUtil.ufSendKeys(driver, Daimlr, oCons.sDaimlerIDForBOMFlow);

			// oSelUtil.ufGetWebElement(driver, role);
			// oSelect = new Select(driver.findElement(Register_UserRole));
			// oSelect.selectByValue("R02");

			Select sc = new Select(driver.findElement(role));
			sc.selectByValue("R06");
			oSelUtil.ufClick(driver, Rgstr_Usr);
			Thread.sleep(2000);
			oSelUtil.AlertHandling(ngWebDriver, driver);
			SoftAssert sa = new SoftAssert();
			// sa.assertEquals(text, oJsDataVal.getString("USER_REGISTER"));
			// sa.assertAll();

			// Robot r= new Robot();
			// r.keyPress(KeyEvent.VK_ENTER);

			// oSelUtil.ufGetTextValidation(driver, Rgstr_Sucess,
			// oJsDataVal.getString("Rgstr_success"));
		} catch (Exception ea) {
			log.info("Error at registering as BOM user" + ea.getMessage());
			rgstrusr = false;
		}
		return rgstrusr;

	}

	public boolean AdminAproveUser() throws Exception {
		boolean adm_aprvUser = false;
		try {
			oSelUtil.ufClick(driver, Pndg);
			Thread.sleep(2000);
			List<WebElement> allusers = oSelUtil.ufGetWebElements(driver, ClkUsr);

			for (int i = 0; i < allusers.size(); i++) {
				allusers.get(i).click();
				if (oCons.sDaimlerIDForBOMFlow.equalsIgnoreCase(oSelUtil.ufGetText(driver, USER_ID_POPUP)))
					break;
				else
					oSelUtil.ufClick(driver, POP_UP_CLOSE);

				Thread.sleep(1000);
			}
			/*
			 * int count = allusers.size(); int iContainText =
			 * oSelUtil.getIndexOfMatchingTextWebElements(allusers,
			 * oCons.sDaimlerIdForBOMFlow); allusers.get(iContainText).click();
			 */
			oSelUtil.ufClick(driver, APPROVE);
			oComUtil.getScreenShot();
			oSelUtil.AlertHandling(ngWebDriver, driver);
			oComUtil.getScreenShot();

			// List<WebElement> allusers =oSelUtil.ufGetWebElements(driver, ClkUsr);
			// int count= allusers.size();
			/*
			 * for(int i=0;i<allusers.size();i++) { String USER =allusers.get(i).getText();
			 * if(USER.contains(oJsTD_Reg.getString("BOM_USER"))); oSelUtil.ufClick(driver,
			 * ClkUsr); }
			 */ // oSelUtil.ufClick(driver, APPROVE);
				// Thread.sleep(2000);
				// Alert alt = driver.switchTo().alert();
				// String USER_APPROVED=alt.getText();
				// alt.accept();
				// SoftAssert sa = new SoftAssert();
				// sa.assertEquals(USER_APPROVED, oJsTD_Reg.getString("USER_APPROVAL"));
				// sa.assertAll();
			/*
			 * adm_aprvUser = true; oSelUtil.ufClick(driver, Admn_Pro); Thread.sleep(2000);
			 * // oSelUtil.ufClick(driver, ADMIN2TEAM); // Thread.sleep(2000);
			 * oSelUtil.ufClick(driver, ADMIN_LOGOUT);
			 */
		} catch (Exception ep) {
			log.info("Unable to login by Admin" + ep.getMessage());
			adm_aprvUser = false;
		}
		return adm_aprvUser;
	}

	public boolean UserRgstrByAdmn() throws Exception {
		boolean UserByAdmn = false;
		try {
			oSelUtil.ufClick(driver, ADD_NEW_USER);
			oSelUtil.ufClick(driver, NEW_USER_BUTTON);
			oSelUtil.ufClear(driver, USER_NAME);
			oSelUtil.ufSendKeys(driver, USER_NAME, oJsTD_Reg.getString("USER_NAME"));
			oSelUtil.ufClear(driver, CONTACT_NUMBER);
			oSelUtil.ufSendKeys(driver, CONTACT_NUMBER, oJsTD_Reg.getString("CONTACT_NUMBER"));
			oSelUtil.ufClear(driver, DAIMLER_DAIMLER);
			oSelUtil.ufSendKeys(driver, DAIMLER_DAIMLER, oJsTD_Reg.getString("DAIMLER_DAIMLER"));
			oSelUtil.ufClear(driver, DEPARTMENT);
			oSelUtil.ufSendKeys(driver, DEPARTMENT, oJsTD_Reg.getString("DEPARTMENT"));
			Select slt = new Select(driver.findElement(ROLE_ROLE));
			slt.deselectByVisibleText(" User");
			oSelUtil.ufClick(driver, SUBMIT_AND_ADDUSER);

		} catch (Exception ua) {
			log.info("Error in registering the user by Admin" + ua.getMessage());
			UserByAdmn = false;
		}
		return UserByAdmn;
	}

	public boolean UpdateRoleByAdmin() throws Exception {
		boolean updt_role = false;
		try {
			oSelUtil.ufClick(driver, UPDATE_USER_ROLE_SECTION);
			oSelUtil.ufClick(driver, UPDATE_BUTTON);
			oSelUtil.ufSendKeys(driver, DAIMLER_SEARCH_FIELD, oJsTD_Reg.getString("DAIMLER_ID_CHANGE_ROLE"));
			oSelUtil.ufClick(driver, GET_DETAILS);
			Select se = new Select(driver.findElement(SELECT_ROLE));
			se.selectByVisibleText("");
			oSelUtil.ufClick(driver, UPDATE_ROLE_BUTTON);
			oSelUtil.AlertHandling(ngWebDriver, driver);
			// sa.assertEquals(actualText, oJsDataVal.getString("ROLE_CHANGEBYADMIN"));
			// sa.assertAll();

		} catch (Exception eu) {
			log.info("Fails to change user role by Admin" + eu);
			updt_role = false;
		}
		return updt_role;
	}

	public boolean SearchShikeisho() throws Exception {
		boolean srh_shi = false;
		try {
			/*
			 * oSelUtil.ufClick(driver, SEARCH_BY); oSelUtil.ufClick(driver, SHIKEISHO_NUM);
			 * oSelUtil.ufSendKeys(driver, SEARCH_FIELD,
			 * oJsTD_Reg.getString("SHIKEISHO ID"));
			 */
			oSelUtil.ufClick(driver, NEW_SHIKEISHO);
			ngWebDriver.waitForAngularRequestsToFinish();
			List<WebElement> allShikeisho = oSelUtil.ufGetWebElements(driver, SHIKEISHO_ID);
			int count = allShikeisho.size();
			log.info("Number of shikeisho are" + count);
			int iContainText = oSelUtil.getIndexOfMatchingTextWebElements(allShikeisho,
					oJsTD_Reg.getString("SHIKEISHO_ID"));
			allShikeisho.get(iContainText).click();
			ngWebDriver.waitForAngularRequestsToFinish();
			oComUtil.getScreenShot();
		} catch (Exception ss) {
			log.info("Fails in searching shikeisho" + ss.getMessage());
			srh_shi = false;
		}
		return srh_shi;
	}

	public boolean VerifyChangedVAlues() throws Exception {
		boolean verify_values = false;
		try {
			System.out.println("Verify the changes");
			oComUtil.getScreenShot();
			List<WebElement> allparts = oSelUtil.ufGetWebElements(driver, PART_DETAILS);
			List<WebElement> Parts_QUANTITIES = oSelUtil.ufGetWebElements(driver, QUANTITIES);
			List<WebElement> Parts_DELIVERY_DATE = oSelUtil.ufGetWebElements(driver, BOM_DLIVERY_DATE);
			List<WebElement> Parts_SELECT_BUYER_GROUP = oSelUtil.ufGetWebElements(driver, SELECT_BUYER_GROUP);
			int count2 = allparts.size();
			log.info("Number of quantities in field are" + count2);
			for (int i = 0; i < allparts.size(); i++) {

				allparts.get(i).click();
				Parts_QUANTITIES.get(i).clear();

				Parts_QUANTITIES.get(i).sendKeys(oJsTD_Reg.getString("QUANTITY"));
				Parts_DELIVERY_DATE.get(i).clear();

				Parts_DELIVERY_DATE.get(i).sendKeys(oJsTD_Reg.getString("DELIVERY_DATE"));
				Select selectBuyerGroup = new Select(Parts_SELECT_BUYER_GROUP.get(i));
				// Select selectBuyerGroup = new Select(driver.findElement(SELECT_BUYER_GROUP));
				selectBuyerGroup.selectByIndex(2);
				ngWebDriver.waitForAngularRequestsToFinish();

			}

			oSelUtil.ufClick(driver, VERIFY);
			oComUtil.getScreenShot();
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, VERIFY_YES_BUTTON);
			oSelUtil.AlertHandling(ngWebDriver, driver);

		} catch (Exception vrf) {
			log.info("Quantity of parts of Shikeisho not changed" + vrf.getMessage());
			verify_values = false;
		}
		return verify_values;
	}

	public boolean ChangesApproving() throws Exception {
		boolean changes_approve = false;
		try {
			oSelUtil.ufClick(driver, SAVE_BUTTON);
		} catch (Exception ca) {
			log.info("Fails to save the changes" + ca.getMessage());
			changes_approve = false;
		}
		return changes_approve;
	}

	public boolean AssignBOMUserforLMAprvShi() throws Exception {
		boolean assgn_bomuser = false;
		try {
			ngWebDriver.waitForAngularRequestsToFinish();
			Select sll = new Select(driver.findElement(ASSIGN_BOM));
			sll.selectByValue("BOMUSER1");
			oSelUtil.ufClick(driver, SAVE_BOMUSER);
			oSelUtil.AlertHandling(ngWebDriver, driver);
			oComUtil.getScreenShot();

		} catch (Exception ab) {
			log.info("Fail to assign the bom user " + ab.getMessage());
			assgn_bomuser = false;

		}
		return assgn_bomuser;
	}

	public boolean AssignBuyerCode() throws Exception {
		boolean buyer_code = false;
		try {
			Select sls = new Select(driver.findElement(ASSIGN_BUYERGROUP));
			sls.selectByIndex(2);
			oSelUtil.ufClick(driver, PL_PART);
			BOMPO bo = new BOMPO();
			bo.SearchShikeisho();

		} catch (Exception bc) {
			log.info("Fails in assigning the buyer code" + bc.getMessage());
			buyer_code = false;
		}
		return buyer_code;
	}

	public boolean AfterRDLMviewConfirmQuantityByBOM() throws Exception {
		boolean after_RDLM = false;
		try {
			oSelUtil.ufClick(driver, APPROVE_BYBOM);
		} catch (Exception ard) {
			log.info("BOM user unable to confirm the quantity of shikeisho which are approved by RD and LM" + ard);
			after_RDLM = false;
		}
		return after_RDLM;
	}

	public boolean BOMlogout() throws Exception {
		boolean logout = false;
		try {
			oSelUtil.ufClick(driver, Usr_pro);
			oSelUtil.ufClick(driver, LOGOUT);
			oSelUtil.AlertHandling(ngWebDriver, driver);
			// saa.assertEquals(logoutText, oJsDataVal.getString("LOGOUT"));
			// saa.assertAll();
		} catch (Exception lo) {
			log.info("User fails to logout" + lo.getMessage());
			logout = false;
		}
		return logout;
	}

}
