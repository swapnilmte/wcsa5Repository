package TestNGPackage;

import org.testng.annotations.Test;
import org.testng.Reporter;

public class Sumo {
  @Test
  public void f() {
	  Reporter.log("This Is a TestNG Sumo class!!", true);
  }
}
