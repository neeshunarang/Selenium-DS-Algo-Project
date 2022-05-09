package com.DsAlgo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgoProject.Base.BaseClass;

public class PortalPage extends BaseClass{
	WebDriver driver;

	public PortalPage(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
	}
	@FindBy(className ="btn")WebElement btnStarted;
	public void clickGetStarted() {
		btnStarted.click();
	}
}
