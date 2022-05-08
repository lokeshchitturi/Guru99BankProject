package pageObject;

		import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import utils.WebdriverUtils;

		public class PractiseFormPage extends WebdriverUtils{
			
			@FindBy(xpath="//input[@id='firstName']")
			WebElement firstName;
			
			@FindBy(xpath="//input[@id='lastName']")
			WebElement lastName;
			
			@FindBy(xpath="//input[@id='userEmail']")
			WebElement email;
			
			@FindBy(xpath="//input[@id='userNumber']")
			WebElement userNum;

			@FindBy(xpath="//label[text()='Female']")
			WebElement gender;
			
			@FindBy(xpath="//input[@id='dateOfBirthInput']")
			WebElement dOB;
			
			@FindBy(xpath="//label[text()='Reading']")
			WebElement hobbise;
			
			@FindBy(xpath="//textarea[@id='currentAddress']")
			WebElement currentAddre;
			
			@FindBy(xpath="//button[text()='Submit']")
			WebElement submit;
			
			public PractiseFormPage() {
				PageFactory.initElements(driver,this);
			}
			
			public void validatePage() throws Exception {	
				try {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.valueOf(prop.getProperty("IMPLICIT_TIMEOUT"))));
					firstName.sendKeys(prop.getProperty("username"));
					test.log(Status.PASS, "Enetered first name as "+prop.getProperty("username"));
					lastName.sendKeys(prop.getProperty("password"));
					test.log(Status.PASS, "Entered LastNAme");
					
					
					
					
					
					firstName.sendKeys(prop.getProperty("username"));
					firstName.sendKeys(prop.getProperty("username"));
					firstName.sendKeys(prop.getProperty("username"));
					firstName.sendKeys(prop.getProperty("username"));
					firstName.sendKeys(prop.getProperty("username"));
					firstName.sendKeys(prop.getProperty("username"));
					test.log(Status.PASS, "Enetered username as "+prop.getProperty("username"));
					lastName.sendKeys(prop.getProperty("password"));
					test.log(Status.PASS, "Entered password");
					email.click();
					test.log(Status.PASS, "Clicked on login button");
					String expectedText="Welcome To Manager's Page of Guru99 Bank";
				}catch(Exception e) {
					System.out.println(e);
					test.log(Status.FAIL, "Unable to login succesfully "+e.getMessage());
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}	
			}
			
		

	}


