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

public class Createnewbillingaccount {

	public static WebDriver driver;

	@SuppressWarnings("static-access")
	public Createnewbillingaccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='Billing Accounts Management']")
	public WebElement create_new_billingaccount;
	
	@FindBy(how = How.XPATH, using = "//a[@class='btn']")
	public WebElement addnewaccount;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@name,'billingCustomerName')]")
	public WebElement Billingcompany;

	@FindBy(how = How.XPATH, using = "//input[contains(@name,'billingAddress')]")
	public WebElement Billingaddress;

	@FindBy(how = How.XPATH, using = "//input[@id='billingContactNumber']")
	public WebElement billingcontactnumber;

	@FindBy(how = How.XPATH, using = "//input[@id='billingCity']")
	public WebElement billingcity;

	@FindBy(how = How.XPATH, using = "//input[@id='billingPostalCode']")
	public WebElement billingpostalcode;

	@FindBy(how = How.XPATH, using = "//input[@id='billingFax']")
	public WebElement billingfax;
	
	@FindBy(how = How.XPATH, using = "//input[@id='saveCustomerBillingAccountButton']")
	public WebElement billingaccountsavebutton;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnAddNewbillingaccount() throws Exception {
		sbloginoobj.Login(ConfigProperties.CUSTOMERUSEREMAIL, ConfigProperties.CUSTOMERPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		create_new_billingaccount.click();
	}

	public void clickonAddnewaccountbutton() throws Exception {
		
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",addnewaccount );
		 Thread.sleep(5000);
	}
	public void billingSelectvalues(String billing_company_1, String billing_address_1, String billing_contactnumber_value,String billing_city_1, String billing_postalcode_value, String billing_fax_value ) {

		Billingcompany.sendKeys(billing_company_1);
		Billingaddress.sendKeys(billing_address_1);
		billingcontactnumber.sendKeys(billing_contactnumber_value);
		billingcity.sendKeys(billing_city_1);
		billingpostalcode.sendKeys(billing_postalcode_value);
		billingfax.sendKeys(billing_fax_value);
	}
	public void billingselectcurrencycountryandstate() {
		Select currencydropdown = new Select(driver.findElement(By.xpath("//select[@id='billingCurrencyID']")));
		 currencydropdown.selectByVisibleText("US Dollar(USD)");
		 
	Select countrydropdown = new Select(driver.findElement(By.xpath("//select[@id='billingCountryID']")));
	countrydropdown.selectByVisibleText("Afghanistan");
	
	Select statedropdown = new Select(driver.findElement(By.xpath("//select[@id='billingStateID']")));
	statedropdown.selectByVisibleText("Badakhshan");
		 
}
	 public void createbillingaccount()
	   {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",billingaccountsavebutton );
}	
	
}
