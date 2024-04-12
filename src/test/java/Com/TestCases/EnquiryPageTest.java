package Com.TestCases;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.TestBase.BaseClass;
import Com.TestUtil.UtilityClass;
import Com.WebPages.Booking;
import Com.WebPages.Enquiry;
import Com.WebPages.LoginPage;


public class EnquiryPageTest extends BaseClass{
	
	LoginPage loginpage;
	Booking  booking;
	Enquiry  enquiry;
	String SheetName ="EnquiryData";
	
	public EnquiryPageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setup() {
		Initialisation();
		loginpage =new LoginPage();
		booking=new Booking();
	    booking =loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		enquiry=booking.Enquiryclick();
	}
	
	
	@Test(priority=1)
	public void EnquiryPageTitleTest() {
		String Title =enquiry.VerifyEnquiryPageTitle();
		Assert.assertEquals(Title,"TSRTC Bus Ticket Enquiry | TSRTC Official Website");
	}
	
	
	@Test(priority=2)
	public void EnquiryPageLogo() {
		boolean flag =enquiry.EnquiryLabel();
		Assert.assertTrue(flag);
	}
	
	
	
	
	
	
	@DataProvider
	public Iterator<Object[]> EnquiryPageTestData() throws InvalidFormatException{
		ArrayList<Object[]> testdata =UtilityClass.getDataFromExcel();
		return testdata.iterator();
	}
	
	@Test(dataProvider="EnquiryPageTestData")
	public void EnquiryPageTest(String TKTNumber,String	MNO) {
		enquiry.EnquiryPage(TKTNumber, MNO);
		
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@Test(priority=3)
	public void EnquiryPageFirstTestData() {
		
		enquiry.EnquiryPage("ACHJ4567", "91767");
			}
	@Test(priority=4)
	public void EnquiryPagesecondTestData() {
		
		enquiry.EnquiryPage("ACHJ5567", "91768");
			}
	*/
	
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	
	

}
