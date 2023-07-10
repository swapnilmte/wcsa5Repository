package AcitonsClassMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementMethod {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
	   
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   
	// launch the bluestone web application.
	   driver.get("https://www.bluestone.com/"); 
	   
	   driver.findElement(By.id("denyBtn")).click(); // handle the popup
	   
	  // driver.findElement(By.xpath("//a[contains(text(),'Watch')]")).click();   
	   //click() is performing click action directly but we dont want click
	   
	  WebElement target = driver.findElement(By.xpath("//a[contains(text(),'Watch')]"));
	  
	// to perform mouse actions on webelement..
	    
	  Actions action = new Actions(driver);
	    // to perform mouseHover action
	     
	     action.moveToElement(target).perform();
	     
	     driver.findElement(By.xpath("//a[.='Band']")).click();
	}
}
