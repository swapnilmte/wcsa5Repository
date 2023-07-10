package AssignmentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		    WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com/login/");
			
			//to identify web element we use  locators
			driver.findElement(By.id("email")).sendKeys("swapnil@12gmail.com"); //username TextBox
			
			Thread.sleep(2000);
			
			
		    driver.findElement(By.id("pass")).sendKeys("swapnil");  //password
		    
		    Thread.sleep(4000);
		    
		    driver.findElement(By.id("loginbutton")).click();
		 
		
	}
}
