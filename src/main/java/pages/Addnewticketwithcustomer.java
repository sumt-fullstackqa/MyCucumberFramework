package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import stepDefinition.TestBase;
import utility.ConfigProperties;

public class Addnewticketwithcustomer extends TestBase {

	public static WebDriver driver;

	@SuppressWarnings("static-access")
	public Addnewticketwithcustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='Tickets']")
	public WebElement add_new_ticketwithcustomer;

	@FindBy(how = How.XPATH, using = "//a[@id='addCustomerTicketButton']")
	public WebElement addcustomerticket;

	@FindBy(how = How.XPATH, using = "//input[@id='ticketName']")
	public WebElement ticketname;

	@FindBy(how = How.XPATH, using = "//textarea[@id='ticketDescription']")
	public WebElement ticketdescription;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Yes')]")
	public WebElement isservicedown;

	@FindBy(how = How.XPATH, using = "//input[@id='files']")
	public WebElement selectfiles;

	@FindBy(how = How.XPATH, using = "//input[@id='saveCustomerTicketBtn']")
	public WebElement customerticketsavebutton;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnAddNewticketwithcustomer() throws Exception {
		sbloginoobj.Login(ConfigProperties.CUSTOMERUSEREMAIL, ConfigProperties.CUSTOMERPASSWORD);
		sbloginoobj.clicksignin();
		ClickOn(driver, add_new_ticketwithcustomer, 15);
		executionDelay(10);

	}

	public void clickonRaiseticketbutton() throws Exception {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addcustomerticket);
		Thread.sleep(5000);
	}

	public void customerticketSelectvalues(String description_1) throws InterruptedException {

		inputText(ticketname, getSaltString());
		ticketdescription.sendKeys(description_1);
		Thread.sleep(4000);

	}

	public void customerticketselectticketfor() throws InterruptedException {

		WebElement ticketfor = driver.findElement(By.xpath("//span[contains(@class,'k-input single_dropdown')]"));
		ticketfor.click();
		Thread.sleep(3000);
		WebElement ticketforvalue = driver.findElement(By.xpath("//div[@class='k-animation-container']//li[2]"));
		ticketforvalue.click();
	}

	public void isyourservicedown() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", isservicedown);
		Thread.sleep(3000);
	}

	public void addattachment() throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", selectfiles);
		Thread.sleep(3000);
		WebElement chooseFile = driver.findElement(By.xpath("//input[@id='files']"));
		File file = new File("src/main/resources/Uploadfile/Ticketing uplaod file.txt");
		chooseFile.sendKeys(file.getAbsolutePath());
		Thread.sleep(3000);
	}

	public void createnewcustomerticket() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", customerticketsavebutton);
	}

}
