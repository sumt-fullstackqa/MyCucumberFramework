/**
 * 
 */
package pages;

import java.util.List;

import org.apache.log4j.Logger;
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
public class ReopenTicketpage extends TestBase {

	public static WebDriver driver;

	Logger log = LoggerHelper.getLogger(ReopenTicketpage.class);

	public ReopenTicketpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement locators
	@FindBy(how = How.CSS, using = "div.control.actions-three-dot-menu")
	private List<WebElement> actionIcon;

	@FindBy(how = How.CSS, using = "div.is-open>ul>li:nth-child(3)>a")
	private WebElement closeticketIcon;

	@FindBy(how = How.CSS, using = "span#closeCustomerTicketFormDiv_wnd_title")
	private WebElement closeTicketScreenTitle;

	@FindBy(how = How.CSS, using = "textarea#comments")
	private WebElement commentTextarea;

	@FindBy(how = How.CSS, using = "select#closeReasonID")
	private WebElement reasondropdown;

	@FindBy(how = How.XPATH, using = "//select[@id='closeReasonID']/option[4]")
	private WebElement reasondropdownvalue;

	@FindBy(how = How.CSS, using = "input#closeCustomerTicketBtn")
	private WebElement closeButton;

	@FindBy(how = How.CSS, using = "ul.nav-pills>li:nth-child(2)>a")
	private WebElement closeticketTab;

	@FindBy(how = How.CSS, using = "td.td_h_group")
	private WebElement closeticketheading;

	@FindBy(how = How.CSS, using = "div.noRecordDiv")
	private WebElement norecords;

	@FindBy(how = How.CSS, using = "a.grid_mcreopen")
	private WebElement reopenicon;

	@FindBy(how = How.CSS, using = "button.btn.btn-primary")
	private WebElement Okbutton;

	@FindBy(how = How.CSS, using = "ul.nav-pills>li:nth-child(1)>a")
	private WebElement Opentab;
	
	@FindBy(how = How.CSS, using = "div#reopenTickettPopupMsg")
	private WebElement reopensuccessmessage;
	


	public void clickOnCloseTicket() {
		actionIcon.get(0).click();
		waitForElement(closeticketIcon, 2);
		clickElement(driver, closeticketIcon);
		executionDelay(5);
		String closescreentitle = closeTicketScreenTitle.getText();
		if (closescreentitle.contains("Close Ticket")) {
			log.info("close ticket screen is opened " + closescreentitle);

		} else {
			log.info("close Ticket screen not found");

		}

	}

	public void addCloseTicketDetails(String addcomment) {
		inputText(commentTextarea, addcomment);
		waitForElementToBeClickable(reasondropdown, driver, 2);
		clickElement(driver, reasondropdown);
		waitForElementToBeVisible(reasondropdownvalue, driver, 2);
		clickElement(driver, reasondropdownvalue);
		executionDelay(3);
		clickElement(driver, closeButton);
		executionDelay(10);

	}

	public void clickOnCloseTickettab() {
		clickElement(driver, closeticketTab);
		executionDelay(3);
		String headingtext = closeticketheading.getText();
		 if(headingtext.contains("Closed Tickets")) {
			 log.info("Closed Ticket screen is opened "+headingtext);
		 }else {
			 log.info("Error in closed ticket ");
		 }	
		
	}
	
	public void clickOnReopenticket() {
		actionIcon.get(0).click();
		waitForElementToBeVisible(reopenicon, driver, 2);
		clickElement(driver, reopenicon);
		waitForElementToBeVisible(Okbutton, driver, 2);
		clickElement(driver, Okbutton);
		executionDelay(5);
		notifymessage(reopensuccessmessage, "updated successfully");
	 
	 }

}
