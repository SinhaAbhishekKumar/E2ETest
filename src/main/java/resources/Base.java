package resources;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("E:\\Framework_Maven\\E2ETest\\src\\main\\java\\resources\\config.properties");
		prop.load(fis);
		
		String browseName = prop.getProperty("browser");
		
		if(browseName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhis\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browseName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhis\\SeleniumDrivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browseName=="ie") {
			//to be done
		}
			
		int defaultTimeout;
		defaultTimeout = Integer.parseInt(prop.getProperty("defaultTimeout"));
		driver.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;

	}
	
	public void CaptureScreenshot(String testName) {
		
		TakesScreenshot ss = ((TakesScreenshot)driver);
		File ssSource = ss.getScreenshotAs(OutputType.FILE);
		File ssDest = new File("E:\\Framework_Maven\\E2ETest\\screenDump" + "\\SS_" + testName + ".png");
		//File ssDest = new File(prop.getProperty("ScreenShotPath") + "\\SS_" + testName + ".png");		
		try {
			FileUtils.copyFile(ssSource, ssDest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
