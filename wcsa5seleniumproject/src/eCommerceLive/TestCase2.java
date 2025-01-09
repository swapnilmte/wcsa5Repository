package eCommerceLive;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase2 {
	
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception{
		
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl ="http://live.techpanda.org/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize(); // Ensure the window is maximized
		
	}
	
	@Test
	public void testTestCase2() throws Exception {
		// 1. Go to http://live.techpanda.org
		driver.get(baseUrl);
		
		//2. Click on Mobile menu
		driver.findElement(By.linkText("MOBILE")).click();
		
		// 3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
		String listedPrice = driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();
		
		// 4. Click on Sony Xperia mobile
		driver.findElement(By.id("product-collection-image-1")).click();
		
		//5. read the XPeria mobile price from details page
		String detailsPrice = driver.findElement(By.cssSelector("span.price")).getText();
		
		//6. Product price in list and details page should be equal ($100)
		assertEquals(listedPrice, detailsPrice, "Product prices do not match!");
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		if (driver != null) {
		driver.quit();
	}
		try {
        Runtime.getRuntime().exec("taskkill /F /IM firefox.exe /T");
        Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
    } catch (IOException e) {
        e.printStackTrace();
	}
}
}
