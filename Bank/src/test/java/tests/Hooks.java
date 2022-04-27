package tests;

import org.junit.After;
import org.junit.Before;

import utils.WebdriverUtils;

public class Hooks extends WebdriverUtils{
	
	
	@Before
	public void setup() throws Exception {
		
		WebdriverUtils.openBrowser();
		
	}
	
	
	@After
	public void tearDown() {
		WebdriverUtils.driver.close();
	}

}
