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

public class LMrqstAprvByAdmnPO extends TestBase {
	By New_Rgstr, fname, lname, email, Daimlr, role, Rgstr_Usr, Usr, Pwd, signup, Usr_pro, swtcadmn, Pndg, ClkUsr, Aprv,
			Admn_Pro, signout, AdminLogout, SEARCH_BY, SHIKEISHO_NUM, PART_NUM, KANRI_NUM, EO_NUM, SEARCH_FIELD,
			SEARCH_BUTTON, NEW_SHIKEISHO, CHANGED_SHIKEISHO, SHIKEISHO_ID, PART_ID, KANRI_ID, EO_ID, APPROVE, REJECT,
			FUNDING_LINK, FUNDING_CLOSE, LOCATION, DELIVERY_DATE, DIGIT, QUANTITY, SUBMIT_BUTTON, ADD_NEW_USER,
			CONTACT_NUMBER, DAIMLER_DAIMLER, NEW_USER_BUTTON, USER_NAME, DEPARTMENT, ROLE_ROLE, SUBMIT_AND_ADDUSER,
			UPDATE_USER_ROLE_SECTION, UPDATE_BUTTON, DAIMLER_SEARCH_FIELD, GET_DETAILS, SELECT_ROLE, UPDATE_ROLE_BUTTON,
			USER_ID_POPUP, POP_UP_CLOSE, SHIKEISHO_ACTION_SECTION, CHANGED_SHIKEISHO_ID, APPROVE_BOM_CHANGE_SHIKEISHO;
	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();
	public static JSONObject oJsDataVal = new JSONObject();

	public void RqstAprvLocators() throws Exception {
		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(
				System.getProperty("user.dir") + "/src/objectRepo/locators_LMrqstAprvByAdmn.json");
		oJsTD_Reg = oComUtil.ReadJsonFileGetJsonObject(
				System.getProperty("user.dir") + "/src/TestData/TestData_LMrqstAprvByAdmn.json");
		// oJsDataVal =
		// oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir")+"/src/dataValidation/dataValidation_LM.json");
		RqstAprvPage(oJsOR_Reg);
	}

	private void RqstAprvPage(JSONObject oJsOR_Reg) {

		New_Rgstr = oSelUtil.loadWithBy(oJsOR_Reg.getString("New_Rgstr"));
		fname = oSelUtil.loadWithBy(oJsOR_Reg.getString("fname"));
		lname = oSelUtil.loadWithBy(oJsOR_Reg.getString("lname"));
		email = oSelUtil.loadWithBy(oJsOR_Reg.getString("email"));
		Daimlr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Daimlr"));
		role = oSelUtil.loadWithBy(oJsOR_Reg.getString("role"));
		Rgstr_Usr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Rgstr_Usr"));
		// Rgstr_Sucess =oSelUtil.loadWithBy(oJsOR_Reg.getString("Rgstr_Sucess"));
		Usr = oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr"));
		Pwd = oSelUtil.loadWithBy(oJsOR_Reg.getString("Pwd"));
		signup = oSelUtil.loadWithBy(oJsOR_Reg.getString("signup"));
		Usr_pro = oSelUtil.loadWithBy(oJsOR_Reg.getString("Usr_pro"));
		swtcadmn = oSelUtil.loadWithBy(oJsOR_Reg.getString("swtcadmn"));
		Pndg = oSelUtil.loadWithBy(oJsOR_Reg.getString("Pndg"));
		ClkUsr = oSelUtil.loadWithBy(oJsOR_Reg.getString("ClkUsr"));
		Aprv = oSelUtil.loadWithBy(oJsOR_Reg.getString("Aprv"));
		signout = oSelUtil.loadWithBy(oJsOR_Reg.getString("signout"));
		AdminLogout = oSelUtil.loadWithBy(oJsOR_Reg.getString("AdminLogout"));
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
		LOCATION = oSelUtil.loadWithBy(oJsOR_Reg.getString("LOCATION"));
		DELIVERY_DATE = oSelUtil.loadWithBy(oJsOR_Reg.getString("DELIVERY_DATE"));
		DIGIT = oSelUtil.loadWithBy(oJsOR_Reg.getString("DIGIT"));
		// QUANTITY = oSelUtil.loadWithBy(oJsOR_Reg.getString("QUANTITY"));
		// SUBMIT_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUBMIT_BUTTON"));
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
		DAIMLER_SEARCH_FIELD = oSelUtil.loadWithBy(oJsOR_Reg.getString("DAIMLER_SEARCH_FIELD"));
		GET_DETAILS = oSelUtil.loadWithBy(oJsOR_Reg.getString("GET_DETAILS"));
		SELECT_ROLE = oSelUtil.loadWithBy(oJsOR_Reg.getString("SELECT_ROLE"));
		UPDATE_ROLE_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("UPDATE_ROLE_BUTTON"));
		USER_ID_POPUP = oSelUtil.loadWithBy(oJsOR_Reg.getString("USER_ID_POPUP"));
		POP_UP_CLOSE = oSelUtil.loadWithBy(oJsOR_Reg.getString("POP_UP_CLOSE"));
		SHIKEISHO_ACTION_SECTION = oSelUtil.loadWithBy(oJsOR_Reg.getString("SHIKEISHO_ACTION_SECTION"));
		CHANGED_SHIKEISHO_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("CHANGED_SHIKEISHO_ID"));
		APPROVE_BOM_CHANGE_SHIKEISHO = oSelUtil.loadWithBy(oJsOR_Reg.getString("APPROVE_BOM_CHANGE_SHIKEISHO"));
	}

	public boolean RgstrLMUsr() throws Exception {
		boolean rgstrusr = false;
		try {
			oCons.sDaimlerIDForLMFlow = oComUtil.generateUnixTimeStamp();
			oSelUtil.ufClick(driver, New_Rgstr);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufSendKeys(driver, fname, oJsTD_Reg.getString("f_name"));
			Thread.sleep(1000);
			oSelUtil.ufSendKeys(driver, lname, oJsTD_Reg.getString("l_name"));
			oSelUtil.ufSendKeys(driver, email, oJsTD_Reg.getString("email"));
			oSelUtil.ufSendKeys(driver, Daimlr, oCons.sDaimlerIDForLMFlow);
			// oSelUtil.ufGetWebElement(driver, role);
			Select sc = new Select(driver.findElement(role));
			sc.selectByVisibleText("LM User");
			oSelUtil.ufClick(driver, Rgstr_Usr);
			Thread.sleep(2000);
			oSelUtil.AlertHandling(ngWebDriver, driver);
			SoftAssert sa = new SoftAssert();
			// sa.assertEquals(text, oJsDataVal.getString("USER_REGISTER"));
			sa.assertAll();

			// Robot r= new Robot();
			// r.keyPress(KeyEvent.VK_ENTER);

			// oSelUtil.ufGetTextValidation(driver, Rgstr_Sucess,
			// oJsDataVal.getString("Rgstr_success"));
		} catch (Exception ea) {
			log.info("Error at registering as LM user" + ea);
			rgstrusr = false;
		}
		return rgstrusr;

	}

	public boolean UsrLogn() throws Exception {
		boolean usr_log = false;
		try {
			log.info(oCons.sDaimlerIDForLMFlow);
			oSelUtil.ufSendKeys(driver, Usr, Constants.sDaimlerIDForLMFlow);
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("UsrPwd"));
			oSelUtil.ufClick(driver, signup);
			Thread.sleep(2000);
			oSelUtil.AlertHandling(ngWebDriver, driver);
		} catch (Exception ee) {
			log.info("Unable to login" + ee.getMessage());
			usr_log = false;
		}
		return usr_log;
	}

	public boolean AdmnLogn() throws Exception {
		boolean adm_log = false;
		try {
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufSendKeys(driver, Usr, oJsTD_Reg.getString("AdmnId"));
			oSelUtil.ufSendKeys(driver, Pwd, oJsTD_Reg.getString("AdmnPwd"));
			Thread.sleep(1000);
			oSelUtil.ufClick(driver, signup);
			Thread.sleep(2000);
			oSelUtil.AlertHandling(ngWebDriver, driver);
			ngWebDriver.waitForAngularRequestsToFinish();

			/*
			 * oSelUtil.ufWaitForElementVisible(driver, Usr_pro, 10);
			 * oSelUtil.ufClick(driver, Usr_pro); oSelUtil.ufClick(driver, swtcadmn);
			 * ngWebDriver.waitForAngularRequestsToFinish();
			 */

		} catch (Exception ep) {
			log.info("Unable to login by Admin" + ep.getMessage());
			adm_log = false;
		}
		return adm_log;
	}

	public boolean LMUserApprovalByLMAdmin() throws Exception {
		boolean user_approve = false;
		try {
			Thread.sleep(1000);
			oSelUtil.ufClick(driver, Pndg);
			Thread.sleep(2000);
			List<WebElement> allusers = oSelUtil.ufGetWebElements(driver, ClkUsr);

			for (int i = 0; i < allusers.size(); i++) {
				allusers.get(i).click();
				if (oCons.sDaimlerIDForLMFlow.equalsIgnoreCase(oSelUtil.ufGetText(driver, USER_ID_POPUP)))
					break;
				else {
					oSelUtil.ufClick(driver, POP_UP_CLOSE);
					Thread.sleep(1000);
				}
			}
			/*
			 * List<WebElement> allusers = oSelUtil.ufGetWebElements(driver, ClkUsr); int
			 * count = allusers.size(); int iContainText =
			 * oSelUtil.getIndexOfMatchingTextWebElements(allusers,
			 * oCons.sDamlerIDForLMFlow); allusers.get(iContainText).click();
			 */
			oSelUtil.ufClick(driver, Aprv);
			Thread.sleep(2000);
			oSelUtil.AlertHandling(ngWebDriver, driver);

			/*
			 * SoftAssert sa = new SoftAssert(); sa.assertEquals(USER_APPROVED,
			 * oJsTD_Reg.getString("USER_APPROVAL")); sa.assertAll();
			 */

		} catch (Exception ua) {
			log.info("Fails to approve user by Admin" + ua.getMessage());
			user_approve = false;
		}
		return user_approve;
	}

	public boolean ApproveShikeishoID() throws Exception {
		boolean aprv_shi = false;
		try {
			/*
			 * oSelUtil.ufClick(driver, SEARCH_BY); oSelUtil.ufClick(driver, SHIKEISHO_NUM);
			 * oSelUtil.ufSendKeys(driver, SEARCH_FIELD,
			 * oJsTD_Reg.getString("SHIKEISHO_ID")); oSelUtil.ufClick(driver,
			 * SEARCH_BUTTON);
			 * 
			 * ngWebDriver.waitForAngularRequestsToFinish(); oSelUtil.ufClick(driver,
			 * NEW_SHIKEISHO); ngWebDriver.waitForAngularRequestsToFinish();
			 * oSelUtil.ufIsDisplayed(driver, SHIKEISHO_ID); oSelUtil.ufClick(driver,
			 * SHIKEISHO_ID); System.out.println("SHikeisho");
			 * ngWebDriver.waitForAngularRequestsToFinish();
			 */
			oSelUtil.ufClick(driver, NEW_SHIKEISHO);
			List<WebElement> allshi = oSelUtil.ufGetWebElements(driver, SHIKEISHO_ID);
			int count = allshi.size();
			log.info("Number of elements in the new shikeisho are" + count);
			for (int i = 0; i < allshi.size(); i++) {
				int iContainText1 = oSelUtil.getIndexOfMatchingTextWebElements(allshi,
						oJsTD_Reg.getString("SHIKEISHO_ID"));
				allshi.get(iContainText1).click();
			}
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, FUNDING_LINK);
			Thread.sleep(1000);
			oSelUtil.ufClick(driver, FUNDING_CLOSE);
			ngWebDriver.waitForAngularRequestsToFinish();
		} catch (Exception m) {
			log.info("Shikeisho not found in User landing screen" + m.getMessage());
			aprv_shi = false;
		}
		return aprv_shi;
	}

	public boolean ApprovePartID() throws Exception {
		boolean aprv_part = false;
		try {
			oSelUtil.ufClick(driver, SEARCH_BY);
			oSelUtil.ufClick(driver, PART_NUM);
			oSelUtil.ufSendKeys(driver, SEARCH_FIELD, oJsTD_Reg.getString("PART_NUM"));
			oSelUtil.ufClick(driver, SEARCH_BUTTON);
			oSelUtil.ufClick(driver, NEW_SHIKEISHO);
			oSelUtil.ufIsDisplayed(driver, PART_ID);
			oSelUtil.ufClick(driver, PART_ID);
			oSelUtil.ufClick(driver, APPROVE);
			oSelUtil.ufClick(driver, FUNDING_LINK);
			oSelUtil.ufClick(driver, FUNDING_CLOSE);
			oSelUtil.ufClick(driver, CHANGED_SHIKEISHO);
			oSelUtil.ufIsDisplayed(driver, PART_ID);
			oSelUtil.ufClick(driver, PART_ID);
			oSelUtil.ufClick(driver, APPROVE);
			oSelUtil.ufClick(driver, FUNDING_LINK);
			oSelUtil.ufClick(driver, FUNDING_CLOSE);

		} catch (Exception pr) {
			log.info("Shikeisho not found in User landing screen" + pr.getMessage());
			aprv_part = false;
		}
		return aprv_part;
	}

	public boolean ApproveKanriID() throws Exception {
		boolean aprv_kanri = false;
		try {
			oSelUtil.ufClick(driver, SEARCH_BY);
			oSelUtil.ufClick(driver, KANRI_NUM);
			oSelUtil.ufSendKeys(driver, SEARCH_FIELD, oJsTD_Reg.getString("KANRI_NUM"));
			oSelUtil.ufClick(driver, SEARCH_BUTTON);
			oSelUtil.ufClick(driver, NEW_SHIKEISHO);
			oSelUtil.ufIsDisplayed(driver, KANRI_ID);
			oSelUtil.ufClick(driver, KANRI_ID);
			oSelUtil.ufClick(driver, APPROVE);
			oSelUtil.ufClick(driver, FUNDING_LINK);
			oSelUtil.ufClick(driver, FUNDING_CLOSE);
			oSelUtil.ufClick(driver, CHANGED_SHIKEISHO);
			oSelUtil.ufIsDisplayed(driver, KANRI_ID);
			oSelUtil.ufClick(driver, KANRI_ID);
			oSelUtil.ufClick(driver, APPROVE);
			oSelUtil.ufClick(driver, FUNDING_LINK);
			oSelUtil.ufClick(driver, FUNDING_CLOSE);

		} catch (Exception kn) {
			log.info("Shikeisho not found in User landing screen" + kn.getMessage());
			aprv_kanri = false;
		}
		return aprv_kanri;
	}

	public boolean ApproveEoID() throws Exception {
		boolean aprv_eo = false;
		try {
			oSelUtil.ufClick(driver, SEARCH_BY);
			oSelUtil.ufClick(driver, EO_NUM);
			oSelUtil.ufSendKeys(driver, SEARCH_FIELD, oJsTD_Reg.getString("EO_NUM"));
			oSelUtil.ufClick(driver, SEARCH_BUTTON);
			oSelUtil.ufClick(driver, NEW_SHIKEISHO);
			oSelUtil.ufIsDisplayed(driver, EO_ID);
			oSelUtil.ufClick(driver, EO_ID);
			oSelUtil.ufClick(driver, APPROVE);
			oSelUtil.ufClick(driver, FUNDING_LINK);
			oSelUtil.ufClick(driver, FUNDING_CLOSE);
			oSelUtil.ufClick(driver, CHANGED_SHIKEISHO);
			oSelUtil.ufIsDisplayed(driver, EO_ID);
			oSelUtil.ufClick(driver, EO_ID);
			oSelUtil.ufClick(driver, APPROVE);
			oSelUtil.ufClick(driver, FUNDING_LINK);
			oSelUtil.ufClick(driver, FUNDING_CLOSE);

		} catch (Exception eo) {
			log.info("Shikeisho not found in User landing screen" + eo.getMessage());
			aprv_eo = false;
		}
		return aprv_eo;
	}

	public boolean UpdateVlues() throws Exception {

		boolean updt_values = false;
		try {
			/*
			 * oSelUtil.ufClick(driver, SEARCH_BY); oSelUtil.ufClick(driver, SHIKEISHO_NUM);
			 * oSelUtil.ufSendKeys(driver, SEARCH_FIELD,
			 * oJsTD_Reg.getString("SHIKEISHO_ID")); oSelUtil.ufClick(driver,
			 * SEARCH_BUTTON);
			 */
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClear(driver, LOCATION);
			oSelUtil.ufSendKeys(driver, LOCATION, oJsTD_Reg.getString("LOCATION"));
			oSelUtil.ufClear(driver, DELIVERY_DATE);
			oSelUtil.ufSendKeys(driver, DELIVERY_DATE, oJsTD_Reg.getString("DELIVERY_DATE"));
			oSelUtil.ufClear(driver, DIGIT);
			oSelUtil.ufSendKeys(driver, DIGIT, oJsTD_Reg.getString("DIGIT"));
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, SUBMIT_BUTTON);
			oSelUtil.AlertHandling(ngWebDriver, driver);

		} catch (Exception uv) {
			log.info("Error in updating the kanri " + uv.getMessage());
			updt_values = false;
		}
		return updt_values;
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
			Select se = new Select((WebElement) SELECT_ROLE);
			se.selectByVisibleText("");
			oSelUtil.ufClick(driver, UPDATE_ROLE_BUTTON);
			oSelUtil.AlertHandling(ngWebDriver, driver);
			/*
			 * SoftAssert sa = new SoftAssert(); sa.assertEquals(actualText,
			 * oJsDataVal.getString("ROLE_CHANGEBYADMIN")); sa.assertAll();
			 */

		} catch (Exception eu) {
			log.info("Fails to change user role by Admin" + eu);
			updt_role = false;
		}
		return updt_role;
	}

	public boolean AdminLogout() throws Exception {
		boolean admin_logout = false;
		try {
			oSelUtil.ufClick(driver, Admn_Pro);
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, AdminLogout);
			oSelUtil.AlertHandling(ngWebDriver, driver);

		} catch (Exception al) {
			log.info("Fails to logout as LM admin" + al.getMessage());
			admin_logout = false;
		}
		return admin_logout;
	}

	public boolean LMUserLogout() throws Exception {
		boolean lmUser_logout = false;
		try {
			oSelUtil.ufClick(driver, Usr_pro);
			Thread.sleep(2000);
			oSelUtil.ufClick(driver, signout);
			oSelUtil.AlertHandling(ngWebDriver, driver);

		} catch (Exception lu) {
			log.info("Fails to logout as LM user" + lu.getMessage());
			lmUser_logout = false;
		}
		return lmUser_logout;
	}

	public boolean ViewvingBOMChangedShikeishoByLM() throws Exception {
		boolean bom_change_shikeisho = false;
		try {

			List<WebElement> Action_Shikeisho = oSelUtil.ufGetWebElements(driver, SHIKEISHO_ACTION_SECTION);
			Action_Shikeisho.get(2).click();
			List<WebElement> allShikeisho = oSelUtil.ufGetWebElements(driver, CHANGED_SHIKEISHO_ID);
			for (int i = 0; i < allShikeisho.size(); i++) {
				int iContainText1 = oSelUtil.getIndexOfMatchingTextWebElements(allShikeisho,
						oJsTD_Reg.getString("BOM_CHANGE_SHIKEISHO_ID"));
				allShikeisho.get(iContainText1).click();
			}
			oSelUtil.ufClick(driver, APPROVE_BOM_CHANGE_SHIKEISHO);

		} catch (Exception bcs) {
			log.info("Fails to approve the Shikeisho Quantity changed by the BOM" + bcs.getMessage());
			bom_change_shikeisho = false;
		}
		return bom_change_shikeisho;
	}

}
