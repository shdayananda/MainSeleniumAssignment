package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonutils.DriverUtils;
import commonutils.GenericUtils;
import pageobjects.WeatherShopperPageObject;
import testdata.Constants;

public class PurchaseTest {
	WebDriver driver;
	GenericUtils genericUtil;
	DriverUtils driverUtil;
	WeatherShopperPageObject weatherShopperPageObject;
	
    @BeforeTest
    @Parameters("browser")
    public void preConfig(String browser) throws Exception
    {
        driverUtil = new DriverUtils();
    	genericUtil = new GenericUtils();	
        driver = driverUtil.launchDriver(browser);
        driver.get(Constants.baseUrl);
        weatherShopperPageObject = PageFactory.initElements(driver,WeatherShopperPageObject.class);
        genericUtil.waitForPageToLoad(driver);
    }

    @Test
    public void test() {
    	
    	System.out.println(weatherShopperPageObject.getTemperature(driver));
    	String temperature = weatherShopperPageObject.getTemperature(driver);
    	System.out.println(temperature);
    	weatherShopperPageObject.buyMoisturiserOrSuncscreen("10");
        
        
    }

    @AfterTest
    public void AfterTest(){
        //driver.quit();
    }

}
