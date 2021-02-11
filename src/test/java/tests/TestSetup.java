package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestSetup {

	protected WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		//DesiredCapabilities caps = new DesiredCapabilities();
		String soSysDriver="";
		String driverPath="";
		soSysDriver = System.getProperty("os.name").toLowerCase();
		if (soSysDriver.contains("win")) {
			driverPath= "Drivers/win10/chromedriver.exe";
		}
		else if (soSysDriver.contains("nux")) {
			driverPath= "Drivers/win10/chromedriver";
		}
		else if (soSysDriver.contains("mac")) {
			driverPath= "Drivers/win10/chromedriver";
		}
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
