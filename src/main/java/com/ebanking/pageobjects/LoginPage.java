package com.ebanking.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebanking.ActionDriver.Action;
import com.ebanking.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath = "//input[@name = 'uid']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement pwd;
	
	@FindBy(xpath = "//input[@name = 'btnLogin']")
	WebElement loginBtb;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage clickonLogin(String uname, String pass) {
		Action.sendKeys(userName, uname);
		Action.sendKeys(pwd, pass);
		Action.clickElement(loginBtb);
		return new HomePage();
	}
}
