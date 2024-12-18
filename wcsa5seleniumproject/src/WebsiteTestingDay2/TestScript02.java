package WebsiteTestingDay2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
* 1) All parameters will will be saved in File Util.java - Helps in easy code maintenance
* 2) We will move the code to launch Webdriver in a separate method as SetUp. Helps in code understanding
*/

public class TestScript02 {

	static WebDriver driver;        // Selenium control driver
	//private static String baseUrl;  // baseUrl of Website Guru99   
	
	/**
	Test Script 02
	          1)  Go to http://www.demo.guru99.com/V4/
              2) Enter valid UserId
              3) Enter valid Password
              4) Click Login
              5) Verify the Page Title after login
	 * @throws InterruptedException 
	
	**/
	public static void main(String[] args) throws InterruptedException {
		  
		System.setProperty("webdriver.gecko.driver", Util.FIREFOX_PATH);
		WebDriver driver= new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get(Util.BASE_URL);
		 
		//driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		 driver.findElement(By.name("uid")).clear();
		 driver.findElement(By.name("uid")).sendKeys(Util.USER_NAME);
		 
		 Thread.sleep(1000);
		 
		 
		 driver.findElement(By.name("password")).clear();
		 driver.findElement(By.name("password")).sendKeys(Util.PASSWORD);
		 
		 //click login
		 driver.findElement(By.name("btnLogin")).click();
		 
		String actualTitle = driver.getTitle();
		if(actualTitle.contains(Util.EXPECT_TITLE)) {
			
			System.out.println("Test Case : PASSED ");
		}
		else {
			System.out.println("Test Case : Failed ");
		}
		 
		driver.close();

	}

}
