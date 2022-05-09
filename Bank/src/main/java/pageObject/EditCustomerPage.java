package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.aventstack.extentreports.Status;

import utils.WebdriverUtils;

public class EditCustomerPage extends WebdriverUtils{

	public EditCustomerPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
	}
	
	@FindBy(name = "cusid")
	WebElement customerId_textbox;
	
	@FindBy(xpath ="//*[@value='Submit']")
	WebElement submit_button;
	
	@FindBy(className = "heading3")
	WebElement heading_element;
	
	public void searchCustomer(String customerId) throws Exception {
		try {
			customerId_textbox.sendKeys(customerId);
			submit_button.click();
			Assert.assertEquals(heading_element.getText().trim(), "Edit Customer");
			test.log(Status.PASS, "Searched the customer with id "+customerId);
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to search the customer with id "+customerId);
			throw new Exception(e);
		}	
	}
	
	
	public void editTheCustomerField(String fieldName,String fieldValue) throws Exception {
		try {
			WebElement customerField= driver.findElement(By.xpath("//td[text()='"+fieldName+"']//following-sibling::td//*[@value or @name='addr']"));
			customerField.clear();
			customerField.sendKeys(fieldValue);
			test.log(Status.PASS, "Edited the customer field "+fieldName+" with the value "+fieldValue);
			submit_button.click();
			Assert.assertFalse(submit_button.isDisplayed());
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to edit the customer field "+fieldName+" with the value "+fieldValue);
			throw new Exception(e);
		}
	}
	
	
}
