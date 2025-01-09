package eCommerceLive;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase6 {
	
	private WebDriver driver;
    private String baseUrl;
    public String FirstName ="John";
    public String LastName ="Wick";
    public String VEmail="johnWeak@apk.com";
    public String VPass="Abcd@22";
    
    @BeforeMethod
    @BeforeTest
    public void setUp() throws Exception {
    	
    	System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
    	driver = new FirefoxDriver();
    	baseUrl = "http://live.techpanda.org/";
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
    public void testTestCase6() throws Exception {
    	
    	//Step 1: open the website
    	driver.get(baseUrl);
    	
    	//Step 2: Click on my account link
    	driver.findElement(By.linkText("MY ACCOUNT")).click();
    	
    	// Step 3: login application using previous created field
    	driver.findElement(By.id("email")).clear();
    	driver.findElement(By.id("email")).sendKeys(VEmail);
    	Thread.sleep(1000);
    	driver.findElement(By.id("pass")).clear();
    	driver.findElement(By.id("pass")).sendKeys(VPass);
    	Thread.sleep(1000);
    	driver.findElement(By.id("send2")).click();
    	
    	//Step 4: click on my wishlist link
    	driver.findElement(By.linkText("MY WISHLIST")).click();
    	Thread.sleep(1000);
    	//Step 5: click on add to cart link
    	driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
    	Thread.sleep(1000);
    	//Step 6: click on proceed to checkout
    	driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();
    	
    	//Step 7: enter shipping information
    	driver.findElement(By.id("billing:street1")).sendKeys("near abc colony, uk");
    	driver.findElement(By.id("billing:city")).sendKeys("New South Wales");
    	driver.findElement(By.id("billing:postcode")).sendKeys("2000");
    	new Select(driver.findElement(By.xpath("//select[@id='country']"))).selectByIndex(14); //Country 
    	driver.findElement(By.id("billing:telephone")).sendKeys("9874561230");
    	driver.findElement(By.xpath("//button[@title='Continue']")).click();
	    
    	//Step 8: click on estimate
    	
    	//Step 9: verify shipping cost generated
    	
    	//Step 10: select shipping cost and update total
    	
    	//Step 11: verify shipping cost is added to total
    	
    	//Step 12: click on proceed to checkout
    	
    	//Step 13: enter billing information
    	
    	//Step 14: in shipping method click to continue
    	
    	//Step 15: in payment information select check moneyorder radio button. click to continue
    	
    	//Step 16: click place order button
    	
    	//Step 17: verify order is generated, note the order number
    	
    	
    	
    	
    	
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
