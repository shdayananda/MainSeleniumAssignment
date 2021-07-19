package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonutils.GenericUtils;

public class WeatherShopperPageObject {
	
	GenericUtils generiUtil= new GenericUtils();
	
	@FindBy (xpath = "//*[@id=\'temperature\']")
	WebElement temperature;
	
	@FindBy (xpath = "//a[contains(@href,'moisturizer')]")
	WebElement buyMoisturiserButton;
	
	@FindBy (xpath = "//a[contains(@href,'sunscreen')]")
	WebElement buySunscreenButton;
	
	public String getTemperature(WebDriver driver) {
		//generiUtil.waitForPageToLoad(driver);
		generiUtil.waitForElementAvailablility(driver, temperature);
		return temperature.getText();
	}
	
	public void buyMoisturiserOrSuncscreen(String temperature) {
		if (extractTemperature(temperature)<= 19)
		{
			buyMoisturiser();
		}
		else if (extractTemperature(temperature)>19) {
			
			buySunscreen();
		}
		
		else {
			System.out.println("Invalid temperature");
		}
		
	}
	 
	public void buyMoisturiser () {
		
		buyMoisturiserButton.click();
		
	}
	
	public void buySunscreen () {
		
		buySunscreenButton.click();
	}
	
	public int extractTemperature (String inputTemperature) {
		
		String sub = inputTemperature.substring(0, 2);
		 int a=Integer.parseInt(sub);
		 //System.out.println(sub);
		 //System.out.println("random text"+a);
		 return a;
	}

}
