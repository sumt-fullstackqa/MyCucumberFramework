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
public class ViewTicketpage extends TestBase {

	public static WebDriver driver;

	Logger log = LoggerHelper.getLogger(ViewTicketpage.class);

	public ViewTicketpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement locators
	@FindBy(how = How.CSS, using = "div.control.actions-three-dot-menu")
	private List<WebElement> actionIcon;

	@FindBy(how = How.CSS, using = "div.is-open>ul>li:nth-child(1)>a")
	private WebElement viewticketlink;

	@FindBy(how = How.CSS, using = "div#view-details>div:nth-child(1)>div:nth-child(1)>h1")
	private WebElement ticketheading;

	@FindBy(how = How.CSS, using = "div.col-md-4")
	private List<WebElement> ticketdetails;

	public void clickOnViewTickets() {
		log.info("Clicking on action link ");
		actionIcon.get(0).click();
		waitForElementToBeClickable(viewticketlink, driver, 2);
		log.info("Clicking on view ticket link ");
		clickElement(driver, viewticketlink);
		waitForElementToBeVisible(ticketheading, driver, 2);
		log.info("View ticket heading is : " + ticketheading.getText());

	}

	public void ticketdetails() {
		int listsize = ticketdetails.size();
		if (!(listsize == 0)) {
			log.info("Below are the ticket details");
			for (WebElement listelements : ticketdetails) {
				log.info("\n" + listelements.getText());
			}
		}else {
			log.info("No Details found");
		}
		executionDelay(10);

	}

}
