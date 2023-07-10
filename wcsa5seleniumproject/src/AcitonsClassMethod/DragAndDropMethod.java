package AcitonsClassMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropMethod {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   
		// launch the web application.
		   driver.get("https://demo.guru99.com/test/drag_drop.html"); 
		   
		   WebElement case1 = driver.findElement(By.xpath(" //a[text()=' SALES ']"));
		   WebElement case3 = driver.findElement(By.xpath(" //a[text()=' BANK ']"));
		   WebElement case2 = driver.findElement(By.xpath(" //a[text()=' 5000']"));
		   WebElement case4 = driver.findElement(By.xpath(" //a[text()=' 5000 ']"));
		   
		   //-----------------------------------------------------------------------------------------------------------
		   
		  WebElement target1 = driver.findElement(By.xpath("//ol[@id='loan']"));   //credit side account box  
		  WebElement target2 = driver.findElement(By.xpath("//ol[@id='amt8']"));   //credit side amount box
		  WebElement target3 = driver.findElement(By.xpath("//ol[@id='bank']"));   //debit side account box
		  WebElement target4 = driver.findElement(By.xpath("//ol[@id='amt7']"));    //debit side amount box
		  
		 Actions act = new Actions(driver);
		 
		 act.dragAndDrop(case1, target1).perform();
		 act.dragAndDrop(case2, target2).perform();
		 Thread.sleep(1000);
		 act.dragAndDrop(case3, target3).perform();
		 Thread.sleep(1000);
		 act.dragAndDrop(case4, target4).perform();
		 
		 if(driver.findElement(By.xpath("//a[text()='Perfect!']")).isDisplayed())
		 {
			 System.out.println("Drag and drop is done");
			 driver.quit();
		 }
		 else
		 {
			 System.out.println("Exception==");
		 }
	}

}
