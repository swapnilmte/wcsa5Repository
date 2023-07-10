package keyWordDrivenFramework;

import java.io.IOException;

import org.openqa.selenium.By;

public class ValidLoginTestCsse extends BaseTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BaseTest bt = new BaseTest();
		bt.openBrowser();
		
		Flib flib = new Flib();
		driver.findElement(By.name("username")).sendKeys(flib.readPropertyData(PROP_PATH, "Username"));
		driver.findElement(By.name("pwd")).sendKeys(flib.readPropertyData(PROP_PATH, "Password"));
		driver.findElement(By.id("loginButton")).click();
		bt.closeBrowser();
	}

}
