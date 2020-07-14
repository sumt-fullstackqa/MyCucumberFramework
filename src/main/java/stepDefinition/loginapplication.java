package stepDefinition;

import org.openqa.selenium.WebDriver;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.login;
import utility.ConfigProperties;

public class loginapplication {

	public static WebDriver driver;

	login pages = new login(TestBase.driver);
	
	@Given("^I navigate to the web URL$")
	public void i_navigate_to_the_web_URL() throws Throwable {
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());

	}
	@And("^click on login link$")
	public void click_on_login_link() throws Throwable {

		pages.clickonlogin();

	}
	
	@When("^user enter Username and Password$")
	public void user_enter_Username_and_Password() throws Throwable {

		pages.Login(ConfigProperties.USEREMAIL, ConfigProperties.PASSWORD);

	}

	@And("^I click on SignIn button$")
	public void i_click_on_SignIn_button() throws Throwable {

		pages.clicksignin();

	}

	@Then("^Login should be successful and click on signout button to logout of the application$")
	public void login_should_be_successful_and_click_on_signout_button_to_logout_of_the_application() throws Throwable {

		pages.logoutApp();
	}

}