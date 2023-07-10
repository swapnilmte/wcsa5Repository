package ScreenshotInterface;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TakesScreenshot3Way {

// create object for driver specific class
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver cdriver = new ChromeDriver();
		
		cdriver.manage().window().maximize();
		cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		cdriver.get("https://www.selenium.dev");
		
		File scr = cdriver.getScreenshotAs(OutputType.FILE);
		
		File Dest = new File("./screenshot/image.png");
		
		Files.copy(scr, Dest);
		
	}
}
