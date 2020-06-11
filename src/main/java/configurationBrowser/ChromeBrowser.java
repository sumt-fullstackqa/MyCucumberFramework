package configurationBrowser;

import java.util.HashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import utility.ResourceHelper;

public class ChromeBrowser {

	public static WebDriver driver;

	public ChromeOptions getChromeCapabilities() {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
		ChromeOptions option = new ChromeOptions();	
		option.setExperimentalOption("prefs", chromePrefs);
		option.addArguments("start-maximized");
		option.setAcceptInsecureCerts(true);
		DesiredCapabilities cap = new DesiredCapabilities();
		option.merge(cap);
		cap.setJavascriptEnabled(true);
		cap.setCapability(ChromeOptions.CAPABILITY, option);
		cap.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		return option;
	}


	public WebDriver getChromeDriver(ChromeOptions option) {
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
			return new ChromeDriver(option);
		} else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
			return new ChromeDriver(option);

		}
		return null;
	}

	/*
	 * public static void main(String[] args) { ChromeBrowser cb = new
	 * ChromeBrowser(); ChromeBrowser.getChromeDriver(cb.getChromeCapabilities());
	 * System.out.println(System.getProperty("os.name"));
	 * System.out.println(System.getProperty("webdriver.chrome.driver"));
	 * 
	 * }
	 */

}
