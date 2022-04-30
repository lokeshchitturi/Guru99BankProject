package tests;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import pageObject.LoginPage;

public class login extends Hooks {
	
	LoginPage loginpage;
	@Rule
	public TestName name=new TestName();
	
	@Before
	public void intlializePageObject() {
		loginpage=new LoginPage();
		test=extent.createTest(name.getMethodName());
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
