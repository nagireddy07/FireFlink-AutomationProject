package ninzaCRM.genericUtilities;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener,ITestNGListener{
	ExtentReports report;
	ExtentTest test;

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }

    @Override
    public void onTestStart(ITestResult result) {
        
        String methodName=result.getMethod().getMethodName();
        System.out.println(methodName+" Test Excution Started");
        
        //Intimate Extent Reports for test Start
        test = report.createTest(methodName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName=result.getMethod().getMethodName();
        System.out.println(methodName+" Test Excution Passed");
        
        //Log the status of @Test as pass in Extent Report
        test.log(Status.PASS, methodName+" Test Excution Passed");
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName=result.getMethod().getMethodName();
        System.out.println(methodName+" Test Excution Falied");
        
      //Log the status of @Test as fail in Extent Report
        test.log(Status.FAIL, methodName+" Test Excution Falied");
        
        //Capture the exception
        System.out.println(result.getThrowable());
        
        //Log the Exception In Extent Report
        test.log(Status.INFO,result.getThrowable() );
        
        //Capture the SS
        JavaUtility ju = new JavaUtility();
        WebDriverUtility wu = new WebDriverUtility();
        
        //Screenshot name = methodName + date and time
        String screenShotName = methodName+ju.getSystemDate();
        try {
			String path = wu.captureScreenShot(BaseClass.sdriver, screenShotName);
			
			//Attach SS to Extent Report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String methodName=result.getMethod().getMethodName();
        System.out.println(methodName+" Test Excution Skipped");
        //Skip info for Extent Report
        test.log(Status.SKIP, methodName+" Test Excution Skipped");
        //Capture the exception
        System.out.println(result.getThrowable());
        //Log the Exception In Extent Report
        test.log(Status.INFO, result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println("--------------Suite Excution Started----------------");
        
        //Configuration Details
        ExtentSparkReporter esr = new ExtentSparkReporter(".\\Extent Reports\\Extent-Report-"+new JavaUtility().getSystemDate()+".html");
        esr.config().setDocumentTitle("Ninza CRM Automation Report");
        esr.config().setTheme(Theme.DARK);
        esr.config().setReportName("Web Automation Execution Report");
        
        report = new ExtentReports();
        report.attachReporter(esr);
        report.setSystemInfo("Base Browser", "Microsoft Edge");
        report.setSystemInfo("Base Platform", "Windows");
        report.setSystemInfo("Base URL", "Test Env");
        report.setSystemInfo("Reporter Name ", "Venkat");
        
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("---------------Suite Excution Finished----------------");
        
        //Report Generation
        report.flush();
    }
    
    

}