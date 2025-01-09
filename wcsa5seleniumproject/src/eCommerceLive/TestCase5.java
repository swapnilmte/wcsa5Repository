package eCommerceLive;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
/*     Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.  
Test Steps:
1. Go to http://live.techpanda.org/
2. Click on my account link
3. Click Create an Account link and fill New User information except Email ID
4. Click Register
5. Verify Registration is done. Expected account registration done.
6. Go to TV menu
7. Add product in your wish list - use product - LG LCD
8. Click SHARE WISHLIST 
9. In next page enter Email and a message and click SHARE WISHLIST
10.Check wishlist is shared. Expected wishlist shared successfully. 

*/
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase5 {
	
	private WebDriver driver;
    private String baseUrl;
    public String FirstName ="John";
    public String LastName ="Wick";
    
    @BeforeMethod
    public void setUp() throws Exception{
    	System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
    	driver =new FirefoxDriver();
    	baseUrl = "http://live.techpanda.org/";
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    }
    
    @Test
    public void testTestCase5() throws Exception {
    	
    	// Step 1: Open the website
    	driver.get(baseUrl);
    	
    	//Step 2: click on my account link
    	driver.findElement(By.linkText("MY ACCOUNT")).click();
    	
    	//Step 3: Click on create new account link and fill all the details except Email
    	driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();
    	
    	 // switching to new window
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
	    driver.findElement(By.id("firstname")).clear();
    	driver.findElement(By.id("firstname")).sendKeys(FirstName);
    	Thread.sleep(1000);
    	
    	driver.findElement(By.id("lastname")).clear();
    	driver.findElement(By.id("lastname")).sendKeys(LastName);
    	Thread.sleep(1000);
    	
    	driver.findElement(By.id("email_address")).clear();
	    driver.findElement(By.id("email_address")).sendKeys("johnWeak@apk.com");
	    Thread.sleep(1000);
	    
	    driver.findElement(By.id("password")).clear();
    	driver.findElement(By.id("password")).sendKeys("Abcd@22");
    	Thread.sleep(1000);
    	
    	driver.findElement(By.id("confirmation")).clear();
    	driver.findElement(By.id("confirmation")).sendKeys("Abcd@22");
    	Thread.sleep(1000);            
    	
    	driver.findElement(By.xpath("//button[@title='Register']")).click();
    	//driver.findElement(By.className("button")).click();
    	
    	// switching to new window
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
    	//Step 4: Verify registraion is done
	    String expectedWelcome  = ("Hello, " + FirstName + " " + LastName + "!");
	    String actualWelcome  =  driver.findElement(By.xpath("//div[@class='welcome-msg']//strong")).getText();
	    assertEquals(actualWelcome, expectedWelcome, "Registration welcome message mismatch!");
	    
    	//Step 5: Go to the TV
    	driver.findElement(By.linkText("TV")).click();
    	Thread.sleep(1000);
    	 
    	//Step 6: Add product to wishlist
    	driver.findElement(By.className("link-wishlist")).click();
    	
    	 // switching to new window
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
    	//Step 7: CLick on shared wishlist
	    driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
	    
	    Thread.sleep(1000);
	    
	    // 9. In next page enter Email and a message and click SHARE WISHLIST
	    driver.findElement(By.id("email_address")).clear();
	    driver.findElement(By.id("email_address")).sendKeys("support@guru99.com");
	    driver.findElement(By.id("message")).clear();
	    driver.findElement(By.id("message")).sendKeys("Hey Mary! This LCD TV looks great, check it out!");
	    
	    driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
	    // the above click will still be in the same page as prior page, so no need take another handle to another window	    
	    
	    // 10. Check wishlist is shared. Expected wishlist shared successfully. 
	    String expectedMessage  = "Your Wishlist has been shared.";
	    String actualMessage  =driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
	    assertEquals(actualMessage, expectedMessage, "Wishlist sharing message mismatch!");
	    
	    Thread.sleep(2000);
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