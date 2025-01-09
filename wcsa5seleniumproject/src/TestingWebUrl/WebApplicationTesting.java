package TestingWebUrl;


/*
 *  WebApplication testing by using TestNg and POM file 
 */

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import POM.LoginPageTest;
import org.testng.Assert;

public class WebApplicationTesting {

	WebDriver driver;
	LoginPageTest loginPage;

@BeforeMethod
public void setUp() {
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://13.202.41.220:3000/#/showHome");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	loginPage = new LoginPageTest(driver);
	
	}
	
	@Test(priority = 4)
	public void testLogin() throws InterruptedException {
		
		loginPage.enterUsername("infodba");
		Thread.sleep(1000);
		loginPage.enterPassword("infodba");
		loginPage.clickLogin();
		
		//Add Assertion to verify login successful
		String expectedTitle = "Teamcenter";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Login failed!");
		System.out.println("Login Successful");
		Thread.sleep(12000);
	
        loginPage.clickInbox();
        Thread.sleep(2000);
        
        String expectedTitle2 = "Teamcenter - Inbox";
		Assert.assertEquals(driver.getTitle(), expectedTitle2, "Failed!- Inbox page not appear");
		System.out.println("Inbox page Open");

	}
  
	@Test(priority = 1)
	 public void testInvalidUsername() throws InterruptedException {
		
		loginPage.enterUsername("invalidUser");
        Thread.sleep(1000);
        loginPage.enterPassword("infodba");
        loginPage.clickLogin();
        verifyErrorMessage();
        
	}
	
	@Test(priority = 2)
	public void testInvalidPassword() throws InterruptedException {
        loginPage.enterUsername("infodba");
        Thread.sleep(1000);
        loginPage.enterPassword("invalidPassword");
        loginPage.clickLogin();
        verifyErrorMessage();
    }
	
	@Test(priority = 3)
    public void testInvalidUsernameAndPassword() throws InterruptedException {
        loginPage.enterUsername("invalidUser");
        Thread.sleep(1000);
        loginPage.enterPassword("invalidPassword");
        loginPage.clickLogin();
        verifyErrorMessage();
    }
	
	private void verifyErrorMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
        String expectedErrorMessage = "The login attempt failed: either the user ID or the password is invalid.";
        String actualErrorMessage = loginPage.errorMessage.getText();
        
        Assert.assertFalse(actualErrorMessage.isEmpty(), "Error message text is empty!");
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message text is incorrect!");
        System.out.println("Error message displayed: " + actualErrorMessage);
    }
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		if (driver != null) {
		driver.quit();
	    }
     }
  }