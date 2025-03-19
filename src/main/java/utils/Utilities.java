package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utilities{
	
	public static WebDriverWait wait;

	public static void sendKeys(WebDriver driver, long time, String value, WebElement element)
	 {
		 wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		 wait.until(ExpectedConditions.visibilityOf(element));
		 element.clear();
		 element.sendKeys(value);
	 }
	
	public static void click(WebDriver driver,long time, WebElement element)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public static String gettext(WebDriver driver,long time,WebElement elemnet,String text) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.textToBePresentInElement(elemnet, text));
		String elettext=elemnet.getText();
		return elettext;
	}
}
