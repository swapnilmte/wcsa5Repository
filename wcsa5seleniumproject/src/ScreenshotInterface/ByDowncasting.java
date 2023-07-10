package ScreenshotInterface;

	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;

	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.remote.RemoteWebDriver;

	import com.google.common.io.Files;

	public class ByDowncasting {

		public static void main(String[] args) throws IOException {
			
			//1st way of taking screenshot by downcasting
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		    WebDriver driver=new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    
		    driver.get("https://www.facebook.com/");
		    
		    // By downcasting to RemoteWebDriver class
		    
		    RemoteWebDriver rwd = (RemoteWebDriver)driver;
		    File src = rwd.getScreenshotAs(OutputType.FILE);
		    File dest = new File("./screenshot/Facebook.png");
		    
		    Files.copy(src, dest);
		}
}
