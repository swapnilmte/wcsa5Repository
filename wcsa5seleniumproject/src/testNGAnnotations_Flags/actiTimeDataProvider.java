package testNGAnnotations_Flags;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class actiTimeDataProvider {
	
  @Test(dataProvider = "testData")
  public void invalidLoginMethod(String username, String password) 
  {
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	  WebDriver driver =new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.get("http://127.0.0.1/login.do;jsessionid=6bstnj5r4m01m");
	  
	  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("pwd")).sendKeys(password);
	  driver.findElement(By.id("loginButton")).click();
	  driver.findElement(By.name("username")).clear();
	  
	  
  }

  @DataProvider
  public Object[][] testData() {
	  
	  Object[][] testData1 = new Object [5] [2];
	  testData1[0][0]="ad_main";
	  testData1[0][1]="man_ager";
	  
	  testData1[1][0]="manager";
	  testData1[1][1]="admin";
	  
	  testData1[2][0]="@man";
	  testData1[2][1]="adminn";
	  
	  testData1[3][0]="admin123";
	  testData1[3][1]="manager123";
	  
	  testData1[4][0]="admin@123";
	  testData1[4][1]="123manager";
	  
	  return testData1;
	  
  }
}
