package com.DsAlgo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgoProject.Base.BaseClass;

public class DataStructuresPage {
	WebDriver driver;

	public DataStructuresPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(linkText = "Time Complexity")WebElement lnkTimeComplexity;
	@FindBy(linkText = "Try here>>>")WebElement btnTryeHere;
	@FindBy(linkText = "Practice Questions")WebElement lnkPracticeQuestions;
	
	public void ClickTimeComplexity() {
		lnkTimeComplexity.click();
	}
	
	public void ClickTryHere() {
		btnTryeHere.click();
	}
	
	public void ClickPracQues() {
		lnkPracticeQuestions.click();
	}
}
