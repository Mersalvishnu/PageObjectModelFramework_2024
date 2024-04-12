package Com.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.TestBase.BaseClass;

public class Enquiry extends BaseClass {

	
	@FindBy(id="id")
	WebElement TicketNumber;
	
	@FindBy(id="mobileNo")
	WebElement MobileNumber;
	
	
	@FindBy(xpath="//span[contains(text(),'Ticket Enquiry Status')]")
	WebElement EnquiryLogo;
	
	public Enquiry() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyEnquiryPageTitle() {
		return driver.getTitle();
	}
	
	public boolean EnquiryLabel() {
		  return   EnquiryLogo.isDisplayed();
	}
	
	public void EnquiryPage(String TKTNumber,String MNO) {
		TicketNumber.sendKeys(TKTNumber);
		MobileNumber.sendKeys(MNO);
	}
	
	
	
	
}
