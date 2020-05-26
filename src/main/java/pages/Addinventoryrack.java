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

public class Addinventoryrack {

	public static WebDriver driver;

	public Addinventoryrack(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='btn']")
	public WebElement addrack;

	@FindBy(how = How.XPATH, using = "//input[@id='modelName']")
	public WebElement modelname;

	@FindBy(how = How.XPATH, using = "//input[@id='rackSize']")
	public WebElement size;

	@FindBy(how = How.XPATH, using = "//textarea[@id='notes']")
	public WebElement racknotes;

	@FindBy(how = How.XPATH, using = "//input[@id='addNewLibBtn']")
	public WebElement save;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnInventorymanagementandRack() throws Exception {
		sbloginoobj.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[@class='Inventory Management']"));
		actions.moveToElement(mainMenu);
		actions.click().build().perform();

		WebElement subMenu = driver.findElement(By.xpath("//a[@href='http://seaborn.cloudsmartz.com/group/service-provider/rack'][contains(.,'Rack')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(7000);
	}

	public void clickonaddrack() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addrack);
		Thread.sleep(7000);
	}

	public void AddRackselectracktypeandManufacturernameandLocation() throws InterruptedException {
		WebElement racktype = driver.findElement(By.xpath("//span[contains(@aria-controls,'rackTypeId_listbox')]"));
		racktype.click();
		Thread.sleep(3000);
		WebElement racktypevalue = driver.findElement(By.xpath("//li[@tabindex='-1'][contains(.,'Cabinet Rack')]"));
		racktypevalue.click();
		Thread.sleep(3000);

		WebElement rackmanufacturername = driver.findElement(By.xpath("//span[contains(@aria-controls,'manufacturerId_listbox')]"));
		rackmanufacturername.click();
		Thread.sleep(3000);
		WebElement manufacturernamevalue = driver.findElement(By.xpath("//li[@tabindex='-1'][contains(.,'Cisco')]"));
		manufacturernamevalue.click();
		Thread.sleep(3000);

		WebElement location = driver.findElement(By.xpath("//span[contains(@aria-controls,'datacenterId_listbox')]"));
		location.click();
		Thread.sleep(3000);
		WebElement locationvalue = driver.findElement(By.xpath("//li[@tabindex='-1'][contains(.,'CLS - Wall')]"));
		locationvalue.click();

	}

	public void addrackSelectvalues(String Model_name_1, String Size_1, String Racknotes_1) {

		modelname.sendKeys(Model_name_1);
		size.sendKeys(Size_1);
		racknotes.sendKeys(Racknotes_1);

	}

	public void addnewrack() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
	}
}
