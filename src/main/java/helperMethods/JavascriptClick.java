package helperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptClick {

	private WebDriver driver;
	private JavascriptExecutor javascriptExecutor;

	public JavascriptClick(WebDriver driver) {
		this.driver = driver;

	}

	public void click(WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click()", element);
	}
	
	
	public void sendKeys(WebElement element,String value) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].value='"+value+"';", element);
	}
	
	public void enterRichText(WebElement element,String value) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].innerHTML='"+value+"';", element);
	}
	
// border: 2px solid;
	public void highLighterMethod(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow;');", element);
	}
}
