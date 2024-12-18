package WebsiteTestingDay3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/*
 * Declare some common parameters for scripts
 * You can change them to adapt your environment
 *
 */

public class Util {
	 
			// Constants for test configuration
			// Time to wait when searching for a GUI element
			public static final int WAIT_TIME =30;       // Delay time to wait the website
		
			//Setting BaseURL
			public static final String BASE_URL = "http://www.demo.guru99.com/"; 
			// Valid account for login
			public static final String USER_NAME = "mngr603881"; 
			public static final String PASSWORD = "jYjYhEn";

			// Expected output
			public static final String EXPECT_TITLE="Guru99 Bank Manager HomePage";
			public static final String EXPECT_ERROR="User or Password is not valid";	
			
			
			//FireFox driver path
			public static final String FIREFOX_PATH = "./drivers/geckodriver.exe";
			
			
			// You can change the information of your data file here	
			public static final String FILE_PATH ="C:\\Users\\S\\git\\wcsa5Repository\\wcsa5seleniumproject\\data\\testData1.xlsx"; 		// ExcelFile Path
			public static final String SHEET_NAME="Data";           		// SheetName in Excel
			//public static final String TABLE_NAME="testData1";           //Name of the data table
	

		/**
		 * Reads test data from an Excel file.
		 * @param xlFilePath Path to the Excel file
		 * @param sheetName  Name of the sheet containing the data
		 * @param tableName
		 *            : Table name is used to mark the start and end position of the
		 *            test data table. The method will find the cell which contains
		 *            the table name to find position of data table
		 * @return a 2D dimensions array to store all the test data read from excel
		 * @throws IOException If there's an issue reading the Excel file
		 */
		
		public static String[][] getDataFromExcel (String xlFilePath, String sheetName ) throws IOException   {
		
		// get the workbook file. Provide the path of excel file
		FileInputStream fileInputStream   = new FileInputStream(new File (xlFilePath)); 
		 Workbook workbook = new XSSFWorkbook(fileInputStream );
	     Sheet sheet = workbook.getSheet(sheetName);
	        
		
	     // Determine number of rows and columns in the sheet
	     int rowCount = sheet.getPhysicalNumberOfRows();
	     int colCount = sheet.getRow(0).getLastCellNum();
	     
	     // Initialize the array to hold data
	     String[][] data = new String[rowCount - 1][colCount];
	        
	     // Loop through each row and cell to read data      
	     
	     for (int i = 1; i < rowCount; i++) { 	// Start from 1 to skip the header row
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                
	     // Handle null cells                
	                if (cell == null) 
	                {
	                    data[i - 1][j] = ""; // Set empty string for null cells
	                
	                } else {
	                	switch (cell.getCellType()) {
	                	
	                	case STRING:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            data[i - 1][j] = String.valueOf(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            data[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
                            break;
                        default:
                            data[i - 1][j] = ""; // Handle other types
	                	
	                	}
	                }
	                    
	            }
	        }
	     workbook.close();
	     fileInputStream.close();
	        return data;
	    }
	}

