package POM;

/*
 * POM file 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class LoginPageTest {

		WebDriver driver;
	
	    //locators
		@FindBy(xpath = "//input[@placeholder='User Name']")
		WebElement usernameField;
	
		@FindBy (className ="gwt-PasswordTextBox" )
		WebElement passwordField;
	
		@FindBy(xpath = "//button[text()='Sign in']")
		WebElement loginButton;
	
	    @FindBy(className ="aw-tile-tileContentData")
	    WebElement inboxTile;
	    
	    @FindBy(xpath = "//div[text()='The login attempt failed: either the user ID or the password is invalid.']")  
	    public WebElement errorMessage;
	     
	    //constructor
	    public LoginPageTest(WebDriver driver) {
	    	this.driver = driver;
	    	PageFactory.initElements(driver, this);
	}
	
	    //Actions
	    public void enterUsername(String username) {
	    	usernameField.clear();
	    	usernameField.sendKeys(username);
	}
	
	    public void enterPassword(String password) {
	    	passwordField.clear();
	    	passwordField.sendKeys(password);
	}

	    public void clickLogin() {
	    	loginButton.click();
	}	
  
	    public String getErrorMessageText() {
	    	return errorMessage.getText();
    }
    
	    public void clickInbox() {
	    	inboxTile.click();
    }
}

