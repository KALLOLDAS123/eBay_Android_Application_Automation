package screens_pageobject;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import Component.Component_textVerifyWithoutLinkClick;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class eBay_LinkAccountScreen extends ScreenBase {
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Next time, save yourself a step']")
	private MobileElement linkebay;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='NO THANKS']")
	public MobileElement noThanks;
	
	private Component_textVerifyWithoutLinkClick linkeBayscreenheader;
	

	public eBay_LinkAccountScreen(AppiumDriver driver) throws IOException {
		super(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		linkeBayscreenheader = new Component_textVerifyWithoutLinkClick(linkebay, this.getClass().getSimpleName());
	}
	
	public void linkeBayscreenverify() throws IOException{
		
		linkeBayscreenheader.verifyTextWithoutLinkClick("Next time, save yourself a step");
		
	}
	
	

}
