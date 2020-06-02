/**
 * 
 */
package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DownloadTicketsDatapage;

/**
 * @author ankur.bhardwaj
 *
 */
public class DownloadFileTicketsSteps {

	DownloadTicketsDatapage downloadpage = new DownloadTicketsDatapage(TestBase.driver);
	
	@When("^I click on Export to excel$")
	public void i_click_on_Export_to_excel() throws Throwable {
		downloadpage.VerifyDownloadExcelWithFileName();
	}

	@Then("^excel file downloaded with tickets data$")
	public void excel_file_downloaded_with_tickets_data() throws Throwable {
	 
	}
	
	@When("^I click on Export to pdf button$")
	public void i_click_on_Export_to_pdf_button() throws Throwable {
	   
	}

	@Then("^pdf file downloaded with ticket data$")
	public void pdf_file_downloaded_with_ticket_data() throws Throwable {
		downloadpage.VerifyDownloadPdfWithFileName();
	}
}
