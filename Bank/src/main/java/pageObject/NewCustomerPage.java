package pageObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;
import utils.WebdriverUtils;

public class NewCustomerPage extends WebdriverUtils{
	
	@FindBy(xpath = "//iframe[contains(@id,'google_ads_iframe')]")
	WebElement googleAd_iframe;
	
	@FindBys(@FindBy(id="dismiss-button"))
	List<WebElement> dismiss_button;
	
	@FindBy(id="ad_iframe")
	WebElement ad_iframe;
	
	@FindBy(name = "name")
	WebElement customerName_textbox;
	
	@FindBys({@FindBy(xpath="//*[@type='radio']")})
	List<WebElement> gender_list;
	
	@FindBy(id="dob")
	WebElement dob_date;
	
	@FindBy(name = "addr")
	WebElement address_textarea;
	
	@FindBy(name="city")
	WebElement city_textbox;
	
	@FindBy(name = "state")
	WebElement state_textbox;
	
	@FindBy(name="pinno")
	WebElement pinno_textbox;
	
	@FindBy(name="telephoneno")
	WebElement mobilenumber_textbox;
	
	@FindBy(name="emailid")
	WebElement emailId_textbox;
	
	@FindBy(name="password")
	WebElement password_textbox;
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submit_button;
	
	@FindBy(className = "heading3")
	WebElement heading;
	
	
	public NewCustomerPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
	}
	
	
	public void closeTheGoogleAdd() throws Exception {
		
		try {
			if(googleAd_iframe.isDisplayed()) {
				driver.switchTo().frame(googleAd_iframe);
				test.log(Status.PASS, "Switched to the parent frame ");
				driver.switchTo().frame(ad_iframe);
				dismiss_button=driver.findElements(By.id("dismiss-button"));
				if(dismiss_button.size()>0) {
					dismiss_button.get(0).click();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to close the google Add");
			throw new Exception(e);
		}
	}
	
	
	public void createNewCustomer() {
		
		customerName_textbox.sendKeys(faker.name().firstName());
		int radioIndex=getRandomNumber(2);
		gender_list.get(radioIndex).click();
		Date dob=faker.date().birthday(18, 50);
		SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy");
		dob_date.sendKeys(sdf.format(dob));
	//	setValueByJs(dob_date, sdf.format(dob));
		address_textarea.sendKeys(faker.address().buildingNumber());
		city_textbox.sendKeys(faker.address().city());
		state_textbox.sendKeys(faker.address().state());
		pinno_textbox.sendKeys(String.format("%06d", getRandomNumber(7)));
		mobilenumber_textbox.sendKeys(String.format("%010d", getRandomNumber(11)));
		emailId_textbox.sendKeys(faker.internet().emailAddress());
		password_textbox.sendKeys(faker.name().firstName());
		submit_button.click();
		Assert.assertEquals(heading.getText(), "Customer Registered Successfully!!!");
	}
	
	public static void main(String[] args) {
		Date dob=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy");
		System.out.println(sdf.format(dob));
	}
	
}
