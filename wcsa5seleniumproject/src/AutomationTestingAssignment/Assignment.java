package AutomationTestingAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://app-staging.nokodr.com/");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("dhokpandes@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1111");
		driver.findElement(By.id("staticElement")).click();
		
		driver.quit();
    }
}