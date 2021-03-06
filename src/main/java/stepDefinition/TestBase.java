package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
//import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import com.google.common.io.Files;

import configreader.ObjectRepo;
import configreader.PropertyFileReader;
import configurationBrowser.BrowserType;
import configurationBrowser.FirefoxBrowser;
import configurationBrowser.HtmlUnitBrowser;
import configurationBrowser.IExploreBrowser;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.DateTimeHelper;
import utility.ResourceHelper;

public class TestBase {

	public static Logger logger = Logger.getLogger("Testbase.class");
	
	
	public static void writeLogs(String msg)
	{
		logger.info(msg);
	}
	
	public static void writeErrorLogs(Throwable t) {
		
		logger.error(t.getMessage());
	}
	public static String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		// wait.ignoring(ElementNotFoundException.class);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.until(elementLocated(element));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	private Function<WebDriver, Boolean> elementLocated(final WebElement element) {
		return new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver driver) {
				logger.debug("Waiting for Element : " + element);
				return element.isDisplayed();
			}
		};
	}

	public String takeScreenShot(String name) throws IOException {

		/*
		 * if (driver instanceof HtmlUnitDriver) {
		 * log.fatal("HtmlUnitDriver Cannot take the ScreenShot"); return ""; }
		 */

		File destDir = new File(ResourceHelper.getResourcePath("screenshots/") + DateTimeHelper.getCurrentDate());
		if (!destDir.exists())
			destDir.mkdir();

		File destPath = new File(destDir.getAbsolutePath() + System.getProperty("file.separator") + name + ".jpg");
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), destPath);
		} catch (IOException e) {
			logger.error(e);
			throw e;
		}
		logger.info(destPath.getAbsolutePath());
		return destPath.getAbsolutePath();
	}

	public WebElement getElement(By locator) {
		logger.info(locator);
		if (IsElementPresentQuick(locator))
			return driver.findElement(locator);

		try {
			throw new NoSuchElementException("Element Not Found : " + locator);
		} catch (RuntimeException re) {
			logger.error(re);
			throw re;
		}
	}

	public WebElement getElementWithNull(By locator) {
		logger.info(locator);
		try {
			return driver.findElement(locator);
		} catch (NoSuchElementException e) {
			// Ignore
		}
		return null;
	}

	public boolean IsElementPresentQuick(By locator) {
		boolean flag = driver.findElements(locator).size() >= 1;
		logger.info(flag);
		return flag;
	}

	public static WebElement waitForElementToBeVisible(WebElement webelement, WebDriver driver, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(webelement));
		return element;

	}

	public static WebElement waitForElementToBeClickable(WebElement webelement, WebDriver driver, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webelement));
		return element;

	}

	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);

	}

	public static void ClickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}
	public static void JSClickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",element );
	
	}
	
	
	public static void clickElement(WebDriver driver, WebElement element) {
		element.click();

	}

	public static void executionDelay(int n) {
		try {
			Thread.sleep(n * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void holdon(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
		}
	}

	public static void sendKeys(WebDriver driver, WebElement element) {
		element.clear();
		element.click();

	}

	public static void inputText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	// Browser case

	public WebDriver getBrowserObject(BrowserType bType) throws Exception {
		try {
			logger.info(bType);

			switch (bType) {

			case Chrome:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();

				// ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				// return chrome.getChromeDriver(chrome.getChromeCapabilities());

			case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver(firefox.getFirefoxCapabilities());

			case HtmlUnitBrowser:
				HtmlUnitBrowser htmlUnit = HtmlUnitBrowser.class.newInstance();
				return (WebDriver) htmlUnit.getHtmlUnitDriver(htmlUnit.getHtmlUnitDriverCapabilities());

			case Iexplorer:
				IExploreBrowser iExplore = IExploreBrowser.class.newInstance();
				return iExplore.getIExplorerDriver(iExplore.getIExplorerCapabilities());
			default:
				throw new Exception(" Driver Not Found : " + new PropertyFileReader().getBrowser());
			}
		} catch (Exception e) {
			logger.equals(e);
			throw e;
		}
	}

	public void setUpDriver(BrowserType bType) throws Exception {

		driver = getBrowserObject(bType);
		logger.debug("InitializeWebDrive : " + driver.hashCode());
		driver.manage().timeouts().pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ObjectRepo.reader.ImplicitWait(), TimeUnit.SECONDS);
		/* driver.manage().window().maximize(); */
	}

	public void notifymessage(WebElement webElement, String expMsg) {
		expMsg = webElement.getText();
		if (webElement.isDisplayed() == true && expMsg.contains("successfully.")) {
			logger.info("Message Appears on Screen : " + expMsg);

		} else {
			logger.info("Message does not get displayed on Screen");
		}

	}

	public void clickOnExistingListElement(String configValue, List<WebElement> list) {
		if (list.size() == 0) {
			Assert.fail("No Record Exists");
		} else {
			for (WebElement li : list) {
				if (li.getText().equalsIgnoreCase(configValue)) {
					System.out.println("Record matches :" + li.getText());
					li.click();
					break;
				}
			}
		}
	}

	public void dropDownList(WebElement countryIdDropdown, String value) {
		Select dropdownlist = new Select(countryIdDropdown);
		dropdownlist.selectByVisibleText(value);
	}

	public static boolean isElementDisplayed(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException
				| org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public static void isloading(WebElement element, int timeout) {
		if (isElementDisplayed(element)) {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
		}
	}

	public static String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public static WebDriver setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		return driver;

	}

	@Before
	public void beforeScenario(Scenario scenario) {
		setup("chrome");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
		System.out.println("Test Environment set up");
		System.out.println("---------------------------------------");
		System.out.println("Executing Scenario :" + scenario.getName());
		Reporter.assignAuthor("Ankur Bhardwaj");

	}

	@SuppressWarnings("unused")
	@After
	public void after(Scenario scenario) throws Exception {
		scenario.write("Scenario finished");
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File sourcePath = ts.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "\\Screenshot\\" + timeStamp + ".png");
				Files.copy(sourcePath, destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			}
		}
		driver.quit();
		logger.info("Browser closed");
	}
}