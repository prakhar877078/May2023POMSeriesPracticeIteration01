package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetup() {
		accountspage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void accPageTitleTest() {
		String accTitle = accountspage.getAccPageTitle();
		Assert.assertEquals(accTitle, AppConstants.ACCOUNT_PAGE_TITLE_VALUE);
	}
	
	@Test(priority = 2)
	public void accPageURLTest() {
		String accURL = accountspage.getAccPageURL();
		Assert.assertTrue(accURL.contains(AppConstants.ACCOUNT_PAGE_URL_FRACTION_VALUE));
	}
	
	@Test(priority = 3)
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accountspage.isLogoutLinkExist());
	}
	
	@Test(priority = 4)
	public void accPageHeadersCountTest() {
		List<String>actualAccPageHeadersList = accountspage.getAccountsPageHeadersList();
		System.out.println("Acount Page Header List :"+actualAccPageHeadersList);
		Assert.assertEquals(actualAccPageHeadersList.size(), AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
	}
	
	@Test(priority = 5)
	public void accPageHeadersValueTest() {
		List<String>actualAccPageHeadersList = accountspage.getAccountsPageHeadersList();
		System.out.println("Actual Acc Page Headers List: "+actualAccPageHeadersList);
		System.out.println("Expected Acc Page Headers List: "+AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST);
		Assert.assertEquals(actualAccPageHeadersList, AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST);
	}

}
