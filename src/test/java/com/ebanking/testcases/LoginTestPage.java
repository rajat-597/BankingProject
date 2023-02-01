package com.ebanking.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebanking.ActionDriver.Action;
import com.ebanking.base.BaseClass;
import com.ebanking.pageobjects.HomePage;
import com.ebanking.pageobjects.LoginPage;

public class LoginTestPage extends BaseClass {

	HomePage homePage;

	@BeforeMethod
	public void setup() {
		launchBrowser("chrome");
	}

	@Test
	public void LaunchPage() {

		LoginPage login = new LoginPage();
		homePage = login.clickonLogin(prop.getProperty("username"), prop.getProperty("password"));
		Action.isAlertPresent(driver);
		if ("GTPL Bank Manager HomePage".equals(driver.getTitle())) {
			System.out.println("We are going to If Block");
			Action.screenShot(driver, "LaunchPage");
			Assert.assertTrue(true);
		} else {
			System.out.println("We are going to else part");
			Action.screenShot(driver, "LaunchPage");
			Assert.assertTrue(false);
		}
	}

	@AfterMethod
	public void teatDown() {
		driver.quit();
	}
}
