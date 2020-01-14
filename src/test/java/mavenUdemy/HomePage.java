package mavenUdemy;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		//Initialize base class to set global driver
		driver = initializeDriver();
		log.info("Driver is initialised");
		driver.get("http://www.qaclickacademy.com/");
		log.info("URL is hit");
	}
	
	@Test(dataProvider="getData")
	public void basePagenavigation(String user, String pwd) throws IOException {
		
		//Page 1
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		
		//Page 2
		LoginPage ln=new LoginPage(driver);
		ln.getUsername().sendKeys(user);
		log.info("UserName = " + user);
		ln.getPassword().sendKeys(pwd);
		log.info("Password = " + pwd);
		ln.getLoginBtn().click();
		log.info("Button is clicked");
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] testData = new Object[1][2];
		testData[0][0] = "Abhishek@email.com";
		testData[0][1] = "bhishek";
		return testData;
		
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Browser Closed");
		driver=null;
	}
	
	
}

