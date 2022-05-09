package com.DsAlgo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgoProject.Base.BaseClass;

public class RegistrationPage extends BaseClass{
	WebDriver driver;
	public RegistrationPage(WebDriver d)
	{
		this.driver=d;
		PageFactory.initElements(d, this);
	}
	@FindBy(id ="id_username")WebElement txtusername;
	@FindBy(id ="id_password1")WebElement txtPassword1;
	@FindBy(id ="id_password2")WebElement txtPassword2;
	@FindBy(xpath ="//input[@value='Register']")WebElement submitRegister;
	
	public void enterUserName(String uname) {
		//txtusername.clear();
		txtusername.sendKeys(uname);
	} 
	public void enterPassword1(String pswd1) {
		//txtPassword1.clear();
		txtPassword1.sendKeys(pswd1);
	}
	public void enterPassword2(String pswd2) {
		//txtPassword2.clear();
		txtPassword2.sendKeys(pswd2);
	}
	
	public void submitRegister() {
		submitRegister.click();
	}
}
