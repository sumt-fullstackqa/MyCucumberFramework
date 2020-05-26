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

public class Addcompany {

	public static WebDriver driver;

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
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",add_new_company );
		Thread.sleep(5000);
	}

	public void companySelectvalues(String company_name_1, String company_email_1,String company_firstname_1, String company_lastname_1,String contactnumber_value, String corporatecontactnumber_value, String taxid_value, String postalcode_value, String address_1, String city_1) {

		customer_name.sendKeys(company_name_1);
		customer_email.sendKeys(company_email_1);
		firstname.sendKeys(company_firstname_1);
		lastname.sendKeys(company_lastname_1);
		contactnumber.sendKeys(contactnumber_value);
		corporatecontactnumber.sendKeys(corporatecontactnumber_value);
		TaxID.sendKeys(taxid_value);
		postalcode.sendKeys(postalcode_value);
		address.sendKeys(address_1);
		city.sendKeys(city_1);
		
	}
	public void companyselectcountyandstate() {
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='customerCountryID']")));
		 dropdown1.selectByVisibleText("Afghanistan");
		 
	Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='customerStateID']")));
	dropdown2.selectByVisibleText("Badakhshan");
		 
}
	 public void createcompany()
	   {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",save );
}	
	
}
