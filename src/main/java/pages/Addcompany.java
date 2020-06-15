/**
 * 
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import stepDefinition.TestBase;
import utility.ConfigProperties;

/**
 * @author sumit.mishra
 *
 */

public class Addcompany extends TestBase {

	public static WebDriver driver;
	static String emailAddress;

	@SuppressWarnings("static-access")
	public Addcompany(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@data-toggle='modal'][contains(.,'Add New Company')]")
	public WebElement add_new_company;

	@FindBy(how = How.XPATH, using = "//input[@name='customerName']")
	public WebElement customer_name;

	@FindBy(how = How.XPATH, using = "//input[@name='adminEmailAddress']")
	public WebElement customer_email;

	@FindBy(how = How.XPATH, using = "//input[@id='adminFirstName']")
	public WebElement firstname;

	@FindBy(how = How.XPATH, using = "//input[@id='adminLastName']")
	public WebElement lastname;

	@FindBy(how = How.XPATH, using = "//input[@id='adminContactNumber']")
	public WebElement contactnumber;

	@FindBy(how = How.XPATH, using = "//input[@id='customerContactNumber']")
	public WebElement corporatecontactnumber;

	@FindBy(how = How.XPATH, using = "//input[@id='customerTaxID']")
	public WebElement TaxID;

	@FindBy(how = How.XPATH, using = "//input[@id='customerPostalCode']")
	public WebElement postalcode;

	@FindBy(how = How.XPATH, using = "//input[@id='customerAddress']")
	public WebElement address;

	@FindBy(how = How.XPATH, using = "//input[@id='customerCity']")
	public WebElement city;
	
	@FindBy(how = How.XPATH, using = "//input[@id='saveCustomerAccountButton']")
	public WebElement save;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnAddNewCompany() throws Exception {
		sbloginoobj.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);
		sbloginoobj.clicksignin();
	    ClickOn(driver, add_new_company, 5);	
	}

	public void companySelectvalues(String company_firstname_1, String company_lastname_1,String contactnumber_value, String corporatecontactnumber_value, String taxid_value, String postalcode_value, String address_1, String city_1) throws InterruptedException {

		waitForElementToBeVisible(customer_name, driver, 4000);
		inputText(customer_name, getSaltString());
		inputText(customer_email, getSaltString()+"@gmail.com");
		emailAddress = customer_email.getAttribute("value");
	     sendKeys(driver, firstname, 5, company_firstname_1);
	     sendKeys(driver, lastname, 5, company_lastname_1);
	     sendKeys(driver, contactnumber, 5, contactnumber_value);
	     sendKeys(driver, corporatecontactnumber, 5, corporatecontactnumber_value);
	     sendKeys(driver, TaxID, 5, taxid_value);
	     sendKeys(driver, postalcode, 5, postalcode_value);
	     sendKeys(driver, address, 5, address_1);
	     sendKeys(driver, city, 5, city_1);	
	}
	public void companyselectcountyandstate() throws InterruptedException {
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='customerCountryID']")));
		 dropdown1.selectByVisibleText("Afghanistan");
		 Thread.sleep(4000);
		 
	Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='customerStateID']")));
	dropdown2.selectByVisibleText("Badakhshan");
	Thread.sleep(3000);
		 
}
	 public void createcompany()
	   {
		ClickOn(driver, save, 5);
}	
	
}
