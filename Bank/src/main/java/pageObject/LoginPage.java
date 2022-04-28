package pageObject;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebdriverUtils;

public class LoginPage{
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement username_textbox;
	
	@FindBy(name="password")
	WebElement password_textbox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login_button;
	
	@FindBy(css=".heading3")
	WebElement loginSuccessMessage_label;
	
	WebDriver driver;
	Properties prop;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		prop=WebdriverUtils.prop;
	}
	
	
	public void validateLogin() throws Exception {	
		try {
			username_textbox.sendKeys(prop.getProperty("username"));
			password_textbox.sendKeys(prop.getProperty("password"));
			login_button.click();
			Assert.assertTrue(loginSuccessMessage_label.isDisplayed());
			String actualText=loginSuccessMessage_label.getText();
			String expectedText="Welcome To Manager's Page of Guru99 Bank";
			Assert.assertEquals("Welcome message didnot matched",expectedText, actualText);	
		}catch(Exception e) {
			System.out.println(e);
			throw new Exception(e.getMessage());
		}	
	}
	
	public void validateInvalidLogin() throws Exception {
		try {
			username_textbox.sendKeys(prop.getProperty("username"));
			password_textbox.sendKeys("invalidpassword");
			login_button.click();
			String actualText=WebdriverUtils.getAlertTextAndAccept();
			System.out.println(actualText);
			Assert.assertEquals(actualText, "User or Password is not valid");
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
			
		}
		
		
	}
	

}
