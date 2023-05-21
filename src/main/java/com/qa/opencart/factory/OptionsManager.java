package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())){
			System.out.println("=========================Runing Chrome in Headless====================");
			co.addArguments("--headless");
		}else if(Boolean.parseBoolean(prop.getProperty("icognito").trim())) {
			System.out.println("=========================Runing Chrome in Icognito====================");
			co.addArguments("--icognito");
		}
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())){
			System.out.println("=========================Runing Firefox in Headless====================");
			fo.addArguments("--headless");
		}else if(Boolean.parseBoolean(prop.getProperty("icognito").trim())) {
			System.out.println("=========================Runing Firefox in Icognito====================");
			fo.addArguments("--icognito");
		}
		return fo;
	}
}
