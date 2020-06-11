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

import stepDefinition.TestBase;
import utility.ConfigProperties;

public class Editcustomeruserpage extends TestBase {

	public static WebDriver driver;
	static String emailAddress;

	public Editcustomeruserpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='User Management']")
	public WebElement customerusermanagementmenu;
	
	@FindBy(how = How.XPATH, using = "//input[@id='emailAddress']")
	public WebElement updatecustomeruser_email;

	@FindBy(how = How.XPATH, using = " //input[@id='firstName']")
	public WebElement updatecustomeruserfirstname;

	@FindBy(how = How.XPATH, using = "//input[@id='middleName']")
	public WebElement updatecustomerusermiddlename;

	@FindBy(how = How.XPATH, using = "//input[@id='lastName']")
	public WebElement updatecustomeruserlastname;

	@FindBy(how = How.XPATH, using = "//input[@id='phoneNumber']")
	public WebElement updatecustomeruserphonenumber;

	@FindBy(how = How.XPATH, using = "//input[@id='saveManagerUserBtn']")
	public WebElement updatebutton;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnCustomerUserManagementmenu() throws Exception {
		sbloginoobj.Login(ConfigProperties.CUSTOMERUSEREMAIL, ConfigProperties.CUSTOMERPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		customerusermanagementmenu.click();
		Thread.sleep(5000);
	}

	public void clickonthreedottediconandeditlinkforcustomer() throws Exception {
		Actions threedottedicon = new Actions(driver);
		WebElement mainMenuedituser = driver.findElement(By.xpath("(//div[contains(@class,'control actions-three-dot-menu')])[1]"));
		threedottedicon.moveToElement(mainMenuedituser);
		threedottedicon.click().build().perform();

		WebElement subMenuedituser = driver.findElement(By.xpath("(//a[@href='#'][contains(.,'Edit')])[1]"));
		threedottedicon.moveToElement(subMenuedituser);
		threedottedicon.click().build().perform();
		Thread.sleep(5000);
	}
	public void customeruserUpdatevalues(String customeruser_firstname_1,String customeruser_middlename_1, String customeruser_lastname_1,String customeruser_phonenumber_value ) {

		updatecustomeruser_email.clear();
		inputText(updatecustomeruser_email, getSaltString()+"@gmail.com");
		updatecustomeruserfirstname.clear();
		updatecustomeruserfirstname.sendKeys(customeruser_firstname_1);
		updatecustomerusermiddlename.clear();
		updatecustomerusermiddlename.sendKeys(customeruser_middlename_1);
		updatecustomeruserlastname.clear();
		updatecustomeruserlastname.sendKeys(customeruser_lastname_1);
		updatecustomeruserphonenumber.clear();
		updatecustomeruserphonenumber.sendKeys(customeruser_phonenumber_value);
	}
	public void customeruserselectnewcountyandnewRole() {
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='country']")));
		 dropdown1.selectByVisibleText("Aland Islands");
		 
	Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='roles']")));
	dropdown2.selectByVisibleText("Billing Contact");
		 
}
	 public void updatecustomeruser()
	   {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",updatebutton );   
}	
	
}
