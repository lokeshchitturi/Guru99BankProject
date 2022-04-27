package tests;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.WebdriverUtils;

public class login extends Hooks {
	
	private static String uid_xpath="//input[@name='uid']";
	private static String pwd_xpath="//input[@name='password']";
	private static String login_xpath="//input[@type='submit']";
	private static String successLogin_messag_css=".heading3";
	static Properties prop;
	
	
	public static WebDriver loginIntoApplication() {
		WebDriver driver=WebdriverUtils.driver;
		try {
			prop=WebdriverUtils.prop;
			WebElement uid=driver.findElement(By.xpath(uid_xpath));
			uid.sendKeys(prop.getProperty("username"));
			WebElement pwd=driver.findElement(By.xpath(pwd_xpath));
			pwd.sendKeys(prop.getProperty("password"));
			WebElement login=driver.findElement(By.xpath(login_xpath));
			login.click();
			WebElement successElement= driver.findElement(By.cssSelector(successLogin_messag_css));
			Assert.assertTrue(successElement.isDisplayed());
			
			String actualText=successElement.getText();
			
			String expectedText="Welcome To Manager's Page of Guru99 Bank";
			Assert.assertEquals("Welcome message didnot matched",expectedText, actualText);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return driver;
	}
	
	@Test
	public void test_loginIntoApplication() {
		login.loginIntoApplication();
	}

}