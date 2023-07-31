package testNGAnnotations_Flags;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Flag1 {
	//it is used to describe method or testcase
  @Test(description = "Login Method!!")
  public void method1() {
	  Reporter.log("method1 from flag1");
  }
}
