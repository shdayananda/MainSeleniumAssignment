package commonutils;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testdata.Constants;

public class GenericUtils {

		
		 WebDriverWait wait;
		    Select select;
		    Actions actions;
		    Set<String> windowIDs;
		    String parentWindowID,childWindowID;
		    static Properties configProp;
		    //public WebDriver driver;

		    public void waitForPageToLoad(WebDriver driver){
		     driver.manage().timeouts().implicitlyWait(Constants.maxWait, TimeUnit.SECONDS);
		    }

		    public void waitForPageToLoad(WebDriver driver, int waitTime){
		        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		    }

		    public void waitForElementAvailablility(WebDriver driver, WebElement element){
		        wait = new WebDriverWait(driver,10);
		        wait.until(ExpectedConditions.visibilityOf(element));
		    }

		    public void select(WebElement element, String text){
		        select = new Select(element);
		        select.selectByVisibleText(text);
		    }

		    public void hoverOnElement(WebDriver driver, WebElement element){
		        actions =new Actions(driver);
		        actions.moveToElement(element).perform();
		    }

		  
		    public void waitSendKeys(WebDriver driver, WebElement element, String inputText){
		        waitForElementAvailablility(driver, element);
		        element.sendKeys(inputText);
		    }

		    public void waitClick(WebDriver driver, WebElement element){
		        waitForElementAvailablility(driver, element);
		        element.click();
		    }

		    public void waitHover(WebDriver driver, WebElement element){
		        waitForElementAvailablility(driver, element);
		        hoverOnElement(driver, element);
		    }

		    		    //public static void screenCapture(WebDriver driver, String movieName) throws Exception {
		       //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        //FileUtils.copyFile(scrFile,  new File(System.getProperty("user.dir")+"//ScreenShot/"+movieName+".jpeg"));      //your screenshot path and convert date string to SimpleDateFormat because windows can't capture screenshot with(:)
		    }



