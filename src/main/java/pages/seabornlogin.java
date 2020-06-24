package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import helperLogger.LoggerHelper;
import stepDefinition.TestBase;

public class seabornlogin extends TestBase {

	public static WebDriver driver;

	Logger log = LoggerHelper.getLogger(seabornlogin.class);
	
	@SuppressWarnings("static-access")
	public seabornlogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement locator user name
	@FindBy(how = How.ID, using = "_58_login")
	public WebElement txtuseremail;

	// WebElement locator password
	@FindBy(how = How.ID, using = "_58_password")
	public WebElement txtpassword;

	// WebElement locator signIn
	@FindBy(how = How.ID, using = "_58_submit")
	public WebElement btnsignin;

	@FindBy(how = How.XPATH, using = "//i[@class='icon-caret-down']")
	public WebElement dropdownicon;

	@FindBy(how = How.CSS, using = "li.sign-out")
	public WebElement logoutlink;

	// Method for Login user name and password with parameters
	public void Login(String useremail, String password) throws Exception {
		sendKeys(driver, txtuseremail, 5, useremail);
		sendKeys(driver, txtpassword, 5, password);
	}

	// Method for signIn click
	public void clicksignin() throws Exception {
		ClickOn(driver, btnsignin, 5);
	}

	public void logoutApp() throws Exception {
		ClickOn(driver, dropdownicon, 15);
		ClickOn(driver, logoutlink, 15);
	}

}
