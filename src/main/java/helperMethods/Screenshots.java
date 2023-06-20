package helperMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class Screenshots {

	public ExtentTest test;
	public WebDriver driver;

	public Screenshots(WebDriver driver) {
		this.driver = driver;
	}

	public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
		// DataGenerator generate = new DataGenerator();

		fileName = fileName + ".png";
		String directory = "report/";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		return fileName;
	}

	public static String retryTakeScreenshot(WebDriver driver, String fileName) throws IOException {

		fileName = fileName + ".png";
		String directory = "RetryScreenShot/";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		return fileName;
	}

	public void zUploadFile(String filePath) throws Exception {

		// Put path to your image in a clipboard
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// OR use java robot for entire filepath
		Thread.sleep(10000);

		// Imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}