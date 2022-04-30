package pageObject;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import utils.WebdriverUtils;

public class LoginPage extends WebdriverUtils{
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement username_textbox;
	
	@FindBy(name="password")
	WebElement password_textbox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login_button;
	
	@FindBy(css=".heading3")
	WebElement loginSuccessMessage_label;

	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void validateLogin() throws Exception {	
		try {
			username_textbox.sendKeys(prop.getProperty("username"));
			test.log(Status.PASS, "Enetered username as "+prop.getProperty("username"));
			password_textbox.sendKeys(prop.getProperty("password"));
			test.log(Status.PASS, "Entered password");
			login_button.click();
			test.log(Status.PASS, "Clicked on login button");
			Assert.assertTrue(loginSuccessMessage_label.isDisplayed());
			String actualText=loginSuccessMessage_label.getText();
			String expectedText="Welcome To Manager's Page of Guru99 Bank";
			Assert.assertEquals("Welcome message didnot matched",expectedText, actualText);	
			test.log(Status.PASS, "Login is succesfull");
		}catch(Exception e) {
			System.out.println(e);
			test.log(Status.FAIL, "Unable to login succesfully "+e.getMessage());
			e.printStackTrace();
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
			test.log(Status.PASS, "Didnot login by providing invalid password");
		}
		catch(Exception e) {
			test.log(Status.FAIL, "Login  Error message didnt displayed "+e.getMessage());
			e.printStackTrace();
			throw new Exception(e);
			
		}
		
		
	}
	

}
