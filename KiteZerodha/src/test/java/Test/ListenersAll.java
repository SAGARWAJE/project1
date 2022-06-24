package Test;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.Screenshot;

public class ListenersAll extends BaseTest implements ITestListener{
     
       
		public void onTestStart(ITestResult result) {
			System.out.println("Test has started");
		}
		
		public void OnTestFailure(ITestResult result) {
	      try {
			Screenshot.takeScreenShot(driver, result.getName());
	      }
	      catch(IOException e) {
	    	  e.printStackTrace();
	      }	
		}
		
		public void onTestSuccess(ITestResult result) {
			System.out.println(result.getTestName() +"Test successful");
		}
		
		public void onTestSkipped(ITestResult result) {
			System.out.println(result.getTestName() +"Test Skipped");
		}
	}

