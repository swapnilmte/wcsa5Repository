package AcitonsClassMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignmentContextClickMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   
		// launch the web application.
		   driver.get("file:///C:/Users/S/Desktop/Web%20element/mutiDropdown.html"); 
		   
		   WebElement target = driver.findElement(By.id("i2"));
		   
		   Actions act = new Actions(driver);
		   
		   act.contextClick(target).perform();
		   
		   
		   
		   
		   
	}

}
