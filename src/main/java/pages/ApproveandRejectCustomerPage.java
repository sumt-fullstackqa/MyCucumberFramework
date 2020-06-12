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

public class ApproveandRejectCustomerPage {

	public static WebDriver driver;

	@SuppressWarnings("static-access")
	public ApproveandRejectCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//textarea[@class='bootbox-input bootbox-input-textarea form-control']")
	public WebElement rejectreason;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn btn-primary']")
	public WebElement savebuttonforreject;

	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'k-icon k-i-filter')])[6]")
	public WebElement statusfiltericon;

	@FindBy(how = How.XPATH, using = "//div[@class='k-animation-container']//input[2]")
	public WebElement filterinputfield;

	@FindBy(how = How.XPATH, using = "//button[@type='submit'][contains(.,'Filter')]")
	public WebElement filterbutton;

	@FindBy(how = How.XPATH, using = "//*[text()=' Create New & Approve']")
	public WebElement createnewandapprove;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickonthreedottediconandrejectlink() throws Exception {
		sbloginoobj.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		Actions threedottedicon = new Actions(driver);
		WebElement mainMenurejectuser = driver
				.findElement(By.xpath("(//div[contains(@class,'control actions-three-dot-menu')])[1]"));
		threedottedicon.moveToElement(mainMenurejectuser);
		threedottedicon.click().build().perform();
		Thread.sleep(5000);

		WebElement subMenudrejectuser = driver.findElement(By.xpath("//a[@href='#'][contains(.,'Reject')]"));
		threedottedicon.moveToElement(subMenudrejectuser);
		threedottedicon.click().build().perform();
		Thread.sleep(7000);
	}

	public void rejectcustomerreason(String Reject_Customer_Reason_1) throws InterruptedException {
		rejectreason.sendKeys(Reject_Customer_Reason_1);
		Thread.sleep(3000);
	}

	public void clickonsavebuttonforrejectcustomer() throws Exception {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", savebuttonforreject);
		Thread.sleep(5000);
	}

	public void Successmessageforrejectcustomer() throws Exception {

		WebElement msg = driver.findElement(By.id("customerMsg"));
		String text = msg.getText();
		if (msg.isEnabled() && text.contains("rejected successfully")) {
			System.out.println("rejection process completed");
		} else {
			System.out.println("Rejection failed");
			Thread.sleep(5000);
		}
	}

	public void clickonstatusfilterandfilterrejectedcustomers(String Filter_Field_Rejected_1) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", statusfiltericon);
		Thread.sleep(5000);
		filterinputfield.clear();
		filterinputfield.sendKeys(Filter_Field_Rejected_1);
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", filterbutton);
		Thread.sleep(5000);
	}

	public void clickonthreedottediconandapprovelink() throws Exception {
		Actions threedottedicon1 = new Actions(driver);
		WebElement mainMenuapproveuser = driver
				.findElement(By.xpath("(//div[contains(@class,'control actions-three-dot-menu')])[1]"));
		threedottedicon1.moveToElement(mainMenuapproveuser);
		threedottedicon1.click().build().perform();

		WebElement subMenuapproveuser = driver.findElement(By.xpath("(//a[@href='#'][contains(.,'Approve')])[1]"));
		threedottedicon1.moveToElement(subMenuapproveuser);
		threedottedicon1.click().build().perform();
		Thread.sleep(5000);
	}

	public void clickoncreatenewandapprovebutton() throws Exception {

		createnewandapprove.click();
		Thread.sleep(5000);
	}

	public void Successmessageforapproveuser() throws Exception {

		WebElement msg1 = driver.findElement(By.id("customerMsg"));
		String text1 = msg1.getText();
		if (msg1.isEnabled() && text1.contains("approved successfully")) {
			System.out.println("customer approved");
		} else {
			System.out.println("customer not approved");
			Thread.sleep(5000);
		}
	}

}
