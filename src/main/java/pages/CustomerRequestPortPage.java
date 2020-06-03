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

public class CustomerRequestPortPage {

	public static WebDriver driver;

	public CustomerRequestPortPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='Assigned Port']//*[local-name()='svg']")
	public WebElement assignedportmenu;
	
	@FindBy(how = How.XPATH, using = "//input[@id='requestPortBtn']")
	public WebElement requestportbutton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='displayName']")
	public WebElement portdisplaynamefield;
	
	@FindBy(how = How.XPATH, using = "//input[@id='savePort']")
	public WebElement saverequestportbutton;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnAssignedPortmenu() throws Exception {
		sbloginoobj.Login(ConfigProperties.CUSTOMERUSEREMAIL, ConfigProperties.CUSTOMERPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		assignedportmenu.click();
		Thread.sleep(3000);
	}

	public void clickonrequestportbutton() throws Exception {
		
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",requestportbutton );
		 Thread.sleep(5000);
	}
	public void requestportselectlocationandPorttypeandBillingaccount() throws InterruptedException {
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='datacenter']")));
		 dropdown1.selectByValue("15");
		 
	Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='portType']")));
	dropdown2.selectByValue("1");
	
	Select dropdown3 = new Select(driver.findElement(By.xpath("//select[@id='billingAccountId']")));
	dropdown3.selectByValue("212378");
	Thread.sleep(5000);		 
}
	public void requestportSelectvalues(String port_displayname_1) throws InterruptedException {

		portdisplaynamefield.sendKeys(port_displayname_1);
		Thread.sleep(3000);	
	}
	 public void requestport()
	   {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",saverequestportbutton );
}	
	 public void Successmessageforrequestport() throws Exception {

			WebElement msg1 = driver.findElement(By.id("assignPortMsg"));
			String text1 = msg1.getText();
			if (msg1.isEnabled() && text1.contains("created successfully")) {
				System.out.println("port requested");
			} else {
				System.out.println("port request failed");
				Thread.sleep(5000);
			}
		}
	
}
