package newCustomer;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import login.login;


//id<name< linketext < tagname < css < xpath
public class NewCustomer_TestCases {
	static String newcustomer_link = "New Customer";
	static String customername_xpath = "//input[@name='name']";
	static String gender_xpath = "//input[@type=\"radio\"]";
	static String dob_xpath = "//input[@name='dob']";
	static String address_xpath = "//textarea[@name='addr']";
	static String city_xpath = "//input[@name='city']";
	static String state_xpath = "//input[@name='state']";
	static String pin_xpath = "//input[@name='pinno']";
	static String telephoneno_xpath = "//input[@name='telephoneno']";
	static String emailid_xpath = "//input[@name='emailid']";
	static String submit_xpath = "//input[@name='sub']";
	static String password_name="password";
	static String successMessage_className="heading3";
	static WebDriver driver;

	
	public static void selectGender(String gender) throws Exception {
		List<WebElement> list=driver.findElements(By.xpath(gender_xpath));
		if(gender.equalsIgnoreCase("male")) {
			list.get(0).click();
		}else if(gender.equalsIgnoreCase("female")) {
			list.get(1).click();
		}else {
			throw new Exception("Input is not givern either male or female");
		}
		
	}
	
	
	
	public static void createNewCustomer() throws Exception {
		
		WebElement newcustomer=driver.findElement(By.linkText(newcustomer_link));
		newcustomer.click();
		List<WebElement> parentFrame= driver.findElements(By.xpath("//iframe[contains(@id,\"google_ads_iframe\")]"));
		if(parentFrame.size()>0) {
			driver.switchTo().frame(parentFrame.get(0));
			driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
			driver.findElement(By.id("dismiss-button")).click();
			driver.switchTo().defaultContent();
		}
		
		WebElement customername=driver.findElement(By.xpath(customername_xpath));
		customername.sendKeys("Madhuri");
		selectGender("female");
		WebElement dob=driver.findElement(By.xpath(dob_xpath));
		dob.sendKeys("29041992");
		WebElement address=driver.findElement(By.xpath(address_xpath));
		address.sendKeys("MainRoad");
		WebElement city=driver.findElement(By.xpath(city_xpath));
	    city.sendKeys("Kalidindi");
		WebElement state=driver.findElement(By.xpath(state_xpath));
		state.sendKeys("Andhrapradesh");
		WebElement pin=driver.findElement(By.xpath(pin_xpath));
		pin.sendKeys("521344");
		WebElement telephoneno=driver.findElement(By.xpath(telephoneno_xpath));
		telephoneno.sendKeys("1234567890");
		WebElement emailid=driver.findElement(By.xpath(emailid_xpath));
		Random random=new Random();
		emailid.sendKeys("x"+random.nextInt(10000)+"yz"+random.nextInt()+"@gmail.com");
		driver.findElement(By.name(password_name)).sendKeys("abc123");
		WebElement submit=driver.findElement(By.xpath(submit_xpath));
		submit.click();
		WebElement successMessage_element=driver.findElement(By.className(successMessage_className ));
		
		Assert.assertEquals(successMessage_element.getText().trim(), "Customer Registered Successfully!!!");
	}
	
	public static void validateFillAllDetailsErrorMessage() {
		

	}
	
	@Test
	public void test_creatNewCustomer() throws Exception {
		NewCustomer_TestCases.driver=login.loginIntoApplication();
		NewCustomer_TestCases.createNewCustomer();
	}

}