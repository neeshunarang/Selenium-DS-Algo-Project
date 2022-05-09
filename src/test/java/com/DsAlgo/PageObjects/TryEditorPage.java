package com.DsAlgo.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgoProject.Base.BaseClass;

public class TryEditorPage extends BaseClass{
	WebDriver driver;
	public TryEditorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath = "(//textarea)[2]")WebElement txtAreaEditor;
	@FindBy(xpath = "//button[@type='button']")WebElement btnRun;
	@FindBy(id = "output")WebElement lblOutput;
	
	
	public void EnterCommand(String str) {
		txtAreaEditor.sendKeys(Keys.CONTROL + "a");
		txtAreaEditor.sendKeys(Keys.DELETE);
		txtAreaEditor.sendKeys( str );
	}
	
	public void ClickRun() {
		btnRun.click();
	}
	
	public String getOutput() {
		return lblOutput.getText();
	}
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	    	driver.switchTo().alert();
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}
	public  String ClickOkOnAlert()
	{
		String alert_text=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return  alert_text;
	}
}
