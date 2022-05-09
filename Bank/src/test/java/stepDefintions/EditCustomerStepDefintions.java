package stepDefintions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.EditCustomerPage;
import pageObject.NewCustomerPage;

public class EditCustomerStepDefintions {

	EditCustomerPage editCustomerPage;
	NewCustomerPage newCustomerPage;
	
	@Before
	public void setup() {
		editCustomerPage=new EditCustomerPage();
		newCustomerPage=new NewCustomerPage();
	}
	
	@When("search the customer to perform edit")
	public void search_the_customer_to_perform_edit() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    newCustomerPage.closeTheGoogleAdd();
	    editCustomerPage.searchCustomer(newCustomerPage.customerDetails.get("Customer ID"));
	}
	@When("edit the address of the customer")
	public void edit_the_address_of_the_customer() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    editCustomerPage.editTheCustomerField("Address", "RandomText");
	}
	@Then("validate address got edited")
	public void validate_address_got_edited() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
}
