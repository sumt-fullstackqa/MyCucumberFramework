/**
 * 
 */
package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ViewTicketpage;

/**
 * @author ankur.bhardwaj
 *
 */
public class ViewTicketSteps {

	ViewTicketpage viewticketpage = new ViewTicketpage(TestBase.driver);
	
	@When("^user selects view tickets option of any tickets$")
	public void user_selects_view_tickets_option_of_any_tickets() throws Throwable {
		viewticketpage.clickOnViewTickets();
	}

	@Then("^view tickets details screen is opened$")
	public void view_tickets_details_screen_is_opened() throws Throwable {
		viewticketpage.ticketdetails();
	}

	@Then("^ticket related details are shown$")
	public void ticket_related_details_are_shown() throws Throwable {
	  
	}

	
}
