package screens_pageobject;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import Component.Component_Textverification;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Common_Utilities;


/***
 * Page object for Country/Region selection Screen for verifications.
 * @author kdas
 *
 */
public class eBay_CountryRegionSelectionScreen extends ScreenBase{
	
	/* Taking the xpath dynamically from Property file*/

	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter search text']")
	public MobileElement entersearchtext;

	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='Australia']")
	public  MobileElement countrySelectdropdown;
	
	
	

	public eBay_CountryRegionSelectionScreen(AppiumDriver driver) {
		super(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	   
		//countryselect = (MobileElement) driver.findElementById("android:id/summary");
		
		
	}
	

}
