package com.utc.flowershop.appmodules;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Reporter;

import com.utc.flowershop.pageobject.Register_Page;
import com.utc.flowershop.pageobject.TestBase;
import com.utc.flowershop.utility.ConnectDatatabase;
import com.utc.flowershop.utility.ExcelUtils;
import com.utc.flowershop.utility.Log;
import com.utc.flowershop.utility.Utility;

public class Register_Action {
	public static ArrayList<WebElement> arrayList = new ArrayList<WebElement>();
	private static WebDriver driver;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	// public static void checkTextNull() throws Exception {
	// String tenDN = Register_Page.txtTenDN().getText();
	// String pass = Register_Page.txtPass().getText();
	// String ho = Register_Page.txtHo().getText();
	// String ten = Register_Page.txtTen().getText();
	// String sdt = Register_Page.txtSDT().getText();
	// String email = Register_Page.txtEmail().getText();
	// String diaChi = Register_Page.txtDiaChi().getText();
	// Select dropDown = new Select(driver.findElement(By.name("gioitinh")));
	// String gioiTinh = dropDown.getFirstSelectedOption().getText();
	//
	// if (tenDN.equals("")) {
	// TestBase.bResult = false;
	// Log.error("Ten dang nhap null");
	// } else if (pass.equals("")) {
	// TestBase.bResult = false;
	// Log.error("Mat khau null");
	// } else if (ho.equals("")) {
	// TestBase.bResult = false;
	// Log.error("Ho null");
	// } else if (ten.equals("")) {
	// TestBase.bResult = false;
	// Log.error("Ten null");
	// } else if (sdt.equals("")) {
	// TestBase.bResult = false;
	// Log.error("So dien thoai null");
	// } else if (email.equals("")) {
	// TestBase.bResult = false;
	// Log.error("Email null");
	// } else if (diaChi.equals("")) {
	// TestBase.bResult = false;
	// Log.error("Dia Chi null");
	// } else if (gioiTinh.equals("Không Xác Định")) {
	// TestBase.bResult = false;
	// Log.error("Gioi Tinh khong xac dinh dc");
	// } else {
	// TestBase.bResult = true;
	// Log.info("Entered successfull for form Dang Nhap ");
	// }
	// }

	public static void testCase001() {
		try {
			Register_Page.getDataCustomer(1);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Dang ky performed on Submit button");
			// Thread.sleep(5000);
			Reporter.log("Register Action is successfully perfomred");
		} catch (Exception e) {
			Log.error("Click Dang ky performed on Submit button");
			e.printStackTrace();
		}

	}

	public static void testCase002() {
		try {
			Register_Page.getDataCustomer(2);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Dang ky performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Dang ky NOT performed on Submit button");
			e.printStackTrace();
		}

	}

	public static void testCase003() {
		try {
			Register_Page.getDataCustomer(3);
			Thread.sleep(10000);
			String user = Register_Page.getIdElement("tendangnhap").getText();
			String pass = Register_Page.getIdElement("matkhau").getText();
			if (user.length() == 30) {
				if (pass.length() == 30) {
					TestBase.bResult = true;
					Register_Page.btnDangKy().click();
					Log.info("Click Dang ky performed on Submit button");
				} else {
					TestBase.bResult = false;
					Log.error("Mat khau khong bang 30 ky tu");
				}
			} else {
				TestBase.bResult = false;
				Log.error("Ten dang nhap khong bang 30 ky tu");
			}

		} catch (Exception e) {
			Log.error("Click Dang ky NOT performed on Submit button");
			e.printStackTrace();
		}

	}

	public static void testCase005() {
		try {
			Register_Page.getDataCustomer(4);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Dang ky performed on Submit button");
			TestBase.bResult = true;

		} catch (Exception e) {
			Log.error("Click Dang ky NOT performed on Submit button");
			e.printStackTrace();
		}

	}

	public static void testCase006() {
		try {
			Register_Page.getDataCustomer(5);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Dang ky performed on Submit button");
			TestBase.bResult = true;

		} catch (Exception e) {
			Log.error("Click Dang ky NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void checkNameKH_TC6() throws Exception {
		ConnectDatatabase.connectToDB();
		ConnectDatatabase.readTenDN(ExcelUtils.getCellData(6, 2));

	}

	public static void testCase007() {
		try {
			Register_Page.getDataCustomer(7);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Dang ky performed on Submit button");
			TestBase.bResult = true;

		} catch (Exception e) {
			Log.error("Click Dang ky NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase008() {
		try {
			Register_Page.getDataCustomer(8);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Dang ky performed on Submit button");
			TestBase.bResult = true;

		} catch (Exception e) {
			Log.error("Click Dang ky NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void checkFistLastNameKH_TC8() throws Exception {
		ConnectDatatabase.connectToDB();
		ConnectDatatabase.read_First_Last_Name(ExcelUtils.getCellData(8, 4), ExcelUtils.getCellData(8, 5));

	}

	public static void testCase009() {
		try {
			Register_Page.getDataCustomer(9);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Dang ky performed on Submit button");
			TestBase.bResult = true;

		} catch (Exception e) {
			Log.error("Click Dang ky NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void checkFistLastNameKH_TC9() throws Exception {
		ConnectDatatabase.connectToDB();
		ConnectDatatabase.read_First_Last_Name(ExcelUtils.getCellData(9, 4), ExcelUtils.getCellData(9, 5));

	}

	public static void testCase010() {
		try {
			Register_Page.getDataCustomer(10);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase011() {
		try {
			Register_Page.getDataCustomer(11);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase012() {
		try {
			Register_Page.getDataCustomer(12);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase013() {
		try {
			Register_Page.getDataCustomer(13);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase014() {
		try {
			Register_Page.getDataCustomer(14);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase015() {
		try {
			Register_Page.getDataCustomer(15);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase016() {
		try {
			Register_Page.getDataCustomer(16);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase017() {
		try {
			Register_Page.getDataCustomer(17);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase018() {
		try {
			Register_Page.getDataCustomer(18);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase019() {
		try {
			Register_Page.getDataCustomer(19);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase020() {
		try {
			Register_Page.getDataCustomer(20);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase021() {
		try {
			Register_Page.getDataCustomer(21);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase022() {
		try {
			Register_Page.getDataCustomer(22);
			Thread.sleep(10000);
			Register_Page.btnDangKy().click();
			Log.info("Click Register performed on Submit button");
			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Register NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void testCase023() {
		try {
			Register_Page.getDataCustomer(23);
			Thread.sleep(10000);
			Register_Page.btnLamTrang().click();
			Log.info("Click Lam trang performed on Submit button");

			TestBase.bResult = true;
		} catch (Exception e) {
			Log.error("Click Lam trang NOT performed on Submit button");
			e.printStackTrace();
		}
	}

	public static void test_pass(int row) throws Exception {
		ExcelUtils.setCellData("Pass", row, 11);
		ExcelUtils.setCellData("", row, 13);
		Log.info("Test Case " + row + " Passed because of Verification");

	}

	public static void test_failed(int row) throws Exception {
		Utility.takeScreenshot(driver, ExcelUtils.getCellData(row, 0));
		ExcelUtils.setCellData("Failed ", row, 11);
	}

	public static void check_phone_tc12() {
		try {
			String phone = ExcelUtils.getCellData(12, 6);
			int sdt = Integer.parseInt(phone);
			Log.error("Not parseInt");
			ConnectDatatabase.connectToDB();
			ConnectDatatabase.read_phoneNumber(sdt);
			Log.info("Check phone number succesfuly");
		} catch (Exception e) {
			Log.error("Check phone number not succesfuly");
			e.printStackTrace();
		}

	}

}
