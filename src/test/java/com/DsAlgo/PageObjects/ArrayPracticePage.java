package com.DsAlgo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArrayPracticePage {
	WebDriver driver;

	public ArrayPracticePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(linkText = "Search the array")WebElement lnkSearchArray;
	@FindBy(linkText = "Max Consecutive Ones")WebElement lnkMaxConOnes;
	@FindBy(linkText = "Find Numbers with Even Number of Digits")WebElement lnkFindNos;
	@FindBy(linkText = "Squares of a Sorted Array")WebElement lnkSqSortedArray;
	
	public void ClickSearchArray() {
		lnkSearchArray.click();
	}
	
	public void ClickMaxConOnes() {
		lnkMaxConOnes.click();
	}
	
	public void ClickFindNos() {
		lnkFindNos.click();
	}
	public void ClickSqSortedArray() {
		lnkSqSortedArray.click();
	}
}
