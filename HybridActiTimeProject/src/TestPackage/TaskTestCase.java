package TestPackage;

import java.io.IOException;

import org.testng.annotations.Test;

import PagePackage.HomePage;
import PagePackage.LoginPage;
import PagePackage.TasksPage;
import genericPackage.BaseTest;
import genericPackage.Flib;

public class TaskTestCase extends BaseTest {
	 private static final String CUST_PROSHEET_NAME = null;

	@Test
	  public void project_customerMethod() throws IOException {
		  
		  LoginPage lp = new LoginPage(driver);
		  Flib flib = new Flib();
		  lp.validLogin(flib.readPropertyData(PROP_PATH,"Username"),flib.readPropertyData(PROP_PATH,"Password"));
	     HomePage hp = new HomePage(driver);
		  
	      hp.clickOntaskModule();
	      // we are there in Task page
	      TasksPage ts = new TasksPage(driver);
	    
	      // create the customer.
	      ts.createNewCustomerMethod(flib.readExcelData(EXCEL_PATH,CUST_PROSHEET_NAME,1,0));
	      // Create the project
	      ts.createNewProjectMethod(flib.readExcelData(EXCEL_PATH,CUST_PROSHEET_NAME,1,0),flib.readExcelData(EXCEL_PATH,CUST_PROSHEET_NAME,1,1));
	  
	  }

}
