package com.utc.flowershop.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utc.flowershop.utility.Log;

public class Home_Page extends TestBase {
	private static WebElement element = null;

	public Home_Page(WebDriver driver) {
		super(driver);
	}

	public static WebElement linkThongtinTaiKhoan() throws Exception {
		try {
			element = driver.findElement(By.linkText("Thông Tin Tài Khoản"));
			Log.info(" Thong tin tai khoan link is found on the HomePage");
		} catch (Exception e) {
			Log.error(" Thong tin tai khoan link is not found on the Home");
			throw (e);
		}
		return element;
	}

	public static WebElement link_pass_forget() throws Exception {
		try {
			element = driver.findElement(By.linkText("Quyên Mật Khẩu"));
			Log.info(" Quen mat khau link is found on the HomePage");
		} catch (Exception e) {
			Log.error(" Quen mat khau link is not found on the Home");
			throw (e);
		}
		return element;
	}
}
