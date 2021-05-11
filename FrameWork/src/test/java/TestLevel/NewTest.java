package TestLevel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.applitools.eyes.selenium.Eyes;
public class NewTest {
	private WebDriver driver;
	private Eyes eyes;


  @BeforeClass
  public void beforeClass() {
	    WebDriver browser =  new FirefoxDriver();
	    eyes = new Eyes();
	    eyes.setApiKey("XzDyvHzHV6t8I110VJVkEFTzlBp9AIokObrC9WoIr1F0g110");
	    driver = eyes.open(browser, "the-internet", "Login succeeded");
  }

  @AfterClass
  public void afterClass() {	eyes.abortIfNotClosed(); 
	driver.quit(); 
  }

}
