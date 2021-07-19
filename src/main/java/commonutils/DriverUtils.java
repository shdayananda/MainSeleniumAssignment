package commonutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverUtils {
	
		public  WebDriver driver;
	    public  DesiredCapabilities capabilities;

	    public WebDriver launchDriver(String browser) throws Exception {
	        
	            if (browser.equalsIgnoreCase("chrome")) {
	            	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	                driver = new ChromeDriver();
	                driver.manage().window().maximize();
	            } 
	             
	        return driver;
	    }

	    }

