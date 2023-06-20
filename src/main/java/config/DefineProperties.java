package config;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("all")
public class DefineProperties {

	public DefineProperties(String setbrowser) {
		if (setbrowser.equalsIgnoreCase("chrome")) {
			// System.setProperty(chromeDriver, setChromeDriverPath);
			WebDriverManager.chromedriver().setup();
		} else if (setbrowser.equalsIgnoreCase("firefox")) {
			System.setProperty(geckoDriver, setGeckoDriverPath);
		} else if (setbrowser.equalsIgnoreCase("internetexplorer")) {
			System.setProperty(internetExplorerDriver, setInternetExplorerDriverPath);
		}
	}

	public DesiredCapabilities setIECapability() {
		DesiredCapabilities setCap = DesiredCapabilities.internetExplorer();
		setCap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
		setCap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		setCap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		setCap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		setCap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		setCap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		return setCap;
	}

	public DesiredCapabilities SauceLabCapabilities() {
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "11");
		return caps;
	}

	public static final String chromeDriver = "webdriver.chrome.driver";
	public static final String setChromeDriverPath = "src/test/exeFiles/chromedriver.exe";

	public static final String geckoDriver = "webdriver.gecko.driver";
	public static final String setGeckoDriverPath = "src/test/exeFiles/geckodriver.exe";

	public static final String internetExplorerDriver = "webdriver.ie.driver";
	public static final String setInternetExplorerDriverPath = "src/test/exeFiles/IEDriverServer.exe";
}