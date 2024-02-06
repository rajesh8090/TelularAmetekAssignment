package com.ametek.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class HomePage {

	@FindBy(id="twotabsearchtextbox") private WebElement searchbar;
	@FindBy(id="nav-search-submit-button") private WebElement searchicon;
	
	//Result Page
	@FindBy(xpath="//div[@class='puisg-col-inner']/div/div/div/a/span/span/span[2]") private List<WebElement> devicePrices;
	@FindBy(xpath="//div[@class='puisg-col-inner']/div/div/h2/a/span") private List<WebElement> deviceNames;
	//@FindBy(linkText="Next") private WebElement nextIcon;
	@FindBy(xpath="//*[text()='Next']") private WebElement nextIcon;
	@FindBy(linkText="5") private WebElement Page5Icon;
	@FindBy(linkText="1") private WebElement Page1Icon;
	@FindBy(xpath="(//div[@class='puisg-col-inner']/div/div/h2/a/span)[3]") private WebElement thirdDeviceNames;
	@FindBy(id="nav-cart-count-container") private WebElement CartIcon;
	@FindBy(xpath="//div[@id='desktop_qualifiedBuyBox']/descendant::span/input[@value='Add to Cart']") private WebElement AddToCartButton;
	@FindBy(id="attach-close_sideSheet-link") private WebElement CrossIcon;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setValueIntoSearchbar(String searchdata)
	{
		searchbar.sendKeys(searchdata);
	}
	
	public void clickOnSearchIcon()
	{
		searchicon.submit();
	}
	
	public List<WebElement> getDeviceNames()
	{
		return deviceNames;
	}
	
	public List<WebElement> getDevicePrices()
	{
		return devicePrices;
	}
	
	public void clickOnNextIcon()
	{
		nextIcon.click();
	}
	
	public boolean isNextIconEnabled()
	{
		//return nextIcon.isEnabled();
		String value = nextIcon.getAttribute("aria-disabled");
		if(value!=null)
		   return false;
		else
			return true;
	}
	public void clickOnPage1Icon()
	{
		Page1Icon.click();
	}
	public void clickOnPage5Icon()
	{
		Page5Icon.click();
	}
	public void clickThirdDeviceName()
	{
		thirdDeviceNames.click();
	}
	public void clickOnAddToCartButton()
	{
		AddToCartButton.click();
	}
	public void clickOnCrossIcon()
	{
		CrossIcon.click();
	}
	public void clickOnCart()
	{
		CartIcon.click();
	}
	
	
}
