package com.DsAlgoProject.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import com.DsAlgo.PageObjects.DataStructuresPage;
import com.DsAlgo.PageObjects.HomePage;
import com.DsAlgoProject.Base.BaseClass;
import com.DsAlgoProject.Utilities.XLUtils;

public class TC03_DataStructures extends BaseClass {
	@Test
	public void DataStructuresTest() throws InterruptedException, IOException {
		SignIn();
		String sheet="DataStructure";
		HomePage hp = new HomePage(driver);
		DataStructuresPage ds = new DataStructuresPage(driver);
		XLUtils objXL = new XLUtils(projectPath + excelPath, sheet);
		hp.ClickOnDSGetStarted();
		logger.info("Clicked on Get Started button of Data Structure");

		ds.ClickTimeComplexity();
		logger.info("Clicked on Time Complexity link");

		ds.ClickTryHere();
		logger.info("Clicked on Try here button");
		
		EnterCommandAndRun(objXL.getCellData(1, 1),objXL.getCellData(1, 2),sheet,1);
		
		logger.info("Back to Data Structure Page");

		ds.ClickPracQues();
		logger.info("Clicked on Practice Questions");

		driver.navigate().back();
		logger.info("Back to Data Structure Page");
	}
	
}
