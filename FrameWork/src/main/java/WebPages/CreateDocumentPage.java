package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import GeneralUIActions.WebElementsActions;

public class CreateDocumentPage {
	private WebDriver driver ;
	private By titleOFpage= By.xpath("//div[@class='title']");
	public  CreateDocumentPage(WebDriver driver) {
		this.driver=driver;	
	}
	 private By clickonbar (String barbname) 
		 {return By.xpath("//div[@class='product-title-container card-header']/div[text()='"+barbname+"']");}

		 private By searchresult_link (String barbname) 
		 {return By.xpath("//div[text()='"+barbname+"']/..//span[(normalize-space(text())) and not(@class='price-strikethrough')]");}
		 
			public String validatetitle (String barbname) {
				if (WebElementsActions.
						clickonElement(clickonbar(barbname), "clickable", driver, titleOFpage , "visibility"))
				
				return WebElementsActions.getText(titleOFpage,"visibility", driver);
				else 
					return null;
				 
			}		 
			public String finditisfreeornot(String barbname) {
					
				return 	WebElementsActions.getText(searchresult_link(barbname),"visibility", driver);
			}		 
		 
}