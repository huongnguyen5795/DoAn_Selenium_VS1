package com.utc.flowershop.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utc.flowershop.utility.Log;

public class TestBase {
	public static WebDriver driver;
	public static boolean bResult;
	public TestBase(WebDriver driver) {
		this.driver = driver;
		TestBase.bResult = true;
	}

	public static By getBy(String locator) {

		By by = null;
		if (locator.startsWith("id=")) {
			locator = locator.substring(3);
			by = By.id(locator);
		} else if (locator.startsWith("name=")) {
			locator = locator.substring(5);
			by = By.id(locator);
		} else if (locator.startsWith("className=")) {
			locator = locator.substring(10);
			by = By.id(locator);
		} else if (locator.startsWith("tagName=")) {
			locator = locator.substring(8);
			by = By.id(locator);
		} else if (locator.startsWith("link=")) {
			locator = locator.substring(5);
			by = By.id(locator);
		} else if (locator.startsWith("partialLinkText=")) {
			locator = locator.substring(16);
			by = By.id(locator);
		} else if (locator.startsWith("css=")) {
			locator = locator.substring(4);
			by = By.id(locator);
		} else if (locator.startsWith("xpath=")) {
			locator = locator.substring(6);
			by = By.id(locator);
		} else {
			Log.error(locator + " not exists");
		}

		return by;
	}

	public static WebElement getWebElement(String locator) {
		return driver.findElement(getBy(locator));
	}

	public static void click(String locator) {
		try {
			Log.info("Click	" + locator);
			WebElement element = getWebElement(locator);
			element.click();
		} catch (Exception e) {
			Log.error(locator + " not found to click ." + e.getMessage());
		}
	}

	public static void sendKey(String locator, String value) {
		try {
			Log.info("SendKeys " + locator + " : " + value + " ");
			WebElement element = getWebElement(locator);
			element.sendKeys(value);
		} catch (Exception e) {
			Log.error(locator + " not exists to sendkeys " + e.getMessage());
		}
	}

	public static String getText(String locator) {
		String result = "";
		try {
			Log.info("Get Text " + locator + " ");
			WebElement element = getWebElement(locator);
			result = element.getText();
		} catch (Exception e) {
			Log.error( locator + " not found to getText |" + e.getMessage());
		}
		return result;
	}

	public static void closed() {
		Log.info("Close Browser" );
		driver.quit();
	}
}
