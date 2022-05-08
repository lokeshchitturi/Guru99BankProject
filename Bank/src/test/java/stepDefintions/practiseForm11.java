package stepDefintions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.PractiseFormPage;

public class practiseForm11 {

	PractiseFormPage form;

	@Given("I want to validate the practise form page")
	public void i_want_to_validate_the_practise_form_page() throws Exception {
		form.validatePage();
		System.out.println("Open the Practise Form");
	}
	@When("enter the all required data")
	public void enter_the_all_required_data() throws Exception {
		//form.validatePage();
		System.out.println("Enter all the data");
	}
	@Then("page is submitted successfully")
	public void page_is_submitted_successfully() {
		System.out.println("Submit the Form");
	}



}
