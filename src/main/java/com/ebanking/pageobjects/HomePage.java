package com.ebanking.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebanking.ActionDriver.Action;
import com.ebanking.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//a[text() = 'New Customer']")
	WebElement newCustomer;
	
	@FindBy(xpath = "//a[text() = 'Mini Statement']")
	WebElement ministatement;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkTextnewCustomer() {
		Action.isElementPresent(newCustomer);
		System.out.println("Yeah we can add new customer to the bank");
	}
	
	public void checkTextministatement() {
		Action.isElementPresent(ministatement);
		System.out.println("Mini statement is present");
	}
}
