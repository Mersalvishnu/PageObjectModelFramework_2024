package Com.WebPages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.TestBase.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(id="userName")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password ;
	
	@FindBy(id="submitBtn")
	WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='headerLogo']")
	WebElement Logo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateTSRTCLogo() {
		
		return Logo.isDisplayed();
	}

	public Booking login (String un,String pwd) {
		
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		LoginButton.click();
		return new Booking();
	}
	
	
	
}
