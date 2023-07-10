package wcsa5seleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLaunchChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
     
		WebDriver driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.google.com/");
     
      Thread.sleep(2000);
      
      driver.close();
	}

}
