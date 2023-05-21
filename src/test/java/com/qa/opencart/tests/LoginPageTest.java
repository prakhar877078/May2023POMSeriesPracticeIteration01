package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualTilte = loginpage.getLoginPageTitle();
		Assert.assertEquals(actualTilte, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	
	@Test(priority = 2)
	public void loginPageURLTest() {
		String actualURL = loginpage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}
	
	@Test(priority = 3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}
	
	@Test(priority = 4)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accountspage.isLogoutLinkExist());
	}

}
