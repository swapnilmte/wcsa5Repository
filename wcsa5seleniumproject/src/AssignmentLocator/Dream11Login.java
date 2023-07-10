package AssignmentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dream11Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 
		  WebDriver driver= new ChromeDriver();
		  driver.manage().window().maximize();
		  
		  driver.get("https://www.dream11.com/login");
		  
		  driver.findElement(By.id("regEmail")).sendKeys("9876543210");
		  
		  Thread.sleep(4000);
		  
		  driver.findElement(By.id("regUser")).click();
		 
		 

	}

}
