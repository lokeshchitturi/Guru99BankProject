package toolsQA;

import org.junit.Before;
import org.junit.Test;

import pageObject.ToolsQA;
import tests.Hooks;
import utils.WebdriverUtils;

public class CheckBox extends Hooks {

	ToolsQA checkbox;
	
	@Before
	public void intlializePageObject() {
		checkbox = new ToolsQA(WebdriverUtils.driver);
	}
	
	@Test
	public void checkBox_validation() throws Exception {	
		checkbox.checkBox();
		
	}

}
