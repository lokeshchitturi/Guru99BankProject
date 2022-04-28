package tests;

import org.junit.Before;
import org.junit.Test;

import pageObject.LoginPage;
import utils.WebdriverUtils;

public class login extends Hooks {
	
	LoginPage loginpage;
	
	@Before
	public void intlializePageObject() {
		loginpage=new LoginPage(WebdriverUtils.driver);
	}
	
	@Test
	public void test_loginIntoApplication() throws Exception {		
		loginpage.validateLogin();
	}
	
	@Test
	public void test_invalidLogin() throws Exception {
		loginpage.validateInvalidLogin();
	}

}
