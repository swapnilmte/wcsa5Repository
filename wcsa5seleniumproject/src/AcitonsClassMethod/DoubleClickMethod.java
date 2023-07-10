package AcitonsClassMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickMethod {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   
		// launch the web application.
		   driver.get("http://127.0.0.1/login.do;jsessionid=kp9t8zffbfhr"); 
		   
		//  new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditons.Titlecontains)
		   
		   driver.findElement(By.name("username")).sendKeys("admin");
		   driver.findElement(By.name("pwd")).sendKeys("manager");
		   driver.findElement(By.id("loginButton")).click();
		   
		   //Homepage
		   
		 //  new WebDriverWait(driver, Duration.ofSeconds(30)).until(E)
		   
		   driver.findElement(By.xpath("//div[text()='Settings']/ancestor::a")).click();
		   
		   driver.findElement(By.xpath("//a[text()='Logo & Color Scheme']")).click();
		   
		   driver.findElement(By.id("uploadNewLogoOption")).click();
		   
	      WebElement target = driver.findElement(By.name("formCustomInterfaceLogo.logo"));
		  
		  Actions act = new Actions(driver);
		  
		  act.doubleClick(target).perform();
		  
		  Thread.sleep(1000);
		  driver.close();
	}

}
