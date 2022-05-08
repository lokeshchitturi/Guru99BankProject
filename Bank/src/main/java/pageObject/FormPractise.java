package pageObject;

		import java.util.Properties;

		import org.junit.Assert;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.support.FindBy;
		import org.openqa.selenium.support.PageFactory;

		import utils.WebdriverUtils;

		public class FormPractise {

			@FindBy(xpath = "//span[text()='Text Box']")
			WebElement textbox;

			@FindBy(xpath = "//input[@id='userName']")
			WebElement userName;

			@FindBy(xpath = "//input[@id='userEmail']")
			WebElement email;

			@FindBy(xpath = "//textarea[@id='currentAddress']")
			WebElement address;

			@FindBy(xpath = "//textarea[@id='permanentAddress']")
			WebElement perAddress;

			@FindBy(xpath = "//button[@id='submit']")
			WebElement submit_button;

			@FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']")
			WebElement successMessage;

			// checkbox
			@FindBy(xpath = "//span[text()='Check Box']")
			WebElement checkbox_xpath;

			@FindBy(xpath = "//span[@class='rct-checkbox']")
			WebElement checkbox_button;

			// radio
			@FindBy(xpath = "//span[text()='Radio Button']")
			WebElement ratio_xpath;

			@FindBy(xpath = "//label[@class='custom-control-label']")
			WebElement input_button;

			@FindBy(xpath = "//input[@id='impressiveRadio']']")
			WebElement impressiveRadio;

			WebDriver driver;
			Properties prop;

			public FormPractise(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
				prop = WebdriverUtils.prop;
			}

			public void textBox() throws Exception {
				try {
					textbox.click();
					userName.sendKeys(prop.getProperty("name"));
					email.sendKeys(prop.getProperty("email"));
					address.sendKeys(prop.getProperty("address"));
					perAddress.sendKeys(prop.getProperty("perAddress"));
					submit_button.click();
					perAddress.sendKeys(prop.getProperty("email"));
					submit_button.click();
				} catch (Exception e) {
					System.out.println(e);
					throw new Exception(e.getMessage());
				}
				
	}

}
