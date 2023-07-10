package wcsa5seleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ToLaunchEdgeBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
     
		WebDriver driver= new EdgeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.google.com/");
     
      Thread.sleep(2000);
      
      driver.close();
	}

}
