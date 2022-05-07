package stepDefintions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;

public class HomeStepDefintions {
	
	HomePage homepage;
	
	@Before
	public void setup() {
		homepage=new HomePage();
	}
	
	@When("click on {string} tab")
	public void click_on_tab(String string) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    homepage.navigateToTab(string);
	}


}
