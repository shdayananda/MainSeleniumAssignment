package Assignment.Selenium;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class miniassignment2 {

	public static void main(String[] args) {
		
		       System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		       WebDriver driver = new ChromeDriver();
		       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		       driver.get("https://flipkart.com");
		       String firstTitle = driver.getTitle();
		       String oldTab = driver.getWindowHandle();

		       System.out.print(firstTitle);
		       JavascriptExecutor js = (JavascriptExecutor) driver;
		       js.executeScript("window.open();");
		       ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		       driver.switchTo().window(newTab.get(1));
		       driver.get("https://facebook.com");
		       driver.switchTo().window(oldTab);
		      String secondTitle = driver.getTitle();
		      Assert.assertEquals(firstTitle,secondTitle);


		   }


	}
