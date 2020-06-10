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

import stepDefinition.TestBase;
import utility.ConfigProperties;

public class EditUserPage {

	public static WebDriver driver;

	public EditUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='User Management']")
	public WebElement usermanagementmenu;
	
	@FindBy(how = How.XPATH, using = "//input[@id='emailAddress']")
	public WebElement updateuser_email;

	@FindBy(how = How.XPATH, using = " //input[@id='firstName']")
	public WebElement updateuserfirstname;

	@FindBy(how = How.XPATH, using = "//input[@id='middleName']")
	public WebElement updateusermiddlename;

	@FindBy(how = How.XPATH, using = "//input[@id='lastName']")
	public WebElement updateuserlastname;

	@FindBy(how = How.XPATH, using = "//input[@id='phoneNumber']")
	public WebElement updateuserphonenumber;

	@FindBy(how = How.XPATH, using = "//input[@id='saveManagerUserBtn']")
	public WebElement updatebutton;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnUserManagementmenu() throws Exception {
		sbloginoobj.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		usermanagementmenu.click();
		Thread.sleep(5000);
	}

	public void clickonthreedottediconandeditlink() throws Exception {
		Actions threedottedicon = new Actions(driver);
		WebElement mainMenuedituser = driver.findElement(By.xpath("(//div[contains(@class,'control actions-three-dot-menu')])[1]"));
		threedottedicon.moveToElement(mainMenuedituser);
		threedottedicon.click().build().perform();

		WebElement subMenuedituser = driver.findElement(By.xpath("(//a[@href='#'][contains(.,'Edit')])[1]"));
		threedottedicon.moveToElement(subMenuedituser);
		threedottedicon.click().build().perform();
		Thread.sleep(5000);
	}
	public void userUpdatevalues(String user_email_1, String user_firstname_1,String user_middlename_1, String user_lastname_1,String user_phonenumber_value ) {

		updateuser_email.clear();
		updateuser_email.sendKeys(user_email_1);
		updateuserfirstname.clear();
		updateuserfirstname.sendKeys(user_firstname_1);
		updateusermiddlename.clear();
		updateusermiddlename.sendKeys(user_middlename_1);
		updateuserlastname.clear();
		updateuserlastname.sendKeys(user_lastname_1);
		updateuserphonenumber.clear();
		updateuserphonenumber.sendKeys(user_phonenumber_value);
	}
	public void userselectnewcountyandnewRole() {
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='country']")));
		 dropdown1.selectByVisibleText("Aland Islands");
		 
	Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='roles']")));
	dropdown2.selectByVisibleText("Billing Contact");
		 
}
	 public void updateuser()
	   {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",updatebutton );   
}	
	 public void Successmessageforupdateuser() throws Exception {

			WebElement msg1 = driver.findElement(By.id("manageUserMsg"));
			String text1 = msg1.getText();
			if (msg1.isEnabled() && text1.contains("updated successfully")) {
				System.out.println("user updated");
			} else {
				System.out.println("user update failed");
				Thread.sleep(5000);
			}
		}
	
}
