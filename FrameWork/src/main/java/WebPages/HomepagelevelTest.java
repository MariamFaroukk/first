package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import GeneralUIActions.WebElementsActions;


public class HomepagelevelTest {
	//variables 
		private String homePagelink="https://www.levelset.com/";
		private WebDriver driver ;
		private By ElementLOCTovalidatoCreateDocumentpage =By.xpath("//div[@class='description-title' and text()='Popular documents ']");
		private By ElementLOCTovalidateHomepage =By.xpath("//h1[text()='Get paid faster.']");
		private By buttonTomoveCreatedocPage =By.xpath("//a[@class=\"btn btn-info btn-outline mob-dropdown-btn\"]");
		//constructor 
		//ask about static 
		public HomepagelevelTest(WebDriver driver) {
			this.driver=driver;	
		}
		public HomepagelevelTest navigateTohomePage() {
            //validate on create document 
			if(WebElementsActions.getPagebyUrl(homePagelink,driver,ElementLOCTovalidateHomepage,"visibility"))
			 return this;
			else 
			return null;
			
		 }
		public CreateDocumentPage clickoncreatedocument() {
			if (WebElementsActions.
					clickonElement(buttonTomoveCreatedocPage, "clickable", driver, ElementLOCTovalidatoCreateDocumentpage , "visibility"))
			
			return new CreateDocumentPage(driver);
			else 
				return null;
				
		}
     







}
