package TestNGPackage;

import org.testng.annotations.Test;
import org.testng.Reporter;

public class Demo {
  @Test
  public void f() {
	  
	  //System.out.println("This Is a TestNG Demo class!!");
	  
	  Reporter.log("This Is a TestNG Demo class!!", true);
  }
}
