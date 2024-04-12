package Com.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.TestBase.BaseClass;

public class Booking extends BaseClass{
	
	
	@FindBy(xpath="//span[contains(text(),'Booking History & Cancellation')]")
	WebElement LabelName;
	
	@FindBy(id="sbkg")
	WebElement NewBooking;
	
	@FindBy(xpath="//a[contains(text(),'Enquiry')]")
	WebElement EnquiryPageclick;
	
	
	public Booking() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String BookingPageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean LabelName() {
		return LabelName.isDisplayed();
	}
	
	
	public void NewBookingClick() {
		NewBooking.click();
		
	}
	
	public Enquiry Enquiryclick() {
		EnquiryPageclick.click();
		return new Enquiry();
	}
	
	
	

}
