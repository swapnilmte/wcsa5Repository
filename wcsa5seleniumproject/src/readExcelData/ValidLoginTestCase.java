package readExcelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidLoginTestCase {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	   WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   driver.get("http://127.0.0.1/login.do;jsessionid=5xpmurh99x1a");
	   
	   //read the data from excel file and test the login page
	   FileInputStream fis = new FileInputStream("./data/ActitimeTestData.xlsx");
	   Workbook wb = WorkbookFactory.create(fis);
	   Sheet sheet = wb.getSheet("validcreds");
	   Row row = sheet.getRow(1);
	   Cell cell = row.getCell(0);
	   String validusername = cell.getStringCellValue();
	   
	   
	}

}
