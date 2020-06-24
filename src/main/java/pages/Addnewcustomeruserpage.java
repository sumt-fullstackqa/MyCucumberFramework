package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import helperLogger.LoggerHelper;
import stepDefinition.TestBase;
import utility.ConfigProperties;

public class Addnewcustomeruserpage extends TestBase {

	public static WebDriver driver;
	static String emailAddress;
	
	
	Logger log = LoggerHelper.getLogger(Addnewcustomeruserpage.class);

	@SuppressWarnings("static-access")
	public Addnewcustomeruserpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='User Management']")
	public WebElement create_new_customeruser;
	
	@FindBy(how = How.XPATH, using = "//a[@id='tabButton']")
	public WebElement addnewcustomeruserbutton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='emailAddress']")
	public WebElement customeruser_email;

	@FindBy(how = How.XPATH, using = " //input[@id='firstName']")
	public WebElement customeruserfirstname;

	@FindBy(how = How.XPATH, using = "//input[@id='middleName']")
	public WebElement customerusermiddlename;

	@FindBy(how = How.XPATH, using = "//input[@id='lastName']")
	public WebElement customeruserlastname;

	@FindBy(how = How.XPATH, using = "//input[@id='phoneNumber']")
	public WebElement customeruserphonenumber;

	@FindBy(how = How.XPATH, using = "//input[@id='saveManagerUserBtn']")
	public WebElement savebutton;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnAddNewcustomeruser() throws Exception {
		sbloginoobj.Login(ConfigProperties.CUSTOMERUSEREMAIL, ConfigProperties.CUSTOMERPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		create_new_customeruser.click();
		Thread.sleep(4000);
	}

	public void clickonAddnewcustomeruserbutton() throws Exception {
		
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",addnewcustomeruserbutton );
		 Thread.sleep(5000);
	}
	public void customeruserSelectvalues(String customeruser_firstname_1,String customeruser_middlename_1, String customeruser_lastname_1,String customeruser_phonenumber_value ) throws InterruptedException {

		inputText(customeruser_email, getSaltString()+"@gmail.com");
		customeruserfirstname.sendKeys(customeruser_firstname_1);
		customerusermiddlename.sendKeys(customeruser_middlename_1);
		customeruserlastname.sendKeys(customeruser_lastname_1);
		customeruserphonenumber.sendKeys(customeruser_phonenumber_value);
		Thread.sleep(4000);
	}
	public void customeruserselectcountyandRoles() throws InterruptedException {
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='country']")));
		 dropdown1.selectByVisibleText("Afghanistan");
		 Thread.sleep(4000);
		 
	Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='roles']")));
	dropdown2.selectByVisibleText("Technical Contact");
	Thread.sleep(4000);
}
	 public void createcustomeruser()
	   {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",savebutton );
}	
	
}
