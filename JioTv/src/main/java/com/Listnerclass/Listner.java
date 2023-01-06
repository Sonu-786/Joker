package com.Listnerclass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listner implements ITestListener {
	
	ExtentReports er;
//  It will monitor the listener class e.g When it is starting ending
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		    String name=result.getName();
		    test=er.createTest(name);
		    
		
	}

	public void onTestSuccess(ITestResult result) {
		   String name=result.getName();
		   test.log(Status.PASS, name +"---->pass");
		}

	public void onTestFailure(ITestResult result) {
		 String name=result.getName();
		   test.log(Status.FAIL, name +"---->fail");
			}

	public void onTestSkipped(ITestResult result) {
		 String name=result.getName();
		   test.log(Status.SKIP, name +"---->skipped");
		
	}

	public void onStart(ITestContext context) {
	  
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentReport\\"+4+".html");
		esr.config().setDocumentTitle("Final Vtiger Report");
		esr.config().setTheme(Theme.STANDARD);
		esr.config().setReportName("Sonu");
		
		// Extra relevent information about report
		er=new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("Operating System", "Window");
		er.setSystemInfo("Language","Java");
		}

	public void onFinish(ITestContext context) {
		//remove the data after execute that testcase
		er.flush();
		
	}
	
	

}
