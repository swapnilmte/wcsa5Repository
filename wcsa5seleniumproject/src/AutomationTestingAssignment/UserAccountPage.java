package AutomationTestingAssignment;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class UserAccountPage {
		  WebDriver driver;
		
		
		// Locators using @FindBy
	    @FindBy(xpath = "//input[@type='email']")
	    private WebElement emailField;

	    @FindBy(xpath = "//input[@type='password']")
	    private WebElement passwordField;

	    @FindBy(id = "staticElement")
	    private WebElement loginButton;

	   

	    @FindBy(css = ".slds-form-element__help") 
	    private WebElement errorMessage; 
	
		
		// Constructor to initialize PageFactory
	     public UserAccountPage(WebDriver driver) {
	    	
		        this.driver = driver;
		        PageFactory.initElements(driver, this); 
		}
	      
	     // Methods for actions
	     public void enterEmail(String email) {
	    	 emailField.clear();
	         emailField.sendKeys(email);
	     }

	     public void enterPassword(String password) {
	    	 passwordField.clear();
	         passwordField.sendKeys(password);
	     }

	     public void clickLogin() {
	         loginButton.click();
	     }
	     
	     public String getErrorMessage() {
	    	 
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	 WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOf(errorMessage));
	         return errorMessageElement.getText();
	     
	     }
	     
	   
	     }