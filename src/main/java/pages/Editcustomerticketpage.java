package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import stepDefinition.TestBase;

public class Editcustomerticketpage extends TestBase {
	public static WebDriver driver;

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

	@FindBy(how = How.CSS, using = "span.ct-active")
	private WebElement ticketnameFilter;

	@FindBy(how = How.CSS, using = "form.k-filter-menu>div:nth-child(1)>input:nth-child(3)")
	private WebElement FilterinputTextField;

	@FindBy(how = How.CSS, using = "button.k-primary")
	private WebElement FilterButton;

	@FindBy(how = How.CSS, using = "div.k-grid-content>table>tbody>tr>td:nth-child(2)")
	private WebElement ticketvalue;

	public void editLink() {
		clickElement(driver, actionIcon);
		waitForElement(editactionIcon, 2);
		clickElement(driver, editactionIcon);
		executionDelay(5);

	}

	public void updateDetails(String ticketname, String description) {
		waitForElement(ticketnameTextField, 2);
		sendKeys(driver, ticketnameTextField);
		waitForElement(ticketdescriptionTextarea, 2);
		sendKeys(driver, ticketdescriptionTextarea);
		clickElement(driver, ticketupdateButton);
		executionDelay(5);
	}

	public void search(String updatedname) {
		clickElement(driver, ticketnameFilter);
		waitForElementToBeVisible(FilterinputTextField, driver, 2);
		sendKeys(driver, FilterinputTextField);
		waitForElementToBeClickable(FilterButton, driver, 2);
		clickElement(driver, FilterButton);
		executionDelay(2);
		if (ticketvalue.getText().equalsIgnoreCase(updatedname)) {
			System.out.println("Ticket updated successfully");
		} else {
			System.out.println("Ticket not updated name not matches");
		}

	}

}
