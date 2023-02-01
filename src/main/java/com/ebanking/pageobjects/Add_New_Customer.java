package com.ebanking.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebanking.ActionDriver.Action;
import com.ebanking.base.BaseClass;

public class Add_New_Customer extends BaseClass {

	@FindBy(xpath = "//a[text() = 'New Customer']")
	WebElement addnewCustomer;

	@FindBy(xpath = "//input[@name='name']")
	WebElement cname;

	@FindBy(xpath = "//input[@name='rad1']")
	WebElement cgender;

	@FindBy(xpath = "//input[@id='dob']")
	WebElement cdob;

	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement caddr;

	@FindBy(xpath = "//input[@name='city']")
	WebElement ccity;

	@FindBy(xpath = "//input[@name='state']")
	WebElement cstate;

	@FindBy(xpath = "//input[@name='pinno']")
	WebElement cpinno;

	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement ctelephoneno;

	@FindBy(xpath = "//input[@name='emailid']")
	WebElement cemailid;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement SubmitBtn;

	public Add_New_Customer() {
		PageFactory.initElements(driver, this);
	}

	public void clickonAddCustomer() {
		Action.waitvisibilityOf(driver, 20, addnewCustomer);
		Action.clickElement(addnewCustomer);
	}

	public void customerName(String name) {
		Action.isDisplayed(cname);
		Action.sendKeys(cname, name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void customerGender() {
		Action.isDisplayed(cgender);
		Action.clickElement(cgender);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void customerdob(String dd, String mm, String yyyy) {
		Action.isDisplayed(cdob);
		cdob.sendKeys(dd);
		cdob.sendKeys(mm);
		cdob.sendKeys(yyyy);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CustomerAddress(String address) {
		Action.isDisplayed(caddr);
		Action.sendKeys(caddr, address);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CustomerCity(String city) {
		Action.isDisplayed(ccity);
		Action.sendKeys(ccity, city);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CustomerState(String state) {
		Action.isDisplayed(cstate);
		Action.sendKeys(cstate, state);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CustomerpinNo(String pin) {
		Action.isDisplayed(cpinno);
		Action.sendKeys(cpinno, pin);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CustomerphoneNo(String phoneNo) {
		Action.isDisplayed(ctelephoneno);
		Action.sendKeys(ctelephoneno, phoneNo);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Action.scolluntilButtonPage(driver);

	}

	public void customerEmail(String email) {
		Action.isDisplayed(cemailid);
		Action.sendKeys(cemailid, email);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickonSubmitBtn() {
		Action.clickElement(SubmitBtn);
	}
}
