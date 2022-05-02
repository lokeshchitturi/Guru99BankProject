package stepDefintions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;
import utils.WebdriverUtils;

public class LoginStepDefinitons {
	LoginPage loginpage;
	
	@Before
	public void setupInClass() {
		loginpage=new LoginPage();
	}

	
	@Given("user should validate the title of the page")
	public void user_should_validate_the_title_of_the_page() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	   loginpage.validatePageTitle("Guru99 Bank Home Page");
	}

	@When("enter the username")
	public void enter_the_username() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("usernaemr ------called respectived method in pageobjecet");
	}

	@When("enter the password")
	public void enter_the_password() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("passweord -------called respectived method in pageobjecet");
	}

	@When("click on login button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("login click ------called respectived method in pageobjecet");
	}

	@Then("validate user logged into application succesfully")
	public void validate_user_logged_into_application_succesfully() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		 loginpage.validateLogin();
	}

}
