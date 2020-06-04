package pages;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import helperLogger.LoggerHelper;
import stepDefinition.TestBase;
import utility.ConfigProperties;

/**
 * @author ankur.bhardwaj
 *
 */
public class ViewBandwidthOnDemandPage extends TestBase {
	public static WebDriver driver;
	String url;
	String title;

	Logger log = LoggerHelper.getLogger(ViewBandwidthOnDemandPage.class);

	public ViewBandwidthOnDemandPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "a.Service.Management")
	private WebElement servicemanagementmenu;

	@FindBy(how = How.CSS, using = "svg.svg-inline--fa.fa-spinner.fa-w-16.fa-spin")
	private WebElement Loader;

	@FindBy(how = How.CSS, using = "tr.k-alt>td:nth-child(1)>a")
	private WebElement Bandwidthondemandlink;

	@FindBy(how = How.XPATH, using = "//a[@role='menuitem']")
	public List<WebElement> submenu;

	@FindBy(how = How.CSS, using = "a.Networks")
	private WebElement networklink;

	@FindBy(how = How.XPATH, using = "//a[@href='http://seaborn.cloudsmartz.com/group/services/networks/network'][contains(.,'Network')]")
	private WebElement submenulink;

	@FindBy(how = How.CSS, using = "span#toggle-arrow")
	private WebElement togglearrow;

	@FindBy(how = How.CSS, using = "div.k-grid-content>table>tbody>tr:nth-child(1)>td:nth-child(10)>div")
	private List<WebElement> actionIcon;

	@FindBy(how = How.CSS, using = "div.is-open>ul>li:nth-child(1)>a")
	private WebElement viewlink;

	@FindBy(how = How.CSS, using = "div.k-window-titlebar")
	private WebElement servicedetailscreen;

	@FindBy(how = How.CSS, using = "a.k-button")
	private WebElement crossicon;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void clickOnserviceManagement() throws Exception {
		sbloginoobj.Login(ConfigProperties.CUSTOMERUSEREMAIL, ConfigProperties.CUSTOMERPASSWORD);
		sbloginoobj.clicksignin();
		executionDelay(20);
		log.info("clicking on service management link");
		clickElement(driver, servicemanagementmenu);
		executionDelay(5);
		url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("service-management"));

	}

	public void clickOnBandwidthondemandlink() {
		log.info("clicking on bandwidth on demand service link");
		String parentwindows = driver.getWindowHandle();
		System.out.println("parent window id is " + parentwindows);
		clickElement(driver, Bandwidthondemandlink);
		executionDelay(10);
		Set<String> allwindows = driver.getWindowHandles();
		int count = allwindows.size();
		System.out.println("Total window" + count);
		for (String child : allwindows) {
			if (!parentwindows.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}
	}

	public void clickOnNetwork() {
		log.info("clicking on network link");
		submenu.get(0).click();
		executionDelay(5);
		log.info("clicking on sub menu network link");
		submenulink.click();
		executionDelay(5);
		url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("networks"));
	}

	public void viewserviceDetails() {
		log.info("clicking on toggle arrow");
		clickElement(driver, togglearrow);
		executionDelay(2);
		actionIcon.get(0).click();
		waitForElementToBeClickable(viewlink, driver, 2);
		clickElement(driver, viewlink);
		executionDelay(5);
		title = servicedetailscreen.getText();
		log.info("Screen Title is- title ");
		Assert.assertTrue(title.contains("Service Details"));
		log.info("clicking on cross sign ");
		clickElement(driver, crossicon);
		executionDelay(5);
	}

}
