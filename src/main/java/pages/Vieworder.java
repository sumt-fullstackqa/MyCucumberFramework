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

public class Vieworder {

	public static WebDriver driver;

	public Vieworder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='previousBtn']")
	public WebElement Previousbutton;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnManageordersandorderlist() throws Exception {
		sbloginoobj.Login(ConfigProperties.CUSTOMERUSEREMAIL, ConfigProperties.CUSTOMERPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[@class='Manage Orders']"));
		actions.moveToElement(mainMenu);
		Thread.sleep(4000);

		WebElement subMenu = driver.findElement(By.xpath("//span[contains(text(),'Order List')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(7000);
	}

	public void clickOnThreedottedandViewdetails() throws InterruptedException {
		Actions actions1 = new Actions(driver);
		WebElement mainMenu1 = driver.findElement(By.xpath("(//div[@class='control actions-three-dot-menu'][contains(.,'View Details')])[1]"));
		actions1.moveToElement(mainMenu1);
		actions1.click().build().perform();
		Thread.sleep(4000);

		WebElement subMenu1 = driver.findElement(By.xpath("//div[@class='box three-dot-menu is-open']//span[contains(text(),'View Details')]"));
		actions1.moveToElement(subMenu1);
		actions1.click().build().perform();
		Thread.sleep(5000);
	}

	public void clickonpreviousbutton() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Previousbutton);
		Thread.sleep(5000);
	}

}
