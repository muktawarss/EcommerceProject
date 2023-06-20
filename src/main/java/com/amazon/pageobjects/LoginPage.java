package com.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import config.DefineConstants;
import helperMethods.DropDown;
import helperMethods.JavascriptClick;
import helperMethods.Keyboard;
import helperMethods.Log;
import helperMethods.Screenshots;
import helperMethods.ScrollTypes;
import helperMethods.SwitchWindow;
import helperMethods.WaitTypes;

public class LoginPage {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private SwitchWindow switchToWindow;
	private Keyboard keyboard;
	private ScrollTypes scrolltype;
	private DropDown dropdown;
	JavascriptClick jsClick;
	Actions actions;
	HomePage homePage;

	public LoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		new JavascriptClick(driver);
		switchToWindow = new SwitchWindow(driver);
		keyboard = new Keyboard();
		scrolltype = new ScrollTypes(driver);
		dropdown = new DropDown(driver);
		jsClick = new JavascriptClick(driver);
		actions = new Actions(driver);
		homePage = new HomePage(driver, test);
	}

	SoftAssert softAssert = new SoftAssert();

	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	private WebElement accountList_link;

	@FindBy(xpath = "//a[@class='nav-action-signin-button']")
	private WebElement signIn_Btn;

	@FindBy(css = "#ap_email")
	private WebElement email_textBx;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continue_Btn;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password_textBx;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement keepMeSignIn_chktBx;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement app_signIn_Btn;

	@FindBy(xpath = "//a[contains(text(),'Try different image')]")
	private WebElement captchaskip_link;

	@FindBy(xpath = "//span[contains(@id,'nav-link-accountList')]")
	private WebElement username_txt;

	@FindBy(xpath = "//div[contains(@id,'auth-email-missing-alert')]")
	private WebElement alert_Email_txt;

	@FindBy(xpath = "//div[contains(@id,'auth-password-missing-alert')]")
	private WebElement alert_password_txt;

	@FindBy(xpath = "//div[@id='auth-error-message-box']")
	private WebElement err_Txt;

	public void loginToApplication(String mobNoOrEmail, String pass) {
		landingOnSignInPage();
		enterEmailOrMobileNo(mobNoOrEmail);
		clickOnContinueBtn();
		enterPassword(pass);
		selectKeepMeSignInChkBx();
		clickOnAppSignIbBtn();
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(accountList_link).build().perform();
		test.log(Status.INFO, "Mouse hower on account list");
		Log.info("Mouse hower on account list");
		softAssert.assertEquals(verifyUserloginText(), "Hello, tester1");

	}

	public String verifyUserloginText() {
		String userName = username_txt.getText();
		return userName;
	}

	public void enterEmailOrMobileNo(String mobNumberOrEmail) {
		applyWait.waitforElementToBeDisplayed(email_textBx, DefineConstants.explicitWait_10);
		email_textBx.sendKeys(mobNumberOrEmail);
		test.log(Status.INFO, "Mobile number entered ::" + email_textBx.getAttribute("value"));
		Log.info("Mobile number entered ::" + email_textBx.getAttribute("value"));
	}

	public void enterPassword(String password) {
		password_textBx.sendKeys(password);
		test.log(Status.INFO, "Password entered ::" + password_textBx.getAttribute("value"));
		Log.info("Password entered ::" + password_textBx.getAttribute("value"));
	}

	public void selectKeepMeSignInChkBx() {
		applyWait.waitforElementToBeDisplayed(keepMeSignIn_chktBx, DefineConstants.explicitWait_10);
		keepMeSignIn_chktBx.click();
	}

	public void landingOnSignInPage() {

		try {
			if (captchaskip_link.isDisplayed() == true) {
				captchaskip_link.click();

			}
		} catch (Exception e) {

		}
		applyWait.waitForElementToBeClickable(signIn_Btn, DefineConstants.explicitWait_30);
		actions.moveToElement(accountList_link).build().perform();
		test.log(Status.INFO, "Mouse hower on account list");
		Log.info("Mouse hower on account list");
		jsClick.click(signIn_Btn);
		test.log(Status.INFO, "landing on Sign Page");
		Log.info("landing on Sign Page");
	}

	public void clickOnContinueBtn() {
		applyWait.waitForElementToBeClickable(continue_Btn, DefineConstants.explicitWait_10);
		continue_Btn.click();
	}

	public void clickOnAppSignIbBtn() {
		app_signIn_Btn.click();
		test.log(Status.INFO, "Clicked on signin button");
		Log.info("Clicked on signin button");
	}

	public boolean blankEmailValidation() {
		landingOnSignInPage();
		clickOnContinueBtn();
		return alert_Email_txt.isDisplayed();
	}

	public boolean invalidEmailValidation(String email) {
		landingOnSignInPage();
		clickOnContinueBtn();
		enterEmailOrMobileNo(email);
		return err_Txt.isDisplayed();
	}
}