package Com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import Com.TestUtil.*;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public BaseClass()  {
		
		try {
			
			prop =new Properties();
			FileInputStream ip =new FileInputStream("C:/Users/vishn/eclipse-workspace/TSRTCBookingTest/src/main/java/Com/ConfigProperties/Configproperties");
			prop.load(ip);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	      public static void Initialisation() {
	    	  
	    	  String Browser =prop.getProperty("Browser");
	    	  if(Browser.equals("Chrome")) {
	    		  ChromeOptions options =new ChromeOptions();
	    		  options.addArguments("--remote-allow-origins=*");
	    		  options.addArguments("--disable-notifications");
	    		   driver =new ChromeDriver(options);
	    	  }else if(Browser.equals("EdgeBrowser")){
	    		  EdgeOptions options =new EdgeOptions();
	    		  options.addArguments("--remote-allow-origins=*");
	    		  options.addArguments("--disable-notifications");
	    		  driver =new EdgeDriver(options);
	    	  }
	    	  driver.manage().window().maximize();
	    	  driver.manage().deleteAllCookies();
	    	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilityClass.PageloadTimeout));
	    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilityClass.implicit_wait));
	    	  driver.get(prop.getProperty("url"));
	      }
	      
	      
	     
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
