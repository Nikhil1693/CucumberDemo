package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	
	private By emailID=By.id("email");
	private By password=By.id("passwd");
	private By signInButton=By.id("SubmitLogin");
	private By forgotPwdLink=By.linkText("Forgot your password?");
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(emailID).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}
	
	public AccountsPage doLogin(String user,String pwd) {
		driver.findElement(emailID).sendKeys(user);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		
		return new AccountsPage(driver);
	}
	

}
