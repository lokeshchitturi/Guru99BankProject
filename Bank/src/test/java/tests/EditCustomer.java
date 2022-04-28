package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditCustomer {
	private static String editCustomer = "//input[@name='Edit Customer']";
	public static void editCustom() {
		WebDriver driver=null;
		try {
			
		//	 login.loginIntoApplication();
				Thread.sleep(3000);
				WebElement editCus= driver.findElement(By.xpath(editCustomer));
				editCus.click();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Not able to click on Edit Custom");
		}
	}
	
	public static void main(String[] args) {
		EditCustomer.editCustom();	
		

	}

}
