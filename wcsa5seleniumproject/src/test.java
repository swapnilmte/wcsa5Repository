import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class test {
		
		WebDriver driver;
		
		@BeforeClass
		public void setup() {
			//set up the psth for the ChromeDriver
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver= new ChromeDriver();
			
			//open the Zomato signup page
			
			driver.get("https://www.zomato.com/");
			driver.manage().window().maximize();
			
		}
		
	  @Test
	  public void testZomatoSignUp() {
		  
		  driver.findElement(By.className("Sign up")).click();
	  }
	}
