package stepDefintions;


import java.util.Locale;

import com.github.javafaker.Faker;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.InstanceFactory;
import utils.WebdriverUtils;

public class Hooks extends WebdriverUtils{
	
	
	@Before(order = 1)
	public void setup(Scenario scenario) throws Exception {
		
		openBrowser();
		prop=InstanceFactory.intilializePropertyFile(propertiesFilepath);
		extent=InstanceFactory.initalizeExtentReportObject();
		test=extent.createTest(scenario.getName());
		faker=new Faker(Locale.ENGLISH);
	
	}
	
	
	@After
	public void tearDown() {
		extent.flush();
		//WebdriverUtils.driver.close();
	}

}
