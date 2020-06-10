package configurationBrowser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import utility.ResourceHelper;

public class IExploreBrowser {

	public Capabilities getIExplorerCapabilities() {
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setAcceptInsecureCerts(true);
		cap.setJavascriptEnabled(true);
		return cap;
	}

	@SuppressWarnings("deprecation")
	public WebDriver getIExplorerDriver(Capabilities cap) {
		System.setProperty("webdriver.ie.driver",
				ResourceHelper.getResourcePath("/src/main/resources/drivers/MicrosoftWebDriver.exe"));
		return new InternetExplorerDriver(cap);
	}

	/*
	 * public static void main(String[] args) { IExploreBrowser ie = new
	 * IExploreBrowser(); ie.getIExplorerDriver(ie.getIExplorerCapabilities());
	 * System.out.println(System.getProperty("webdriver.ie.driver"));
	 * 
	 * }
	 */

}
