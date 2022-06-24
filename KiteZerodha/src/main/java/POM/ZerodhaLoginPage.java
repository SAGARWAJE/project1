package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaLoginPage {
	
    @FindBy(xpath="//input[@id=\"userid\"]")private WebElement userID;
   	@FindBy(xpath="//input[@type=\"password\"]")private WebElement password;
   	@FindBy(xpath="//button[@type=\"submit\"]")private WebElement login;
   	@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement forgot;
   	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signUp;

       public ZerodhaLoginPage(WebDriver driver) {
       	PageFactory.initElements(driver, this);
       }
       
       public void enterUserID(String user){
       	userID.sendKeys(user);
       }
       public void enterPassword(String pass){
       	password.sendKeys(pass);
       }
       public void clickOnlogin(){
	        login.click();
       }
       public void clickOnForgotPassword(){
	        forgot.click();
       }
       public void clickOnSignUp(){
	        signUp.click();
       }
	}
