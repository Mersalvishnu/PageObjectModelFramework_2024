package Com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.TestBase.BaseClass;
import Com.WebPages.Booking;
import Com.WebPages.Enquiry;
import Com.WebPages.LoginPage;


public class BookingPageTest extends BaseClass {

	public static LoginPage login;
	public static Booking  booking;
	public static Enquiry  enquiry;
	
	public BookingPageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setup(){
		
		Initialisation();
		 login =new LoginPage();
		  
		booking =login.login(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}
	
	@Test(priority=1)
	public void VerifyBookingTitle() {
		String Title =booking.BookingPageTitle();
		Assert.assertEquals(Title, "Online Bus Ticket Booking | TSRTC Official Website | Telangana");
	}
	
	@Test(priority=2)
	public void VerifyLabelName() {
		boolean flag =booking.LabelName();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void BookingTestClick() {
		    booking.NewBookingClick();
	}
	
	
	@Test(priority=4)
	public void EnquiryPageTest() {
		  enquiry     =booking.Enquiryclick();
	}
	
	@AfterMethod()
	public void TearDown() {
		driver.quit();
	}
	
	
	
}
