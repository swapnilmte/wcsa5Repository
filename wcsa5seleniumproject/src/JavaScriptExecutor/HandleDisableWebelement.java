package JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDisableWebelement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//launch the browser
		WebDriver driver=new ChromeDriver();
		
		//maximize browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch the webapplication
		driver.get("file:///C:/Users/S/Desktop/Web%20element/disable%20element.html");
		
		//To handle disable webelement 
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		
		//to generate alert popup
	//	jse.executeScript("alert(Hello There)")
		
		//identify webelement
		
		driver.findElement(By.id("i1")).sendKeys("admin");
		Thread.sleep(2000);
		
	//	driver.findElement(By.id("i2")).sendKeys("manager");
		Thread.sleep(2000);
		
		//scrolldown
		Thread.sleep(2000);
		jse.executeScript("document.getElementById('i2').value='manager'");
		
		
	}

}
