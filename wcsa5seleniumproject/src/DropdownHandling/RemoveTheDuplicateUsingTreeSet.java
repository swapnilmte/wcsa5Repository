package DropdownHandling;

import java.time.Duration;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RemoveTheDuplicateUsingTreeSet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("file:///C:/Users/S/Desktop/Web%20element/mutiDropdown.html");
		
		WebElement Dropdown = driver.findElement(By.id("i2"));
		
		Select sel = new Select(Dropdown);
		
		
		TreeSet<String> ts = new TreeSet<String>();
		
		List<WebElement> allops = sel.getOptions();
		
		for (int i=0; i<allops.size(); i++) {
			WebElement op = allops.get(i);
			
			String value = op.getText();
		  ts.add(value);
		 
		}
		
		for(String element:ts)
		{
			Thread.sleep(2000);
			 System.out.println(element);
		}
	}

}
