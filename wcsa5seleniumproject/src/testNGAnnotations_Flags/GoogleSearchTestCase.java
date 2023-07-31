package testNGAnnotations_Flags;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GoogleSearchTestCase extends BaseTest {
	
  @Test(description = "TestCase1")
  public void search1() {
	  driver.switchTo().activeElement().sendKeys("java",Keys.ENTER);
	  
  }
  
  @Test(description = "TestCase2")
  public void search2()
  {
	  driver.switchTo().activeElement().sendKeys("sql",Keys.ENTER);
  }
  
  @Test(description = "TestCase3")
  public void search3()
  {
	  driver.switchTo().activeElement().sendKeys("selenium",Keys.ENTER);
  }
  
}
