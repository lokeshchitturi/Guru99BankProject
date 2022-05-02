package toolsQA;

import org.junit.Before;
import org.junit.Test;

import pageObject.ToolsQA;
import tests.Hooks;
import utils.WebdriverUtils;

public class Textbox extends Hooks {

	ToolsQA textbox;

	@Before
	public void intlializePageObject() {
		textbox = new ToolsQA(WebdriverUtils.driver);
	}
	
	@Test
	public void textBox_validation() throws Exception {	
		textbox.textBox();
		
	}

	
}
