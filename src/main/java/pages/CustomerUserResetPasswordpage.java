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

public class CustomerUserResetPasswordpage {

	public static WebDriver driver;

	public CustomerUserResetPasswordpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='User Management']")
	public WebElement customerusermanagementmenu;

	@FindBy(how = How.XPATH, using = "//input[@id='newPassword']")
	public WebElement newpassword;

	@FindBy(how = How.XPATH, using = "//input[@id='confirmPassword']")
	public WebElement confirmpassword;

	@FindBy(how = How.XPATH, using = "//input[@id='savePasswordBtn']")
	public WebElement okbuttonresetpassword;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnCustomerUserManagementmenu() throws Exception {
		sbloginoobj.Login(ConfigProperties.CUSTOMERUSEREMAIL, ConfigProperties.CUSTOMERPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		customerusermanagementmenu.click();
		Thread.sleep(5000);
	}

	public void clickonthreedottediconandresetpasswordlink() throws Exception {
		Actions threedottedicon2 = new Actions(driver);
		WebElement mainMenuresetpassword = driver
				.findElement(By.xpath("(//div[contains(@class,'control actions-three-dot-menu')])[1]"));
		threedottedicon2.moveToElement(mainMenuresetpassword);
		threedottedicon2.click().build().perform();
		Thread.sleep(5000);

		WebElement subMenuresetpassword = driver
				.findElement(By.xpath("(//a[@href='#'][contains(.,'Reset Password')])[1]"));
		threedottedicon2.moveToElement(subMenuresetpassword);
		threedottedicon2.click().build().perform();
		Thread.sleep(5000);
	}

	public void customeruserresetpasswordSelectvalues(String New_Password_1, String Confirm_Password_1)
			throws InterruptedException {

		newpassword.sendKeys(New_Password_1);
		confirmpassword.sendKeys(Confirm_Password_1);
		Thread.sleep(3000);
	}

	public void clickonokbuttonforresetpassword() throws Exception {

		okbuttonresetpassword.click();
		Thread.sleep(5000);
	}

	public void Successmessageforresetpasswordcustomeruser() throws Exception {

		WebElement msg2 = driver.findElement(By.id("manageUserMsg"));
		String text2 = msg2.getText();
		if (msg2.isEnabled() && text2.contains("reset successfully.")) {
			System.out.println("reset password process completed");
		} else {
			System.out.println("reset password failed");
			Thread.sleep(5000);
		}
	}

}
