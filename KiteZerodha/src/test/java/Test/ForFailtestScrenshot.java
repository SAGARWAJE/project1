package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.ZerodhaLoginPage;
import Utility.Parametrization;

@Listeners(ListenersAll.class)

public class ForFailtestScrenshot extends BaseTest{
	
	@BeforeMethod
	public void browser() {
		driver = Browser.openBrowser();
	}
	@Test
	public void loginwithvaliddata() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData("Sheet2", 10, 1);
		String Password = Parametrization.getData("Sheet2", 26, 1);
		zerodhaLoginPage.enterUserID(userName);
		zerodhaLoginPage.enterPassword(Password);
		zerodhaLoginPage.clickOnlogin();
	    Thread.sleep(1000);
	}
}
