package DropdownHandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class isMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("file:///C:/Users/S/Desktop/Web%20element/Multiselectdropdown.html");
		
		WebElement Dropdown = driver.findElement(By.id("menu"));
		//check wheather dropdown is multi select or not
		 Select sel = new Select(Dropdown);
		 boolean value = sel.isMultiple();
		 System.out.println(value);

	}

}
