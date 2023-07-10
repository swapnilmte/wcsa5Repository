package AssignmentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AssignmentOnXpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://www.hotstar.com/in/mypage#mp-login");
		
		driver.findElement(By.xpath("//input[@id='7']"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Get OTP']"));

	}

}
