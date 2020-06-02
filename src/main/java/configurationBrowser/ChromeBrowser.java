package configurationBrowser;

import java.util.HashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import utility.ResourceHelper;

public class ChromeBrowser {

	public static WebDriver driver;

	public Capabilities getChromeCapabilities() {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", chromePrefs);
		option.addArguments("start-maximized");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		chrome.setCapability(ChromeOptions.CAPABILITY, option);
		chrome.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return chrome;
	}

	public WebDriver getChromeDriver(Capabilities capabilities) {
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
			return new ChromeDriver(capabilities);
		} else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.chrome.driver",
					ResourceHelper.getResourcePath("/src/main/resources/drivers/chromedriver.exe"));
			return new ChromeDriver(capabilities);

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
