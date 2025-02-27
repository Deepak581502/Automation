package Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String reName;
	public void onStart(ITestContext context) {
		  //  String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		   // reName="test-Report"+timeStamp+".html";
		    sparkReporter= new ExtentSparkReporter(".//Reports/myreports.html");
		    sparkReporter.config().setDocumentTitle("Automaion Report");
		    sparkReporter.config().setReportName("Regression Testing");
		    sparkReporter.config().setTheme(Theme.DARK);
		    
		    extent=new ExtentReports();
		    extent.attachReporter(sparkReporter);
		    
		    extent.setSystemInfo("Environment", "QA");
		    extent.setSystemInfo("Tester name", "Deepak");
		    extent.setSystemInfo("Browser", "Chrome");
		  }
	 public void onTestSuccess(ITestResult result) {
		   test=extent.createTest(result.getClass().getName());
		   test.log(Status.PASS, "Test case passed is "+result.getName());
		  }
	 public void onTestFailure(ITestResult result) {
		 test=extent.createTest(result.getClass().getName());
		   test.log(Status.FAIL, "Test case FAILED is "+result.getName());
		   test.log(Status.FAIL, "Test case FAILED CAUSED IS"+result.getThrowable());
		  }
	 public void onTestSkipped(ITestResult result) {
		 test=extent.createTest(result.getClass().getName());
		   test.log(Status.SKIP, "Test case skipped is "+result.getName());
		  }
	 public void onFinish(ITestContext context) {
		   extent.flush();
		  }
}
