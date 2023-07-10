package AssignmentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathOfSpicejet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://spiceclub.spicejet.com/signup");
		driver.findElement(By.xpath("//select[@class='form-control form-select']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("abc");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("xyz");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@class='form-control form-select']"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='dobDate']")).sendKeys("27/07/1999");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='+91 01234 56789']")).sendKeys("7775998000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='email_id']")).sendKeys("abc@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='new-password']")).sendKeys("abcdef");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='c-password']")).sendKeys("abcdef");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='defaultCheck1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-red']")).click();
		

	}

}
