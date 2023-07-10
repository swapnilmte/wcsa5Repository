package AcitonsClassMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClickMethod {

	//use to perform right click
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   
		// launch the web application.
		   driver.get("file:///C:/Users/S/Desktop/Web%20element/Dropdown.html"); 
		   
		  WebElement target = driver.findElement(By.id("menu"));
		  
		  //to perform right click
		  Actions act = new Actions(driver);
		  Thread.sleep(1000);
		  act.contextClick(target).perform();
	}

}
