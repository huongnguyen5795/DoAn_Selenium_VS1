package com.utc.flowershop.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utc.flowershop.utility.ExcelUtils;
import com.utc.flowershop.utility.Log;

public class QuickSearch_Page extends TestBase {
	public static WebElement element = null;

	public QuickSearch_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement txtTim() throws Exception {
		try {
			element = driver.findElement(By.name("txttim"));
			Log.info(" Tim textbox is found on the Quick Search Page");
		} catch (Exception e) {
			Log.error(" Tim textbox is not found on the Quick Search Page");
			throw (e);
		}
		return element;
	}

	public static WebElement btnTim() throws Exception {
		try {
			element = driver.findElement(By.name("Button"));
			Log.info(" Tim button is found on the Quick Search Page");
		} catch (Exception e) {
			Log.error(" Tim button is not found on the Quick Search Page");
			throw (e);
		}
		return element;
	}


}
