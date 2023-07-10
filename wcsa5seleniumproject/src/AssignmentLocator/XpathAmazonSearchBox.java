package AssignmentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAmazonSearchBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@id,'twotabsearchtextbox')]")).sendKeys("HP laptop");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@id,'nav-search-submit-button')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'HP 15s, AMD Ryzen 3')]")).click();


	}

}
