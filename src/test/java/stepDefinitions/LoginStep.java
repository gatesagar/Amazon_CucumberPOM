package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.Login;

public class LoginStep extends Base {

	@Given("User is landed on login page")
	public void user_is_landed_on_login_page() throws InterruptedException {
		//Thread.sleep(2000);
		driver.get(prop.getProperty("url"));
		l = new Login(driver);

	}

	@When("Use enters username {string} and password {string}")
	public void use_enters_username_and_password(String username, String password) throws InterruptedException {
		l.signinPage();
		l.setUsername(username);
		l.clickContinue();
		l.setPassword(password);
	}

	@When("Click on submit button")
	public void click_on_submit_button() {
		l.clickSignin();
	}

	@Then("User is able to login and access the dashboard")
	public void user_is_able_to_login_and_access_the_dashboard() {
		System.out.println("logged in");
	}
	
	@When("Use enters incorrect username {string} and password {string}")
	public void use_enters_incorrect_username_and_password(String username, String password) throws InterruptedException {
		l.signinPage();
		l.setUsername(username);
		l.clickContinue();
	    l.incorrectUsernameAlertMessage();
	}
	
	@When("Use enters username {string} and Incorrect password {string}")
	public void use_enters_username_and_incorrect_password(String username, String password) throws InterruptedException {
	   l.signinPage();
	   l.setUsername(username);
	   l.clickContinue();
	   l.setPassword(password);
	   

		
	}
	@Then("User gets authentication error message")
	public void user_gets_authentication_error_message() throws InterruptedException {
		System.out.println("Inside auth error");
		//Thread.sleep(5000);
	   l.incorrectPasswordAlertMessage();
	}


}
