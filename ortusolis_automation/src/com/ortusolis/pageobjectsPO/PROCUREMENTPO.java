package com.ortusolis.pageobjectsPO;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortusolis.utilities.TestBase;

public class PROCUREMENTPO extends TestBase {
	By NEW_REGISTER, F_NAME, L_NAME, E_MAIL, ID, ROLE, PROC_USER_ID, PROC_USER_PASSWORD, SIGN_IN, PROC_USER_PROFILE,
			REGISTER_BUTTON, SWITCH2ADMIN, NEW_BUYER_SECTION, NEW_BUYER_BUTTON, PROC_USER_LIST, GET_DETAILS_BUTTON,
			ASSIGN_GROUP, SUBMIT_ADD_NEW_BUYER, NEW_BUYER__GROUP_SECTION, NEW_BUYER_GROUP_BUTTON,
			SUBMIT_ADD_NEW_BUYER_GROUP, GROUP_NAME_FIELD, ADD_BUYER_IN_BUYER_GROUP_SECTION, SELECT_BUYER_POPUP,
			ADD_BUYER_POPUP_DONE, NEW_ASSISTANT_SECTION, NEW_ASSISTANT_BUTTON, ASSISTANT_USER_ID, ASSISTANT_NAME,
			ASSISTANT_ID, ASSISTANT_USER_SUBMIT_BUTTON, PENDING_SECTION, USER_DETAIL, APPROVE, SELECT_SUPPLIER_CLASS,
			AFTER_SUPPLIER_DONE, SEARCH_BY, SHIKEISHO_NUM, PART_NUM, KANRI_NUM, EO_NUM, SEARCH_FIELD, SEARCH_BUTTON,
			NEW_SHIKEISHO, CHANGED_SHIKEISHO, SHIKEISHO_ID, PART_CLASSIFICATION, SAVE_URL, SUPPLIER_SEARCH_FIELD,
			ALL_SUPPLIERS, SUPPLIER_DONE, SAVE_SELECTED_SUPPLIERS, RFQ_SECTION, SEND_RFQ, SELECT_LANGUAGE,
			GET_RFQ_BUTTON, SUPPLIER_HEADINGS, LANGUAGE_CLASS, LANGUAGE_DONE, CANCEL_ORDER, COMMENTS_ON_CANCELORDER,
			CANCEL_ORDER_DONE, UNIT_PRICE, MOLD_COST, PREPARATION_COST, TRANSPORTATION_COST, NOTES, SAVE_UNIT_PRICE,
			PLACE_ORDER, CHECK_MARKS, UPDATE_ROLE_SECTION, UPDATE_ROLE_BUTTON, USER_ID_FIELD, GET_ROLE_DETAILS,
			CHANGE_ROLE, EDIT_USER_DETAILS, SAVE_USER_DETAILS, CANCEL_USER_DETAILS, PART_TABLE;

	final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	public static JSONObject oJsOR_Reg = new JSONObject();
	public static JSONObject oJsTD_Reg = new JSONObject();

	// public static JSONObject oJsDataVal = new JSONObject();
	public void ProcusrLocators() throws Exception {

		oJsOR_Reg = oComUtil.ReadJsonFileGetJsonObject(
				System.getProperty("user.dir") + "/src/objectRepo/locators_PROCUREMENT.json");
		oJsTD_Reg = oComUtil
				.ReadJsonFileGetJsonObject(System.getProperty("user.dir") + "/src/TestData/TestData_PROCUREMENT.json");
		// oJsDataVal =
		// oComUtil.ReadJsonFileGetJsonObject(System.getProperty("user.dir") +
		// "/src/TestData/dataValidationPROC.json");

		ProcPageObjects(oJsOR_Reg);
	}

	private void ProcPageObjects(JSONObject oJsOR_Reg) {

		NEW_REGISTER = oSelUtil.loadWithBy(oJsOR_Reg.getString("NEW_REGISTER"));
		F_NAME = oSelUtil.loadWithBy(oJsOR_Reg.getString("F_NAME"));
		L_NAME = oSelUtil.loadWithBy(oJsOR_Reg.getString("L_NAME"));
		E_MAIL = oSelUtil.loadWithBy(oJsOR_Reg.getString("E_MAIL"));
		REGISTER_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("REGISTER_BUTTON"));
		PROC_USER_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("PROC_USER_ID"));
		PROC_USER_PASSWORD = oSelUtil.loadWithBy(oJsOR_Reg.getString("PROC_USER_PASSWORD"));
		SIGN_IN = oSelUtil.loadWithBy(oJsOR_Reg.getString("SIGN_IN"));
		PROC_USER_PROFILE = oSelUtil.loadWithBy(oJsOR_Reg.getString("PROC_USER_PROFILE"));
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
		// SUPPLIER_SEARCH_FIELD
		// =oSelUtil.loadWithBy(oJsOR_Reg.getString("SUPPLIER_SEARCH_FIELD"));
		CHECK_MARKS = oSelUtil.loadWithBy(oJsOR_Reg.getString("CHECK_MARKS"));
		ALL_SUPPLIERS = oSelUtil.loadWithBy(oJsOR_Reg.getString("ALL_SUPPLIERS"));
		SUPPLIER_DONE = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUPPLIER_DONE"));
		SAVE_SELECTED_SUPPLIERS = oSelUtil.loadWithBy(oJsOR_Reg.getString("SAVE_SELECTED_SUPPLIERS"));
		RFQ_SECTION = oSelUtil.loadWithBy(oJsOR_Reg.getString("RFQ_SECTION"));
		SEND_RFQ = oSelUtil.loadWithBy(oJsOR_Reg.getString("SEND_RFQ"));
		SELECT_LANGUAGE = oSelUtil.loadWithBy(oJsOR_Reg.getString("SELECT_LANGUAGE"));
		GET_RFQ_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("GET_RFQ_BUTTON"));
		SUPPLIER_HEADINGS = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUPPLIER_HEADINGS"));
		LANGUAGE_CLASS = oSelUtil.loadWithBy(oJsOR_Reg.getString("LANGUAGE_CLASS"));
		LANGUAGE_DONE = oSelUtil.loadWithBy(oJsOR_Reg.getString("LANGUAGE_DONE"));
		SELECT_SUPPLIER_CLASS = oSelUtil.loadWithBy(oJsOR_Reg.getString("SELECT_SUPPLIER_CLASS"));
		AFTER_SUPPLIER_DONE = oSelUtil.loadWithBy(oJsOR_Reg.getString("AFTER_SUPPLIER_DONE"));
		CANCEL_ORDER = oSelUtil.loadWithBy(oJsOR_Reg.getString("CANCEL_ORDER"));
		COMMENTS_ON_CANCELORDER = oSelUtil.loadWithBy(oJsOR_Reg.getString("COMMENTS_ON_CANCELORDER"));
		CANCEL_ORDER_DONE = oSelUtil.loadWithBy(oJsOR_Reg.getString("CANCEL_ORDER_DONE"));
		NEW_BUYER_SECTION = oSelUtil.loadWithBy(oJsOR_Reg.getString("NEW_BUYER_SECTION"));
		SWITCH2ADMIN = oSelUtil.loadWithBy(oJsOR_Reg.getString("SWITCH2ADMIN"));
		NEW_BUYER_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("NEW_BUYER_BUTTON"));
		PROC_USER_LIST = oSelUtil.loadWithBy(oJsOR_Reg.getString("PROC_USER_LIST"));
		GET_DETAILS_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("GET_DETAILS_BUTTON"));
		ASSIGN_GROUP = oSelUtil.loadWithBy(oJsOR_Reg.getString("ASSIGN_GROUP"));
		SUBMIT_ADD_NEW_BUYER = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUBMIT_ADD_NEW_BUYER"));
		NEW_BUYER__GROUP_SECTION = oSelUtil.loadWithBy(oJsOR_Reg.getString("NEW_BUYER__GROUP_SECTION"));
		NEW_BUYER_GROUP_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("NEW_BUYER_GROUP_BUTTON"));
		SUBMIT_ADD_NEW_BUYER_GROUP = oSelUtil.loadWithBy(oJsOR_Reg.getString("SUBMIT_ADD_NEW_BUYER_GROUP"));
		GROUP_NAME_FIELD = oSelUtil.loadWithBy(oJsOR_Reg.getString("GROUP_NAME_FIELD"));
		ADD_BUYER_IN_BUYER_GROUP_SECTION = oSelUtil.loadWithBy(oJsOR_Reg.getString("ADD_BUYER_IN_BUYER_GROUP_SECTION"));
		SELECT_BUYER_POPUP = oSelUtil.loadWithBy(oJsOR_Reg.getString("SELECT_BUYER_POPUP"));
		ADD_BUYER_POPUP_DONE = oSelUtil.loadWithBy(oJsOR_Reg.getString("ADD_BUYER_POPUP_DONE"));
		NEW_ASSISTANT_SECTION = oSelUtil.loadWithBy(oJsOR_Reg.getString("NEW_ASSISTANT_SECTION"));
		NEW_ASSISTANT_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("NEW_ASSISTANT_BUTTON"));
		ASSISTANT_USER_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("ASSISTANT_USER_ID"));
		ASSISTANT_NAME = oSelUtil.loadWithBy(oJsOR_Reg.getString("ASSISTANT_NAME"));
		ASSISTANT_ID = oSelUtil.loadWithBy(oJsOR_Reg.getString("ASSISTANT_ID"));
		ASSISTANT_USER_SUBMIT_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("ASSISTANT_USER_SUBMIT_BUTTON"));
		PENDING_SECTION = oSelUtil.loadWithBy(oJsOR_Reg.getString("PENDING_SECTION"));
		USER_DETAIL = oSelUtil.loadWithBy(oJsOR_Reg.getString("USER_DETAIL"));
		APPROVE = oSelUtil.loadWithBy(oJsOR_Reg.getString("APPROVE"));
		UNIT_PRICE = oSelUtil.loadWithBy(oJsOR_Reg.getString("UNIT_PRICE"));
		MOLD_COST = oSelUtil.loadWithBy(oJsOR_Reg.getString("MOLD_COST"));
		PREPARATION_COST = oSelUtil.loadWithBy(oJsOR_Reg.getString("PREPARATION_COST"));
		TRANSPORTATION_COST = oSelUtil.loadWithBy(oJsOR_Reg.getString("TRANSPORTATION_COST"));
		NOTES = oSelUtil.loadWithBy(oJsOR_Reg.getString("NOTES"));
		SAVE_UNIT_PRICE = oSelUtil.loadWithBy(oJsOR_Reg.getString("SAVE_UNIT_PRICE"));
		UPDATE_ROLE_SECTION = oSelUtil.loadWithBy(oJsOR_Reg.getString("UPDATE_ROLE_SECTION"));
		UPDATE_ROLE_BUTTON = oSelUtil.loadWithBy(oJsOR_Reg.getString("UPDATE_ROLE_BUTTON"));
		USER_ID_FIELD = oSelUtil.loadWithBy(oJsOR_Reg.getString("USER_ID_FIELD"));
		GET_ROLE_DETAILS = oSelUtil.loadWithBy(oJsOR_Reg.getString("GET_ROLE_DETAILS"));
		CHANGE_ROLE = oSelUtil.loadWithBy(oJsOR_Reg.getString("CHANGE_ROLE"));
		EDIT_USER_DETAILS = oSelUtil.loadWithBy(oJsOR_Reg.getString("EDIT_USER_DETAILS"));
		PLACE_ORDER = oSelUtil.loadWithBy(oJsOR_Reg.getString("PLACE_ORDER"));
		SAVE_USER_DETAILS = oSelUtil.loadWithBy(oJsOR_Reg.getString("SAVE_USER_DETAILS"));
		CANCEL_USER_DETAILS = oSelUtil.loadWithBy(oJsOR_Reg.getString("CANCEL_USER_DETAILS"));
		PART_TABLE = oSelUtil.loadWithBy(oJsOR_Reg.getString("PART_TABLE"));
	}

	public boolean RegisterAsProcUser() throws Exception {
		boolean rgstr_procUser = false;
		try {
			oSelUtil.ufClick(driver, NEW_REGISTER);
			oSelUtil.ufSendKeys(driver, F_NAME, oJsTD_Reg.getString("F_NAME"));
			oSelUtil.ufSendKeys(driver, L_NAME, oJsTD_Reg.getString("L_NAME"));
			oSelUtil.ufSendKeys(driver, E_MAIL, oJsTD_Reg.getString("E_MAIL"));
			oSelUtil.ufSendKeys(driver, ID, oJsTD_Reg.getString("ID"));
			Select slt = new Select(driver.findElement(ROLE));
			slt.selectByVisibleText("Proc User");
			oSelUtil.ufClick(driver, REGISTER_BUTTON);
			oSelUtil.AlertHandling(ngWebDriver, driver);

		} catch (Exception rpU) {
			log.info("Fails to Register as Procurement User" + rpU.getMessage());
			rgstr_procUser = false;
		}
		return rgstr_procUser;
	}

	public boolean ProcUserLogin() throws Exception {
		boolean procUser_login = false;
		try {
			oSelUtil.ufSendKeys(driver, PROC_USER_ID, oJsTD_Reg.getString("PROC_USER_ID"));
			oSelUtil.ufSendKeys(driver, PROC_USER_PASSWORD, oJsTD_Reg.getString("PROC_USER_PASSWORD"));
			oSelUtil.ufClick(driver, SIGN_IN);
			oSelUtil.AlertHandling(ngWebDriver, driver);
			oComUtil.getScreenShot();
		} catch (Exception pul) {
			log.info("Fails to login as Procurement User" + pul.getMessage());
			procUser_login = false;

		}
		return procUser_login;
	}

	public boolean ProcAdminLogin() throws Exception {
		boolean procAdmin_login = false;
		try {
			oSelUtil.ufSendKeys(driver, PROC_USER_ID, oJsTD_Reg.getString("PROC_ADMIN_ID"));
			oSelUtil.ufSendKeys(driver, PROC_USER_PASSWORD, oJsTD_Reg.getString("PROC_ADMIN_PASSWORD"));
			oSelUtil.ufClick(driver, SIGN_IN);
			oSelUtil.AlertHandling(ngWebDriver, driver);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, PROC_USER_PROFILE);
			oSelUtil.ufClick(driver, SWITCH2ADMIN);
			oComUtil.getScreenShot();
		} catch (Exception pul) {
			log.info("Fails to login as Procurement Admin" + pul.getMessage());
			procAdmin_login = false;

		}
		return procAdmin_login;
	}

	public boolean NewBuyer() throws Exception {
		boolean new_buyer = false;
		try {
			oSelUtil.ufClick(driver, NEW_BUYER_SECTION);
			oSelUtil.ufClick(driver, NEW_BUYER_BUTTON);
			ngWebDriver.waitForAngularRequestsToFinish();
			Select selectProcUser = new Select(driver.findElement(PROC_USER_LIST));
			selectProcUser.selectByIndex(0);
			oSelUtil.ufClick(driver, GET_DETAILS_BUTTON);
			ngWebDriver.waitForAngularRequestsToFinish();
			Select assignGroup = new Select(driver.findElement(ASSIGN_GROUP));
			assignGroup.selectByIndex(2);
			oSelUtil.ufClick(driver, SUBMIT_ADD_NEW_BUYER);
			oSelUtil.AlertHandling(ngWebDriver, driver);

		} catch (Exception nb) {
			log.info("Fails to create new buyer by Proc Admin" + nb.getMessage());
			new_buyer = false;

		}
		return new_buyer;
	}

	public boolean NewBuyerGroup() throws Exception {
		boolean new_buyerGroup = false;
		try {
			oSelUtil.ufClick(driver, NEW_BUYER__GROUP_SECTION);
			oSelUtil.ufClick(driver, NEW_BUYER_GROUP_BUTTON);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufSendKeys(driver, GROUP_NAME_FIELD, oJsTD_Reg.getString("GROUP_NAME_FIELD"));
			oSelUtil.ufClick(driver, SUBMIT_ADD_NEW_BUYER_GROUP);
		} catch (Exception nbg) {
			log.info("Fails to create new buyer by Proc Admin" + nbg.getMessage());
			new_buyerGroup = false;

		}
		return new_buyerGroup;
	}

	public boolean AddBuyerInBuyerGroupSection() throws Exception {
		boolean buyerIngroup = false;
		try {
			oSelUtil.ufClick(driver, NEW_BUYER__GROUP_SECTION);
			oSelUtil.ufClick(driver, NEW_BUYER_GROUP_BUTTON);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufSendKeys(driver, GROUP_NAME_FIELD, oJsTD_Reg.getString("GROUP_NAME_FIELD"));
			oSelUtil.ufClick(driver, ADD_BUYER_IN_BUYER_GROUP_SECTION);
			ngWebDriver.waitForAngularRequestsToFinish();
			Select selectbuyer = new Select(driver.findElement(SELECT_BUYER_POPUP));
			selectbuyer.selectByIndex(3);
			oSelUtil.ufClick(driver, ADD_BUYER_POPUP_DONE);
			oSelUtil.ufClick(driver, SUBMIT_ADD_NEW_BUYER_GROUP);

		} catch (Exception big) {
			log.info("Fails in assigning the buyer inbuyer group section" + big.getMessage());
			buyerIngroup = false;

		}
		return buyerIngroup;
	}

	public boolean NewAssistant() throws Exception {
		boolean new_Assistant = false;
		try {
			oSelUtil.ufClick(driver, NEW_ASSISTANT_SECTION);
			oSelUtil.ufClick(driver, NEW_ASSISTANT_BUTTON);
			oSelUtil.ufSendKeys(driver, ASSISTANT_USER_ID, oJsTD_Reg.getString("ASSISTANT_USER_ID"));
			oSelUtil.ufSendKeys(driver, ASSISTANT_NAME, oJsTD_Reg.getString("ASSISTANT_NAME"));
			oSelUtil.ufSendKeys(driver, ASSISTANT_ID, oJsTD_Reg.getString("ASSISTANT_ID"));

		} catch (Exception nA) {
			log.info("Fails to create new buyer by Proc Admin" + nA.getMessage());
			new_Assistant = false;

		}
		return new_Assistant;
	}

	public boolean UserApprovalByAdmin() throws Exception {
		boolean user_approval = false;
		try {
			oSelUtil.ufClick(driver, PENDING_SECTION);
			oSelUtil.ufClick(driver, USER_DETAIL);
			oSelUtil.ufClick(driver, APPROVE);
			oSelUtil.AlertHandling(ngWebDriver, driver);
			oComUtil.getScreenShot();

		} catch (Exception ua) {
			log.info("Fails to create new buyer by Proc Admin" + ua.getMessage());
			user_approval = false;

		}
		return user_approval;
	}

	public boolean UpdateRoleByAdmin() throws Exception {
		boolean Update_role = false;
		try {
			oSelUtil.ufClick(driver, UPDATE_ROLE_SECTION);
			oSelUtil.ufClick(driver, UPDATE_ROLE_BUTTON);
			oSelUtil.ufSendKeys(driver, USER_ID_FIELD, oJsTD_Reg.getString("USER_ID_SEARCH"));
			oSelUtil.ufClick(driver, GET_ROLE_DETAILS);
			Select selectrole = new Select(driver.findElement(CHANGE_ROLE));
			selectrole.selectByVisibleText("PROC ADMIN");
			oSelUtil.ufClick(driver, EDIT_USER_DETAILS);
			oSelUtil.ufClick(driver, SAVE_USER_DETAILS);
		} catch (Exception ur) {
			log.info("Fails to update role of User" + ur.getMessage());
			Update_role = false;
		}
		return Update_role;
	}

	public boolean SearchShikeisho() throws Exception {
		boolean srh_shi = false;
		try {
			/*
			 * oSelUtil.ufClick(driver, SEARCH_BY); oSelUtil.ufClick(driver, SHIKEISHO_NUM);
			 * oSelUtil.ufSendKeys(driver, SEARCH_FIELD,
			 * oJsTD_Reg.getString("SHIKEISHO ID"));
			 */
			// oSelUtil.ufClick(driver, NEW_SHIKEISHO);
			ngWebDriver.waitForAngularRequestsToFinish();
			List<WebElement> ShiRfq = oSelUtil.ufGetWebElements(driver, NEW_SHIKEISHO);
			Thread.sleep(1000);
			ShiRfq.get(1).click();
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, SHIKEISHO_ID);
			ngWebDriver.waitForAngularRequestsToFinish();
			oComUtil.getScreenShot();
			/*
			 * List<WebElement> allShikeisho =oSelUtil.ufGetWebElements(driver,
			 * SHIKEISHO_ID); int count= allShikeisho.size(); int iContainText =
			 * oSelUtil.getIndexOfMatchingTextWebElements(allShikeisho,oJsTD_Reg.getString(
			 * "SHIKEISHO_ID")); allShikeisho.get(iContainText).click();
			 */

		} catch (Exception ss) {
			log.info("Fails to search the shikeisho by Procurement team" + ss.getMessage());
			srh_shi = false;
		}
		return srh_shi;
	}

	public boolean SelectSupplier() throws Exception {
		boolean select_supplier = false;
		try {
			List<WebElement> SupplierClass = oSelUtil.ufGetWebElements(driver, SELECT_SUPPLIER_CLASS);
			log.info("Number of supplier fields are" + SupplierClass.size());
			for (int i = 0; i < SupplierClass.size(); i++) {

				SupplierClass.get(i).click();
				ngWebDriver.waitForAngularRequestsToFinish();
				List<WebElement> SelectSuppliers = oSelUtil.ufGetWebElements(driver, ALL_SUPPLIERS);

				SelectSuppliers.get(1).click();
				SelectSuppliers.get(2).click();
				SelectSuppliers.get(3).click();
				// ngWebDriver.waitForAngularRequestsToFinish();
				oSelUtil.ufClick(driver, SUPPLIER_DONE);
				ngWebDriver.waitForAngularRequestsToFinish();

			}
			ngWebDriver.waitForAngularRequestsToFinish();

			oSelUtil.ufClick(driver, SAVE_SELECTED_SUPPLIERS);
			oComUtil.getScreenShot();

			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.AlertHandling(ngWebDriver, driver);

			oSelUtil.ufClick(driver, AFTER_SUPPLIER_DONE);
			ngWebDriver.waitForAngularRequestsToFinish();

		} catch (Exception ss) {
			log.info("Fails to select supplier" + ss.getMessage());
		}
		return select_supplier;
	}

	public boolean RFQ() throws Exception {
		boolean rfq_basedon_group = false;
		try {
			int count = 0;
			ngWebDriver.waitForAngularRequestsToFinish();
			List<WebElement> rfq = oSelUtil.ufGetWebElements(driver, NEW_SHIKEISHO);
			Thread.sleep(1000);
			rfq.get(0).click();
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufClick(driver, GET_RFQ_BUTTON);
			ngWebDriver.waitForAngularRequestsToFinish();
			List<WebElement> SupplierHeadingToShow = oSelUtil.ufGetWebElements(driver, SUPPLIER_HEADINGS);
			int count1 = SupplierHeadingToShow.size();
			log.info("Number supplier based on group is" + count1);
			for (int i = 0; i < SupplierHeadingToShow.size(); i++) {
				String supplierNames = SupplierHeadingToShow.get(i).getText();
				log.info("supplier names are" + supplierNames);
				List<WebElement> AllCheckmark = oSelUtil.ufGetWebElements(driver, CHECK_MARKS);
				ngWebDriver.waitForAngularRequestsToFinish();
				for (int j = count; j < AllCheckmark.size(); j++) {
					AllCheckmark.get(j).click();
					count++;
				}
				ngWebDriver.waitForAngularRequestsToFinish();
				oComUtil.getScreenShot();
				selectlanguage();

			}

		} catch (Exception rbg) {
			log.info("Fails to select Chekmarks" + rbg.getMessage());
			rfq_basedon_group = false;
		}
		return rfq_basedon_group;

	}

	public boolean selectlanguage() throws Exception {
		boolean select_lan = false;
		try {
			ngWebDriver.waitForAngularRequestsToFinish();
			List<WebElement> AllSendRFQ = oSelUtil.ufGetWebElements(driver, SEND_RFQ);

			AllSendRFQ.get(0).click();
			ngWebDriver.waitForAngularRequestsToFinish();

			oSelUtil.ufClick(driver, SELECT_LANGUAGE);
			Thread.sleep(1000);
			ngWebDriver.waitForAngularRequestsToFinish();
			List<WebElement> Language = oSelUtil.ufGetWebElements(driver, LANGUAGE_CLASS);
			Language.get(0).click();

			ngWebDriver.waitForAngularRequestsToFinish();

			oSelUtil.ufClick(driver, LANGUAGE_DONE);
			oComUtil.getScreenShot();

		} catch (Exception sl) {
			log.info("fails to select language" + sl.getMessage());
			select_lan = false;
		}
		return select_lan;
	}

	public boolean CancelOrder() throws Exception {
		boolean cancel_order = false;
		try {
			oSelUtil.ufClick(driver, CANCEL_ORDER);
			Thread.sleep(2000);
			ngWebDriver.waitForAngularRequestsToFinish();
			oSelUtil.ufSendKeys(driver, COMMENTS_ON_CANCELORDER, oJsTD_Reg.getString("CANCELORDER"));
			oSelUtil.ufClick(driver, CANCEL_ORDER_DONE);
			oComUtil.getScreenShot();

		} catch (Exception co) {
			log.info("Fails to cancel the order" + co.getMessage());
			cancel_order = false;
		}
		return cancel_order;
	}

	public boolean UnitPrice_Cost() throws Exception {
		boolean unit_price = false;
		try {
			oSelUtil.ufSendKeys(driver, UNIT_PRICE, oJsTD_Reg.getString("UNIT_PRICE"));
			oSelUtil.ufSendKeys(driver, MOLD_COST, oJsTD_Reg.getString("MOLD_COST"));
			oSelUtil.ufSendKeys(driver, PREPARATION_COST, oJsTD_Reg.getString("PREPARATION_COST"));
			oSelUtil.ufSendKeys(driver, TRANSPORTATION_COST, oJsTD_Reg.getString("TRANSPORTATION_COST"));
			oSelUtil.ufSendKeys(driver, NOTES, oJsTD_Reg.getString("NOTES"));
			oSelUtil.ufClick(driver, SAVE_UNIT_PRICE);
			oComUtil.getScreenShot();

		} catch (Exception up) {
			log.info("Fails to enter and save Unit price" + up.getMessage());
			unit_price = false;
		}
		return unit_price;
	}

	public boolean PlaceOrderByBOM() throws Exception {
		boolean place_order = false;
		try {
			oSelUtil.ufClick(driver, PLACE_ORDER);
			oComUtil.getScreenShot();
		} catch (Exception po) {
			log.info("Fails to place order by BOM" + po.getMessage());
			place_order = false;
		}
		return place_order;
	}

}