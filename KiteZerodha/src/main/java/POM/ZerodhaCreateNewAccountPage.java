package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaCreateNewAccountPage {
    
	@FindBy(xpath="//input[@type=\"text\"]")private WebElement mobileNo;
	@FindBy(xpath="//button[@type=\"submit\"]")private WebElement submit;
    @FindBy(xpath="//input[@type=\"text\"]")private WebElement mobileOTP;
	@FindBy(xpath="//button[@type=\"submit\"]")private WebElement go;
	
	public ZerodhaCreateNewAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobNo(String mobno) {
		mobileNo.sendKeys(mobno);
	}
    public void pressSubmit() {
    	submit.click();
    }
    public void enterMobileotp(String mobotp) {
    	mobileOTP.sendKeys(mobotp);
    }
    public void clickoncontinue() {
    	go.click();
    }
}
