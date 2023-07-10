package AssignmentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.netflix.com/in/login");
	
	//to identify web element we use  locators
	driver.findElement(By.id("id_userLoginId")).sendKeys("swapnil@12gmail.com"); //username TextBox
	
	Thread.sleep(2000);
	
	
    driver.findElement(By.id("id_password")).sendKeys("swapnil");  //password
    
    Thread.sleep(4000);
    
    driver.findElement(By.className("btn login-button btn-submit btn-small")).click();
 
	}

}
