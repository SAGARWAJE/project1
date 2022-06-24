package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaHomePage {
	
	
    @FindBy(xpath="//a[@href=\"/dashboard\"]")private WebElement dashboard;
    @FindBy(xpath="//a[@href=\"/order\"]")private WebElement order;
    @FindBy(xpath="//a[@href=\"/holdings\"]")private WebElement holdings;
    @FindBy(xpath="//a[@href=\"/positions\"]")private WebElement positions;
    @FindBy(xpath="//a[@href=\"/funds\"]")private WebElement funds;
    @FindBy(xpath="//a[@href=\"/apps\"]")private WebElement apps;
    @FindBy(xpath="//div[@class=\"user-nav perspective\"]")private WebElement profile;
    @FindBy(xpath="(//span[@class=\"tradingsymbol link-chart\"])[1]")private WebElement nifty50;
    @FindBy(xpath="(//span[@class=\"tradingsymbol link-chart\"])[2]")private WebElement sensex;
    @FindBy(xpath="//input[@placeholder=\"Search eg: infy bse, nifty fut, nifty weekly, gold mcx\"]")private WebElement search;
    @FindBy(xpath="//span[text()='View statement']")private WebElement equitystatement;
    @FindBy(xpath="//span[@class=\"settings-button icon icon-settings\"]")private WebElement marketwatch;
    @FindBy(xpath="//span[@class=\"nice-name\"]")private List<WebElement> element;
    @FindBy(xpath="//button[@class='button-blue buy']")private WebElement buy;
    
    public ZerodhaHomePage(WebDriver driver){
    	PageFactory.initElements(driver, this);
    }
    
    public void ClickOnDashboard() {
    	dashboard.click();
    }
    public void ClickOnOrder() {
    	order.click();
    }
    public void ClickOnHoldings() {
    	holdings.click();
    }
    public void ClickOnPositions() {
    	positions.click();
    }
    public void ClickOnFunds() {
    	funds.click();
    }
    public void ClickOnApps() {
    	apps.click();
    }
    public void ClickOnProfile() {
    	profile.click();
    }
    public void ClickOnNifty50() {
    	dashboard.click();
    }
    public void ClickOnSensex() {
    	sensex.click();
    }
    public void Search() {
    	search.click();
    }
    public void Buy(WebDriver driver) throws InterruptedException {
    	int list=element.size();
 //   	System.out.println(list);
    	for(int i=0;i<=list-1;i++) {
    		WebElement value=element.get(i);
    		String text=value.getText();
    		System.out.println(text);
    		if(text.equals("TCS")) {
    	
    	Actions action = new Actions(driver);
        action.moveToElement(value);
        action.perform();
        Thread.sleep(2000);
        buy.click();
    		}
    		else {
    			System.out.println("text doesnt match");
    		}
    	}
    }
    public void ClickOnEquityStatement() {
    	equitystatement.click();
    }
    public void ClickOnMarketWatch() {
    	marketwatch.click();
    }
   
    
    
}
