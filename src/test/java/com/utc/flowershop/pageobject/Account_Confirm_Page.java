package com.utc.flowershop.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utc.flowershop.utility.Log;

public class Account_Confirm_Page extends TestBase {
	private static WebElement element = null;
	public Account_Confirm_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement link_dangKyPass() throws Exception {
		try {
			element = driver.findElement(By.xpath("html/body/div[1]/div/div[3]/table/tbody/tr/td[1]/div/table/tbody/tr/td/center/span"));
			Log.info("Link xac nhan dang ky is found on the Xac nhan tai khoan Page");
		} catch (Exception e) {
			Log.error("Link xac nhan dang ky is not found on the xac nhan tai khoan Page");
			throw (e);
		}
		return element;
	}
	public static WebElement linkBack() throws Exception {
		try {
			element = driver.findElement(By.xpath("html/body/div[1]/div/div[3]/table/tbody/tr/td[1]/div/table/tbody/tr/td/center/span/strong/a"));
			Log.info("Link quay lại is found on the Xac nhan tai khoan Page");
		} catch (Exception e) {
			Log.error("Link quay lai is not found on the xac nhan tai khoan Page");
			throw (e);
		}
		return element;
	}

}
