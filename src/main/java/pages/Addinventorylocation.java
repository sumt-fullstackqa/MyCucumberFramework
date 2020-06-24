package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import helperLogger.LoggerHelper;
import stepDefinition.TestBase;
import utility.ConfigProperties;

public class Addinventorylocation extends TestBase {

	public static WebDriver driver;

	Logger log = LoggerHelper.getLogger(Addinventorylocation.class);
	
	@SuppressWarnings("static-access")
	public Addinventorylocation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='btn']")
	public WebElement addnewlocation;
	
	@FindBy(how = How.XPATH, using = "//input[@id='dc_name']")
	public WebElement locationname;

	@FindBy(how = How.XPATH, using = "//input[@id='dc_code']")
	public WebElement locationcode;

	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	public WebElement address;

	@FindBy(how = How.XPATH, using = "//input[@id='otherCity']")
	public WebElement othercity;
	
	@FindBy(how = How.XPATH, using = "//input[@id='zipcode']")
	public WebElement zipcode;
	
	@FindBy(how = How.XPATH, using = "//input[@id='saveBtn']")
	public WebElement savelocation;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnInventorymanagementandLocation() throws Exception {
		sbloginoobj.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[@class='Inventory Management']"));
		actions.moveToElement(mainMenu);
		actions.click().build().perform();

		WebElement subMenu = driver.findElement(By.xpath(
				"//a[@href='http://seaborn.cloudsmartz.com/group/service-provider/location'][contains(.,'Location')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(7000);
	}

	public void clickonaddnewlocation() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addnewlocation);
		Thread.sleep(7000);
	}

	public void AddNewLocationselectcountryandselectStateandselectCity()
			throws InterruptedException {
		Select country = new Select(driver.findElement(By.xpath("//select[@id='country_name']")));
		country.selectByVisibleText("Afghanistan");
		Thread.sleep(3000);

		Select state = new Select(driver.findElement(By.xpath("//select[@id='state_name']")));
		state.selectByVisibleText("Badakhshan");
		Thread.sleep(3000);
		
		Select city = new Select(driver.findElement(By.xpath("//select[@id='city_name']")));
		city.selectByVisibleText("Other");
		Thread.sleep(3000);
	
	}

	public void addnewlocationSelectvalues(String Location_Address_1, String Othercity_1, String Location_Zipcode_1) throws InterruptedException {

		inputText(locationname, getSaltString());
		inputText(locationcode, getSaltString());
		address.sendKeys(Location_Address_1);
		othercity.sendKeys(Othercity_1);
		zipcode.sendKeys(Location_Zipcode_1);
		Thread.sleep(4000);
	}
	
	public void addnewlocation() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", savelocation);
	}
}
