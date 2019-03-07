package testcases;

import java.io.IOException;

import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import Component.GenerateReport;
import base.TestBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import screens_pageobject.eBay_AddtoCartScreen;
import screens_pageobject.eBay_CountryOrRegionScreen;
import screens_pageobject.eBay_CheckoutScreen;
import screens_pageobject.eBay_CountryRegionSelectionScreen;
import screens_pageobject.eBay_MenuScreen;
import screens_pageobject.eBay_OverviewScreen;
import screens_pageobject.eBay_PaywithScreen;
import screens_pageobject.eBay_ProductDetailsScreen;
import screens_pageobject.eBay_SearchResultScreen;
import screens_pageobject.eBay_SearchScreen;
import screens_pageobject.eBay_SignINScreen;
import screens_pageobject.eBay_ChooseAnotherAccountScreen;
import screens_pageobject.eBay_CreditdebitDetailsScreen;
import screens_pageobject.eBay_LinkAccountScreen;
import screens_pageobject.ebay_SettingsDetailsScreen;
import utilities.Common_Utilities;



/* This class we are using for the writing the test script only through method invocations*/
@Listeners(GenerateReport.class)
public class EBayTestSuits extends TestBase {
	
	
	
	@BeforeTest
	public void init() throws InterruptedException, IOException{
		addtCart=new eBay_AddtoCartScreen(driver);
		checkOut=new eBay_CheckoutScreen(driver);
		chooseOtherAccount=new eBay_ChooseAnotherAccountScreen(driver);
		country=new eBay_CountryOrRegionScreen(driver);
		countrySelection=new eBay_CountryRegionSelectionScreen(driver);
		cardDetails=new eBay_CreditdebitDetailsScreen(driver);
		overview=new eBay_OverviewScreen(driver);
		payWith=new eBay_PaywithScreen(driver);
		productDetails=new eBay_ProductDetailsScreen(driver);
		seachItems=new eBay_SearchScreen(driver);
		settingsDetails=new ebay_SettingsDetailsScreen(driver);
		signIn=new eBay_SignINScreen(driver);
		Menu=new eBay_MenuScreen(driver);
		NolinkAccount= new eBay_LinkAccountScreen(driver);
		searchedProds= new eBay_SearchResultScreen(driver);
		
		
		
	}
	
	@Test
	public void test001OverviewScreenUIVerification() throws InterruptedException, IOException{
		
		
		test = extent.createTest("test001OverviewScreenUIVerification");
		//overview.logoExistence.isDisplayed();
		Common_Utilities.log("/-----Log for Testscripts-----/");
		System.out.println("Logo is displayed--Confirmed overview screen is correct");
		overview.hamburgerMenu_click("test001OverviewScreenUIVerification");
		Menu.settingsOption();
	    settingsDetails.settingsHeaderText();
	    settingsDetails.countryregionOptionclick();
		country.countryregionheaderverify();
	    country.countryRegionlinkverfiy();
	    /*============ To remove the touch Action I tried different ways, for that particular object element I tried creating 
	     * Xpath with , i used parent child class approach as well, but that was not working So finally kept this , so that Code can be 
	     * in runnable mode.
	    */
	    TouchAction action = new TouchAction(Common_Utilities.driver);
	    action.press(PointOption.point(629, 944)).release().perform();
	    countrySelection.entersearchtext.sendKeys("Australia");
		countrySelection.countrySelectdropdown.click();
		driver.navigate().back();
		driver.navigate().back();

		
	}
	
	@Test
	public void test002SignIn() throws Exception{
		
		test = extent.createTest("test002SignIn");
		overview.hamburgerMenu_click("test002SignIn");
		Menu.signInclick();
		Thread.sleep(2000);
		Common_Utilities.driver.navigate().back();
		signIn.signindataentry("test002SignIn");
		Common_Utilities.log("/-----Log for Testscripts-----/");
		NolinkAccount.linkeBayscreenverify();
		NolinkAccount.noThanks.click();
		Thread.sleep(3000);
	
		
	}

	@Test
	public void test003searchproduct() throws InterruptedException{
		
		test = extent.createTest("test003searchproduct");
		seachItems.entertextInsearchBox();
		seachItems.requiredproduct.click();
		seachItems.divantiTVselect.click();
	}
	
	@Test
	public void test004productDetails() throws InterruptedException, IOException{
		
		test = extent.createTest("test004productDetails");
		String value = productDetails.detailsscreentextWithoutLinkclik("test004productDetails");
		Common_Utilities.log("/-----Log for Testscripts-----/");
		searchedProds.searchedProduct.click();
		productDetails.addproductAddtocart("test004productDetails");
		productDetails.cartViewsbutton("test004productDetails");
		addtCart.productTextVerifyOnAddtocartScreen(value);
		addtCart.checkoutButtonclick("test004productDetails");
			
	}	
	@Test
	public void test005purchaseflow() throws InterruptedException{
		
		test = extent.createTest("test005purchaseflow");
		checkOut.CheckoutscreentitleVerification();
		checkOut.payemtoptionlinkclick();
		payWith.creditdebitoptionverfiyandClick();
				
	}
	
	@Test
	public void test006enteringpaymentdetails() throws InterruptedException{
		
		test = extent.createTest("test006enteringpaymentdetails");
		cardDetails.payemntdataentry();
		cardDetails.submitepaymentdetails();
		cardDetails.wrongpaymentdetailsverification();
		driver.navigate().back();
		
			
	}
	
	

	

	
	
}
