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

public class Portandelineorderpage extends TestBase {

	public static WebDriver driver;

	public Portandelineorderpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='uniPortDisplayName']")
	public WebElement portdisplayname;

	@FindBy(how = How.XPATH, using = "//input[@id='uniDuration']")
	public WebElement portduration;

	@FindBy(how = How.XPATH, using = "//input[@id='addToCart']")
	public WebElement addtocartport;
	
	@FindBy(how = How.XPATH, using = "//a[@type='button'][contains(.,'Ethernet Private Line')]")
	public WebElement elinesection;

	@FindBy(how = How.XPATH, using = "//input[@id='privateLineName']")
	public WebElement elinename;

	@FindBy(how = How.XPATH, using = "//input[@id='privateLineDuration']")
	public WebElement elineduration;

	@FindBy(how = How.XPATH, using = "//input[@id='privateLineAddToCart']")
	public WebElement addtocarteline;

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

	public void clickOnManageordersandPlaceanordersubmenu() throws Exception {
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

	public void clickOnThreedottedandAddbuttonforuniport() throws InterruptedException {
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

	public void uniportselectvaluesforlocationportandcapacity() throws InterruptedException {
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='uniLocation']")));
		 dropdown1.selectByValue("4");
		 Thread.sleep(12000);

		Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='uniPortType']")));
		dropdown2.selectByVisibleText("Ethernet U.N.I. Port - 100Gb");
		Thread.sleep(4000);
	}

	public void uniportEntervalues(String portduration_1) throws InterruptedException {

		inputText(portdisplayname, getSaltString());
		portduration.sendKeys(portduration_1);
		Thread.sleep(4000);
	}

	public void clickonadduniporttocart() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addtocartport);
		Thread.sleep(5000);
	}
	
	public void clickonelinesection() throws InterruptedException {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", elinesection );
		Thread.sleep(3000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elinesection);
		Thread.sleep(5000);
	}

	public void elineSelectvalues(String elineduration_1) throws InterruptedException {

		inputText(elinename, getSaltString());
		elineduration.sendKeys(elineduration_1);
		Thread.sleep(5000);
	}

	public void elineselectlatencyprotectionclassbandwidthandport() throws InterruptedException {
		Select dropdown4 = new Select(driver.findElement(By.xpath("//select[@id='privateLineLTNCY']")));
		dropdown4.selectByVisibleText("Best Effort");
		Thread.sleep(4000);
		
		Select dropdown5 = new Select(driver.findElement(By.xpath("//select[@id='privateLinePRTN']")));
		dropdown5.selectByVisibleText("Protected");
		Thread.sleep(4000);
		
		Select dropdown6 = new Select(driver.findElement(By.xpath("//select[@id='privateLineSLA']")));
		dropdown6.selectByVisibleText("Standard");
		Thread.sleep(4000);
		
		Select dropdown7 = new Select(driver.findElement(By.xpath("//select[@id='privateLineBandwidth']")));
		dropdown7.selectByVisibleText("5");
		Thread.sleep(4000);

		Select dropdown8 = new Select(driver.findElement(By.xpath("//select[@id='privateLineSourcePort']")));
		dropdown8.selectByValue("0");
		Thread.sleep(4000);
		
		Select dropdown9 = new Select(driver.findElement(By.xpath("//select[@id='privateLineDestLocation']")));
		dropdown9.selectByValue("5");
		Thread.sleep(4000);

		Select dropdown10 = new Select(driver.findElement(By.xpath("//select[@id='privateLineDestPort']")));
		dropdown10.selectByValue("0");
		Thread.sleep(4000);
	}

	public void addelinetocart() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addtocarteline);
		Thread.sleep(4000);
	}

	public void clickOnCartmainmenubuttonandPlaceorderbutton() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartmainbutton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeorderbutton);
		Thread.sleep(5000);
	}

	public void referenceandcommentsEntertvalues(String poreference_1, String comments_1) throws InterruptedException {

		referenceid.sendKeys(poreference_1);
		comments.sendKeys(comments_1);
		Thread.sleep(4000);
	}

	public void orderselectprimarycontact247contactandtechnicalcontactElineorder() throws InterruptedException {
		Select dropdown9 = new Select(driver.findElement(By.xpath("//select[@id='primaryContact']")));
		dropdown9.selectByVisibleText(" Lohit Kumar ");

		Select dropdown10 = new Select(driver.findElement(By.xpath("//select[@id='247Contact']")));
		dropdown10.selectByVisibleText(" Lohit Kumar ");

		Select dropdown11 = new Select(driver.findElement(By.xpath("//select[@id='technicalContact']")));
		dropdown11.selectByVisibleText(" Lohit Kumar ");
		Thread.sleep(4000);
	}

	public void clickOnNextbuttonandConfirmorderbuttonforeline() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextbutton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmorder);
		Thread.sleep(5000);
	}
	
	public void Successmessageforelineorder() throws Exception {

		WebElement msg1 = driver.findElement(By.id("orderMsg"));
		String text1 = msg1.getText();
		if (msg1.isEnabled() && text1.contains("placed successfully")) {
			System.out.println("order placed");
		} else {
			System.out.println(" place order failed");
			Thread.sleep(5000);
		}
	}

}
