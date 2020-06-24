/**
 * 
 */

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

/**
 * @author sumit.mishra
 *
 */

public class AssignPortPage extends TestBase {

	public static WebDriver driver;
	
	Logger log = LoggerHelper.getLogger(AssignPortPage.class);

	@SuppressWarnings("static-access")
	public AssignPortPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='Display_Name']")
	public WebElement portdisplaynamefield;

	@FindBy(how = How.XPATH, using = "//input[@id='addBtn']")
	public WebElement addbutton;

	@FindBy(how = How.XPATH, using = "//input[contains(@name,'assigedPortList')]")
	public WebElement addedportcheckbox;

	@FindBy(how = How.XPATH, using = "//input[@id='assignBtn']")
	public WebElement assignbuttonport;
		
	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnInventorymanagementandManagePort() throws Exception {
		sbloginoobj.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[@class='Inventory Management']"));
		actions.moveToElement(mainMenu);
		actions.click().build().perform();
		Thread.sleep(5000);

		WebElement subMenu = driver.findElement(By.xpath(
				"//a[@href='http://seaborn.cloudsmartz.com/group/service-provider/manage-port'][contains(.,'Manage Port')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(7000);
	}

	public void clickonthreedottediconandassignportlink() throws Exception {
		Actions threedottedicon = new Actions(driver);
		WebElement mainMenuassignroles = driver.findElement(
				By.xpath("(//div[@class='control actions-three-dot-menu'][contains(.,'Assign Port')])[1]"));
		threedottedicon.moveToElement(mainMenuassignroles);
		threedottedicon.click().build().perform();
		Thread.sleep(5000);

		WebElement subMenuassignroles = driver.findElement(By.xpath("(//a[@href='#'][contains(.,'Assign Port')])[1]"));
		threedottedicon.moveToElement(subMenuassignroles);
		threedottedicon.click().build().perform();
		Thread.sleep(5000);
	}

	public void AssignPortselectlocationandinventoryandportandbillingaccount() throws InterruptedException {
		Select location = new Select(driver.findElement(By.xpath("//select[@id='Data_Center_Code']")));
		location.selectByValue("4");
		Thread.sleep(4000);

		Select inventory = new Select(driver.findElement(By.xpath("//select[@id='Device']")));
		inventory.selectByValue("148");
		Thread.sleep(4000);

		Select port = new Select(driver.findElement(By.xpath("//select[@id='Port']")));
		port.selectByIndex(1);
		Thread.sleep(4000);

		Select billingaccount = new Select(driver.findElement(By.xpath("//select[@id='billingAccountId']")));
		billingaccount.selectByValue("212378");
		Thread.sleep(4000);

	}

	public void AssignportSelectvalues() throws InterruptedException {
		
		inputText(portdisplaynamefield, getSaltString());
		Thread.sleep(3000);
	}

	public void clickonaddbutton() throws Exception {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addbutton);
		Thread.sleep(5000);
	}

	public void clickonaddedvaluecheckboxinassignedportlist() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addedportcheckbox);
		Thread.sleep(5000);
	}

	public void clickonassignbuttonforport() throws Exception {

		assignbuttonport.click();
		Thread.sleep(5000);
	}

	public void Successmessageforassignedport() throws Exception {

		WebElement msg1 = driver.findElement(By.id("customerMsg"));
		String text1 = msg1.getText();
		if (msg1.isEnabled() && text1.contains("Assigned Successfully")) {
			System.out.println("new port assigned to company");
		} else {
			System.out.println("Port assignment Failed");
			Thread.sleep(12000);
		}
	}

	
}
