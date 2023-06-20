package com.amazon.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amazon.pageobjects.HomePage;
import com.amazon.pageobjects.LoginPage;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.DataGenerator;
import helperMethods.JsonUtils;

public class Login_test_02 extends BaseClass {

	LoginPage droom_page;
	DataGenerator dataGenrator;
	HomePage homePage;
	SoftAssert softAssert = new SoftAssert();

	@Test(enabled = true ,priority = 3)
	public void LoginWithEmailValidCredentials() throws Exception {

		test = extent.createTest("Login_test_001",
				"User should be able to register successfully on  droom application");

		dataGenrator = new DataGenerator();
		droom_page = new LoginPage(driver, test);
		driver.get(DefineConstants.Amazon_URL);
		droom_page.loginToApplication(JsonUtils.getData(DefineConstants.Login_Details, "valid_email"),
				JsonUtils.getData(DefineConstants.Login_Details, "valid_password"));
		homePage = new HomePage(driver, test);
		homePage.logOutFromApplication();

	}

	//@Test(enabled = true ,priority = 2)
	public void checkWithBlankEmail() {
		droom_page.blankEmailValidation();
	}

	//@Test(enabled = true, priority = 1)
	public void checkWithInvalidEmail(String email) {
		droom_page.invalidEmailValidation(JsonUtils.getData(DefineConstants.Login_Details, "invalid_email"));
	}

//	@AfterMethod
//	public void tearDown() throws IOException {
//		extent.flush();
//		driver.quit();
//	}
}