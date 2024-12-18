import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertHandling {
	@Test
	public void Alert_Handling() throws InterruptedException
	
	{
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	
	//Observe in that page have "3 buttons there" 1. Show Me Confiramation 2. Show Me Alert 3. Show Me Prompt
	
	//Alert Pop up Handling - click the Show Me Alert Button
	driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
	
	//To locate alert.
	Alert A1= driver.switchTo().alert();
	
	//To read the text from alert popup.
	String Alert1= A1.getText();
	System.out.println(Alert1);
	Thread.sleep(2000);
	
	//To accept/Click Ok on alert popup.
	A1.accept();
	
	//Confirmation Pop up Handling - CLick the Show Me Confiramation Button
	driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
	Alert A2=driver.switchTo().alert();
	String Alert2 = A2.getText();
	System.out.println(Alert2);
	Thread.sleep(2000);
	
	//To click On cancel button of confirmation box.
	A2.dismiss();
	
	//Prompt Pop up Handling - Click the Show Me Prompt button
	
	driver.findElement(By.className("Show Me Prompt")).click();
	Alert A3= driver.switchTo().alert();
	String Alert3= A3.getText();
	System.out.println(Alert3);
	//To type text In text box of prompt pop up.
	A3.sendKeys("This is sam");
	
	Thread.sleep(1000);
	A3.accept();
	
	}

}
