package DropdownHandling;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RemoveTheDuplicateUsingSet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("file:///C:/Users/S/Desktop/Web%20element/mutiDropdown.html");
		
		WebElement Dropdown = driver.findElement(By.id("i2"));
		
		Select sel = new Select(Dropdown);
		
		
		HashSet<String> set = new HashSet<String>();
		
		List<WebElement> allops = sel.getOptions();
		
		for (int i=0; i<allops.size(); i++) {
			WebElement op = allops.get(i);
			
			String value = op.getText();
		  set.add(value);
		 
		}
		
		for(String element:set)
		{
			Thread.sleep(2000);
			 System.out.println(element);
		}
	}

}
