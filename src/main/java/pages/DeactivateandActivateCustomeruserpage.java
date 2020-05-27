package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.assertEquals;
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
import stepDefinition.TestBase;

public class DeactivateandActivateCustomeruserpage {

	public static WebDriver driver;

	public DeactivateandActivateCustomeruserpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='User Management']")
	public WebElement customerusermanagementmenu;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn btn-primary']")
	public WebElement okbuttondeactivate;

	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'k-icon k-i-filter')])[4]")
	public WebElement statusfiltericon;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'Inactive')]")
	public WebElement inactiveradiobutton;

	@FindBy(how = How.XPATH, using = "//button[@class='k-button k-primary']")
	public WebElement filterbutton;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn btn-primary']")
	public WebElement okbuttonactivate;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnCustomerUserManagementmenu() throws Exception {
		sbloginoobj.Login(ConfigProperties.CUSTOMERUSEREMAIL, ConfigProperties.CUSTOMERPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		customerusermanagementmenu.click();
		Thread.sleep(5000);
	}

	public void clickonthreedottediconanddeactivatebutton() throws Exception {
		Actions threedottedicon = new Actions(driver);
		WebElement mainMenudeactivateuser = driver
				.findElement(By.xpath("(//div[contains(@class,'control actions-three-dot-menu')])[1]"));
		threedottedicon.moveToElement(mainMenudeactivateuser);
		threedottedicon.click().build().perform();
		Thread.sleep(5000);

		WebElement subMenudeactivateuser = driver.findElement(By.xpath("//div[@class='box three-dot-menu is-open']//a[@class='grid_mcdeactivate_icon']"));
		threedottedicon.moveToElement(subMenudeactivateuser);
		threedottedicon.click().build().perform();
		Thread.sleep(5000);
	}

	public void clickonokbuttonfordeactivate() throws Exception {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", okbuttondeactivate);
		Thread.sleep(5000);
	}

	public void Successmessagefordeactivatecustomeruser() throws Exception {

		WebElement msg = driver.findElement(By.id("manageUserMsg"));
		String text = msg.getText();
		if (msg.isEnabled() && text.contains("deactivated successfully.")) {
			System.out.println("deactivation process completed");
		} else {
			System.out.println("deactivation failed");
			Thread.sleep(5000);
		}
	}

	public void clickonstatusfilterandinactiveandfilterbutton() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", statusfiltericon);
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", inactiveradiobutton);
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", filterbutton);
		Thread.sleep(5000);
	}

	public void clickonthreedottediconandactivatebutton() throws Exception {
		Actions threedottedicon1 = new Actions(driver);
		WebElement mainMenuactivateuser = driver
				.findElement(By.xpath("(//div[@class='control actions-three-dot-menu'][contains(.,'Activate')])[1]"));
		threedottedicon1.moveToElement(mainMenuactivateuser);
		threedottedicon1.click().build().perform();

		WebElement subMenuactivateuser = driver.findElement(By.xpath("(//a[@href='#'][contains(.,'Activate')])[1]"));
		threedottedicon1.moveToElement(subMenuactivateuser);
		threedottedicon1.click().build().perform();
		Thread.sleep(5000);
	}

	public void clickonokbuttonforactivate() throws Exception {

		okbuttonactivate.click();
		Thread.sleep(5000);
	}

	public void Successmessageforactivatecustomeruser() throws Exception {

		WebElement msg1 = driver.findElement(By.id("manageUserMsg"));
		String text1 = msg1.getText();
		if (msg1.isEnabled() && text1.contains("activated successfully.")) {
			System.out.println("activation process completed");
		} else {
			System.out.println("activation failed");
			Thread.sleep(5000);
		}
	}

}
