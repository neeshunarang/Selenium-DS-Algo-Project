package com.DsAlgo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgoProject.Base.BaseClass;

public class SignInPage extends BaseClass{
	WebDriver driver;
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id ="id_username")WebElement txtusername;
	@FindBy(id ="id_password")WebElement txtPassword;
	
	@FindBy(xpath ="//input[@value='Login']")WebElement btnLogin;
	@FindBy(xpath ="//div[contains(@class,'alert')]")WebElement alertMsg;
	
	public void enterUserName(String str) {
		txtusername.sendKeys(str);
	} 
	public void enterPassword(String str) {
		txtPassword.sendKeys(str);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	public String returnMsg() {
		return alertMsg.getText();
	}
	
}
