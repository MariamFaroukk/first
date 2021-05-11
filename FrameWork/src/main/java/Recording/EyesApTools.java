package Recording;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.applitools.eyes.selenium.Eyes;

public class EyesApTools {
	private WebDriver driver;
	private Eyes eyes;


	public void setup() {
	    WebDriver browser =  new FirefoxDriver();
	    eyes = new Eyes();
	    eyes.setApiKey("XzDyvHzHV6t8I110VJVkEFTzlBp9AIokObrC9WoIr1F0g110");
	    driver = eyes.open(browser, "the-internet", "Login succeeded");
	}
	public void teardown() { 
		eyes.abortIfNotClosed(); 
		driver.quit(); 
		} 

}
