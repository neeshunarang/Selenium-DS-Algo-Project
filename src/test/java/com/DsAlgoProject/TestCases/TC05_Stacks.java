package com.DsAlgoProject.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.DsAlgo.PageObjects.ArrayPage;
import com.DsAlgo.PageObjects.HomePage;
import com.DsAlgo.PageObjects.StackPage;
import com.DsAlgo.PageObjects.TryEditorPage;
import com.DsAlgoProject.Base.BaseClass;
import com.DsAlgoProject.Utilities.XLUtils;

public class TC05_Stacks extends BaseClass {
	@Test
	public void StacksTest() throws InterruptedException, IOException {
		SignIn();
		HomePage hp = new HomePage(driver);
		StackPage stack = new StackPage(driver);
		String sheet="Stack";
		XLUtils objXL = new XLUtils(projectPath + excelPath, sheet);
		
		hp.clickOnDataStruc();
		logger.info("Clicked on Data Structure dropdown");

		hp.ClickStack();
		logger.info("Select Stack from dropdown");

		// Operations in stack
		stack.clickOperInStack();
		logger.info("Clicked Operations in stack");

		stack.ClickTryHere();
		logger.info("Clicked on Try here button");

		EnterCommandAndRun(objXL.getCellData(1, 1),objXL.getCellData(1, 2),sheet,1);
		
		// Implementation
		stack.clickImplement();
		logger.info("Clicked Implementation");

		stack.ClickTryHere();
		logger.info("Clicked on Try here button");

		EnterCommandAndRun(objXL.getCellData(2, 1),objXL.getCellData(2, 2),sheet,2);
		
		// Applications
		stack.clickApplications();
		logger.info("Clicked Applications");

		stack.ClickTryHere();
		logger.info("Clicked on Try here button");

		EnterCommandAndRun(objXL.getCellData(3, 1),objXL.getCellData(3, 2),sheet,3);
		
		driver.navigate().back();

	}

	public void EnterCommandAndRun(String cmd) throws InterruptedException {
		TryEditorPage te = new TryEditorPage(driver);
		te.EnterCommand(cmd);
		logger.info("Entered command in Editor");
		te.ClickRun();
		logger.info("Clicked on Run button");
		Assert.assertEquals(te.getOutput(), cmd);

		Thread.sleep(2000);
		driver.navigate().back();
		logger.info("Back to Array Page");
	}
}
