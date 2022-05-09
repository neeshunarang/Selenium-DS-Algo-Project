package com.DsAlgoProject.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.DsAlgo.PageObjects.ArrayPage;
import com.DsAlgo.PageObjects.ArrayPracticePage;
import com.DsAlgo.PageObjects.DataStructuresPage;
import com.DsAlgo.PageObjects.HomePage;
import com.DsAlgo.PageObjects.TryEditorPage;
import com.DsAlgoProject.Base.BaseClass;
import com.DsAlgoProject.Utilities.XLUtils;

public class TC04_Arrays extends BaseClass{
	@Test
	public void ArraysTest() throws InterruptedException, IOException 
	{
		SignIn();
		HomePage hp = new HomePage(driver);
		ArrayPage arr = new ArrayPage(driver);
		
		String sheet="Array";
		XLUtils objXL = new XLUtils(projectPath + excelPath, sheet);
		
		hp.clickOnDataStruc();
		logger.info("Clicked on Data Structure dropdown");
		
		hp.ClickArrays();
		logger.info("Select Array from dropdown");
		
		//Arrays in Python
		
		arr.clickArraysinPython();
		logger.info("Clicked on Arrays Python link");
		
		arr.ClickTryHere();
		logger.info("Clicked on Try here button");
		
		EnterCommandAndRun(objXL.getCellData(1, 1),objXL.getCellData(1, 2),sheet,1);
		//Arrays Using List
		arr.clickArraysUsingList();
		logger.info("Clicked on Arrays Using list");
		
		arr.ClickTryHere();
		logger.info("Clicked on Try here button");
		
		EnterCommandAndRun(objXL.getCellData(2, 1),objXL.getCellData(2, 2),sheet,2);
		
		//Basic Operations in Lists
		arr.clickArraysBasicOp();
		logger.info("Clicked on Basic Operations in List");
		
		arr.ClickTryHere();
		logger.info("Clicked on Try here button");
		
		EnterCommandAndRun(objXL.getCellData(3, 1),objXL.getCellData(3, 2),sheet,3);
		
		//**********Applications of Array************
		arr.ClicklnkAppofArray();
		logger.info("Clicked on Applications of Array");
		
		arr.ClickTryHere();
		logger.info("Clicked on Try here button");
		
		//EnterCommandAndRun("Applications of Array");
		EnterCommandAndRun(objXL.getCellData(4, 1),objXL.getCellData(4, 2),sheet,4);	
		
		//Practice Questions
		arr.clickPracQues();
		ArrayPracticePage ap=new ArrayPracticePage(driver);
		
		//Search the Array
		ap.ClickSearchArray();
		EnterCommandAndRun(objXL.getCellData(6, 1),objXL.getCellData(6, 2),sheet,6);
		
		//Max Consecutieves ones
		ap.ClickMaxConOnes();
		EnterCommandAndRun(objXL.getCellData(7, 1),objXL.getCellData(7, 2),sheet,7);
		
		//Find numbers with Even Numbers of Digits
		ap.ClickFindNos();
		EnterCommandAndRun(objXL.getCellData(8, 1),objXL.getCellData(8, 2),sheet,8);
		
		//Squares of a Sorted Array
		ap.ClickSqSortedArray();
		EnterCommandAndRun(objXL.getCellData(9, 1),objXL.getCellData(9, 2),sheet,9);
		
		driver.navigate().back();
		logger.info("Back to Array Page");
	}
}
