package testExecution;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test2 {
  @Test
  public void test2method() throws InterruptedException {
	  
	  System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
	  WebDriver driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.get("https://www.google.com");
	  driver.switchTo().activeElement().sendKeys("JAVA",Keys.ENTER);
	  Thread.sleep(2000);
	  driver.quit();
  }
}
