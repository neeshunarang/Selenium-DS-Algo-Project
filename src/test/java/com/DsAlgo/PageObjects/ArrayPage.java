package com.DsAlgo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArrayPage {
	WebDriver driver;

	public ArrayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Arrays in Python")WebElement lnkArraysinPython;
	@FindBy(linkText = "Arrays Using List")WebElement lnkArraysUsingList;
	@FindBy(linkText = "Basic Operations in Lists")WebElement lnkArraysBasicOp;
	@FindBy(linkText = "Applications of Array")WebElement lnkAppofArray;
	@FindBy(linkText = "Practice Questions")WebElement lnkPracQues;
	@FindBy(linkText = "Try here>>>")WebElement btnTryeHere;
	
	public void clickArraysinPython() {
		lnkArraysinPython.click();
	}
	public void clickArraysUsingList() {
		lnkArraysUsingList.click();
	}
	public void clickArraysBasicOp() {
		lnkArraysBasicOp.click();
	}
	public void clickPracQues() {
		lnkPracQues.click();
	}
	public void ClickTryHere() {
		btnTryeHere.click();
	}
	public void ClicklnkAppofArray() {
		lnkAppofArray.click();
	}
}
