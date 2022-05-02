package pageObject;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebdriverUtils;

public class ToolsQA {

	//textbox
	@FindBy(xpath = "//span[text()='Text Box']")
	WebElement textBox_xpath;

	@FindBy(xpath = "//input[@id='userName']")
	WebElement fullName_xpath;

	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement userEmail_xpath;

	@FindBy(xpath = "//textarea[@id='currentAddress']")
	WebElement currentAddress_xpath;

	@FindBy(xpath = "//textarea[@id='permanentAddress']")
	WebElement permanentAddress_xpath;

	@FindBy(xpath = "//button[@id='submit']")
	WebElement submitButton_xpath;
	
	
	//Checkbox
	
	@FindBy(xpath = "//span[text()='Check Box']")
	WebElement checkBox_xpath;
	

	@FindBy(xpath = "//span//button[@type='button']")
	WebElement homeToggile_xpath;
	
	
	
	
	//radiobutton
	@FindBy(xpath = "//span[text()='Radio Button']")
	WebElement radioButton_xpath;
	
	@FindBy(xpath = "//input[@id='impressiveRadio']")
	WebElement impressiveRadio_xpath;
	
	@FindBy(xpath = "//span[text()='Impressive']")
	WebElement impressive_xpath;
	
	
	
	

	WebDriver driver;
	Properties prop;

	public ToolsQA(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		prop = WebdriverUtils.prop;
	}

	public void textBox() throws Exception {
		try {
			textBox_xpath.click();
			fullName_xpath.sendKeys(prop.getProperty("name"));
			Thread.sleep(30);
			userEmail_xpath.sendKeys(prop.getProperty("email"));
			Thread.sleep(30);
			currentAddress_xpath.sendKeys(prop.getProperty("address"));
			Thread.sleep(30);
			permanentAddress_xpath.sendKeys(prop.getProperty("address"));
			Thread.sleep(30);
			submitButton_xpath.click();

		} catch (Exception e) {
			System.out.println(e);
			throw new Exception(e.getMessage());
		}
	}

	public void checkBox() throws Exception {
		try {
			checkBox_xpath.click();
			homeToggile_xpath.click();

		} catch (Exception e) {
			System.out.println(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public void radioButton() throws Exception {
		try {
			radioButton_xpath.click();
			impressiveRadio_xpath.click();
			Assert.assertTrue(impressive_xpath.isDisplayed());
			String actualText=impressive_xpath.getText();
			String expectedText="Impressive";
			Thread.sleep(30);
			Assert.assertEquals("Impressive",expectedText, actualText);	
			
			
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception(e.getMessage());
		}
	}
		}
