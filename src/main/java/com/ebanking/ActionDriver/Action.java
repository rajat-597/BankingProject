package com.ebanking.ActionDriver;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebanking.base.BaseClass;



public class Action extends BaseClass{
	
	public static void clickElement(WebElement element) {
		element.click();
	}
	
	public static void sendKeys(WebElement element, String text) {
		isElementPresent(element);
		element.click();
		element.clear();
		element.sendKeys(text);
	}
	
	public static boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public static boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	public static boolean isSelected(WebElement element) {
		return element.isSelected();
	}
	
	//How to scroll down to an element in Selenium until it is visible
	
	public static void scollByVisibilityOfElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	// How to scroll down on a web page in Selenium by defining the number of pixels
	
	public static void scollByPixel(WebElement element, WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)", element);	
	}
	
	// How to scroll down to the bottom of the webpage using Selenium
	
	public static void scolluntilButtonPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");	
		}
	
	// How to scroll horizontally on a web page to a specific web element using Selenium
	
	public static void scollHorizontally(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);	
		}
	
	public static void jsClick(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()
					|| element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}
	
	public static void sleep(long time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void jsMousehover(WebDriver driver, WebElement element) {
		String strJavaScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";
	     JavascriptExecutor js =  (JavascriptExecutor) driver;
	     js.executeScript(strJavaScript, element);
	}
	
	public static void selectByIndex(WebElement element, int index) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element, String value) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}
	public static void selectByVisibleText (WebElement element, String text) {
		try {
		Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
		}
        catch (StaleElementReferenceException e) {
    		Select dropdown = new Select(element);
            dropdown.selectByVisibleText(text);
		}
	} 
	
	public static void SwitchToframeByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public static void SwitchToframeById(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}
	
	public static void SwitchToframeByName(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}
	
	public static void SwitchToDeafaultContext(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public static void implicitWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public static void waitvisibilityOfElementLocated(WebDriver driver, int seconds, By by) {
		WebDriverWait  wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public static void waitvisibilityOf(WebDriver driver, int seconds, WebElement element) {
		WebDriverWait  wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waittitleContains(WebDriver driver, int seconds, String title) {
		WebDriverWait  wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public static void waitpresenceOfElementLocated(WebDriver driver, int seconds, By by ) {
		WebDriverWait  wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static void waitelementToBeClickable(WebDriver driver, int seconds, By by ) {
		WebDriverWait  wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public static void waitelementToBeSelected(WebDriver driver, int seconds, By by ) {
		WebDriverWait  wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeSelected(by));
	}
	
	public static void waitalertIsPresent(WebDriver driver, int seconds ) {
		WebDriverWait  wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void waitinvisibilityOfTheElementLocated(WebDriver driver, int seconds, By by ) {
		WebDriverWait  wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public static void switchToNewWindow(WebDriver driver) {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> itr = s.iterator();
		@SuppressWarnings("unused")
		String Windows1 = itr.next();
		String Windows2 = itr.next();
		try {
			driver.switchTo().window(Windows2);
		} catch (Exception e) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			driver.switchTo().window(Windows2);
		}
	}

	public static int getSize(WebDriver driver, String element) {
		List<WebElement> count = driver.findElements(By.xpath(element));
		return count.size();
	}

	
	public static void switchToOldWindow(WebDriver driver) {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> itr = s.iterator();
		String Windows1 = itr.next();
		@SuppressWarnings("unused")
		String Windows2 = itr.next();
		try {
			driver.switchTo().window(Windows1);
		} catch (Exception e) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			driver.switchTo().window(Windows1);
		}
	}

	public static void switchToParentWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public static String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	
	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
	
	public static void launchUrl(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	// Action class Methods
	//click moveToElement(): Shifts the mouse pointer to the center of the element
	public static void moveToElement(WebDriver driver, WebElement element) {
	Actions action = new Actions(driver);
	action.moveToElement(element).click();
	}
	
	//  Perform Double Click Action on the Web Element
	public static void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
		}
	
	// perform drag and drop
	
	public static void dragAnddrop(WebDriver driver, WebElement source, WebElement target) {
		Actions action = new Actions(driver);
        action.dragAndDrop(source, target).build().perform();
	}
	
	// perform Right Click
	
	public static void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
        action.contextClick(element);
	}
	
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
	//	String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
		//		+ dateName + ".png";
		return destination;
	}
	
	// only row and column methoda are left
}


