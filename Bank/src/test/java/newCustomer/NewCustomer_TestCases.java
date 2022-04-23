package newCustomer;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import login.login;

public class NewCustomer_TestCases {
	String NewCustomer_xpath = "//li/a[@href='addcustomerpage.php']";
	String Customername_xpath = "//td/input[@name='name']";
	String Gender_xpath = "//td/input[@name='rad1']";
	String DOB_xpath = "//td/input[@name='dob']";
	String Address_xpath = "//td/textarea[@name='addr']";
	String City_xpath = "//td/input[@name='city']";
	String State_xpath = "//td/input[@name='state']";
	String Pin_xpath = "//td/input[@name='pinno']";
	String TelephoneNo_xpath = "//td/input[@name='telephoneno']";
	String EmailId_xpath = "//td/input[@name='emailid']";
	String Submit_xpath = "//td/input[@name='sub']";
	static WebDriver driver;

	public static void createNewCustomer() {

		driver.findElement(By.xpath("//li/a[@href='addcustomerpage.php']")).click();
		driver.findElement(By.xpath("//td/input[@name='name']")).sendKeys("Madhuri");
		driver.findElement(By.xpath("//td/input[@name='rad1']")).sendKeys("f");
		driver.findElement(By.xpath("//td/input[@name='dob']")).sendKeys("29041992");
		driver.findElement(By.xpath("//td/textarea[@name='addr']")).sendKeys("MainRoad");
		driver.findElement(By.xpath("//td/input[@name='city']")).sendKeys("Kalidindi");
		driver.findElement(By.xpath("//td/input[@name='state']")).sendKeys("Andhrapradesh");
		driver.findElement(By.xpath("//td/input[@name='pinno']")).sendKeys("521344");
		driver.findElement(By.xpath("//td/input[@name='telephoneno']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//td/input[@name='emailid']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//td/input[@name='sub']")).click();
		System.out.println("Test");

	}

	public static void main(String[] args) throws Exception {
		try {
			
		
			NewCustomer_TestCases.driver=login.loginIntoApplication();
			//driver.findElement(By.xpath("//li/a[@href='addcustomerpage.php']")).click();
			
			//driver=login.loginIntoApplication();
			NewCustomer_TestCases.createNewCustomer();
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}