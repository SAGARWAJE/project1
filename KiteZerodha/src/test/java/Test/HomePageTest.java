package Test;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.ZerodhaHomePage;
import POM.ZerodhaLoginPage;
import POM.ZerodhaPinPage;

public class HomePageTest {
    WebDriver driver;
   
    @BeforeMethod
    public void browser() {
    	driver=Browser.openBrowser();
    	
    }
    @Test
    public void LoginWithValidCredentials() throws InterruptedException {
    	
    	ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
    	zerodhaloginpage.enterUserID("NLY982");
    	zerodhaloginpage.enterPassword("Sagar@123");
    	zerodhaloginpage.clickOnlogin();
    	ZerodhaPinPage zerodhapinpage = new ZerodhaPinPage(driver);
    	Thread.sleep(2000);
    	zerodhapinpage.enterPin("112233");
    	zerodhapinpage.clickOnContinue();
    	ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
    	Thread.sleep(2000);
    //	zerodhahomepage.ClickOnFunds();
    	zerodhahomepage.Search();
    	Thread.sleep(2000);
    	zerodhahomepage.Buy(driver);
    	
    }
    
  
	
	
}
