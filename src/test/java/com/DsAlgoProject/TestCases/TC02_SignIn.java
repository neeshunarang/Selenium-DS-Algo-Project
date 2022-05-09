package com.DsAlgoProject.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.DsAlgo.PageObjects.PortalPage;
import com.DsAlgo.PageObjects.HomePage;
import com.DsAlgo.PageObjects.SignInPage;
import com.DsAlgoProject.Base.BaseClass;

import com.DsAlgoProject.Utilities.XLUtils;

public class TC02_SignIn extends BaseClass {
	    @Test(dataProvider = "loginData")
		public void SignInTest(String uname,String pwd) throws InterruptedException{
	    SignInPage sip = new SignInPage(driver);
		HomePage hp = new HomePage(driver);

		hp.lnkLogin();
		logger.info("Clicked on Login link");
		
		sip.enterUserName(uname);
		logger.info("Entered Username");
		
		sip.enterPassword(pwd);
		logger.info("Entered password");
		
		sip.clickLogin();
		logger.info("Clicked on Login button");
		
		Assert.assertEquals(driver.getTitle(), "NumpyNinja");
		if (driver.getTitle().equals("NumpyNinja"))
		{
			hp.clickLogout();
			logger.info("Clicked on Logout button");
		}
	}

	@DataProvider(name = "loginData")
	public String[][] getData() throws IOException {

		XLUtils objXL = new XLUtils(projectPath + excelPath, "Login");
		int rowNum = objXL.getRowCount();
		int colNum = objXL.getCellCount(1);
		String loginDetails[][] = new String[rowNum][colNum-1];
		for (int i = 1; i <= rowNum; i++) {
			for (int j = 1; j < colNum; j++) {
				loginDetails[i - 1][j-1] = objXL.getCellData(i, j);
			}
		}
		return (loginDetails);
	}
}
