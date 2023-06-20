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

public class HomePage {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private SwitchWindow switchToWindow;
	private Keyboard keyboard;
	private ScrollTypes scrolltype;
	private DropDown dropdown;
	JavascriptClick jsClick;
	Actions actions;

	public HomePage(WebDriver driver, ExtentTest test) {
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
	}

	SoftAssert softAssert = new SoftAssert();

	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	private WebElement accountList_link;
	
	@FindBy(xpath = "//span[contains(text(),'Your Account')]")
	private WebElement yourAcct_link;

	@FindBy(xpath = "//span[contains(text(),'Your Orders')]")
	private WebElement your_Orders_link;
	
	@FindBy(xpath = "//span[contains(text(),'Sign Out')]")
	private WebElement signOut_Btn;

	@FindBy(xpath = "//input[@placeholder='Search Amazon.ca']")
	private WebElement searchItem_textBx;

	@FindBy(xpath = "//input[@value='Go']")
	private WebElement searchItem_Btn;

	
	public void logOutFromApplication() {		
		actions.moveToElement(accountList_link).build().perform();
		test.log(Status.INFO, "Mouse hower on account list");
		Log.info("Mouse hower on account list");
		applyWait.waitforElementToBeDisplayed(signOut_Btn, DefineConstants.explicitWait_10);
	    signOut_Btn.click();
	}

}