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

import helperLogger.LoggerHelper;
import stepDefinition.TestBase;
import utility.ConfigProperties;

public class Viewreportingtabs {

	public static WebDriver driver;
	
	Logger log = LoggerHelper.getLogger(Viewreportingtabs.class);

	public Viewreportingtabs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Overdue Tickets')]")
	public WebElement overdue;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Ticket Response Rate')]")
	public WebElement ticketresponserate;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'First Time Response')]")
	public WebElement firsttimeresponse;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Ticket Count')]")
	public WebElement ticketcount;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Outage Tickets')]")
	public WebElement outage;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Unattended Tickets')]")
	public WebElement Unattended;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reopened Tickets')]")
	public WebElement reopened;
	
	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnTicketmanagementandReports() throws Exception {
		sbloginoobj.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[@class='Ticket Management']"));
		actions.moveToElement(mainMenu);
		actions.click().build().perform();
		Thread.sleep(4000);

		WebElement subMenu = driver.findElement(By.xpath("//a[contains(.,'Reports')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(7000);
	}


	public void clickonallreportingtabsonebyone() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", overdue );
		Thread.sleep(5000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ticketresponserate);
		Thread.sleep(5000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firsttimeresponse);
		Thread.sleep(5000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ticketcount);
		Thread.sleep(5000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", outage);
		Thread.sleep(5000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Unattended);
		Thread.sleep(5000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", reopened);
		Thread.sleep(5000);
		
	}

}

