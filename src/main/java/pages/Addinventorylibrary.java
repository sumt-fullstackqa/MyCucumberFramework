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

public class Addinventorylibrary {

	public static WebDriver driver;

	public Addinventorylibrary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = " //a[@class='btn']")
	public WebElement addlibrary;
	
	@FindBy(how = How.XPATH, using = "//input[@id='libraryDeviceName']")
	public WebElement devicemodel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='rackUnitSize']")
	public WebElement racksize;
	
	@FindBy(how = How.XPATH, using = "//textarea[@id='deviceNotes']")
	public WebElement notes;

	@FindBy(how = How.XPATH, using = "//input[@id='addNewLibBtn']")
	public WebElement save;
	
	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnInventorymanagementandLibrary() throws Exception {
		sbloginoobj.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[@class='Inventory Management']"));
		actions.moveToElement(mainMenu);
		actions.click().build().perform();

		WebElement subMenu = driver.findElement(By.xpath("//a[@href='http://seaborn.cloudsmartz.com/group/service-provider/inventory-management/library'][contains(.,'Library')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(7000);
	}


	public void clickonaddlibrary() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addlibrary);
		Thread.sleep(7000);	
	}

	public void Addlibraryselectdevicetypeandmanufacturername() throws InterruptedException {
		WebElement devicetype=driver.findElement(By.xpath("//span[contains(@aria-controls,'deviceTypeId_listbox')]"));
		devicetype.click();
		Thread.sleep(3000);
		WebElement devicetypevalue=driver.findElement(By.xpath("(//li[@tabindex='-1'][contains(.,'Chassis')])[1]"));
		devicetypevalue.click();
		
		WebElement manufacturername=driver.findElement(By.xpath("//span[contains(@aria-controls,'manufacturerId_listbox')]"));
		manufacturername.click();
		Thread.sleep(3000);
		WebElement manufacturernamevalue=driver.findElement(By.xpath("//li[@tabindex='-1'][contains(.,'Cisco')]"));
		manufacturernamevalue.click();
	
}
	
	public void addlibrarySelectvalues(String Device_model_1, String Notes_1, String Racksize_1) {

		devicemodel.sendKeys(Device_model_1);
		notes.sendKeys(Notes_1);
		racksize.sendKeys(Racksize_1);
		
	}
	
	 public void addnewlibrary()
	   {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
}
}

