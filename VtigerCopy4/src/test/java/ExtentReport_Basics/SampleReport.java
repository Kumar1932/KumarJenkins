package ExtentReport_Basics;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport 
{
@Test
public void createContactTest(Method m)
{
	ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceRepots/report.html");
	spark.config().setDocumentTitle("CRM Vtiger Test Suite");
	spark.config().setReportName("Vtiger report");
	spark.config().setTheme(Theme.DARK);
	
	ExtentReports report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS", "Windows 11");
	report.setSystemInfo("Browser", "Chrome 133");
	
	ExtentTest test = report.createTest(m.getName());
	
	test.log(Status.INFO, "Test Start");
	test.log(Status.INFO, "login to app");
	test.log(Status.INFO, "perform action");
	
	if("Luffy".equals("Luffy"))
	{
		test.log(Status.PASS, "=====>PASS");
	}
	else
	{
		test.log(Status.FAIL, "=====>FAIL");
	}
	
	test.log(Status.INFO, "Test completed");
	report.flush();
}
}
