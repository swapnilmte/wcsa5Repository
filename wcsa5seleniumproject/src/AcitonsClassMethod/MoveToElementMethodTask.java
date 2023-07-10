package AcitonsClassMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementMethodTask {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		   System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   
		// launch the bluestone web application.
		   driver.get("https://www.bluestone.com/"); 
		  
		   driver.findElement(By.id("denyBtn")).click(); // handle the popup
		
		   
		   WebElement target = driver.findElement(By.xpath("//a[text()='Coins ']"));
		   
		// to perform mouse actions on webelement. craete object of action class
		  Actions act = new Actions(driver);
		  
		  // to perform mouseHover action
		  
		  act.moveToElement(target).perform();
		  
		  driver.findElement(By.xpath("//span[text()='5 gram' and (@data-p='gold-coins-weight-5gms,m')]")).click();
		
		 WebElement coin = driver.findElement(By.xpath("//a[@id='5922']"));
	
		  if (coin.isDisplayed())
		  {
			  driver.quit();
		  }
		  
		  else {
			  System.out.println("Exception...");
		  }
	}

}
