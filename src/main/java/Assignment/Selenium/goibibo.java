package Assignment.Selenium;

import java.awt.List;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class goibibo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver=new ChromeDriver();
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			   driver.get("https://www.goibibo.com/");
			   driver.manage().window().maximize();
			   driver.findElement(By.xpath("//*[@id=\"roundTrip\"]")).click();
			   driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).sendKeys("NewYork");
			   driver.findElement(By.xpath("//*[@id=\"react-autosuggest-1-suggestion--0\"]")).click();
			   driver.findElement(By.xpath("//*[@id=\"gosuggest_inputDest\"]")).sendKeys("Seattle");
			   driver.findElement(By.xpath("//*[@id=\"react-autosuggest-1-suggestion--0\"]")).click();
			   driver.findElement(By.xpath("//*[@id=\"fare_20210728\"]")).click();
			   driver.findElement(By.xpath("//*[@id=\"searchWidgetCommon\"]/div[1]/div[1]/div[1]/div/div[8]/div/div/div/div[1]/span[2]")).click();
			   driver.findElement(By.xpath("//*[@id=\"fare_20210808\"]")).click();

			   driver.findElement(By.xpath("//*[@id=\"gi_search_btn\"]")).click();
			   File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			   String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			   driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div[4]/div/span")).click();
			   String fairPrice = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/div[1]/div")).getText();

			   int i = Integer.parseInt(fairPrice.replaceAll(",", ""));
			   System.out.println(i);

			   if (i >= 25000) {
			       driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/button")).click();
			   }
			   //List <WebElement> links = driver.findElements(By.xpath("//*[@id=\"fareSummary\"]/div[2]/div[1]/div/span"));    //Identify the number of Link on webpage and assign into Webelement List
			   //int linkCount = links.size();     // Count the total Link list on Web Page
			   //System.out.println("Total Number of link count on webpage = " + linkCount);
			}


	}


