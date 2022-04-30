package tests;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;

import utils.InstanceFactory;
import utils.WebdriverUtils;

public class Hooks extends WebdriverUtils{
	
	
	@Before
	public void setup() throws Exception {
		
		openBrowser();
		prop=InstanceFactory.intilializePropertyFile(propertiesFilepath);
		extent=InstanceFactory.initalizeExtentReportObject();
		
	
	}
	
	
	@After
	public void tearDown() {
		extent.flush();
		WebdriverUtils.driver.close();
	}

}
