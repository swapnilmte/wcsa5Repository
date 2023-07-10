package AssignmentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathCase2TextFunction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://spiceclub.spicejet.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='d-none d-lg-block']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='+91 01234 56789']")).sendKeys("9879879879");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abcd");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Log In']")).click();
		

	}

}
