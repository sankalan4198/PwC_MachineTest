package main.java.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;

import test.java.BaseTest;

//This TestNG Listener method will take the screenshot in case test cases are failed
public class SuiteListener implements ITestListener, IAnnotationTransformer {
	
	@Override
	public void onTestFailure(ITestResult iTestResult)
	{
		String fileName=System.getProperty(("user.dir")+File.separator+"screenshots"+File.separator+ iTestResult.getMethod().getMethodName());
		File f= ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f, new File(fileName+"png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
