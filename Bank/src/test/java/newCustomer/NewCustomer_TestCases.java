package newCustomer;

import org.openqa.selenium.WebDriver;

import login.login;

public class NewCustomer_TestCases {
	WebDriver driver;
	
	public void createNewCustomer() {
		driver=login.loginIntoApplication();
		
	}

}
