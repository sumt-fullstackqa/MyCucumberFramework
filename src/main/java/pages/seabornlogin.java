package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class seabornlogin {

	public static WebDriver driver;

	// constructor initialisation
	public seabornlogin(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement locator username
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

	// Method for Login username and password with parameters
	public void Login(String useremail, String password) throws Exception
	{
		txtuseremail.sendKeys(useremail);
		txtpassword.sendKeys(password);
	}

	// Method for signIn click
	public void clicksignin() throws Exception {
		btnsignin.submit();
		Thread.sleep(5000);
		
	}

	public void logoutApp() throws Exception {
	
		
	dropdownicon.click();
	logoutlink.click();
	
		
	}

}

