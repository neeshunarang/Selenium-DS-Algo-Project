package com.DsAlgoProject.Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.DsAlgo.PageObjects.HomePage;
import com.DsAlgo.PageObjects.PortalPage;
import com.DsAlgo.PageObjects.SignInPage;
import com.DsAlgo.PageObjects.TryEditorPage;
import com.DsAlgoProject.Utilities.ReadConfig;
import com.DsAlgoProject.Utilities.XLUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public String excelPath = readconfig.getExcelPath();
	public String projectPath = System.getProperty("user.dir");
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeTest
	public void setup(String br) {

		logger = LogManager.getLogger(BaseClass.class);
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(br + " Thread ID:" + Thread.currentThread().getId());
		} else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(br + " Thread ID:" + Thread.currentThread().getId());
		}
		else if (br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(br + " Thread ID:" + Thread.currentThread().getId());
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		logger.info(br + " browser Opened");
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		PortalPage pp = new PortalPage(driver);
		pp.clickGetStarted();
	}
	@Parameters("browser")
	@AfterTest
	public void tearDown(String br) {
		driver.manage().deleteAllCookies();
		driver.quit();
		logger.info(br + "Driver Closed");
	}

	public String CaptureScreenShot(String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String ssPath = System.getProperty("user.dir") + "/Screenshots/" + tname + ".png";
		File target = new File(ssPath);
		FileUtils.copyFile(source, target);
		return ssPath;
	}

	public void SignIn() throws InterruptedException {
		driver.navigate().to("https://dsportalapp.herokuapp.com/home");
		HomePage hp = new HomePage(driver);
		if (hp.isSignOutVisible().equals("Sign in"))
		{	
			SignInPage sip = new SignInPage(driver);
			
			hp.lnkLogin();
			logger.info("Clicked on Login link");

			sip.enterUserName(username);
			logger.info("Entered Username");

			sip.enterPassword(password);
			logger.info("Entered password");

			sip.clickLogin();
			logger.info("Clicked on Login button");
			//Thread.sleep(1000);
		}
	}
	
	public void EnterCommandAndRun(String cmd,String expOutput,String sheet, int rowNum) throws InterruptedException, IOException {
		XLUtils objXL = new XLUtils(projectPath + excelPath, sheet);
		TryEditorPage te = new TryEditorPage(driver);
		te.EnterCommand(cmd);
		logger.info("Entered command in Editor");
		te.ClickRun();
		logger.info("Clicked on Run button");
		
		if (te.isAlertPresent()==true)
		{
			String alertMsg = te.ClickOkOnAlert();
			logger.info("Alert message is: " + alertMsg);
			objXL.setCellData(rowNum, 4,alertMsg);
		}
		else
		{
		Assert.assertEquals(te.getOutput(), expOutput);
			objXL.setCellData(rowNum, 3, te.getOutput());
		}
		
		driver.navigate().back();
	}
}
