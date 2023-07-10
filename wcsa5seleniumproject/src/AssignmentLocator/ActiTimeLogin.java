package AssignmentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiTimeLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 
		    WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("http://127.0.0.1/login.do;jsessionid=20olj5kekmkvg");
			
			//to identify web element we use  locators
			driver.findElement(By.name("username")).sendKeys("admin"); //username TextBox
			
			Thread.sleep(2000);
		    driver.findElement(By.name("pwd")).sendKeys("manager");  //password
		    
		    Thread.sleep(4000);
		    
		    driver.findElement(By.id("loginButton")).click();
		    
		    Thread.sleep(2000);
		    
		    driver.findElement(By.linkText("Logout")).click();

	}

}
