package login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	
	public static String uid_xpath="//input[@name='uid']";
	public static String pwd_xpath="//input[@name='password']";
	public static String login_xpath="//td//input[@type='submit']";
	
	public static void main(String[] args) {

		try {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			driver.get("https://demo.guru99.com/V1/index.php");
			WebElement uid=driver.findElement(By.xpath(uid_xpath));
			uid.sendKeys("mngr400118");
			WebElement pwd=driver.findElement(By.xpath(pwd_xpath));
			pwd.sendKeys("gUnemAq");
			WebElement login=driver.findElement(By.xpath(login_xpath));
			login.click();
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
