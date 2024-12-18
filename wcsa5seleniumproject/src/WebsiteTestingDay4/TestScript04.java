package WebsiteTestingDay4;

import static org.testng.Assert.assertEquals;

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

public class TestScript04 {

	private WebDriver driver;    // Selenium Control driver
	private String baseUrl;      //baseUrl of Website Guru99
	
	// DataProvider to fetch test data from the Util class
	@DataProvider(name = "GuruTest")
	public Object [][] testData() throws Exception
	{
		return Util.getDataFromExcel(Util.FILE_PATH, Util.SHEET_NAME);
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", Util.FIREFOX_PATH);
		driver = new FirefoxDriver();
		
		// Initialize base URL and set implicit wait
		// Setting Base URL of website Guru99
		baseUrl = Util.BASE_URL;
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		
		 // Navigate to the Guru99 login page
        driver.get(baseUrl + "/V4/");
	}
	
	
	@Test (dataProvider = "GuruTest")
	public void testCase04(String username, String password) throws Exception {
		String actualTitle;
		String actualBoxMsg;
		
		// Enter username and password
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		
		 // Implicit wait for a response
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		
		try {
			// Handle the alert if login fails
			Alert alert = driver.switchTo().alert();
			actualBoxMsg =alert.getText();
			alert.accept();
			 // Compare the actual error message with the expected error message
			assertEquals(actualBoxMsg,Util.EXPECT_ERROR);
			
			 alert.accept(); // Close the alert box
		}
		catch (NoAlertPresentException Ex) {
			 // Handle the successful login scenario
			actualTitle=driver.getTitle();
			
			// Compare the actual title with the expected title
	    	assertEquals(actualTitle,Util.EXPECT_TITLE);
		}
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		 // Quit the browser after the test
		
		driver.quit();
		
	}
}
