/*      
Test Steps:
1. Goto http://live.techpanda.org/
2. Click on ‘MOBILE’ menu
3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Sony Xperia & Iphone)
4. Click on ‘COMPARE’ button. A popup window opens
5. Verify the pop-up window and check that the products are reflected in it
   Heading "COMPARE PRODUCTS" with selected products in it.
6. Close the Popup Windows
*/
package eCommerceLive;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase4 {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl ="http://live.techpanda.org/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize(); // Ensure the window is maximized;
	}
	
	@Test
	public void testTestCase4() throws Exception{
		// Step 1: Open the website
		driver.get(baseUrl);
				
		// Step 2: Click on Mobile option
		driver.findElement(By.linkText("MOBILE")).click();
		Thread.sleep(1000);
		
		// Step 3: Add 'IPhone' to Compare
		driver.findElement(By.cssSelector("div.product-info:has(h2 a[text='SONY XPERIA']) .link-compare")).click();
		System.out.println("Added Sony Xperia to compare.");
	   
	    
	    // Step 3.1: Add 'Sony Xperia' to Compare
	    driver.findElement(By.xpath("//h2/a[text()='IPHONE']/ancestor::div[@class='product-info']//a[contains(@class, 'link-compare')]")).click();   
	    System.out.println("Added IPhone to compare.");
	    
		
        // Step 4: Click on Compare button
        driver.findElement(By.xpath("//button[@title='compare']")).click();
        
        
        // switching to new window
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
	    }
        }
	    
		//Step 5: Verify the popup window and check that the products are reflected in it
		//    Heading "COMPARE PRODUCTS" with selected products in it.
	    String popupHeading  = driver.findElement(By.cssSelector("h1")).getText();	
	    assertEquals(popupHeading, "COMPARE PRODUCTS", "Popup heading mismatch!");

	    // Verify the products in the popup
	    String popupMobile1 = driver.findElement(By.xpath("//a[@title='Sony Xperia']")).getText();
        String popupMobile2 = driver.findElement(By.xpath("//a[@title='IPhone']")).getText(); // text captured "SONY XPERIA" in uppercase
        assertEquals(popupMobile1, "SONY XPERIA", "Sony Xperia not found in popup!");
        assertEquals(popupMobile2, "IPHONE", "IPhone not found in popup!");

        System.out.println("Both products are displayed correctly in the popup.");
	    Thread.sleep(1000);
	 
		//Step 6: Check if the products are listed in the popup
	    driver.findElement(By.cssSelector("button[title='Close Window']")).click();

	    driver.switchTo().window(mainWindowHandle);
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
		} 	catch (IOException e) {
			e.printStackTrace();
			}
		}
}