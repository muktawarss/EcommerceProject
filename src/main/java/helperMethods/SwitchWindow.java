package helperMethods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SwitchWindow {

	WebDriver driver;
	String primaryWindowHandle;
	String subWindowHandler = null;

	public SwitchWindow(WebDriver driver) {
		this.driver = driver;
		this.primaryWindowHandle = driver.getWindowHandle();
	}

	public void switchToNewWindow() {
		
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		
		System.out.println(iterator);
		
		subWindowHandler = iterator.next();

		driver.switchTo().window(subWindowHandler); // switch to popup window
	}
	
	public void switchToNewFrame() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void closeCurrentWindowAndSwitchToPrimaryFrame() {
		driver.close();
		driver.switchTo().window(primaryWindowHandle);
	}

	public void switchToParentFrame() {
		driver.switchTo().window(primaryWindowHandle);
	}

	@SuppressWarnings("unchecked")
	public int windowCount() {
		@SuppressWarnings("rawtypes")
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		int size = (tabs.size());
		/*
		 * for (int i =1;i<tabs.size();i++){
		 * driver.switchTo().window(tabs.get(i)); }
		 */
		// driver.switchTo().window(tabs.get(0));
		return size;
	}

	public static void openNewTab(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
	
	public static void openReportTab(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
	}
}