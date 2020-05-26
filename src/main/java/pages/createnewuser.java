package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import configreader.ObjectRepo;
import stepDefinition.TestBase;
import utility.ConfigProperties;

public class createnewuser {

	public static WebDriver driver;

	public createnewuser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='User Management']")
	public WebElement create_new_user;
	
	@FindBy(how = How.XPATH, using = "//a[@id='tabButton']")
	public WebElement addnewuserbutton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='emailAddress']")
	public WebElement user_email;

	@FindBy(how = How.XPATH, using = " //input[@id='firstName']")
	public WebElement userfirstname;

	@FindBy(how = How.XPATH, using = "//input[@id='middleName']")
	public WebElement usermiddlename;

	@FindBy(how = How.XPATH, using = "//input[@id='lastName']")
	public WebElement userlastname;

	@FindBy(how = How.XPATH, using = "//input[@id='phoneNumber']")
	public WebElement userphonenumber;

	@FindBy(how = How.XPATH, using = "//input[@id='saveManagerUserBtn']")
	public WebElement savebutton;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnAddNewuser() throws Exception {
		sbloginoobj.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		create_new_user.click();
	}

	public void clickonAddnewuserbutton() throws Exception {
		
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",addnewuserbutton );
		 Thread.sleep(5000);
	}
	public void userSelectvalues(String user_email_1, String user_firstname_1,String user_middlename_1, String user_lastname_1,String user_phonenumber_value ) {

		user_email.sendKeys(user_email_1);
		userfirstname.sendKeys(user_firstname_1);
		usermiddlename.sendKeys(user_middlename_1);
		userlastname.sendKeys(user_lastname_1);
		userphonenumber.sendKeys(user_phonenumber_value);
	}
	public void userselectcountyandRoles() {
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='country']")));
		 dropdown1.selectByVisibleText("Afghanistan");
		 
	Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='roles']")));
	dropdown2.selectByVisibleText("Technical Contact");
		 
}
	 public void createuser()
	   {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",savebutton );
}	
	
}
