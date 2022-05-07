package stepDefintions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.NewCustomerPage;

public class NewCustomerStepDefintions {
	
	NewCustomerPage newCustomerPage;
	
	@Before
	public void setup() {
		newCustomerPage=new NewCustomerPage();
	}
	
	
	@When("Fill all the customer details")
	public void fill_all_the_customer_details() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    newCustomerPage.closeTheGoogleAdd();
	    newCustomerPage.createNewCustomer();
	}
	@Then("validate new customer got created")
	public void validate_new_customer_got_created() {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

}
