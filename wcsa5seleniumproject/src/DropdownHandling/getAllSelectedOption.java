package DropdownHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class getAllSelectedOption {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("file:///C:/Users/S/Desktop/Web%20element/Multiselectdropdown.html");
		
		WebElement Dropdown = driver.findElement(By.id("menu"));
		//check wheather dropdown option is displayed or not
		 Select sel = new Select(Dropdown);
		 
		 for(int i=2; i<=5; i++)
		 {
			 Thread.sleep(1000);
			 sel.selectByIndex(i);
		 }
			 List<WebElement> allopts = sel.getAllSelectedOptions();
			 for(WebElement op:allopts) 
			 {
				 Thread.sleep(1000);
				 System.out.println(op.getText());
			 }
	}

}
