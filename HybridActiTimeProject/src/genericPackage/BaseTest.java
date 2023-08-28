package genericPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class BaseTest implements IAutoConstant{
	protected static WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		Flib flib = new Flib();
		String browserValue = flib.readPropertyData(PROP_PATH, "Browser");
		String url = flib.readPropertyData(PROP_PATH, "Url");
		
		if(browserValue.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_PATH);
			driver=new ChromeDriver();
		}
		
		else if(browserValue.equalsIgnoreCase("edge"))
		{
			System.setProperty(EDGE_KEY, EDGE_PATH);
			driver=new EdgeDriver();
		}
		
		else if(browserValue.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_PATH);
			driver= new FirefoxDriver();
		}
		
		else {
			Reporter.log("Invalid BrowserValue", true);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get(url);
	}
	
	
	
	
	public void failedMethodToTakeScreenshot(String failedMethod)
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(SCREENSHOT_PATH+failedMethod+".png");
		try
		{
			Files.copy(scr, dest);
		}
		
		catch(Exception e)
		{
			
		}
	}
	
	@AfterMethod
	public void tearDown() throws IOException
	{
		driver.quit();
	}
}