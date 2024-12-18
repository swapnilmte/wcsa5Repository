package WebsiteTestingDay6;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestScript06 {
	
	 private WebDriver driver;
	 private String baseUrl;
	 
	 // DataProvider for test data
	    @DataProvider(name = "GuruTest")
	    public Object[][] testData() {
	        return new Object[][] {
	            { Util.USER_NAME, Util.PASSWORD },   // Valid UserId & Password
	            { "invalid", Util.PASSWORD },        // Invalid UserId & Valid Password
	            { Util.USER_NAME, "invalid" },       // Valid UserId & Invalid Password
	            { "invalid", "invalid" }             // Invalid UserId & Invalid Password
	        };
	    }
	    @BeforeMethod
	    public void setUp() throws Exception {
	        System.setProperty("webdriver.gecko.driver", Util.FIREFOX_PATH);
	        driver = new FirefoxDriver();
	        baseUrl = Util.BASE_URL;
	        driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
	   
	     // Navigate to the Guru99 login page
	        driver.get(baseUrl + "/V4/");
	    }
	    
	    @Test(dataProvider = "GuruTest")
	    public void testLogin(String username, String password) throws Exception {
	        driver.findElement(By.name("uid")).clear();
	        driver.findElement(By.name("uid")).sendKeys(username);
	        driver.findElement(By.name("password")).clear();
	        driver.findElement(By.name("password")).sendKeys(password);
	        driver.findElement(By.name("btnLogin")).click();

	        // Add delay to see the outcome
	        Thread.sleep(2000); // 2-second delay
	        
	        // Capture screenshot for each scenario
	        String fileName = "./screenshot/TestCase_" + username + "_" + password + ".png";

	        try {
	            Alert alert = driver.switchTo().alert();
	            Thread.sleep(1000); // Additional delay to see the alert
	            String alertText = alert.getText();
	            alert.accept();
	            
	            // Verify error message
	            assertEquals(alertText, Util.EXPECT_ERROR);
	            takeScreenshot(fileName);
	            System.out.println("Screenshot captured: " + fileName);
	        } catch (NoAlertPresentException e) {
	        	
	        	// Wait and verify text on successful login page
	            Thread.sleep(2000); // Additional delay for the successful login page
	            String pageText = driver.findElement(By.tagName("tbody")).getText();
	            String[] parts = pageText.split(Util.PATTERN);
	            if (parts.length > 1) {
	                String dynamicText = parts[1].trim();
	                assertTrue(dynamicText.startsWith(Util.FIRST_PATTERN), "ManagerID Pattern mismatch");
	                String remain = dynamicText.substring(Util.FIRST_PATTERN.length());
	                assertTrue(remain.matches(Util.SECOND_PATTERN), "ManagerID is not numeric");
	                takeScreenshot(fileName);

	                System.out.println("Screenshot captured: " + fileName);
	            } else {
	                throw new Exception("ManagerID not found!");
	            }
	        }
	    }


			@AfterMethod
			public void tearDown() {
			driver.quit();
}

			// Method to take a screenshot
			private void takeScreenshot(String baseFileName) throws IOException {
				// Append timestamp to make the filename unique
			    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			    String filePath = baseFileName + "_" + timestamp + ".png";

			    // Capture the screenshot
			    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(screenshot, new File(filePath));
			    System.out.println("Screenshot saved: " + filePath);

}
}
