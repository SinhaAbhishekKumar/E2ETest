package mavenUdemy;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
//import pageObjects.LoginPage;
import resources.Base;

public class ValidateTitle extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		//Initialize base class to set global driver
		driver = initializeDriver();
		log.info("Driver is initialised");
		driver.get("http://www.qaclickacademy.com/");
		log.info("URL is hit");
	}
	
	@Test
	public void basePagenavigation() throws IOException {
		
		//Page 1
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED  COURSES");
		l.getLogin().click();
		log.info("Login is Clicked");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Browser is Closed");
		driver=null;
	}
}

