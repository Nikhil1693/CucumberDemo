package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	
	private By accountSections=By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public int getSectionCount() {
		return driver.findElements(accountSections).size()-1;
	}
	
	public List<String> getSectionHeader() {
		
		List<String> sectionList=new ArrayList<>();
		List<WebElement> sectionHeader=driver.findElements(accountSections);
		
		for(WebElement e:sectionHeader) {
			
			if(!(e.getText().equals("Home"))){
			
			sectionList.add(e.getText());
			}
		}
		
		return sectionList;
	}
		
}
