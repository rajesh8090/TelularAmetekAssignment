package com.ametek.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ametek.generic.Utils;
import com.ametek.pages.CartPage;
import com.ametek.pages.HomePage;
import com.aventstack.extentreports.ExtentTest;
/**
 * 
 * @author Rajesh Kumar
 *
 */
public class HomePageTest extends BaseTest {

	@Test()
	public void verifySearchFunctionality() throws Exception {
		ExtentTest test = extent.createTest("Verify Amazon Search & Add to Cart functionality");
		test.assignCategory("Regression", "Smoke");
		test.assignAuthor("Rajesh Kumar");
		HomePage hp = new HomePage(driver);
		Thread.sleep(5000);
		// Enter value into Search Bar
		hp.setValueIntoSearchbar("mobile phone under 15000");
		// Click on Search Icon
		hp.clickOnSearchIcon();

		// Get List of Device Name & Price
		int i = 0, j = 0;
		while (hp.isNextIconEnabled()) {
			for (WebElement deviceName : hp.getDeviceNames()) {
				Utils.writeDataIntoExcelSheet("Amazon", i++, 0, deviceName.getText());
				System.out.println(deviceName.getText());
			}
			for (WebElement devicePrice : hp.getDevicePrices()) {
				Utils.writeDataIntoExcelSheet("Amazon", j++, 1, devicePrice.getText());
				System.out.println(devicePrice.getText());
			}
			hp.clickOnNextIcon();
		}
		hp.clickOnPage1Icon();
		hp.clickOnNextIcon();
		hp.clickOnNextIcon();
		hp.clickOnNextIcon();
		//Navigating to 5th page
		hp.clickOnPage5Icon();
		//Click on the third device from search result
		hp.clickThirdDeviceName();
		Utils.switchToChildWindow(driver);
		Thread.sleep(5000);
		//Click on Add to Cart button
		hp.clickOnAddToCartButton();
		Thread.sleep(5000);
		hp.clickOnCrossIcon();
		Thread.sleep(5000);
		//Click on Cart button
		hp.clickOnCart();
		CartPage cp = new CartPage(driver);
		//Click on Proceed to Buy button
		cp.clickOnProceedToBuyButton();
		test.pass("Verify Amazon Search & Add to Cart functionality test is passed");
	}
}
