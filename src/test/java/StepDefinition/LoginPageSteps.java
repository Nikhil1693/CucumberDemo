package StepDefinition;

import org.junit.Assert;

import DriverFactory.dFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {
	
	String title;
	private LoginPage loginPage=new LoginPage(dFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
	
		dFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		title=loginPage.getLoginPageTitle();
		System.out.println("Page title is: " +title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		
		
		Assert.assertTrue(title.equals(expectedTitle));
		
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	   
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	   
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	  loginPage.clickOnLogin();
	}

	

}
