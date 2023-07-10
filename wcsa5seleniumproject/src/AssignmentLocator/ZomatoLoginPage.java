package AssignmentLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZomatoLoginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 
		  WebDriver driver= new ChromeDriver();
		  driver.manage().window().maximize();
		  
		  driver.get("http://www.zomato.com/india");
		  
		  //to click on signup link
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("Sign up")).click();
		  
		  //TO send the inputs for fullname textbox
		  Thread.sleep(4000);
		  driver.findElement(By.cssSelector("input[class='sc-1yzxt5f-9 dFkpnp']")).sendKeys("swapnil");
		  Thread.sleep(2000);
		//TO send the inputs for email textbox
		  
		  driver.findElement(By.cssSelector("input[class='sc-1yzxt5f-9 bbrwhB']")).sendKeys("adc");
		  

	}

}
