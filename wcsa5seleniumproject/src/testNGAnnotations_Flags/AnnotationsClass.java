package testNGAnnotations_Flags;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsClass {
  @Test
  public void method1() {
	  Reporter.log("TestAnnotation", true);
  }
  
  @AfterMethod
  public void method2()
  {
	  Reporter.log("AfterMethodAnnotation", true);
  }
  
  @BeforeMethod
  public void method3()
  {
	  Reporter.log("BeforeMethodAnnotation", true);
  }
  
  @BeforeClass
  public void method4()
  {
	  Reporter.log("BeforeClassMethodAnnotation", true);
  }
  
  @AfterClass
  public void method5()
  {
	  Reporter.log("AfterClassMethodAnnotation", true);
  }
  
  @BeforeSuite
  public void method6()
  {
	  Reporter.log("BeforeSuiteMethodAnnotation", true);
  }
  
  @AfterSuite
  public void method7()
  {
	  Reporter.log("AfterSuiteMethodAnnotation", true);
  }
  
  @BeforeTest
  public void method8()
  {
	  Reporter.log("BeforeTestMethodAnnotation", true);
  }
  
  @AfterTest
  public void method9()
  {
	  Reporter.log("AfterTestMethodAnnotation", true);
  }
  
  @Test
  public void method10()
  {
	  Reporter.log("TestAnnotation2", true);
  }
}
