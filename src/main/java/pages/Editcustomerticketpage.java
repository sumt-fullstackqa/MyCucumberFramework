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

public class Editcustomerticketpage extends TestBase {
	public static WebDriver driver;

	Logger log = LoggerHelper.getLogger(Editcustomerticketpage.class);

	public Editcustomerticketpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "div.control")
	private WebElement actionIcon;

	@FindBy(how = How.CSS, using = "a.grid_mcedit_icon")
	private WebElement editactionIcon;

	@FindBy(how = How.CSS, using = "input#ticketName")
	private WebElement ticketnameTextField;

	@FindBy(how = How.CSS, using = "textarea#ticketDescription")
	private WebElement ticketdescriptionTextarea;

	@FindBy(how = How.CSS, using = "input#saveCustomerTicketBtn")
	private WebElement ticketupdateButton;

	@FindBy(how = How.CSS, using = "a.k-grid-filter")
	private List<WebElement> ticketnameFilter;

	@FindBy(how = How.CSS, using = "form.k-filter-menu>div:nth-child(1)>input:nth-child(3)")
	private WebElement FilterinputTextField;

	@FindBy(how = How.CSS, using = "button.k-primary")
	private WebElement FilterButton;

	@FindBy(how = How.CSS, using = "div.k-grid-content>table>tbody>tr>td:nth-child(2)")
	private WebElement ticketvalue;

	@FindBy(how = How.CSS, using = "span#createNewCustomerTicketFormDiv_wnd_title")
	private WebElement EditTicketScreen;

	public void editLink() {
		clickElement(driver, actionIcon);
		waitForElement(editactionIcon, 2);
		clickElement(driver, editactionIcon);
		executionDelay(5);
		String editscreentext = EditTicketScreen.getText();
		if (editscreentext.equalsIgnoreCase("Edit Ticket")) {
			log.info("Edit Ticket screen is opened " + EditTicketScreen.getText());

		} else {
			log.info("Edit Ticket screen not found");

		}

	}

	public void updateDetails(String ticketname, String description) {
		waitForElement(ticketnameTextField, 2);
		inputText(ticketnameTextField, ticketname);
		waitForElement(ticketdescriptionTextarea, 2);
		inputText(ticketdescriptionTextarea, description);
		executionDelay(5);
		clickElement(driver, ticketupdateButton);
		executionDelay(10);
	}

	public void search(String searchtext) {
		ticketnameFilter.get(1).click();
		waitForElementToBeVisible(FilterinputTextField, driver, 2);
		inputText(FilterinputTextField, searchtext);
		executionDelay(2);
		clickElement(driver, FilterButton);
		executionDelay(5);
		String ticketname = ticketvalue.getText();
		if (ticketname.equalsIgnoreCase(searchtext)) {
			log.info("Ticketname found in the list -" + ticketname);
		} else {
			log.info("Ticketname not found");
		}

	}

	public void cleanup(String ttname, String tdescription) {
		editLink();
		updateDetails(ttname, tdescription);
	}

}
