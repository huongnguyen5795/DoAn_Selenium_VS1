package com.utc.flowershop.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utc.flowershop.appmodules.SignIn_Action;
import com.utc.flowershop.pageobject.Home_Page;
import com.utc.flowershop.pageobject.LogIn_Page;
import com.utc.flowershop.pageobject.TestBase;
import com.utc.flowershop.utility.Constant;
import com.utc.flowershop.utility.ExcelUtils;
import com.utc.flowershop.utility.Log;
import com.utc.flowershop.utility.Utility;

//@Listeners(com.utc.flowershop.utility.Listener.class)
public class TestCase_SignIn {
	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("SignIn");
		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, "SignIn");
		Log.info("Excel sheet opened");
		String browserName = ExcelUtils.getCellData(1, 5);
		driver = Utility.openBrowser(browserName);
		Log.info("New driver instantiated");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		driver.manage().window().maximize();
		Log.info("Browser full screen");
		driver.get(Constant.url);
		Log.info("Web application launched successfully");
		new TestBase(driver);

	}

	@Test(priority = 1)
	public void signIn_TC1() throws Exception {
		try {
			SignIn_Action.testCase1();
			if (driver.findElement(By.linkText("Thông Tin Tài Khoản")).isDisplayed()) {
				Log.info("Check display xpath form SignIn ");
				ExcelUtils.setCellData("Pass", 1, 4);
			}
		} catch (Exception e) {
			ExcelUtils.setCellData("Fail", 1, 4);
			Utility.takeScreenshot(driver, ExcelUtils.getCellData(1, 0));
			Log.error(e.getMessage());
			throw (e);
		}

	}

	@Test(priority = 2)
	public void signIn_TC2() throws Exception {
		try {
			SignIn_Action.testCase2();
			WebElement message = driver.findElement(By.xpath(
					"html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/table[1]/tbody/tr[2]/td/form/table/tbody/tr[5]/td/span"));
			if (message.getText().equals("Sai Tên Đăng Nhập Hoặc Mật Khẩu")) {
				Log.info("Check display message form SignIn ");
				ExcelUtils.setCellData("Pass", 2, 4);
			}
		} catch (Exception e) {
			ExcelUtils.setCellData("Fail", 2, 4);
			Utility.takeScreenshot(driver, ExcelUtils.getCellData(2, 0));
			Log.error(e.getMessage());
			throw (e);
		}

	}

	@Test(priority = 3)
	public void signIn_TC3() throws Exception {
		try {
			SignIn_Action.testCase3();
			WebElement message = driver.findElement(By.xpath(
					"html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/table[1]/tbody/tr[2]/td/form/table/tbody/tr[5]/td/span"));
			if (message.getText().equals("Sai Tên Đăng Nhập Hoặc Mật Khẩu")) {
				Log.info("Check display message form SignIn ");
				ExcelUtils.setCellData("Pass", 3, 4);
			}
		} catch (Exception e) {
			ExcelUtils.setCellData("Fail", 3, 4);
			Utility.takeScreenshot(driver, ExcelUtils.getCellData(3, 0));
			Log.error(e.getMessage());
			throw (e);
		}

	}

	@Test(priority = 4)
	public void signIn_TC4() throws Exception {
		try {
			SignIn_Action.testCase4();
			WebElement message = driver.findElement(By.xpath(
					"html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/table[1]/tbody/tr[2]/td/form/table/tbody/tr[5]/td/span"));
			if (message.getText().equals("Sai Tên Đăng Nhập Hoặc Mật Khẩu")) {
				Log.info("Check display message form SignIn ");
				ExcelUtils.setCellData("Pass", 4, 4);
			}
		} catch (Exception e) {
			ExcelUtils.setCellData("Fail", 4, 4);
			Utility.takeScreenshot(driver, ExcelUtils.getCellData(4, 0));
			Log.error(e.getMessage());
			throw (e);
		}

	}

	@Test(priority = 5)
	public void signIn_TC5() throws Exception {
		try {
			String userName = ExcelUtils.getCellData(5, 2);
			Log.info("User name picked from Excel is " + userName);
			String passWord = ExcelUtils.getCellData(5, 3);
			Log.info("Pass word picked from Excel is " + passWord);
			LogIn_Page.txt_UserName().sendKeys(userName);
			if (userName.length() < 30) {
				Log.info("User name entered in the Username text box");
				LogIn_Page.txt_Password().sendKeys(passWord);
				if (passWord.length() < 30) {
					Log.info("PassWord entered in the Password text box");
					LogIn_Page.btn_LogIn().click();
				} else {
					ExcelUtils.setCellData("Fail", 5, 4);
					Utility.takeScreenshot(driver, ExcelUtils.getCellData(5, 0));
					Log.error("Password entered larger 30 characters");
				}
			} else {
				ExcelUtils.setCellData("Fail", 5, 4);
				Utility.takeScreenshot(driver, ExcelUtils.getCellData(5, 0));
				Log.error(" Username entered larger 30 characters");
			}

		} catch (Exception e) {
			ExcelUtils.setCellData("Fail", 5, 4);
			Utility.takeScreenshot(driver, ExcelUtils.getCellData(5, 0));
			Log.error(e.getMessage());
			throw (e);
		}

	}

	@Test(priority = 6)
	public void signIn_TC6() throws Exception {
		try {
			SignIn_Action.enterUser();
			SignIn_Action.enterPass();
			LogIn_Page.btn_LogIn();
			if (Home_Page.linkThongtinTaiKhoan().isDisplayed()) {
				Log.error("SignIn sucessfull ");
				ExcelUtils.setCellData("Pass", 6, 4);
			} else {
				TestBase.bResult = false;
				Log.error("SignIn not sucessfull ");
				ExcelUtils.setCellData("Fail", 6, 4);
				Utility.takeScreenshot(driver, ExcelUtils.getCellData(6, 0));

			}
			if (TestBase.bResult == true) {
				ExcelUtils.setCellData("Pass", 7, 4);
			} else {
				Log.error("Test Case Failed because of Verification");
				ExcelUtils.setCellData("Fail", 7, 4);
				Utility.takeScreenshot(driver, ExcelUtils.getCellData(7, 0));
			}
		} catch (Exception e) {
			ExcelUtils.setCellData("Fail", 6, 4);
			Utility.takeScreenshot(driver, ExcelUtils.getCellData(6, 0));
			Log.error(e.getMessage());
			throw (e);
		}

	}

	@Test(priority = 7)
	public void signIn_TC7() throws Exception {
		try {
			SignIn_Action.check_text();
			SignIn_Action.check_linkDangKy();
			SignIn_Action.check_linkFoundPass();
			if (TestBase.bResult == true) {
				ExcelUtils.setCellData("Pass", 7, 4);
			} else {
				Log.error("Test Case Failed because of Verification");
				ExcelUtils.setCellData("Fail", 7, 4);
				Utility.takeScreenshot(driver, ExcelUtils.getCellData(7, 0));
			}

		} catch (Exception e) {
			ExcelUtils.setCellData("Fail", 7, 4);
			Utility.takeScreenshot(driver, ExcelUtils.getCellData(7, 0));
			Log.error(e.getMessage());
			throw (e);
		}
	}

	@AfterMethod
	public void afterMethod() {
		Log.endTestCase("SignIn");
		driver.quit();

	}
}
