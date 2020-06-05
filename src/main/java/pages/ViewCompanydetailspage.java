package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import helperLogger.LoggerHelper;
import stepDefinition.TestBase;
import utility.ConfigProperties;

/**
 * @author ankur.bhardwaj
 *
 */
public class ViewCompanydetailspage extends TestBase {

	public static WebDriver driver;
	String heading;

	Logger log = LoggerHelper.getLogger(ViewCompanydetailspage.class);

	public ViewCompanydetailspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators WebElement

	@FindBy(how = How.CSS, using = "div.control.actions-three-dot-menu")
	private List<WebElement> actionIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='box three-dot-menu is-open']//span[contains(text(),'View Details')]")
	private WebElement viewdetailslink;

	@FindBy(how = How.XPATH, using = "//span[@id='showCustomerDetails_wnd_title']")
	private WebElement companydetailsHeading;

	@FindBy(how = How.CSS, using = "div.row.control-group")
	private List<WebElement> companyDetails;

	seabornlogin sbloginoobj = new seabornlogin(TestBase.driver);

	public void navigateToCompanyList() throws Exception {
		sbloginoobj.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);
		sbloginoobj.clicksignin();
		executionDelay(10);
	}

	public void clickOnViewDetails() {
		log.info("clicking on action link");
		actionIcon.get(0).click();
		log.info("clicking on view details link");
		clickElement(driver, viewdetailslink);
		executionDelay(2);
		heading = companydetailsHeading.getText();
		Assert.assertTrue(heading.contains("Company Details"));

	}

	public void companyDetails() {
		int listsize = companyDetails.size();
		if (!(listsize == 0)) {
			log.info("Below are the ticket details");
			for (WebElement listelements : companyDetails) {
				log.info("\n" + listelements.getText());
			}
		} else {
			log.info("No Details found");
		}
		executionDelay(10);
	}
}