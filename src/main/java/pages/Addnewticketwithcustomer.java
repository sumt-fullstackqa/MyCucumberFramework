package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

import configreader.ObjectRepo;
import stepDefinition.TestBase;
import utility.ConfigProperties;

public class Addnewticketwithcustomer {

	public static WebDriver driver;

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
		Thread.sleep(5000);
		add_new_ticketwithcustomer.click();
	}

	public void clickonRaiseticketbutton() throws Exception {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addcustomerticket);
		Thread.sleep(5000);
	}

	public void customerticketSelectvalues(String Ticket_name_1, String description_1) {

		ticketname.sendKeys(Ticket_name_1);
		ticketdescription.sendKeys(description_1);

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
