/**
 * 
 */


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

/**
 * @author sumit.mishra
 *
 */

public class AssignRoletoCustomeruserpage extends TestBase {

	public static WebDriver driver;

	@SuppressWarnings("static-access")
	public AssignRoletoCustomeruserpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='User Management']")
	public WebElement customerusermanagementmenu;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Assign Roles')]")
	public WebElement assignrolestab;

	@FindBy(how = How.XPATH, using = "(//input[contains(@type,'checkbox')])[4]")
	public WebElement customeradmincheckbox;

	@FindBy(how = How.XPATH, using = "//input[@id='saveRoleAssignmentBtn']")
	public WebElement assignbutton;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnCustomerUserManagementmenuforcustomeradmin() throws Exception {
		sbloginoobj.Login(ConfigProperties.CUSTOMERUSEREMAIL, ConfigProperties.CUSTOMERPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		customerusermanagementmenu.click();
		Thread.sleep(5000);
	}

	public void clickonthreedottediconandassignroleslink() throws Exception {
		Actions threedottedicon = new Actions(driver);
		WebElement mainMenuassignroles = driver
				.findElement(By.xpath("(//div[contains(@class,'control actions-three-dot-menu')])[1]"));
		threedottedicon.moveToElement(mainMenuassignroles);
		threedottedicon.click().build().perform();
		Thread.sleep(8000);

		WebElement subMenuassignroles = driver.findElement(By.xpath("(//a[@href='#'][contains(.,'Assign Roles')])[1]"));
		threedottedicon.moveToElement(subMenuassignroles);
		threedottedicon.click().build().perform();
		Thread.sleep(7000);
	}

	public void clickonassignrolestab() throws Exception {
		
      	ClickOn(driver, assignrolestab, 5);
		Thread.sleep(5000);
	}

	public void clickoncustomeradminrolecheckbox() throws Exception {
		
	    ClickOn(driver, customeradmincheckbox, 5);
		Thread.sleep(5000);
	}

	public void clickonassignbutton() throws Exception {

		assignbutton.click();
		Thread.sleep(5000);
	}

	public void Successmessageforrolesupdated() throws Exception {

		WebElement msg1 = driver.findElement(By.id("manageUserMsg"));
		String text1 = msg1.getText();
		if (msg1.isEnabled() && text1.contains("successfully updated")) {
			System.out.println("Roles updated");
		} else {
			System.out.println("Roles updation failed");
			Thread.sleep(5000);
		}
	}

}
