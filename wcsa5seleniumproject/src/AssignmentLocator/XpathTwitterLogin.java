package AssignmentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTwitterLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
       System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://twitter.com/i/flow/login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("9998889998");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'css-901oao r-1awozwy r-6')]")).click();
	}

}
