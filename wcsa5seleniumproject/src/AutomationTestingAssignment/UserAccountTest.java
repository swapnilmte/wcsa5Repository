package AutomationTestingAssignment;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class UserAccountTest {

        WebDriver driver;
	    UserAccountPage userAccountPage;

	    @BeforeMethod
	    public void setup() {
	    	
	        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	        driver = new ChromeDriver(); 
	        driver.manage().window().maximize();
	        driver.get("https://app-staging.nokodr.com/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        userAccountPage = new UserAccountPage(driver);
	    }
         
	      //test with valid credentials
	    @Test(priority = 1)
	    public void testLoginValidCredentials() throws InterruptedException {
	    	
	    	userAccountPage.enterEmail("dhokpandes@gmail.com");
	        userAccountPage.enterPassword("Swapnil@2899");
	        userAccountPage.clickLogin();
	        Thread.sleep(2000);
	        //Add Assertion to verify login successful
	        Assert.assertEquals(driver.getTitle(), "noKodr", "Login failed!");
	        
	        System.out.println("Login Successful");
			Thread.sleep(1000);
	    }

	    //test with invalid credentials
	    @Test(priority = 2)
	    public void testLoginInvalidCredentials() {
	        
	        userAccountPage.enterEmail("rohitgmailcom");
	        userAccountPage.enterPassword("Rohit@1122");
	        Assert.assertEquals(driver.getTitle(), "noKodr", "Login failed!");
	        String actualErrorMessage = userAccountPage.getErrorMessage();
	        String expectedErrorMessage = "Please enter a valid email";
	        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message for invalid email is incorrect!");
	    }
	    
	    //test with blank space
	    @Test(priority = 3)
	    public void testLoginBlankSpace() {
	    	
	    	 	userAccountPage.enterEmail("");
		        userAccountPage.enterPassword("");
		        Assert.assertEquals(driver.getTitle(), "noKodr", "Login failed!");
	    }

	    //test with speacial character
	    @Test(priority = 4)
	    public void testSpecialCharacter() {
	    	
	    	userAccountPage.enterEmail("ROHIT@#$");
	        userAccountPage.enterPassword("@#$%^&");
	        Assert.assertEquals(driver.getTitle(), "noKodr", "Login failed!");
	        // Capture and verify the error message
	        String actualErrorMessage = userAccountPage.getErrorMessage();
	        String expectedErrorMessage = "Please enter a valid email";
	        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message for invalid email is incorrect!");
	    }
	    

	    @AfterMethod
	    public void teardown() {
	    	 if (driver != null) {
	        driver.quit();
	    	 }
	    }
	}