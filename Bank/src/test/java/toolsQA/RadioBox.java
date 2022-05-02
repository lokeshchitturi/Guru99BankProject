package toolsQA;

import org.junit.Before;
import org.junit.Test;

import pageObject.ToolsQA;
import tests.Hooks;
import utils.WebdriverUtils;

public class RadioBox extends Hooks {
	ToolsQA radio;

	@Before
	public void intlializePageObject() {
		radio = new ToolsQA(WebdriverUtils.driver);
	}

	@Test
	public void radioButton_validation() throws Exception {
		radio.radioButton();

	}
}