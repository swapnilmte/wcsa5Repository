package WebsiteTestingDay5;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestScript05 {

	private WebDriver driver; // Selenium control driver
	private String baseUrl; // BaseUrl of website Guru99
	
	@DataProvider(name="GuruTest")
	public Object[][] testData() {
		
		return new Object[][] {
			
			{ Util.USER_NAME, Util.PASSWORD },  // Valid credentials
            { "invalid", Util.PASSWORD },       // Invalid username
            { Util.USER_NAME, "invalid" },      // Invalid password
            { "invalid", "invalid" }            // Both username and password invalid
		};
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.gecko.driver", Util.FIREFOX_PATH);
		driver = new FirefoxDriver();
		
		// Setting Base URL of website Guru99
		baseUrl = Util.BASE_URL;
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		
		// Navigate to the Guru99 login page
        driver.get(baseUrl + "/V4/");
        
	}
	
	/**
	 * Start Testing Test script 05 
	 * 1) Go to http://www.demo.guru99.com/V4/ 
	 * 2) Enter valid UserId 
	 * 3) Enter valid Password 
	 * 4) Click Login Expected
	 * result: Login successful home page shown Message shown Welcome
	 * <managerid>
	 * 
	 * @throws Exception
	 */
	
	@Test (dataProvider = "GuruTest")
	public void testCase05(String username, String password) throws Exception{
		
		
		
		// Enter username and password
				driver.findElement(By.name("uid")).clear();
				driver.findElement(By.name("uid")).sendKeys(username);
				driver.findElement(By.name("password")).clear();
				driver.findElement(By.name("password")).sendKeys(password);
				driver.findElement(By.name("btnLogin")).click();
				
				
				try {
					// Handle the alert if login fails
					Alert alert = driver.switchTo().alert();
					String actualBoxMsg =alert.getText();
					alert.accept();
					 // Compare the actual error message with the expected error message
					assertEquals(actualBoxMsg,Util.EXPECT_ERROR);
					
					 alert.accept(); // Close the alert box
				}
				catch (NoAlertPresentException Ex) {
					// Get text displayed on login page 
					String pageText = driver.findElement(By.tagName("tbody")).getText();

					// Extract the dynamic text mngrXXXX on page		
					String[] parts = pageText.split(Util.PATTERN);
					if (parts.length > 1) {
					String dynamicText = parts[1].trim();
					
					// Validate the dynamic text pattern
					// First 4 characters must be "mngr"
					assertTrue(dynamicText.startsWith(Util.FIRST_PATTERN));
					
					// remain stores the "XXXX" in pattern mngrXXXX
					String remain = dynamicText.substring(Util.FIRST_PATTERN.length());
					// Check remain string must be numbers;
					assertTrue(remain.matches(Util.SECOND_PATTERN));
				}		else {
					throw new Exception("Unable to extract dynamic manager ID from page text.");
				}
				}
	}
	
	/**
	 * Complete the testing
	 * 
	 * @throws Exception
	 */
	
	@AfterMethod
	public void tearDown() throws Exception{
		
		driver.quit();
	}
}
