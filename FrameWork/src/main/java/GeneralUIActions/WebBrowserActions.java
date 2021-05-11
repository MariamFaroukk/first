package GeneralUIActions;
import com.applitools.eyes.*;
import com.applitools.eyes.selenium.Eyes;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebBrowserActions {
	

	public static void intiateeyes() {
		
		Eyes eyes=new Eyes();
		eyes.setApiKey("XzDyvHzHV6t8I110VJVkEFTzlBp9AIokObrC9WoIr1F0g110");
	}
  
	public static WebDriver chooseBrowserDriver(String browswername) {
		//makontesh 3arfa a return null
		//switch case better in performance done 
	switch(browswername)	{
	case "Chrome":
	{ WebDriverManager.chromedriver().setup(); return  new ChromeDriver(stopnotificationforchrome()); }
	case "Firefox":
	 {WebDriverManager.firefoxdriver().setup();return new FirefoxDriver(); }
	case "Edge":
	{	WebDriverManager.edgedriver().setup(); return new EdgeDriver();}
	 default :
		 return null;
	}
	/* if (browswername =="Chrome")
		 
	 { WebDriverManager.chromedriver().setup(); return  new ChromeDriver(); }
	 else 	
	 {WebDriverManager.firefoxdriver().setup();
		 return new FirefoxDriver(); }*/
	 
	}
    public static void maximizewithDIMWindow(WebDriver driver, int horizontalaxis,int verticalaxis)
    {      Dimension dim = new Dimension(horizontalaxis,verticalaxis);
    	driver.manage().window().setSize(dim);}
	
    public static void staticmaximizeWindow(WebDriver driver)
    {
    	driver.manage().window().maximize();}
	public static void quitWindow(WebDriver driver)
	{    
		driver.quit();
	}
	   public void goBack(WebDriver driver){
	        driver.navigate().back();
	    }
	   public void refreshPage(WebDriver driver){
		   driver.navigate().refresh();
	    }
	   public void goForward(WebDriver driver){
		   driver.navigate().forward();
	    }
	   public void switchToTab(String tabTitle,WebDriver driver){
	        Set<String> windows = driver.getWindowHandles();

	        System.out.println("Number of tabs: " + windows.size());

	        System.out.println("Window handles:");
	        windows.forEach(System.out::println);

	        for(String window : windows){
	            System.out.println("Switching to window: " + window);
	            driver.switchTo().window(window);

	            System.out.println("Current window title: " + driver.getTitle());

	            if(tabTitle.equals(driver.getTitle())){
	                break;
	            }
	        }
	    }

	   

 //stop notification -http://www.qaautomated.com/2018/03/ho...
	public static ChromeOptions stopnotificationforchrome() {
		try {                // Create object of HashMap Class
			  Map<String, Object> prefs = new HashMap<String, Object>();
              
              // Set the notification setting it will override the default setting
prefs.put("profile.default_content_setting_values.notifications", 2);

              // Create object of ChromeOption class
ChromeOptions options = new ChromeOptions();

              // Set the experimental option
options.setExperimentalOption("prefs", prefs);
return options;
}catch(Exception e){
	e.printStackTrace();
	return null;
}
		
		
		
	}
//stop notification
//maximize with dim
//don't catch cookies
//https://www.browserstack.com/guide/how-to-handle-cookies-in-selenium	
	//search 
}
