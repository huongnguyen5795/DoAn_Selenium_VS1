package com.utc.flowershop.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utc.flowershop.appmodules.Register_Action;

import com.utc.flowershop.pageobject.LogIn_Page;
import com.utc.flowershop.pageobject.Register_Page;
import com.utc.flowershop.pageobject.TestBase;
import com.utc.flowershop.pageobject.Account_Confirm_Page;

import com.utc.flowershop.utility.Constant;
import com.utc.flowershop.utility.ExcelUtils;
import com.utc.flowershop.utility.Log;
import com.utc.flowershop.utility.Utility;

public class TestCase_Register {
	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Register");
		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, "Register");
		Log.info("Excel sheet opened");
		String browerName = ExcelUtils.getCellData(1, 12);
		driver = Utility.openBrowser(browerName);
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
	public void register_TC1() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase001();
			String message = Register_Page.error_TenDN().getText();
			Assert.assertEquals(message, "bạn chưa nhập vào tên đăng nhập!");
			Register_Action.test_pass(1);
		} catch (Exception e) {
			Register_Action.test_failed(1);
			Log.error("Test Case 001 Failed because of Verification" + e.getMessage());
		}
	}

	@Test(priority = 2)
	public void register_TC2() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase002();
			// Register_Action.checkTextNull();
			if (TestBase.bResult = true) {
				if (!Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
					Register_Action.test_pass(2);
				} else {
					Register_Action.test_failed(2);
					Log.error("Test Case 002 Failed because of Ten dang nhap and Mat khau > 30 charactor");
				}
			} else {
				Register_Action.test_failed(2);
				Log.error("Test Case 002 Failed because of verification");
			}
		} catch (Exception e) {
			Register_Action.test_failed(2);
			Log.error("Test Case 002 Failed because of Verification");
		}
	}

	@Test(priority = 3)
	public void register_TC3() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase003();
			// Register_Action.checkTextNull();
			if (TestBase.bResult = true) {
				if (Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
					Register_Action.test_pass(3);
				} else {
					Register_Action.test_failed(3);
					Log.error("Test Case 003 Failed because of Ten dang nhap and Mat khau >30 charactor");
				}
			} else {
				Register_Action.test_failed(3);
				Log.error("Test Case 003 Failed because of verification");
			}
		} catch (Exception e) {
			Register_Action.test_failed(3);
			Log.error("Test Case 003 Failed because of Verification");
		}
	}

	@Test(priority = 5)
	public void register_TC5() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase005();
			// Register_Action.checkTextNull();
			if (TestBase.bResult = true) {
				if (Account_Confirm_Page.linkBack().isDisplayed()) {
					Register_Action.test_pass(5);
				} else {
					Register_Action.test_failed(5);
					Log.error("Test Case 005 Failed because of not found linh back");

				}
			} else {
				Register_Action.test_failed(5);
				Log.error("Test Case 005 Failed because of verification");

			}
		} catch (Exception e) {
			Register_Action.test_failed(5);
			Log.error("Test Case 005 Failed because of Verification");

		}
	}

	@Test(priority = 6)
	public void register_TC6() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase006();
			// Register_Action.checkTextNull();

			if (Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
				Register_Action.checkNameKH_TC6();
				if (TestBase.bResult == true) {
					Register_Action.test_pass(6);
				} else {
					Register_Action.test_failed(6);
					ExcelUtils.setCellData("Failed sai do khong insert trong CSDL", 6, 13);
					Log.error("Test Case 006 Failed because of not insert CSDL");
				}
			} else {
				Register_Action.test_failed(6);
				ExcelUtils.setCellData("Failed sai do link pass ko ton tai", 6, 13);
				Log.error("Test Case 006 Failed because of verification");

			}
		} catch (Exception e) {
			Register_Action.test_failed(6);
			Log.error("Test Case 006 Failed because of Verification");

		}
	}

	@Test(priority = 7)
	public void register_TC7() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase007();
			if (TestBase.bResult = true) {
				if (!Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
					Register_Action.test_pass(7);
				} else {
					Register_Action.test_failed(7);
					ExcelUtils.setCellData("Failed - tim thay linh dang ky thanh cong", 7, 13);
					Log.error("Test Case 007 Failed because of Ho Ten > 30 charactor");
				}
			} else {
				Register_Action.test_failed(7);
				Log.error("Test Case 007 Failed ");
			}
		} catch (Exception e) {
			Register_Action.test_failed(7);
			Log.error("Test Case 006 Failed because of Verification" + e.getMessage());
		}
	}

	@Test(priority = 8)
	public void register_TC8() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase008();
			// Register_Action.checkTextNull();
			if (Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
				Register_Action.checkFistLastNameKH_TC8();
				if (TestBase.bResult == true) {
					Register_Action.test_pass(8);
				} else {
					Register_Action.test_failed(8);
					ExcelUtils.setCellData("Failed sai do khong insert trong CSDL", 8, 13);
					Log.error("Test Case 008 Failed because of not insert CSDL");
				}
			} else {
				Register_Action.test_failed(8);
				ExcelUtils.setCellData("Failed sai do link pass ko ton tai", 8, 13);
				Log.error("Test Case 008 Failed because of verification");

			}
		} catch (Exception e) {
			Register_Action.test_failed(8);
			Log.error("Test Case 008 Failed because of Verification" + e.getMessage());

		}
	}

	@Test(priority = 9)
	public void register_TC9() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase009();
			// Register_Action.checkTextNull();
			if (Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
				Register_Action.checkFistLastNameKH_TC9();
				if (TestBase.bResult == true) {
					ExcelUtils.setCellData("Pass", 9, 11);
					ExcelUtils.setCellData("", 9, 13);
					Log.info("Test Case 009 Passed because of Verification");
				} else {
					Utility.takeScreenshot(driver, ExcelUtils.getCellData(9, 0));
					ExcelUtils.setCellData("Fail", 9, 11);
					ExcelUtils.setCellData("Failed - do khong insert trong CSDL", 9, 13);
					Log.error("Test Case 009 Failed because of not insert CSDL");
				}
			} else {
				Utility.takeScreenshot(driver, ExcelUtils.getCellData(9, 0));
				ExcelUtils.setCellData("Failed ", 9, 11);
				ExcelUtils.setCellData("Failed - do link pass ko ton tai", 9, 13);
				Log.error("Test Case 009 Failed because of verification");

			}
		} catch (Exception e) {
			Utility.takeScreenshot(driver, ExcelUtils.getCellData(9, 0));
			ExcelUtils.setCellData("Fail", 9, 11);
			Log.error("Test Case 009 Failed because of Verification" + e.getMessage());

		}
	}

	// @Test
	// public void register_TC10() throws Exception {
	// try {
	// LogIn_Page.link_dangKy().click();
	// Register_Action.testCase010();
	// // Register_Action.checkTextNull();
	// if (Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
	// Register_Action.check_phone();
	// if (TestBase.bResult == true) {
	// ExcelUtils.setCellData("Pass", 10, 11);
	// ExcelUtils.setCellData("", 10, 13);
	// Log.info("Test Case 010 Passed because of Verification");
	// } else {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(10, 0));
	// ExcelUtils.setCellData("Fail", 10, 11);
	// ExcelUtils.setCellData("Failed - do khong insert trong CSDL", 10, 13);
	// Log.error("Test Case 010 Failed because of not insert CSDL");
	// }
	// } else {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(10, 0));
	// ExcelUtils.setCellData("Failed ", 10, 11);
	// ExcelUtils.setCellData("Failed - do link pass ko ton tai", 10, 13);
	// Log.error("Test Case 009 Failed because of verification");
	//
	// }
	// } catch (Exception e) {
	// Utility.takeScreenshot(driver, ExcelUtils.getCellData(10, 0));
	// ExcelUtils.setCellData("Fail", 10, 11);
	// Log.error("Test Case 009 Failed because of Verification" +
	// e.getMessage());
	//
	// }
	// }

	@Test(priority = 11)
	public void register_TC11() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase011();
			// String phone = ExcelUtils.getCellData(11, 6);
			String mess = Register_Page.mes_sdt().getText();
			Assert.assertEquals(mess, "bạn phải nhập bằng số có từ 10 đến 11 ký tự!");
			Register_Action.test_pass(11);

		} catch (Exception e) {
			Register_Action.test_failed(11);
			Log.error("Test Case 011 Failed because of Verification " + e.getMessage());

		}
	}

	@Test(priority = 12)
	public void register_TC12() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase012();
			String mess = Register_Page.mes_sdt().getText();
			Assert.assertEquals(mess, "bạn phải nhập bằng số có từ 10 đến 11 ký tự!");
			Register_Action.test_pass(12);

		} catch (Exception e) {
			Register_Action.test_failed(12);
			Log.error("Test Case 011 Failed because of Verification " + e.getMessage());

		}
	}

	@Test(priority = 13)
	public void register_TC13() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase013();
			if (Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
				Register_Action.test_pass(13);
			} else {
				Register_Action.test_failed(13);
				ExcelUtils.setCellData("Failed - do link pass ko ton tai", 13, 13);
				Log.error("Test Case 0013 Failed because of verification");

			}

		} catch (Exception e) {
			Register_Action.test_failed(13);
			Log.error("Test Case 013 Failed because of Verification " + e.getMessage());

		}
	}

	@Test(priority = 14)
	public void register_TC14() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase014();
			String mess = Register_Page.mes_gmail().getText();
			Assert.assertEquals(mess, "bạn nhập sai dạng email - dạng email vd: tenban@yahoo.com");
			Register_Action.test_pass(14);

		} catch (Exception e) {
			Register_Action.test_failed(14);
			Log.error("Test Case 014 Failed because of Verification " + e.getMessage());

		}
	}

	@Test(priority = 15)
	public void register_TC15() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase015();
			String email = ExcelUtils.getCellData(15, 7);
			if (Register_Action.validateEmail(email)) {
				if (Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
					Register_Action.test_pass(15);
				} else {
					Register_Action.test_failed(15);
					ExcelUtils.setCellData("Failed - do link pass ko ton tai", 15, 13);
					Log.error("Test Case 0015 Failed because of verification");
				}
			} else {
				Register_Action.test_failed(15);
				ExcelUtils.setCellData("Failed - dia chi email ko hop le", 15, 13);
				Log.error("Test Case 016 Failed because of verification");

			}

		} catch (Exception e) {
			Register_Action.test_failed(15);
			Log.error("Test Case 015 Failed because of Verification " + e.getMessage());

		}
	}

	@Test(priority = 16)
	public void register_TC16() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase016();
			String email = ExcelUtils.getCellData(16, 7);
			if (Register_Action.validateEmail(email)) {
				if (Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
					Register_Action.test_pass(16);
				} else {
					Register_Action.test_failed(16);
					ExcelUtils.setCellData("Failed - do link pass ko ton tai", 16, 13);
					Log.error("Test Case 016 Failed because of verification");

				}
			} else {
				Register_Action.test_failed(16);
				ExcelUtils.setCellData("Failed - dia chi email ko hop le", 16, 13);
				Log.error("Test Case 016 Failed because of verification");

			}
		} catch (Exception e) {
			Register_Action.test_failed(16);
			Log.error("Test Case 016 Failed because of Verification " + e.getMessage());

		}
	}

	@Test(priority = 17)
	public void register_TC17() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase017();
			String email = ExcelUtils.getCellData(17, 7);
			if (Register_Action.validateEmail(email)) {
				if (!Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
					Register_Action.test_failed(17);
				} else {
					Register_Action.test_failed(17);
					ExcelUtils.setCellData("Failed - ton tai link dang nhap thanh cong", 16, 13);
					Log.error("Test Case 016 Failed because of verification - ton tai link dang nhap thanh cong");

				}
			} else {
				Register_Action.test_failed(17);
				ExcelUtils.setCellData("Failed - dia chi email ko hop le", 17, 13);
				Log.error("Test Case 017 Failed because of verification");

			}
		} catch (Exception e) {
			Register_Action.test_failed(17);
			Log.error("Test Case 017 Failed because of Verification " + e.getMessage());

		}
	}

	@Test(priority = 18)
	public void register_TC18() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase018();
			if (!Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
				Register_Action.test_pass(18);
			} else {
				Register_Action.test_failed(18);
				ExcelUtils.setCellData("Failed - ton tai link dang nhap thanh cong", 18, 13);
				Log.error("Test Case 018 Failed because of verification - ton tai link dang nhap thanh cong");

			}

		} catch (Exception e) {
			Register_Action.test_failed(18);
			Log.error("Test Case 018 Failed because of Verification " + e.getMessage());

		}
	}

	@Test(priority = 19)
	public void register_TC19() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase019();
			if (Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
				Register_Action.test_pass(19);
			} else {
				Register_Action.test_failed(19);
				ExcelUtils.setCellData("Failed - khong ton tai link dang nhap thanh cong", 19, 13);
				Log.error("Test Case 019 Failed because of verification - khong ton tai link dang nhap thanh cong");

			}

		} catch (Exception e) {
			Register_Action.test_failed(19);
			Log.error("Test Case 019 Failed because of Verification " + e.getMessage());

		}
	}

	@Test(priority = 20)
	public void register_TC20() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase020();
			if (Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
				Register_Action.test_pass(20);
			} else {
				Register_Action.test_failed(20);
				ExcelUtils.setCellData("Failed - khong ton tai link dang nhap thanhcong", 20, 13);
				Log.error("Test Case 019 Failed because of verification - khong ton tai link dang nhap thanh cong");
			}
		} catch (Exception e) {
			Register_Action.test_failed(20);
			Log.error("Test Case 20 Failed because of Verification " + e.getMessage());

		}
	}

	@Test(priority = 21)
	public void register_TC21() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase021();
			if (Account_Confirm_Page.link_dangKyPass().isDisplayed()) {
				Register_Action.test_pass(21);
			} else {
				Register_Action.test_failed(11);
				ExcelUtils.setCellData("Failed - khong ton tai link dang nhap thanh  cong", 21, 13);
				Log.error("Test Case 021 Failed because of verification - khong ton tai link dang nhap thanh cong");
			}

		} catch (Exception e) {
			Register_Action.test_failed(21);
			Log.error("Test Case 021 Failed because of Verification " + e.getMessage());
		}

	}

	@Test
	public void register_TC22() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase022();
			String mess = Register_Page.messMaXN().getText();
			Assert.assertEquals(mess,
					"Bạn Nhập Sai Mã Xác Nhận Vui Lòng Nhập Lại!" + "\nBấm Vào Đây Để Nhập Lại Mã Xác Nhận");
			Register_Action.test_pass(22);
		} catch (Exception e) {
			Register_Action.test_failed(22);
			Log.error("Test Case 22 Failed because of Verification " + e.getMessage());

		}
	}

	@Test(priority = 23)
	public void register_TC23() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Register_Action.testCase023();
			Register_Page.getDataEmpty();
			if (TestBase.bResult == true) {
				Register_Action.test_pass(23);
			} else {
				Register_Action.test_failed(23);
				ExcelUtils.setCellData("Failed - lam trang form ko thanh cong", 23, 13);
				Log.error("Test Case 023 Failed because of verification - lam trang form ko thanh cong");

			}

		} catch (Exception e) {
			Register_Action.test_failed(23);
			Log.error("Test Case 023 Failed because of Verification " + e.getMessage());
		}

	}

	@Test(priority = 24)
	public void register_TC24() throws Exception {
		try {
			LogIn_Page.link_dangKy().click();
			Select dropDown = new Select(driver.findElement(By.name("gioitinh")));
			if (dropDown.getFirstSelectedOption().getText().equals("Nam")) {
				Register_Action.test_pass(24);
			} else {
				Register_Action.test_failed(24);
				ExcelUtils.setCellData("Failed - drop down box ko bat dau la Nam", 24, 13);
				Log.error("Test Case 024 Failed because of verification - drop down box ko bat dau la Nam");

			}

		} catch (Exception e) {
			Register_Action.test_failed(24);
			Log.error("Test Case 024 Failed because of Verification " + e.getMessage());
		}

	}

	@AfterMethod
	public void afterMethod() {
		Log.endTestCase("Register");
		driver.quit();

	}

}
