import java.io.File;
import java.io.IOException;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class captureScreenshot {
	@Test
	public void Capturing_Screenshot() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		
	    // Typecasting from WebDriver to TakesScreenshot
		
		 TakesScreenshot ts = (TakesScreenshot) driver;
		    
		    File src = ts.getScreenshotAs(OutputType.FILE);
		    
		    File dest = new File("./screenshot/google.png");
		    
		    Files.copy(src, dest);
		    
		System.out.println("screenshot is captured and stored in");
	}

}
