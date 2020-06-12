package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import stepDefinition.TestBase;
import utility.ConfigProperties;

public class Addinventoryinterconnect extends TestBase {

	public static WebDriver driver;

	@SuppressWarnings("static-access")
	public Addinventoryinterconnect(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='btn']")
	public WebElement addinterconnect;
	
	@FindBy(how = How.XPATH, using = "//input[@id='interconnectIdentifier']")
	public WebElement interconnectid;

	@FindBy(how = How.XPATH, using = "//input[@id='circuitId']")
	public WebElement circuitid;

	@FindBy(how = How.XPATH, using = "//textarea[@id='description']")
	public WebElement description;

	@FindBy(how = How.XPATH, using = "//input[@id='addNewInterConnectBtn']")
	public WebElement save;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnInventorymanagementandInterconnect() throws Exception {
		sbloginoobj.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[@class='Inventory Management']"));
		actions.moveToElement(mainMenu);
		actions.click().build().perform();

		WebElement subMenu = driver.findElement(By.xpath(
				"//a[@href='http://seaborn.cloudsmartz.com/group/service-provider/interconnect'][contains(.,'Interconnect')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(7000);
	}

	public void clickonaddinterconnect() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addinterconnect);
		Thread.sleep(7000);
	}

	public void AddInterconnectselectSourcedeviceandselectDestinationdeviceandselectSourceportandselectDestinationport()
			throws InterruptedException {
		WebElement sourcedevice = driver.findElement(By.xpath("//span[contains(@aria-controls,'sourceDeviceId_listbox')]"));
		sourcedevice.click();
		Thread.sleep(3000);
		WebElement sourcedevicevalue = driver.findElement(By.xpath("(//li[@tabindex='-1'][contains(.,'1-A (INV-CHASSIS-1-A)')])[1]"));
		sourcedevicevalue.click();
		Thread.sleep(3000);

		WebElement destinationdevice = driver.findElement(By.xpath("//span[contains(@aria-controls,'destinationDeviceId_listbox')]"));
		destinationdevice.click();
		Thread.sleep(3000);
		WebElement destinationdevicevalue = driver.findElement(By.xpath("(//li[@tabindex='-1'][contains(.,'1-A-1 (INV-NJ7-1-A)')])[2]"));
		destinationdevicevalue.click();
		Thread.sleep(3000);
	
		WebElement sourceport = driver.findElement(By.xpath("//span[contains(@aria-controls,'sourceDevicePortId_listbox')]"));
		sourceport.click();
		Thread.sleep(3000);
		WebElement sourceportvalue = driver.findElement(By.xpath("(//li[@tabindex='-1'][contains(.,'3-1')])[3]"));
		sourceportvalue.click();
		Thread.sleep(3000);
		
		WebElement destinationport = driver.findElement(By.xpath("//span[contains(@aria-controls,'destinationDevicePortId_listbox')]"));
		destinationport.click();
		Thread.sleep(3000);
		WebElement destinationportvalue = driver.findElement(By.xpath("(//li[@tabindex='-1'][contains(.,'3-2')])[2]"));
		destinationportvalue.click();
		Thread.sleep(5000);
	}

	public void addinterconnectSelectvalues(String Interconnect_Description_1) throws InterruptedException {

		
		inputText(interconnectid, getSaltString());
		inputText(circuitid, getSaltString());
		description.sendKeys(Interconnect_Description_1);	
		Thread.sleep(5000);
	}
	
	public void addnewinterconnect() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
	}
}
