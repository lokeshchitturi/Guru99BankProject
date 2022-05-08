package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverUtils {

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Faker faker;
	
	public static final String propertiesFilepath="//src//test//resources//project.properties";
	
	
	
	public static void openBrowser() throws Exception {
		prop=InstanceFactory.intilializePropertyFile(propertiesFilepath);
		
		String browserValue=prop.getProperty("browser");
		
		if(browserValue.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			List<String> list=new ArrayList<String>();
			list.add("--ignore-ssl-errors=yes");
			list.add("--ignore-certificate-errors");
			options.addArguments(list);
			driver=new ChromeDriver(options);
		}else if(browserValue.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			throw new Exception("You have not passed following values in the browser propert : chrome,firefox");
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.valueOf(prop.getProperty("IMPLICIT_TIMEOUT"))));
		
	}
	
	public static String getAlertTextAndAccept() {
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		alert.accept();
		return alertText;
	}
	
	public static int getRandomNumber(int rangeExclusive) {
		Random random =new Random();
		return random.nextInt(rangeExclusive);
	}
	
    public static void setValueByJs(WebElement element,String value) {
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].value='arguments[1]'", element,value);
	}
	

	
	
	

}
