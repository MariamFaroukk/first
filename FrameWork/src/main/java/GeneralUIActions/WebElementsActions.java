package GeneralUIActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
public class WebElementsActions {
	//what i need to add more 
	public static boolean validateOnElement(By locator,String Condition,WebDriver driver)
	{   //change to descriptive 
		ExpectedCondition<WebElement> expectedContion= null;
		WebElement element;
		switch(Condition) {
		case "presence":
			expectedContion=ExpectedConditions.presenceOfElementLocated(locator);
			break;
		case "clickable":
			expectedContion=ExpectedConditions.elementToBeClickable(locator);
			break;
		case "visibility":
			expectedContion=ExpectedConditions.visibilityOfElementLocated(locator);
			break;
		
		}
		//dowhileloop refresh 
		try {
			if (expectedContion!=null)
			{
				//do{element =new WebDriverWait(driver,60).until(x);}while(element==null);
				new WebDriverWait(driver,60).until(expectedContion);
			}
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;	
		}	
		
	}
    //why not try and catch mn el fo2ha 
    //dropdownmenu

	
	
	public static String getText(By locator,String Condition,WebDriver driver) {
		if(validateOnElement(locator,Condition,driver)) {
			return driver.findElement(locator).getText();
		}else { return "NoText";}}
	//why not try and catch 	
	public static boolean clickonElement(By locatorOnCurrentPage,String ConditionOnCurrentPage,WebDriver driver,By locatorOnNextPage,String ConditionOnNextPage) {
		if(validateOnElement(locatorOnCurrentPage,ConditionOnCurrentPage,driver))
		{
			driver.findElement(locatorOnCurrentPage).click();
			return validateOnElement(locatorOnNextPage,ConditionOnNextPage,driver);
		}
		else { System.out.println("Couldnt Find the Current Locator."); return false;}
	}
    public static boolean getPagebyUrl(String url,WebDriver driver,By locator,String Condition)
    {
    	driver.navigate().to(url);
    	return validateOnElement(locator,Condition,driver);
	}
    public void selectFromDropDown(WebDriver driver,By locator,String option){
    	 new Select(driver.findElement(locator)).selectByVisibleText(option);
    }
    /* var dropDownPage = homePage.clickDropDown();

        String option = "Option 1";
        dropDownPage.selectFromDropDown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");*/

    public List<String> getSelectedOptions(WebDriver driver,By locator){
        List<WebElement> selectedElements =  new Select(driver.findElement(locator)).getAllSelectedOptions();
        List<String> taskList = new ArrayList<String>();
        
        for(WebElement element : selectedElements ){
            taskList.add(element.getText());
        }
     
        return taskList;
    }
    public void triggerAlert(WebDriver driver,By triggerAlertButton){
        driver.findElement(triggerAlertButton).click();
    }

    public void triggerConfirm(WebDriver driver,By triggerConfirmButton){
        driver.findElement(triggerConfirmButton).click();
    }

    public void triggerPrompt(WebDriver driver,By triggerPromptButton){
        driver.findElement(triggerPromptButton).click();
    }

    public void alert_clickToAccept(WebDriver driver){
        driver.switchTo().alert().accept();
    }

    public void alert_clickToDismiss(WebDriver driver){
        driver.switchTo().alert().dismiss();
    }

    public String alert_getText(WebDriver driver){
        return driver.switchTo().alert().getText();
    }

    public void alert_setInput(String text,WebDriver driver){
        driver.switchTo().alert().sendKeys(text);
    }
    /**
     * Provides path of file to the form then clicks Upload button
     * @param absolutePathOfFile The complete path of the file to upload
     */
    public void uploadFile(String absolutePathOfFile,WebDriver driver,By inputField,By uploadButton){
        
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
       // verify it is send verify that button isclickable 
        driver.findElement(uploadButton).click();
    }

    public void setSliderValue(String value,By sliderValue,By slider,WebDriver driver){
        while(!driver.findElement(sliderValue).getText().equals(value)){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);}
        //different keys Keys.chord(Keys.ALT, "p")
        }
 /*      String value = "4";
        var sliderPage = homePage.clickHorizonalSlider();
        sliderPage.setSliderValue(value);
        assertEquals(sliderPage.getSliderValue(), value, "Slider value is incorrect");*/
    private void switchToEditArea(WebDriver driver,int editorIframeId){
        driver.switchTo().frame(editorIframeId);
    }
    public void scrollToParagraph(int index,WebDriver driver,By textBlocks){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;

        while(driver.findElements(textBlocks).size() < index){
            jsExecutor.executeScript(script);
        }
    }

   

    private void switchToMainArea(WebDriver driver){
        driver.switchTo().parentFrame();
    }
    public void scrollToTable(WebDriver driver,By table){
        WebElement tableElement = driver.findElement(table);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, tableElement);
    }

    /**
     * @param index starts at 1
     */

    public void hoverOverFigure(int index,By locator,WebDriver driver){
        WebElement figure = driver.findElements(locator).get(index - 1);

        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        //actions.contextClick(driver.findElement(box)).perform();
        //return new ReturnCaptionAfterHover(figure.findElement(boxCaption));
        //ha3mel class lwa7dp
        /* var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);

        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(), "name: user1", "Caption title incorrect");
        assertEquals(caption.getLinkText(), "View profile", "Caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"), "Link incorrect");*/

    }



	}

//reading from different files
//cross and parallel browsing xml testng
//hover 
//scroll
//select drop 
//drag
//javascript stuff (presence of element)
//text
//angie jones



