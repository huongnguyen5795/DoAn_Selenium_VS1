package com.utc.flowershop.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utc.flowershop.appmodules.FlowerShop_Action;
import com.utc.flowershop.pageobject.FlowerShop_Page;
import com.utc.flowershop.pageobject.TestBase;
import com.utc.flowershop.utility.Constant;
import com.utc.flowershop.utility.ExcelUtils;
import com.utc.flowershop.utility.Log;
import com.utc.flowershop.utility.Utility;

public class TestCase_FlowerShop {
	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("FlowerShop");
		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, "FlowerShop");
		Log.info("Excel sheet opened");
		String browserName = ExcelUtils.getCellData(1, 9);
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

	// @Test(priority = 1)
	// public void flowerShop_TC1() throws Exception {
	// try {
	// FlowerShop_Action.testCase001();
	// String mess = FlowerShop_Page.messNotSignIn().getText();
	// if (mess.equals("Bạn Phải Là Thành Viên Mới Được Sử Dụng Chức Năng Mua
	// Hàng")) {
	// FlowerShop_Page.linkDangKyTK().click();
	// String title = driver.getTitle();
	// if (title.equals("dangky")) {
	// FlowerShop_Action.test_pass(1);
	// } else {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(1, 0));
	// FlowerShop_Action.test_failed(1, "Chuyển sang form đăng ký không
	// thànhcông");
	// }
	//
	// } else {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(1, 0));
	// FlowerShop_Action.test_failed(1, "Không tìm thấy thông báo lỗi");
	// }
	// } catch (
	//
	// Exception e) {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(1, 0));
	// FlowerShop_Action.test_failed(1, "error exception");
	// e.printStackTrace();
	// }
	//
	// }

	// @Test(priority = 2)
	// public void flowerShop_TC2() throws Exception {
	// try {
	// FlowerShop_Action.testCase002();
	// String title = driver.getTitle();
	// if(title.equals("dathang")) {
	// FlowerShop_Action.test_pass(2);
	// } else {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(2, 0));
	// FlowerShop_Action.test_failed(2, "Không tìm thấy form Gio hang");
	// }
	// } catch (Exception e) {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(2, 0));
	// FlowerShop_Action.test_failed(2, "error exception");
	// e.printStackTrace();
	// }
	//
	// }

	// @Test(priority = 3)
	// public void flowerShop_TC3() throws Exception {
	// try {
	// FlowerShop_Action.testCase003();
	// String mess = FlowerShop_Page.messNotSignIn().getText();
	// if (mess.equals("Bạn Phải Là Thành Viên Mới Được Sử Dụng Chức Năng Mua
	// Hàng")) {
	// FlowerShop_Page.linkDangKyTK().click();
	// String title = driver.getTitle();
	// if (title.equals("dangky")) {
	// FlowerShop_Action.test_pass(3);
	// } else {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(3, 0));
	// FlowerShop_Action.test_failed(3, "Chuyển sang form đăng ký không thành
	// công");
	// }
	//
	// } else {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(3, 0));
	// FlowerShop_Action.test_failed(3, "Không tìm thấy thông báo lỗi");
	// }
	// } catch (
	//
	// Exception e) {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(3, 0));
	// FlowerShop_Action.test_failed(3, "error exception");
	// e.printStackTrace();
	// }
	// }

	// @Test(priority = 4)
	// public void flowerShop_TC4() throws Exception {
	// try {
	// FlowerShop_Action.testCase004();
	// Thread.sleep(3000);
	// String title = driver.getTitle();
	// if (title.equals("dathang")) {
	// FlowerShop_Action.test_pass(4);
	// } else {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(4, 0));
	// FlowerShop_Action.test_failed(4, "Không tìm thấy form Gio hang");
	// }
	// } catch (Exception e) {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(4, 0));
	// FlowerShop_Action.test_failed(4, "error exception");
	// e.printStackTrace();
	// }
	//
	// }

	// @Test(priority = 5)
	// public void flowerShop_TC5() throws Exception {
	// try {
	// FlowerShop_Action.testCase005();
	// String mess = FlowerShop_Page.messNotSignIn().getText();
	// if (mess.equals("Bạn Phải Là Thành Viên Mới Được Sử Dụng Chức Năng Mua
	// Hàng")) {
	// FlowerShop_Page.linkDangKyTK().click();
	// String title = driver.getTitle();
	// if (title.equals("dangky")) {
	// FlowerShop_Action.test_pass(5);
	// } else {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(5, 0));
	// FlowerShop_Action.test_failed(5, "Chuyển sang form đăng ký không thành
	// công");
	// }
	//
	// } else {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(5, 0));
	// FlowerShop_Action.test_failed(5, "Không tìm thấy thông báo lỗi");
	// }
	// } catch (
	//
	// Exception e) {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(5, 0));
	// FlowerShop_Action.test_failed(5, "error exception");
	// e.printStackTrace();
	// }
	// }

	// @Test(priority = 6)
	// public void flowerShop_TC6() throws Exception {
	// try {
	// FlowerShop_Action.testCase006();
	// Thread.sleep(3000);
	// String title = driver.getTitle();
	// if (title.equals("dathang")) {
	// FlowerShop_Action.test_pass(6);
	// } else {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(6, 0));
	// FlowerShop_Action.test_failed(6, "Không tìm thấy form Gio hang");
	// }
	// } catch (Exception e) {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(6, 0));
	// FlowerShop_Action.test_failed(6, "error exception");
	// e.printStackTrace();
	// }
	//
	// }

//	@Test(priority = 7)
//	public void flowerShop_TC7() throws Exception {
//		try {
//			FlowerShop_Action.testCase007();
//			Thread.sleep(3000);
//			String tong = FlowerShop_Page.txtTongGioHang().getText();
//			if (tong.equals("0.000")) {
//				FlowerShop_Action.test_pass(7);
//			} else {
//				Utility.takeScreenshot(driver, ExcelUtils.getCellData(7, 0));
//				FlowerShop_Action.test_failed(7, "Sai khi nhap so luong la kieu float khong thong bao loi");
//			}
//		} catch (Exception e) {
//			Utility.takeScreenshot(driver, ExcelUtils.getCellData(7, 0));
//			FlowerShop_Action.test_failed(7, "error exception");
//			e.printStackTrace();
//		}
//
//	}
//	@Test(priority = 8)
//	public void flowerShop_TC8() throws Exception {
//		try {
//			FlowerShop_Action.testCase008();
//			Thread.sleep(3000);
//			String tong = FlowerShop_Page.txtTongGioHang().getText();
//			if (tong.equals("0 VNĐ")) {
//				FlowerShop_Action.test_pass(8);
//			} else {
//				Utility.takeScreenshot(driver, ExcelUtils.getCellData(8, 0));
//				FlowerShop_Action.test_failed(8, "Sai khi nhap so luong la kieu string khong thong bao loi");
//			}
//		} catch (Exception e) {
//			Utility.takeScreenshot(driver, ExcelUtils.getCellData(8, 0));
//			FlowerShop_Action.test_failed(8, "error exception");
//			e.printStackTrace();
//		}
//
//	}
	@Test(priority = 9)
	public void flowerShop_TC9() throws Exception {
		try {
			FlowerShop_Action.testCase009();
			Thread.sleep(3000);
			String tong = FlowerShop_Page.txtSoLuong().getText();
			String tongExcel = ExcelUtils.getCellData(9, 4);
			if(tong.equals(tongExcel)){
//				if()
				FlowerShop_Action.test_pass(8);
			} else {
				Utility.takeScreenshot(driver, ExcelUtils.getCellData(8, 0));
				FlowerShop_Action.test_failed(8, "Sai khi nhap so luong la kieu string khong thong bao loi");
			}
		} catch (Exception e) {
			Utility.takeScreenshot(driver, ExcelUtils.getCellData(8, 0));
			FlowerShop_Action.test_failed(8, "error exception");
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void afterMethod() {
		Log.endTestCase("FlowerShop");
		driver.quit();

	}
}
