package eCommerceLive;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestCase1 {
	
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	@BeforeTest
	public void setUp() {
		  System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		  driver=new FirefoxDriver();
		  baseUrl ="http://live.techpanda.org/";
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
	}
	
	@Test
	public void testDay1TestCase1() throws Exception {
		// Open the base URL and verify the page title
		driver.get(baseUrl);
		String homePageTitle  = driver.getTitle();
		 Assert.assertEquals(homePageTitle, "Home page", "Home page title does not match!");

		// Verify the demo site header text
	    String demoSite = driver.findElement(By.cssSelector("h2")).getText();
	    Assert.assertEquals(demoSite, "THIS IS DEMO SITE FOR   ", "Demo site text does not match!");
		
		 // Step 3. Click on ‘MOBILE’ menu
		driver.findElement(By.linkText("MOBILE")).click();
		String mobilePageTitle = driver.getTitle();
		Assert.assertEquals(mobilePageTitle, "Mobile", "Mobile page title does not match!");
		
		// Select ‘SORT BY’ dropdown as ‘Name’
		new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
		
		// Step 6. Verify all products are sorted by name
		// Take a screenshot after sorting
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("screenshot/Mobile_Sorted_By_Name.png"));
            System.out.println("Screenshot taken: Mobile_Sorted_By_Name");
        } catch (IOException e) {
            System.err.println("Error while taking screenshot: " + e.getMessage());
        }
    }

	
	@AfterMethod
	public void tearDown() throws Exception {
		if(driver != null ) {
		driver.close();
	}
		try {
	        Runtime.getRuntime().exec("taskkill /F /IM firefox.exe /T");
	        Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
	    } catch (IOException e) {
	        e.printStackTrace();
	}
}
}
