package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement username_textbox;
	
	@FindBy(name="password")
	WebElement password_textbox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login_button;
	
	@FindBy(css=".heading3")
	WebElement loginSuccessMessage_label;
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,LoginPage.class);
		
	}
	
	
	public void validateLogin() {
		
		
		
		
		
	}
	

}
