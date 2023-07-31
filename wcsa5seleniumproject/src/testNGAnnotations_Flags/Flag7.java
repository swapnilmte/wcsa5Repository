package testNGAnnotations_Flags;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Flag7 {
	
	  @Test
	  public void loginMethod() 
	  {
		  System.out.println("it is used to perform login!!");
	  }
	  
	  @Test(dependsOnMethods = "loginMethod")
	  public void createUserMethod() 
	  {
		  Assert.fail();
		  System.out.println("it is used to create user!!");
	  }
	  
	  @Test(dependsOnMethods = "createUserMethod", alwaysRun = true)
	  public void logoutMethod() 
	  {
		  System.out.println("it is used to perform logout!!");
	  }
}
