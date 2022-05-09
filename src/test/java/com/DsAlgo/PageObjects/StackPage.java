package com.DsAlgo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StackPage {
	WebDriver driver;

	public StackPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Operations in Stack")WebElement lnkOperInStack;
	@FindBy(linkText = "Implementation")WebElement lnkImplement;
	@FindBy(linkText = "Applications")WebElement lnkApplications;
	@FindBy(linkText = "Try here>>>")WebElement btnTryeHere;
	
	public void clickOperInStack() {
		lnkOperInStack.click();
	}
	public void clickImplement() {
		lnkImplement.click();
	}
	public void clickApplications() {
		lnkApplications.click();
	}
	public void ClickTryHere() {
		btnTryeHere.click();
	}
}
