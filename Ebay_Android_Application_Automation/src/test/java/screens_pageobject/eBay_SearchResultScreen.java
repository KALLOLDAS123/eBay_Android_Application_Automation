package screens_pageobject;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class eBay_SearchResultScreen extends ScreenBase{
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.ebay.mobile:id/cell_collection_item']")
	public MobileElement searchedProduct;
	
	

	public eBay_SearchResultScreen(AppiumDriver driver) {
		super(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

}
