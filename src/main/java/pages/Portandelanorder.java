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

public class Portandelanorder extends TestBase {

	public static WebDriver driver;

	public Portandelanorder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='uniPortDisplayName']")
	public WebElement portdisplayname;

	@FindBy(how = How.XPATH, using = "//input[@id='uniDuration']")
	public WebElement portduration;

	@FindBy(how = How.XPATH, using = "//input[@id='addToCart']")
	public WebElement addtocartport;

	@FindBy(how = How.XPATH, using = "//input[@id='privateLanName']")
	public WebElement elanname;

	@FindBy(how = How.XPATH, using = "//input[@id='privateLanDuration']")
	public WebElement elanduration;

	@FindBy(how = How.XPATH, using = "//input[@id='privateLanAddToCart']")
	public WebElement addtocartelan;

	@FindBy(how = How.XPATH, using = "//button[@id='cartbutton']")
	public WebElement cartmainbutton;

	@FindBy(how = How.XPATH, using = "//div[@class='col-sm-4 text-right']//input[@id='placeOrderButton']")
	public WebElement placeorderbutton;

	@FindBy(how = How.XPATH, using = "//input[@id='referenceId']")
	public WebElement referenceid;

	@FindBy(how = How.XPATH, using = "//textarea[@id='comments']")
	public WebElement comments;

	@FindBy(how = How.XPATH, using = "//div[@class='row-fluid text-right']//button[@class='btn btn-primary'][contains(text(),'Next')]")
	public WebElement nextbutton;

	@FindBy(how = How.XPATH, using = "//input[@id='confirmOrder']")
	public WebElement confirmorder;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnManageordersandPlaceanorder() throws Exception {
		sbloginoobj.Login(ConfigProperties.CUSTOMERUSEREMAIL, ConfigProperties.CUSTOMERPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[@class='Manage Orders']"));
		actions.moveToElement(mainMenu);
		Thread.sleep(4000);

		WebElement subMenu = driver.findElement(By.xpath("//span[contains(text(),'Place an Order')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(7000);
	}

	public void clickOnThreedottedandAddbutton() throws InterruptedException {
		Actions actions1 = new Actions(driver);
		WebElement mainMenu1 = driver.findElement(By.xpath("(//div[contains(@class,'control actions-three-dot-menu')])[1]"));
		actions1.moveToElement(mainMenu1);
		actions1.click().build().perform();
		Thread.sleep(4000);

		WebElement subMenu1 = driver.findElement(By.xpath("(//a[@class='grid_mcadd_icon'][contains(.,'Add')])[1]"));
		actions1.moveToElement(subMenu1);
		actions1.click().build().perform();
		Thread.sleep(5000);
	}

	public void uniportselectlocationportandcapacity() throws InterruptedException {
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='uniLocation']")));
		 dropdown1.selectByValue("4");
		 Thread.sleep(5000);

		Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='uniPortType']")));
		dropdown2.selectByVisibleText("Ethernet U.N.I. Port - 100Gb");
		Thread.sleep(4000);

		Select dropdown3 = new Select(driver.findElement(By.xpath("//select[@id='uniCapacity']")));
		dropdown3.selectByVisibleText("100");
		 Thread.sleep(5000);
	}

	public void uniportSelectvalues(String portduration_1) throws InterruptedException {

		inputText(portdisplayname, getSaltString());
		portduration.sendKeys(portduration_1);
		Thread.sleep(4000);
	}

	public void adduniporttocart() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addtocartport);
		Thread.sleep(5000);
	}

	public void elanSelectvalues(String elanduration_1) throws InterruptedException {

		inputText(elanname, getSaltString());
		elanduration.sendKeys(elanduration_1);
		Thread.sleep(4000);
	}

	public void elanselectlatencyprotectionclassbandwidthandport() throws InterruptedException {
		Select dropdown4 = new Select(driver.findElement(By.xpath("//select[@id='privateLanLTNCY']")));
		dropdown4.selectByVisibleText("Best Effort");
		Thread.sleep(4000);

		Select dropdown5 = new Select(driver.findElement(By.xpath("//select[@id='privateLanPRTN']")));
		dropdown5.selectByVisibleText("Protected");
		Thread.sleep(4000);

		Select dropdown6 = new Select(driver.findElement(By.xpath("//select[@id='privateLanSLA']")));
		dropdown6.selectByVisibleText("Standard");
		Thread.sleep(4000);

		Select dropdown7 = new Select(driver.findElement(By.xpath("//select[@id='privateLanBandwidth']")));
		dropdown7.selectByVisibleText("5");
		Thread.sleep(4000);

		Select dropdown8 = new Select(driver.findElement(By.xpath("//select[@id='privateLanDestPort']")));
		dropdown8.selectByValue("0");
		Thread.sleep(4000);

	}

	public void addelantocart() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addtocartelan);
		Thread.sleep(4000);
	}

	public void clickOnCartmainbuttonandPlaceorderbutton() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartmainbutton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeorderbutton);
		Thread.sleep(5000);
	}

	public void referenceandcommentsSelectvalues(String poreference_1, String comments_1) throws InterruptedException {

		referenceid.sendKeys(poreference_1);
		comments.sendKeys(comments_1);
		Thread.sleep(4000);
	}

	public void orderselectprimarycontact247contactandtechnicalcontact() {
		Select dropdown9 = new Select(driver.findElement(By.xpath("//select[@id='primaryContact']")));
		dropdown9.selectByVisibleText(" Lohit Kumar ");

		Select dropdown10 = new Select(driver.findElement(By.xpath("//select[@id='247Contact']")));
		dropdown10.selectByVisibleText(" Lohit Kumar ");

		Select dropdown11 = new Select(driver.findElement(By.xpath("//select[@id='technicalContact']")));
		dropdown11.selectByVisibleText(" Lohit Kumar ");
	}

	public void clickOnNextbuttonandConfirmorderbutton() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextbutton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmorder);
		Thread.sleep(5000);
	}

}
