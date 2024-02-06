package com.ametek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

@FindBy(name="proceedToRetailCheckout") private WebElement ProceedToBuyButton;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnProceedToBuyButton()
	{
		ProceedToBuyButton.submit();
	}
	
}
