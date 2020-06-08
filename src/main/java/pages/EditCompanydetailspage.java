/**
 * 
 */
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

/**
 * @author ankur.bhardwaj
 *
 */
public class EditCompanydetailspage extends TestBase {

	public static WebDriver driver;

	String heading;

	Logger log = LoggerHelper.getLogger(ViewCompanydetailspage.class);

	public EditCompanydetailspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators WebElement

	@FindBy(how = How.CSS, using = "div.control.actions-three-dot-menu")
	private List<WebElement> actionIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='box three-dot-menu is-open']//span[contains(text(),'Edit')]")
	private WebElement editdetailslink;

	@FindBy(how = How.XPATH, using = "//span[@id='createCustomerAccountWin_wnd_title']")
	private WebElement editscreenheading;

	@FindBy(how = How.XPATH, using = "//input[@id='customerName']")
	private WebElement companynameTextField;

	@FindBy(how = How.XPATH, using = "//input[@id='customerAccountNumber']")
	private WebElement accountnumberTextField;

	@FindBy(how = How.XPATH, using = "//select[@id='customerCountryID']")
	private WebElement countryIdDropdown;

	@FindBy(how = How.XPATH, using = "//input[@id='customerAddress']")
	private WebElement addressTextField;

	@FindBy(how = How.XPATH, using = "//input[@id='customerCity']")
	private WebElement cityTextField;

	@FindBy(how = How.XPATH, using = "//select[@id='customerStateID']")
	private WebElement statedropdown;

	@FindBy(how = How.XPATH, using = "//input[@id='customerTaxID']")
	private WebElement customerTaxId;

	@FindBy(how = How.XPATH, using = "//input[@id='adminEmailAddress']")
	private WebElement emailaddresstextField;

	@FindBy(how = How.XPATH, using = "//input[@id='adminFirstName']")
	private WebElement firstnametextField;

	@FindBy(how = How.XPATH, using = "//input[@id='adminLastName']")
	private WebElement lastnametextField;

	@FindBy(how = How.XPATH, using = "//select[@id='adminCountryID']")
	private List<WebElement> countrydropdown;

	@FindBy(how = How.XPATH, using = "//input[@id='saveCustomerAccountButton']")
	private WebElement updatebutton;
	
	@FindBy(how = How.CSS, using = "div#customerMsg")
	private WebElement successmsg;

	public void clickOnEditlink() {
		log.info("clicking on action link");
		actionIcon.get(0).click();
		log.info("clicking on view details link");
		clickElement(driver, editdetailslink);
		executionDelay(2);
		heading = editscreenheading.getText();
		Assert.assertTrue(heading.contains("Edit Company"));

	}

	public void EditCompanyDetails(String companyname, String accnumber, String countrydrp, String address, String city,
			String state, String taxid) {
		log.info("updating the companyname");
		inputText(companynameTextField, companyname);
		log.info("updating the accountnumber");
		inputText(accountnumberTextField, accnumber);
		log.info("select the country");
		dropDownList(countryIdDropdown, countrydrp);
		log.info("updating the address");
		inputText(addressTextField, address);
		log.info("updating the city");
		inputText(cityTextField, city);
		dropDownList(statedropdown, state);
		inputText(customerTaxId, taxid);
		executionDelay(2);

	}

	public void EditContactDetails(String emailaddress, String firstname, String lastname, String country) {
		log.info("updating the emailaddress");
		inputText(emailaddresstextField, emailaddress);
		log.info("updating the first name");
		inputText(firstnametextField, firstname);
		log.info("updating the last name");
		inputText(lastnametextField, lastname);
		log.info("updating the last name");
		dropDownList(countryIdDropdown, country);
		clickElement(driver, updatebutton);
		executionDelay(10);
		notifymessage(successmsg, "Company Account has been updated successfully.");

	}

}
