package TestLevel;

import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;
import GeneralUIActions.WebBrowserActions;
import WebPages.CreateDocumentPage;
import WebPages.HomepagelevelTest;
import Wrappers.PropertiesFileReader;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class NewTestForLevelTest {
	WebDriver driver;
  @Test
  public void LeinProductScenarioTest() {
	  CreateDocumentPage page= new HomepagelevelTest(driver).navigateTohomePage().clickoncreatedocument();
	  Assert.assertEquals(page.validatetitle("Lien Waiver"),"Lien Waiver");
	 Assert.assertEquals(page.finditisfreeornot("Lien Waiver"),"Free");
  }
  @Test
  public void NoticeProductScenarioTest() {
	  CreateDocumentPage page= new HomepagelevelTest(driver).navigateTohomePage().clickoncreatedocument();
	  Assert.assertEquals(page.validatetitle("Notice of Intent to Lien"),"Notice of Intent to Lien");
	 Assert.assertEquals(page.finditisfreeornot("Notice of Intent to Lien"),"Free");
  }
  @Test
  public void PreliminryProductScenarioTest() {
	  CreateDocumentPage page= new HomepagelevelTest(driver).navigateTohomePage().clickoncreatedocument();
	  Assert.assertEquals(page.validatetitle("20-Day Preliminary Notice"),"20-Day Preliminary Notice");
	 Assert.assertEquals(page.finditisfreeornot("20-Day Preliminary Notice"),"Free");
  }
  @Test
  public void LeinAndbondProductScenarioTest() {
	  CreateDocumentPage page= new HomepagelevelTest(driver).navigateTohomePage().clickoncreatedocument();
	  Assert.assertEquals(page.validatetitle("Lien / Bond Claim"),"Lien / Bond Claim");
	 Assert.assertEquals(page.finditisfreeornot("Lien / Bond Claim"),"Free");
  }
  @Test
  public void stopnotify() {
	  driver.get("http://www.qaautomated.com/2018/03/how-to-disable-chrome-notifications.html");
  }
  @Test(dataProvider="SearchProvider")
  public void allproductScenario(String productname ,String price) {
	  CreateDocumentPage page= new HomepagelevelTest(driver).navigateTohomePage().clickoncreatedocument();
	  Assert.assertEquals(page.validatetitle(productname),productname);
	 Assert.assertEquals(page.finditisfreeornot(productname),price);
  }

  @DataProvider(name="SearchProvider")
  public Object[][] getDataFromDataprovider(){
  return new Object[][] 
  	{
          { "Lien / Bond Claim", "Free" },
          { "20-Day Preliminary Notice", "Free" },
          { "Notice of Intent to Lien", "Free" },
          { "Lien Waiver", "Free" }
      };

  }
  @BeforeClass
  public void beforeClass() {
	 // WebDriverManager.chromedriver().setup();
	driver=  WebBrowserActions.chooseBrowserDriver("Chrome");
	  WebBrowserActions.staticmaximizeWindow(driver);
	  
  }
  @Test
  public void testingwrapperpropfile() {
	  Assert.assertEquals("Mariam",PropertiesFileReader.getValue("Name"));
  }

  @AfterClass
  public void afterClass() {
	  WebBrowserActions.quitWindow(driver);
	  driver.manage().deleteAllCookies();
  }
  @AfterMethod
  public void recordFailure(ITestResult result){

      if(ITestResult.FAILURE == result.getStatus())
      {
    	  TakesScreenshot ts = (TakesScreenshot)driver; 
    	  File file = ts.getScreenshotAs(OutputType.FILE); 
    	  try {
			FileUtils.copyFile(file,new File ("./ScreenShot_Folder/Test1_Login.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	  
          //File screenshot = new File("resources/screenshoots/test.png");
		/*try {
			 File screenshot = null;
			Files.move(screenshot, new File("/FrameWork/src/main/resources/screenshots" + result.getName() + ".png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

      }
  }

}
