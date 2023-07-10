package dataDrivenFramework;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class invalidLoginTestCase {

	public static void main(String[] args) throws EncryptedDocumentException, IOException{
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	      WebDriver driver=new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	      driver.get("http://127.0.0.1/login.do;jsessionid=5xpmurh99x1a");
	      
	      //read the data from excel file and test the loginpage
	      Flib flib = new Flib();
	      
	    int rc = flib.getLastRowCount("./data/ActitimeTestData.xlsx", "invalidcreds");
	      //to 
	      for(int i=1;i<rc;i++)
	      {
//	      String invalidUsername = flib.readExcelData("./data/ActitimeTestData.xlsx", "invalidcreds",i,0);
//	      String invalidPassword = flib.readExcelData("./data/ActitimeTestData.xlsx", "invalidcreds",1,1);
	      
//	      driver.findElement(By.name("username")).sendKeys(invalidUsername);
//          driver.findElement(By.name("pwd")).sendKeys(invalidPassword);
	      	
	      //driver.findElement(By.name("username")).sendKeys(flib.readExcelData("./data/ActitimeTestData.xlsx", "invalidcreds",i,0));
	    WebElement usernameTB = driver.findElement(By.name("username"));
	    usernameTB.sendKeys(flib.readExcelData("./data/ActitimeTestData.xlsx", "invalidcreds",i,0));
	    usernameTB.clear();
	   
	      driver.findElement(By.name("pwd")).sendKeys(flib.readExcelData("./data/ActitimeTestData.xlsx", "invalidcreds",i,1));
	      driver.findElement(By.id("loginButton")).click();
	      }
	}

}
