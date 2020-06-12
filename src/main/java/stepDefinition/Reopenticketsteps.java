/**
 * 
 */
package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ReopenTicketpage;
import utility.ConfigProperties;

/**
 * @author ankur.bhardwaj
 *
 */
public class Reopenticketsteps {
	
	ReopenTicketpage reopenpage = new ReopenTicketpage(TestBase.driver);
	
	@When("^user clicks on action icon and select close Ticket$")
	public void user_clicks_on_action_icon_and_select_close_Ticket() throws Throwable {
		reopenpage.clickOnCloseTicket();
	}


	@Then("^ticket closed successfully and move to closed ticket tab$")
	public void ticket_closed_successfully_and_move_to_closed_ticket_tab() throws Throwable {
		reopenpage.addCloseTicketDetails(ConfigProperties.TICKETCOMMENTS);
	}

	@Then("^validate ticket on closed tab screen$")
	public void validate_ticket_on_closed_tab_screen() throws Throwable {
		reopenpage.clickOnCloseTickettab();
	}

	@When("^user click on Reopen ticket$")
	public void user_click_on_Reopen_ticket() throws Throwable {
		reopenpage.clickOnReopenticket();
	}

	@Then("^ticket moves to Open ticket tab$")
	public void ticket_moves_to_Open_ticket_tab() throws Throwable {
	    
	}

	
}
