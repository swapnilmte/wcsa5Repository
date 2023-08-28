package TestPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import PagePackage.LoginPage;
import genericPackage.BaseTest;
import genericPackage.Flib;

public class LoginTestCase extends BaseTest {
  
	@Test
  public void ValidloginMethod() throws IOException 
	{
		//to perform login call  the methods from LoginPage pom class
		LoginPage lp = new LoginPage(driver);
		Flib flib = new Flib();
		lp.validLogin(flib.readPropertyData(PROP_PATH,"Username"),flib.readPropertyData(PROP_PATH,"Password"));
		
    }
	
	 @Test(dependsOnMethods = "ValidloginMethod")
	  public void inValidLoginMethod() throws EncryptedDocumentException, IOException, InterruptedException
	  {
		  LoginPage lp = new LoginPage(driver);
		  Flib flib = new Flib();
		  int rc = flib.getLastRowCount(EXCEL_PATH,INVALIDSHEET_NAME);
		  for(int i=1;i<=rc;i++)
		  {
			  lp.inValidLogin(flib.readExcelData(EXCEL_PATH,INVALIDSHEET_NAME,i,0),flib.readExcelData(EXCEL_PATH, INVALIDSHEET_NAME, i,1));
		  }
	  }
}
