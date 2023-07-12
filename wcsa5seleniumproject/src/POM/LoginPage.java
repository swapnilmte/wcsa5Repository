package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	//it is a webelement repository
	
	@FindBy(xpath="//*[@name='username']") private WebElement usnTB;
	@FindBy(xpath="//*[@name='pwd']") private WebElement pssTB;
	@FindBy(xpath="//*[contains(@class,'initial')]") private WebElement loginButton;
	@FindBy(id ="keepLoggedInCheckbox") private WebElement checkBox;
	@FindBy(partialLinkText = "Actimind Inc.") private  WebElement actiMindLink;
	

//initialization 

	public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//utilization

public WebElement getUsnTB() {
	return usnTB;
}


public WebElement getPssTB() {
	return pssTB;
}


public WebElement getLoginButton() {
	return loginButton;
}


	public WebElement getCheckBox() {
	return checkBox;
	}


	public WebElement getActiMindLink() {
	return actiMindLink;
	}

	public void validLoginMethod(String validUsername, String validPassword)
	{
		usnTB.sendKeys(validUsername);
		pssTB.sendKeys(validPassword);
		loginButton.click();
	
	}
}











