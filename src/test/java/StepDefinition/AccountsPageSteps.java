package StepDefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import DriverFactory.dFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AccountsPage;
import pages.LoginPage;

public class AccountsPageSteps {

	private LoginPage loginPage=new LoginPage(dFactory.getDriver());
	private AccountsPage accountsPage;
	
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
	   List<Map<String,String>> credList=credTable.asMaps();
	   String userName=credList.get(0).get("username");
	   String password=credList.get(0).get("password");
	   
	   dFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	   accountsPage=loginPage.doLogin(userName,password);
	  
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		
		String title=accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page title is: "+title);
	    
	}

	@Then("user gets account section")
	public void user_gets_account_section(DataTable sectionsTable) {
	   List<String> expSectionList=sectionsTable.asList();
	   System.out.println("Expected section list: "+expSectionList);
		
	   List<String> actSectionList=accountsPage.getSectionHeader();
	   System.out.println("Actual section list: "+actSectionList);
	   
	   Assert.assertTrue(expSectionList.containsAll(actSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expSectionCount) {
		
		Assert.assertTrue(accountsPage.getSectionCount()==expSectionCount);
	 
	}
}
