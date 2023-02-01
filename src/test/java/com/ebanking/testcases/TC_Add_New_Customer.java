package com.ebanking.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebanking.ActionDriver.Action;
import com.ebanking.base.BaseClass;
import com.ebanking.pageobjects.Add_New_Customer;
import com.ebanking.pageobjects.HomePage;
import com.ebanking.pageobjects.LoginPage;

public class TC_Add_New_Customer extends BaseClass{

    HomePage homePage;
    Add_New_Customer AddNC;
	@BeforeMethod
	public void setup() {
		launchBrowser("chrome");
	}

	@Test
	public void addCustomerToBank() {

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
		
		AddNC = new Add_New_Customer();
		
		AddNC.clickonAddCustomer();
		AddNC.customerName("Rajat");
		AddNC.customerGender();
		AddNC.customerdob("28", "10", "1996");
		AddNC.CustomerAddress("New Colony, Mining road");
		AddNC.CustomerCity("Keonjhar");
		AddNC.CustomerState("Odisha");
		AddNC.CustomerpinNo("758001");
		AddNC.CustomerphoneNo("7205493277");
		AddNC.customerEmail("rksahoome140063@gmail.com");
		AddNC.clickonSubmitBtn();
		
		
	}

	@AfterMethod
	public void teatDown() {
		driver.quit();
	}
}
