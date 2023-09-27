package com.HMS.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//actual testscripts execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"----->Execution starts");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"----Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		
		try {
			WebDriverUtility.takeScreenShot(BaseClass.sdriver, MethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, MethodName+"-----Failed");
		Reporter.log(MethodName+"-----Failed");
		

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, MethodName+"---->skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./Extentreport/report.html");
		
		htmlreport.config().setDocumentTitle("SDET-51");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("HMS");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "windows-11");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Hospital_Management_System/hms/admin");
		report.setSystemInfo("Reporter Name", "Prasad Jodu");
	
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}
