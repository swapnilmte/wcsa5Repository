package wcsa5seleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToLaunchFirefoxBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
     
		WebDriver driver= new FirefoxDriver();
      driver.manage().window().maximize();
      driver.get("https://www.google.com/");
     
      Thread.sleep(2000);
      
      driver.close();
	}

}
