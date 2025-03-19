package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utils.Utilities;




public class Login extends Utilities {
	
	WebDriver ldriver;
	Utilities utl;
	
	public Login(WebDriver driver)
	{                                   /*  Ie we don't define constructor then we get below exception
		                                   * java.lang.NullPointerException: Cannot invoke
		                                 * "pageObjects.Login.signinPage()" because "this.l" is null
		                                      */
		ldriver=driver;
		PageFactory.initElements(driver, this);  
	}
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	WebElement btnsigninPage;
	
	@FindBy(xpath="//input[contains(@id,'ap_email')]")
	WebElement txtusername;
	
	@FindBy(id="continue")
	WebElement btncontinue;
	
	@FindBy (id="ap_password")
	WebElement txtpassword;
	
	@FindBy(id="signInSubmit")
	WebElement btnsignin;
	
	@FindBy(xpath="//div[@id='invalid-email-alert']")
	WebElement usermsgalert;
	
	@FindBy(xpath="//span[@class='a-size-large']")
	WebElement passmsgalaert;
	
	
	//Methods//
	public void signinPage()
	{
		Utilities.click(ldriver,2l, btnsigninPage);
//		btnsigninPage.click();
	}
	
	public void setUsername(String username) throws InterruptedException
	{
		Thread.sleep(5000);
	new Utilities();
	//Utilities.sendKeys(ldriver,10l,username, txtusername);
		txtusername.clear();
		txtusername.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		Utilities.sendKeys(ldriver, 10l, password, txtpassword);
//		txtpassword.clear();
//		txtpassword.sendKeys(password);
	}
	
	public void clickContinue()
	{
		Utilities.click(ldriver,5, btncontinue);
		//btncontinue.click();
	}
	
	public void clickSignin()
	{
		Utilities.click(ldriver,9, btnsignin);
		//btnsignin.click();
	}
	
	
	public void incorrectUsernameAlertMessage() throws InterruptedException
	{
		Thread.sleep(5000);
		String usermsg=Utilities.gettext(ldriver, 6l, usermsgalert, "Invalid email address.");
			
		Assert.assertEquals("Invalid email address.",usermsg);
	}
	
	

	public void incorrectPasswordAlertMessage()
	{
	
		String passmsg=Utilities.gettext(ldriver, 10l, passmsgalaert, "Solve this puzzle to protect your account");
		System.out.println(passmsg);
	Assert.assertEquals("Solve this puzzle to protect your account",passmsg);

	;
	}
}
