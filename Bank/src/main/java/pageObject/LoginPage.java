package pageObject;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.aventstack.extentreports.Status;

import utils.WebdriverUtils;

public class LoginPage extends WebdriverUtils{
	
	@FindBy(xpath="//input[@name='uid']")
	public WebElement username_textbox;
	
	@FindBy(name="password")
	public WebElement password_textbox;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement login_button;
	
	@FindBy(css=".heading3")
	public WebElement loginSuccessMessage_label;
	
	@FindBy(xpath = "//*[text()='Password must not be blank']")
	public WebElement passwordError_label;

	
	public LoginPage() {
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
		PageFactory.initElements(driver, this);

	}
	
	public void enterUserName() throws Exception {
		try {
			username_textbox.sendKeys(prop.getProperty("username"));
			test.log(Status.PASS, "Enetered username as "+prop.getProperty("username"));
		}
		catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to enter username");
			throw new Exception(e);
		}
		
	}
	
	public void validateLogin() throws Exception {	
		try {
			enterUserName();
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
	
	public void validatePageTitle(String titleName) throws Exception {
		try {
			String actualTitle=driver.getTitle();
			Assert.assertEquals(actualTitle, titleName);
			test.log(Status.PASS, "Page Title Matched");
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Page title didn't matched");
			throw new Exception(e);
		}
	}
	
	public void validatePasswordErrorMessage() throws Exception {
		enterUserName();
		login_button.click();
		String actualText=WebdriverUtils.getAlertTextAndAccept();
		System.out.println(actualText);
		Assert.assertEquals(actualText, "User or Password is not valid");
		test.log(Status.PASS, "Didnot login by providing invalid password");	
//		String passwordErrorText=passwordError_label.getText();
//		Assert.assertEquals(passwordErrorText, "Password must not be blank");
//		Assert.assertTrue(passwordError_label.isDisplayed());
//		test.log(Status.PASS, "Error message displayed");
	}
	

}
