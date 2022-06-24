package Test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POJO.Browser;
import POM.ZerodhaCreateNewAccountPage;
import POM.ZerodhaForgotPasswordPage;
import POM.ZerodhaLoginPage;
import POM.ZerodhaPinPage;
import Utility.Parametrization;
import Utility.Report;

@Listeners(ListenersAll.class)

public class LoginPageTest extends BaseTest{
     ExtentReports reports;
     ExtentTest test;
     
	@BeforeTest
	public void extentReports() {
		 Report.createReport();
	}
	@BeforeMethod
	public void browser() {
		driver = Browser.openBrowser();
	}
	@Test
	public void loginWithValidCrentialsTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		
		String userName = Parametrization.getData("Sheet2", 0, 1);
		String Password = Parametrization.getData("Sheet2", 1, 1);
		zerodhaLoginPage.enterUserID(userName);
		zerodhaLoginPage.enterPassword(Password);
		zerodhaLoginPage.clickOnlogin();
	   
		ZerodhaPinPage zerodhaPinPage = new ZerodhaPinPage(driver) ;
		String piN = Parametrization.getData("Sheet2", 5, 1);
		System.out.println(piN);
		zerodhaPinPage.enterPin(piN);
		zerodhaPinPage.clickOnContinue();
		
		}	
	
	@Test
	public void forgotalinkTest() throws EncryptedDocumentException, IOException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnForgotPassword();
		ZerodhaForgotPasswordPage zerodhaFogotPassPage = new ZerodhaForgotPasswordPage(driver);
		zerodhaFogotPassPage.clickOnIRemember();
		String userid = Parametrization.getData("Sheet2", 1, 1);
		zerodhaFogotPassPage.enteruseriD(userid);
		String panid = Parametrization.getData("Sheet2", 2, 1);
		zerodhaFogotPassPage.enterPanNo(panid);
		String emailid = Parametrization.getData("Sheet2", 3, 1);
		zerodhaFogotPassPage.enterEmailID(emailid);
		zerodhaFogotPassPage.enterCaptcha(null);
		zerodhaFogotPassPage.clickOnReset();
		
	}
	@Test(dependsOnMethods = {"loginWithValidCrentialsTest"})
	public void signUpLinkTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnSignUp();
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		int values = list.size();
		System.out.println(values);
		driver.switchTo().window(list.get(1));

		ZerodhaCreateNewAccountPage zerodhasignUp = new ZerodhaCreateNewAccountPage(driver);
		String mobNO = Parametrization.getData("Sheet2", 4, 1);
		zerodhasignUp.enterMobNo(mobNO);
		zerodhasignUp.pressSubmit();
		
		String mobileOtp = Parametrization.getData("Sheet2", 6, 1);
		zerodhasignUp.enterMobileotp(mobileOtp);
		zerodhasignUp.clickoncontinue();
	}
	
//	@Test
//	public void enterPin() throws EncryptedDocumentException, IOException, InterruptedException {
//		ZerodhaPinPage zerodhaPinPage = new ZerodhaPinPage(driver) ;
//			String piN = Parametrization.getData("Sheet2", 5, 1);
//			System.out.println(piN);
//			zerodhaPinPage.enterPin(piN);
//			zerodhaPinPage.clickOnContinue();
//		}
	   @AfterMethod
	   public void closeBrowser(ITestResult result) {
		   if(result.getStatus() == ITestResult.FAILURE) {
			   test.log(Status.FAIL, result.getName());
		   }else if (result.getStatus() == ITestResult.SUCCESS){
			   test.log(Status.PASS, result.getName());	   
		   }else {
			   test.log(Status.SKIP, result.getName());
		   }
	   }
	   @AfterTest
	   public void flushResult() {
		   reports.flush();
	   }
	}
	

