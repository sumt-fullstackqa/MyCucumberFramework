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

public class Addinventorypage extends TestBase {

	public static WebDriver driver;

	@SuppressWarnings("static-access")
	public Addinventorypage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='btn']")
	public WebElement addinventory;
	
	@FindBy(how = How.XPATH, using = "//select[@id='rackStartUnit']")
	public WebElement rackstartunit;

	@FindBy(how = How.XPATH, using = "//input[@id='deviceName']")
	public WebElement devicename;

	@FindBy(how = How.XPATH, using = "//input[@id='inventoryId']")
	public WebElement inventoryid;

	@FindBy(how = How.XPATH, using = "//input[@id='serialNo']")
	public WebElement serialno;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ipAddress']")
	public WebElement ipaddress;
	
	@FindBy(how = How.XPATH, using = "//textarea[@id='note']")
	public WebElement inventorynotes;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@name,'statusName_input')]")
	public WebElement inventorystatus;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Device for LOA')]")
	public WebElement deviceforloa;
	
	@FindBy(how = How.XPATH, using = "//input[@id='addInventoryBtn']")
	public WebElement save;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnInventorymanagementandInventory() throws Exception {
		sbloginoobj.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[@class='Inventory Management']"));
		actions.moveToElement(mainMenu);
		actions.click().build().perform();

		WebElement subMenu = driver.findElement(By.xpath(
				"//a[@href='http://seaborn.cloudsmartz.com/group/service-provider/inventory'][contains(.,'Inventory')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(7000);
	}

	public void clickonaddinventory() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addinventory);
		Thread.sleep(7000);
	}

	public void AddInventoryselectDeviceModelandselectLocationandselectVlanStartRangeandselectVlanEndRangeandselectRackandselectrackstartunit()
			throws InterruptedException {
		WebElement devicemodel = driver.findElement(By.xpath("//span[contains(@aria-controls,'deviceModelName_listbox')]"));
		devicemodel.click();
		Thread.sleep(5000);
		
		WebElement devicemodelvalue = driver.findElement(By.xpath("(//li[@tabindex='-1'][contains(.,'1-A')])[1]"));
		devicemodelvalue.click();
		Thread.sleep(5000);

		WebElement inventorylocation = driver.findElement(By.xpath("//span[contains(@aria-controls,'location_listbox')]"));
		inventorylocation.click();
		Thread.sleep(5000);
		
		WebElement inventorylocationvalue = driver.findElement(By.xpath("//li[@tabindex='-1'][contains(.,'CLS - Wall (S1WLL)')]"));
		inventorylocationvalue.click();
		Thread.sleep(5000);

		Select vlanstartrange = new Select(driver.findElement(By.xpath("//select[@id='vlanStartRange']")));
		vlanstartrange.selectByVisibleText("2");
		Thread.sleep(3000);

		Select vlanendrange = new Select(driver.findElement(By.xpath("//select[@id='vlanEndRange']")));
		vlanendrange.selectByVisibleText("3");
		Thread.sleep(3000);
		
		WebElement rackdropdown = driver.findElement(By.xpath("//span[contains(@aria-controls,'rackModelName_listbox')]"));
		rackdropdown.click();
		Thread.sleep(5000);
		
		WebElement rackdropdownvalue = driver.findElement(By.xpath("//li[@tabindex='-1'][contains(.,'QFX701')]"));
		rackdropdownvalue.click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", rackstartunit );
		
		Select rackstartunit = new Select(driver.findElement(By.xpath("//select[@id='rackStartUnit']")));
		rackstartunit.selectByVisibleText("5");
		Thread.sleep(5000);
	}

	public void addinventorySelectvalues(String IPAddress_1, String notes_1, String Inventorystatus_1) throws InterruptedException {

		inputText(devicename, getSaltString());
		inputText(inventoryid, getSaltString());
		inputText(serialno, getSaltString());
		ipaddress.sendKeys(IPAddress_1);
		inventorynotes.sendKeys(notes_1);
		inventorystatus.sendKeys(Inventorystatus_1);
		Thread.sleep(5000);
	}
	
	public void clickonDeviceforLOA() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", deviceforloa );
		Thread.sleep(2000);
	}

	public void addnewinventory() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
	}
}
