package POM;

import java.io.IOException;

public class ValidLoginTestCase extends BaseTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BaseTest bt = new BaseTest();
		bt.setUp();
		
	    Flib flib = new Flib();
		
		//to call the webelement of loginpage create the obj of login page class
		LoginPage lp = new LoginPage(driver);
//		lp.getUsnTB().sendKeys(flib.readPropertyData(PROP_PATH, "Username"));
//		lp.getPssTB().sendKeys(flib.readPropertyData(PROP_PATH, "Password"));
		
		lp.validLoginMethod(flib.readPropertyData(PROP_PATH,"Username"),flib.readPropertyData(PROP_PATH, "Password"));
		
		
		
		 // use homepage Elements create obj of HomePage POM
//	       HomePage hp = new HomePage(driver);
//	       hp.clickOnLogoutLink();
		
		Thread.sleep(2000);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnLogoutLink();
	}

	
}
