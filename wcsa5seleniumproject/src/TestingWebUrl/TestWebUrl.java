package TestingWebUrl;
/*
 * Simple WebApplication testing Without using TestNg
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebUrl {

	public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	driver.get("http://13.202.41.220:3000/#/showHome");
	WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='User Name']"));
	usernameField.clear();
	usernameField.sendKeys("infodba");
	Thread.sleep(1000);
	
	WebElement passwordField = driver.findElement(By.className("gwt-PasswordTextBox"));
	passwordField.clear();
	passwordField.sendKeys("infodba");
	Thread.sleep(1000);
	
	WebElement loginButton=driver.findElement(By.cssSelector(".aw-base-button.ng-binding"));
	loginButton.click();
	
	Thread.sleep(12000);
	String pageTitle = driver.getTitle();
    System.out.println("Page Title: " + pageTitle);
	
	System.out.println("Current URL: " + driver.getCurrentUrl());

	System.out.println("Login Sucessful");
	driver.quit();
}
}