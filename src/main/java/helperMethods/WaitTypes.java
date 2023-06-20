package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {

	WebDriver driver;
	WebDriverWait wait;

	public WaitTypes(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForElementToBeClickable(WebElement Element, int timeout) {

		try {
			wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(Element));

		} catch (Exception e) {
			e.getMessage();
		}

		return Element;
	}

	public WebElement waitforElementToBeDisplayed(WebElement Element, int timeout) {
		try {
			wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(Element));
		} catch (Exception e) {
			e.getMessage();
			System.out.println("" + e.getStackTrace());
		}
		return Element;
	}
	
	public WebElement waitforPresenceOfElementLocated(WebElement Element, int timeout) {
		try {
			wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(Element)));
		} catch (Exception e) {
			e.getMessage();
			System.out.println("" + e.getStackTrace());
		}
		return Element;
	}
	
	

}