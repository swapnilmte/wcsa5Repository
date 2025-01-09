package eCommerceLive;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase3 {
	
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl ="http://live.techpanda.org/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize(); // Ensure the window is maximized
	}
	
	@Test
	public void testTestCase3(){
		// Step 1: Open the website
		driver.get(baseUrl);
		
		// Step 2: Click on Mobile option
		driver.findElement(By.linkText("MOBILE")).click();
		
		// Step 3: Click on Add to Cart button for Sony Xperia mobile
		driver.findElement(By.xpath("//a[@title='Sony Xperia']/../following-sibling::div/button")).click();
		
		// Step 4: Clear quantity and set it to 1000
		driver.findElement(By.xpath("//input[@title='Qty']")).clear();
        driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("1000");
        
        // Step 5: Click on Update button
        driver.findElement(By.xpath("//button[@title='Update']")).click();
        
        // Step 6: Verify the error message
        String actualErrorMsg = driver.findElement(By.xpath("//p[contains(@class, 'item-msg')]")).getText();
        String expectedErrorMsg =  "* The maximum quantity allowed for purchase is 500.";
		
        assertEquals(actualErrorMsg, expectedErrorMsg, "Error message mismatch!");
        
        // Step 7: Click on Empty Cart button.
		//driver.findElement(By.linkText("Empty Cart")).click();         another way to locate 
        driver.findElement(By.id("empty_cart_button")).click();

		
     // Step 8: Verify the cart is empty
        String actualCartMsg = driver.findElement(By.cssSelector(".cart-empty p")).getText();
        String expectedCartMsg = "You have no items in your shopping cart.";
        assertEquals(actualCartMsg, expectedCartMsg, "Cart empty message mismatch!");
	    
	    
	}

		@AfterMethod
		public void tearDown() throws Exception {
			if(driver != null ) {
		Thread.sleep(1000);
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