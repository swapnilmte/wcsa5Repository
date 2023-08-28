package genericPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WorkLib extends BaseTest {

	//handle alert popUp methods
	
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	
	//handle confirmation popUp methods
	public void acceptConfirmation()
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissConfirmation()
	{
		driver.switchTo().alert().dismiss();
	}
	
	//Handle the mouse Actions
	
	public void rightClick(WebElement target)
	{
		Actions act = new Actions(driver);
		act.contextClick(target).perform();
	}
	
	public void doubleClickMethod(WebElement target)
	{
		Actions act = new Actions(driver);
		act.doubleClick(target).perform();
	}

	public void mouseHoverMethod(WebElement target)
	{
		Actions act = new Actions(driver);
		act.moveToElement(target).perform();
	}
	public void dragAndDropMethod(WebElement src,WebElement target)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	
	
	
	//Handle keyboard actions
	public void hitEnterMethod() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void hitTabButtonMethod() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	
	
	//Handle frame
	public void handleFrameByIndex(int index)
	{
		driver.switchTo().frame(index);
	}

	public void handleFrameByNameOrId(String NameOrId)
	{
		driver.switchTo().frame(NameOrId);
	}

	public void handleFrameByFrameElement(WebElement frame)
	{
		driver.switchTo().frame(frame);
	}
	
	public void switchTomainpage()
	{
		driver.switchTo().parentFrame();
	}

	
	//Handle DropDown Methods
	public void dropDownSelect(WebElement element, int index)
	{
		Select sel = new Select(element);
	    sel.selectByIndex(index);
	}
	
	public void selectByVisibleTextMethod(WebElement element, String text)
	{
		Select sel = new Select(element);
	    sel.selectByVisibleText(text);
	}
	
	public void selectByValueMethod(WebElement element, String value)
	{
		Select sel = new Select(element);
	    sel.selectByValue(value);
	}

}
