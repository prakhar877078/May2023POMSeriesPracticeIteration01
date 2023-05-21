package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	
	//the purpose of creating DriverFactory object is to call the initDriver method
	DriverFactory df;
	//the purpose of creating Webdriver object is we need to store returned value of initDriver
	WebDriver driver;
	//the purpose of creating LoginPage object is to pass the driver while calling constructor so that the same sessionid should be maintained
	protected LoginPage loginpage;
	protected AccountsPage accountspage;
	//this is used to store the value of methods created inside DriverFactory
	protected Properties prop;

	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		//driver = df.initDriver("chrome");
		loginpage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}


}
