package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaPinPage {

	@FindBy(xpath="//input[@type=\"password\"]")private WebElement pin;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
	@FindBy(xpath="//a[text()=\"Forgot 2FA?\"]")private WebElement forgot;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signUp;
	
	public ZerodhaPinPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 public void enterPin(String pinno) {
		 pin.sendKeys(pinno);
	 }
	 public void clickOnContinue(){
		submit.click();
	 }
	 public void clickOnForgot() {
		forgot.click();
	 }
	 public void clickOnSignUp(){
		signUp.click();
	 }
	 public void clickOnSign(){
			signUp.click();
		 }
}
