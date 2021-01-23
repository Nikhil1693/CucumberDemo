package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class dFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tl=new ThreadLocal<>();
	
	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tl.
	 */
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("browser value is: "+browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tl.set(new ChromeDriver());
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tl.set(new FirefoxDriver());
		}else if(browser.equals("safari")) {
			tl.set(new SafariDriver());
		}else {
			System.out.println("Please pass correct browser value " +browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tl.get();
	}
}
