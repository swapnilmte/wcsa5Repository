package WebsiteTesingDay1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScript01 {
public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		String baseUrl = "http://www.demo.guru99.com/V4/";
		//String expectedTitle = "Welcome: Guru Bank Homepage";
	    //  String actualTitle = "";
		
		driver.get(baseUrl);
		
		// get the actual value of the title
//        actualTitle = driver.getTitle();
//        System.out.println(actualTitle);
		
		driver.findElement(By.name("uid")).sendKeys("mngr603881");
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("jYjYhEn");
		Thread.sleep(1000);
		driver.findElement(By.name("btnLogin")).click();
		
		Thread.sleep(1000);
		driver.close();
	}

}
