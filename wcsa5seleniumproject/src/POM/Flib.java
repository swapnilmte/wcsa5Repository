package POM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {
	//to store generic reusable methods
	//all the methods are non static
	
	
	//it is used to read the data from excel sheet
	public String readExcelData(String excelPath, String sheetName, int rowCount, int cellCount) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelPath);  //provide the path of file
		Workbook wb = WorkbookFactory.create(fis);  //make the file ready
		Sheet sheet = wb.getSheet(sheetName);  //get into the sheet
		Row row = sheet.getRow(rowCount);     //get into desired row
		Cell cell = row.getCell(cellCount);    //get into desired cell/column
		String data = cell.getStringCellValue();  //read the value from cell
		return data;
		
	}
	
	//it is used to get the last count of row where we store the data
	
	public int getLastRowCount(String excelPath,String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelPath);  //provide the path of file
		Workbook wb = WorkbookFactory.create(fis); //make file for ready to read
		Sheet sheet = wb.getSheet(sheetName); //get into the sheet
		int rc = sheet.getLastRowNum(); //read the last row count
		return rc;
	}
	
	//it is used to write the data into exxcel sheet
	
	public void writeExcelData(String excelPath,String sheetName, int rowCount, int cellCount,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelPath);  //
		Workbook wb = WorkbookFactory.create(fis);  //make the file ready
		Sheet sheet = wb.getSheet(sheetName);  //get into the sheet
		Row row = sheet.getRow(rowCount);  //pass the row count
		Cell cell = row.createCell(cellCount);  //pass the cell count
		cell.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(excelPath);
		wb.write(fos);

	}

	// it is use to read the data from property file
		public String readPropertyData(String propPath,String key) throws IOException
		{
			FileInputStream fis = new FileInputStream(propPath);
			// create a obj of Properties class
			Properties prop = new Properties();
			
		// make a file ready for read
			prop.load(fis);
		// read the particular key form file
			String data = prop.getProperty(key);
			return data;
		}
}
