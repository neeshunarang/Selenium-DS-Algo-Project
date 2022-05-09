package com.DsAlgoProject.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.DsAlgo.PageObjects.HomePage;
import com.DsAlgo.PageObjects.PortalPage;
import com.DsAlgo.PageObjects.RegistrationPage;
import com.DsAlgoProject.Base.BaseClass;
import com.DsAlgoProject.Utilities.AllureListener;
import com.DsAlgoProject.Utilities.Reporting;
import com.DsAlgoProject.Utilities.XLUtils;

@Listeners({AllureListener.class})
public class TC01_Registration extends BaseClass{
	@Test(dataProvider = "loginData")
	public void Registration(String username,String password) throws IOException {
		HomePage hp=new HomePage(driver);
		RegistrationPage rp=new RegistrationPage(driver);
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		rp.enterUserName(username);
		logger.info("Entered value for username");
		
		rp.enterPassword1(password);
		logger.info("Entered value for password");
		
		rp.enterPassword2(password);
		logger.info("Entered value for confirm password");
		
		rp.submitRegister();
		logger.info("Clicked on Register button");
		
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
