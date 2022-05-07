package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import utils.WebdriverUtils;

public class HomePage extends WebdriverUtils{
	
	
	@FindBy(linkText = "Manager")
	WebElement manager_link;
	
	@FindBy(linkText = "New Customer")
	WebElement newCustomer_link;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);

	}
	
	
	public void navigateToTab(String tabName) throws Exception {
		
		try {
			WebElement tab= driver.findElement(By.linkText(tabName));
			tab.click();
			test.log(Status.PASS, "Navigated to the tab "+tabName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(Status.FAIL, "Unable to navigate to the tab"+tabName);
			throw new Exception(e);
		}
		
	}

}
