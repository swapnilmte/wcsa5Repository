package DropdownHandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GenerateException {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("file:///C:/Users/S/Desktop/Web%20element/Multiselectdropdown.html");
		
		//identify dropDown on webpage
	 	WebElement multidropdd = driver.findElement(By.id("menu"));
		
		// handle the dropDown by createing obj of Select...
		Select sel = new Select(multidropdd);
		 
		 //select the option from dropdown...
		   // use selection methods
		 Thread.sleep(2000);
		 sel.selectByIndex(2); // from single select dropDown
		 
		 Thread.sleep(2000);
		 // try to deselect given option from dropdown
		 sel.deselectByIndex(2);
	}

}
