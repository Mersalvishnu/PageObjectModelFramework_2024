package Com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.TestBase.BaseClass;
import Com.WebPages.Booking;
import Com.WebPages.LoginPage;


public class LoginPageTest extends BaseClass {

	LoginPage loginpage;
	Booking  booking;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Initialisation();
		 loginpage =new LoginPage();
	}
	
	@Test(priority=1)
	public void TitleTest() {
		
	String Title	=((LoginPage) loginpage).ValidateLoginPageTitle();
	Assert.assertEquals(Title, "Online Bus Ticket Booking | TSRTC Official Website | Telangana");
	}
	
	@Test(priority=2)
	public void LogoTest() {
		boolean flag  =loginpage.validateTSRTCLogo();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3)
	public void loginTest() {
		 booking=loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
	
	
}
