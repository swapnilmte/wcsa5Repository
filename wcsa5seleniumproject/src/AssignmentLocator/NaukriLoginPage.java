package AssignmentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaukriLoginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		    WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.naukri.com/nlogin/login");
			
			//to identify web element we use  locators
			driver.findElement(By.id("usernameField")).sendKeys("swapnil@12gmail.com"); //username TextBox
			
			Thread.sleep(2000);
			
			
		    driver.findElement(By.id("passwordField")).sendKeys("swapnil");  //password
		    
		    Thread.sleep(4000);
		    
		    driver.findElement(By.className("waves-effect waves-light btn-large btn-block btn-bold blue-btn textTransform")).click();

	}

}
