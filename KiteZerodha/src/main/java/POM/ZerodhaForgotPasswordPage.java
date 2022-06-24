package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaForgotPasswordPage {
	
	@FindBy(xpath="//label[@for='radio-30']") private WebElement iRememberID;
	@FindBy(xpath="//label[@for='radio-31']") private WebElement iforgotID;
	@FindBy(xpath="//input[@placeholder='User ID']") private WebElement userID;
	@FindBy(xpath="//input[@placeholder='PAN']") private WebElement panNo;
	@FindBy(xpath="//label[@for='radio-35']") private WebElement email;
	@FindBy(xpath="//input[@placeholder='E-mail (as on account)']") private WebElement emailID;
	@FindBy(xpath="//label[@for='radio-36']") private WebElement sms;
	@FindBy(xpath="//input[@placeholder='Mobile number (as on account)']") private WebElement mobileNo;
	@FindBy(xpath="//input[@placeholder='Captcha']") private WebElement captcha;
	@FindBy(xpath="//button[@type='submit']") private WebElement reset;
	
	public ZerodhaForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnIRemember() {
		iRememberID.click();
	}
	public void clickOnIForgot() {
		iforgotID.click();
	}
	public void enteruseriD(String user) {
		userID.sendKeys(user);	
	}
	public void enterPanNo(String panno) {
		panNo.sendKeys(panno);	
		}
	public void clickOnEmail() {
		email.click();
	}
	public void enterEmailID(String emaiid) {
		email.sendKeys(emaiid);
	}
	public void clickOnSMS() {
		iRememberID.click();
	}
	public void enterMobNo(String mobno) {
		mobileNo.sendKeys(mobno);
	}
	public void enterCaptcha(String captchatext) {
		captcha.sendKeys(captchatext);
	}
	public void clickOnReset(){
		reset.click();
	}
}
