import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Navigate_forward_back {
	

@Test
 public void Navigate_forward_back() throws InterruptedException
{
		//1. Open the Chrome Browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Open the URL
		driver.get("https://www.google.com");
		
		//navigate on specific software web application page or URL
		driver.navigate().to("https://selenium-venkat.blogspot.com/p/index_4.html");
		
		Thread.sleep(2000);
		
		//To navigate back (Same as clicking on browser back button)
		driver.navigate().back();
		
		Thread.sleep(2000);
		//To navigate forward (Same as clicking on browser forward button)
		driver.navigate().forward();
				
}	
}
