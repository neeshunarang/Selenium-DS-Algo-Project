package com.DsAlgoProject.Utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.DsAlgoProject.Base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Reporting extends BaseClass implements ITestListener{
	
	public static ExtentReports extent= new ExtentReports();
	public static ExtentTest test;
	public static ExtentSparkReporter spark ;
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp

	public void onStart(ITestContext testContext) 
	{
		
		String repName="Test-Report-"+timeStamp+".html";
		final File CONF = new File("extentconfig.xml");
		spark = new ExtentSparkReporter("target/Spark/spark.html");
		
		try {
			spark.loadXMLConfig(CONF);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//extent=new ExtentReports();

		extent.attachReporter(spark);
		extent.setSystemInfo("Host name","Localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("User Name","Neeshu");

	}

	public void onTestSuccess(ITestResult tr)
	{
		test=extent.createTest(tr.getMethod().getMethodName());
		//test=extent.createTest(tr.getName()); // create new entry in the report
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		
	}

	public void onTestFailure(ITestResult tr)
	{
		//test=extent.createTest(tr.getMethod().getMethodName());
		test=extent.createTest(tr.getName()); // create new entry in th report
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted

		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f = new File(screenshotPath); 
		try {
			test.fail("Test Failed "+test.addScreenCaptureFromPath(CaptureScreenShot(tr.getName()+timeStamp)));
			test.log(Status.FAIL,tr.getThrowable());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult tr)
	{
		test=extent.createTest(tr.getName()); // create new entry in th report
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}


}
