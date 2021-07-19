package Assignment.Selenium;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

		public class Alerts {

			public static void main(String[] args) throws InterruptedException {
				System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
				WebDriver driver=new ChromeDriver();
				   String baseUrl = "https://the-internet.herokuapp.com/";
				   driver.get(baseUrl);
				// This function is used to scroll down and click the specific element 
				   WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[29]/a"));
				   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
				   element.click();
				   Thread.sleep(500);
				//clicks on JS PROMOT
				   driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
				   Thread.sleep(3000);
				// Enter keys to alert box 
				   driver.switchTo().alert().sendKeys("Ex - TEST");
				   driver.switchTo().alert().accept();
				// Storing the alert box text into string called result 
				 String result = driver.findElement(By.id("result")).getText();
				 String actualResult = "You entered: Ex - TEST";
				// Here i am comparing both the strings > Expected & actual 
				   Assert.assertEquals(result, actualResult);
				   System.out.println("Test case is pass");
				   driver.close();
				   System.exit(0);
				}

	}