package DropdownHandling;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DeselectAll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver.", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("file:///C:/Users/S/Desktop/Web%20element/Multiselectdropdown.html");
		
		WebElement multiselectDD = driver.findElement(By.id("menu"));
		
		 Select sel = new Select(multiselectDD);
		 
		// To select Multiple options using for loop
			for(int i=0 ; i<5; i++) 
			{
				sel.selectByIndex(i);
				Thread.sleep(1000);
			}
		
			// To deselect Multiple options using for loop
//			for(int i=0; i<5; i++)
//			{
//				sel.deselectByIndex(i);
//				Thread.sleep(1000);
//			}
//			
			// To deselect all options using deselectAll()
			sel.deselectAll();

		
	}

}
