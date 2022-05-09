package com.DsAlgo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgoProject.Base.BaseClass;

public class HomePage extends BaseClass{
	
	WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Register")WebElement linkRegister;
	@FindBy(linkText = "Sign in")WebElement linkLogin;
	@FindBy(linkText ="Sign out")WebElement linkSignOut;
	@FindBy(xpath = "//a[@href='data-structures-introduction']")WebElement btnDSGetStarted;
	@FindBy(linkText ="Data Structures")WebElement lnkDataStruc;
	@FindBy(linkText ="Arrays")WebElement lnkArrays;
	@FindBy(linkText ="Stack")WebElement lnkStack;
	@FindBy(xpath ="//div/div[2]/ul/a[3]")WebElement signOutVisible;
	
	public void lnkLogin() {
		linkLogin.click();
	}
	public void clickRegister() {
		linkRegister.click();
	}
	public void clickLogout() {
		linkSignOut.click();
	}
	public void clickOnDataStruc() {
		
		lnkDataStruc.click();
		
	}
	public void ClickOnDSGetStarted() {
		btnDSGetStarted.click();
	}
	
	public void ClickArrays() {
		lnkArrays.click();
	}
	public String isSignOutVisible() {
		return signOutVisible.getText();
	}
	public void ClickStack() {
		lnkStack.click();
	}
}
