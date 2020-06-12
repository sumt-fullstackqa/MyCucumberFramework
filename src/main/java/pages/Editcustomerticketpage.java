package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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

	@SuppressWarnings("static-access")
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
	
	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'k-icon k-i-filter')])[8]")
	public WebElement createdonfiltericon;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'k-animation-container')]//input[1]")
	private WebElement filterinput;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'k-button k-primary')]")
	private WebElement filterbutton;
	
	

	public void editLink(String filtervalue) {
		try {
			log.info("clicking on created By filter");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", createdonfiltericon);
			executionDelay(2);
			log.info("adding filter value");
			inputText(filterinput, filtervalue);
			log.info("clicking on filter button");
			clickElement(driver, filterbutton);
			executionDelay(2);
			log.info("clicking on action 3 doticon");
			clickElement(driver, actionIcon);
			executionDelay(2);
			log.info("clicking on edit icon link");
			clickElement(driver, editactionIcon);
			executionDelay(5);
			String editscreentext = EditTicketScreen.getText();
			if (editscreentext.equalsIgnoreCase("Edit Ticket")) {
				log.info("Edit Ticket screen is opened " + EditTicketScreen.getText());

			} else {
				log.info("Edit Ticket screen not found");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateDetails(String description) {
		waitForElement(ticketnameTextField, 2);
		inputText(ticketnameTextField, getSaltString());
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

	public void cleanup(String tdescription, String value) {
		editLink(value);
		updateDetails(tdescription);
	}

}
