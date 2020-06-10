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

public class PortandETreeorderpage {

	public static WebDriver driver;

	public PortandETreeorderpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='uniPortDisplayName']")
	public WebElement portdisplayname1;

	@FindBy(how = How.XPATH, using = "//input[@id='uniDuration']")
	public WebElement portduration1;

	@FindBy(how = How.XPATH, using = "//input[@id='addToCart']")
	public WebElement addtocartport1;
	
	@FindBy(how = How.XPATH, using = "//a[@type='button'][contains(.,'Ethernet Private Tree')]")
	public WebElement etreesection;

	@FindBy(how = How.XPATH, using = "//input[@id='privateTreeName']")
	public WebElement etreename;

	@FindBy(how = How.XPATH, using = "//input[@id='privateTreeDuration']")
	public WebElement etreeduration;

	@FindBy(how = How.XPATH, using = "//input[@id='privateTreeAddToCart']")
	public WebElement addtocartetree;

	@FindBy(how = How.XPATH, using = "//button[@id='cartbutton']")
	public WebElement cartmainbutton1;

	@FindBy(how = How.XPATH, using = "//div[@class='col-sm-4 text-right']//input[@id='placeOrderButton']")
	public WebElement placeorderbutton1;

	@FindBy(how = How.XPATH, using = "//input[@id='referenceId']")
	public WebElement referenceid1;

	@FindBy(how = How.XPATH, using = "//textarea[@id='comments']")
	public WebElement comments1;

	@FindBy(how = How.XPATH, using = "//div[@class='row-fluid text-right']//button[@class='btn btn-primary'][contains(text(),'Next')]")
	public WebElement nextbutton1;

	@FindBy(how = How.XPATH, using = "//input[@id='confirmOrder']")
	public WebElement confirmorder1;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnManageordersandPlaceanordersubmenuforetree() throws Exception {
		sbloginoobj.Login(ConfigProperties.CUSTOMERUSEREMAIL, ConfigProperties.CUSTOMERPASSWORD);
		sbloginoobj.clicksignin();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[@class='Manage Orders']"));
		actions.moveToElement(mainMenu);

		WebElement subMenu = driver.findElement(By.xpath("//span[contains(text(),'Place an Order')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		Thread.sleep(7000);
	}

	public void clickOnThreedottedandAddbuttonforetree() throws InterruptedException {
		Actions actions1 = new Actions(driver);
		WebElement mainMenu1 = driver.findElement(By.xpath("(//div[contains(@class,'control actions-three-dot-menu')])[1]"));
		actions1.moveToElement(mainMenu1);
		actions1.click().build().perform();

		WebElement subMenu1 = driver.findElement(By.xpath("(//a[@class='grid_mcadd_icon'][contains(.,'Add')])[1]"));
		actions1.moveToElement(subMenu1);
		actions1.click().build().perform();
		Thread.sleep(5000);
	}

	public void uniportselectvaluesforlocationportandcapacityetree() throws InterruptedException {
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='uniLocation']")));
		 dropdown1.selectByVisibleText("POP - 165 Halsey");
		 Thread.sleep(5000);

		Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='uniPortType']")));
		dropdown2.selectByVisibleText("Ethernet U.N.I. Port - 100Gb");

		Select dropdown3 = new Select(driver.findElement(By.xpath("//select[@id='uniCapacity']")));
		dropdown3.selectByVisibleText("100");
		 Thread.sleep(5000);
	}

	public void uniportEntervaluesetree(String portdisplay_name_1, String portduration_1) {

		portdisplayname1.sendKeys(portdisplay_name_1);
		portduration1.sendKeys(portduration_1);
	}

	public void clickonadduniporttocartetree() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addtocartport1);
		Thread.sleep(5000);
	}
	
	public void clickonetreesection() throws InterruptedException {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", etreesection );
		Thread.sleep(3000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", etreesection);
		Thread.sleep(7000);
	}

	public void etreeSelectvalues(String etree_name_1, String etreeduration_1) throws InterruptedException {

		etreename.sendKeys(etree_name_1);
		etreeduration.sendKeys(etreeduration_1);
		Thread.sleep(7000);
	}

	public void etreeselectlatencyprotectionclassbandwidthandport() throws InterruptedException {
		Select dropdown4 = new Select(driver.findElement(By.xpath("//select[@id='privateTreeLTNCY']")));
		dropdown4.selectByVisibleText("Best Effort");
		Thread.sleep(3000);
		
		Select dropdown5 = new Select(driver.findElement(By.xpath("//select[@id='privateTreePRTN']")));
		dropdown5.selectByVisibleText("Protected");
		Thread.sleep(3000);
		
		Select dropdown6 = new Select(driver.findElement(By.xpath("//select[@id='privateTreeSLA']")));
		dropdown6.selectByVisibleText("Standard");
		Thread.sleep(3000);
		
		Select dropdown7 = new Select(driver.findElement(By.xpath("//select[@id='privateTreeBandwidth']")));
		dropdown7.selectByVisibleText("5");
		Thread.sleep(3000);

		Select dropdown8 = new Select(driver.findElement(By.xpath("//select[@id='privateTreeSourcePort']")));
		dropdown8.selectByValue("62");
		Thread.sleep(3000);
		
		Select dropdown9 = new Select(driver.findElement(By.xpath("//select[@id='privateTreeDestLocation']")));
		dropdown9.selectByValue("5");
		Thread.sleep(3000);

		Select dropdown10 = new Select(driver.findElement(By.xpath("//select[@id='privateTreeDestPortOne']")));
		dropdown10.selectByValue("57");
		Thread.sleep(3000);
	}

	public void addetreetocart() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addtocartetree);
	}

	public void clickOnCartmainmenubuttonandPlaceorderbuttonetree() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartmainbutton1);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeorderbutton1);
		Thread.sleep(5000);
	}

	public void referenceandcommentsEntertvaluesetree(String poreference_1, String comments_1) {

		referenceid1.sendKeys(poreference_1);
		comments1.sendKeys(comments_1);
	}

	public void orderselectprimarycontact247contactandtechnicalcontactEtreeorder() {
		Select dropdown9 = new Select(driver.findElement(By.xpath("//select[@id='primaryContact']")));
		dropdown9.selectByVisibleText(" Lohit Kumar ");

		Select dropdown10 = new Select(driver.findElement(By.xpath("//select[@id='247Contact']")));
		dropdown10.selectByVisibleText(" Lohit Kumar ");

		Select dropdown11 = new Select(driver.findElement(By.xpath("//select[@id='technicalContact']")));
		dropdown11.selectByVisibleText(" Lohit Kumar ");
	}

	public void clickOnNextbuttonandConfirmorderbuttonforetree() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextbutton1);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmorder1);
		Thread.sleep(5000);
	}
	
	public void Successmessageforetreeorder() throws Exception {

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
