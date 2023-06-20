package helperMethods;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollTypes {

	WebDriver driver;

	public ScrollTypes(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollDown() throws AWTException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void scrollUp() throws AWTException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	public void scrollByParameter(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public void scrollInToView(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public boolean verifyScroller() {
		String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
		Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
		return test;
	}
}