package AssignmentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpicejetLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
	    WebDriver driver1 = new ChromeDriver(co);
		
		driver1.manage().window().maximize();
		
		driver1.get("https://www.spicejet.com/");
		driver1.findElement(By.xpath("//div[text()='Login']")).click();
		Thread.sleep(2000);
		driver1.findElement(By.xpath("//input[@type='number']")).sendKeys("9876543210");
		Thread.sleep(2000);
		driver1.findElement(By.xpath("//input[@type='password']")).sendKeys("abcdef");
		Thread.sleep(2000);
		driver1.findElement(By.xpath("//div[@style='border-radius: 0px;']']")).click();
		Thread.sleep(2000);

	}

}
