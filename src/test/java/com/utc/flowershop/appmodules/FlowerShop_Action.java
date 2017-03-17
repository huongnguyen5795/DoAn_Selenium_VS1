package com.utc.flowershop.appmodules;

import com.utc.flowershop.pageobject.FlowerShop_Page;
import com.utc.flowershop.pageobject.LogIn_Page;
import com.utc.flowershop.utility.ExcelUtils;
import com.utc.flowershop.utility.Log;

public class FlowerShop_Action {
	public static void testCase001() {
		try {
			FlowerShop_Page.linkGioHang().click();
		} catch (Exception e) {
			Log.error("Test Case 001 Failed because of Verification");
			e.printStackTrace();
		}
	}

	public static void testCase002() {
		try {
			logIn();
			Thread.sleep(5000);
//			Log.info("LogIn Successfuly");
			FlowerShop_Page.linkGioHang().click();
		} catch (Exception e) {
			Log.error("Test Case 002 Failed because of Verification");
			e.printStackTrace();
		}
	}

	public static void testCase003() {
		try {
			FlowerShop_Page.linkDatMua_NgayQuanTrong_TC().click();
			Thread.sleep(3000);
		} catch (Exception e) {
			Log.error("Test Case 003 Failed because of Verification");
			e.printStackTrace();
		}

	}

	public static void testCase004() {
		try {
			logIn();
			Thread.sleep(2000);
			Log.info("LogIn Successfuly");
			FlowerShop_Page.linkDatMua_NgayQuanTrong_TC().click();
		} catch (Exception e) {
			Log.error("Test Case 004 Failed because of Verification");
			e.printStackTrace();
		}
	}

	public static void testCase005() {
		try {
			FlowerShop_Page.linkSanPham().click();
			FlowerShop_Page.linkDatMua_NgayQuanTrong_SP().click();
			Thread.sleep(3000);
		} catch (Exception e) {
			Log.error("Test Case 005 Failed because of Verification");
			e.printStackTrace();
		}

	}

	public static void testCase006() {
		try {
			logIn();
			FlowerShop_Page.linkSanPham().click();
			Thread.sleep(2000);
			FlowerShop_Page.linkDatMua_NgayQuanTrong_SP().click();
		} catch (Exception e) {
			Log.error("Test Case 006 Failed because of Verification");
			e.printStackTrace();
		}
	}
	
	public static void testCase007() {
		try {
			testCase006();
			String sluong = ExcelUtils.getCellData(7, 4);
			FlowerShop_Page.txtSoLuong().sendKeys(sluong);
			FlowerShop_Page.link_Update().click();
		} catch (Exception e) {
			Log.error("Test Case 007 Failed because of Verification");
			e.printStackTrace();
		}
	}
	
	public static void testCase008() {
		try {
			testCase006();
			String sluong = ExcelUtils.getCellData(8, 4);
			FlowerShop_Page.txtSoLuong().sendKeys(sluong);
			FlowerShop_Page.link_Update().click();
		} catch (Exception e) {
			Log.error("Test Case 008 Failed because of Verification");
			e.printStackTrace();
		}
	}
	
	public static void testCase009() {
		try {
			testCase006();
			String sluong = ExcelUtils.getCellData(9, 4);
			FlowerShop_Page.txtSoLuong().sendKeys(sluong);
			FlowerShop_Page.link_Update().click();
		} catch (Exception e) {
			Log.error("Test Case 009 Failed because of Verification");
			e.printStackTrace();
		}
	}
	public static void logIn() {
		try {
			LogIn_Page.txt_UserName().sendKeys("HuongNguyen");
			LogIn_Page.txt_Password().sendKeys("05071995");
			LogIn_Page.btn_LogIn().click();
			Log.info("LogIn successful");
		} catch (Exception e) {
			Log.error("Error SignIn");
			e.printStackTrace();
		}

	}

	public static void test_pass(int row) throws Exception {
		ExcelUtils.setCellData("Pass", row, 8);
		ExcelUtils.setCellData("", row, 10);
		Log.info("Test Case " + row + " Passed because of Verification");
	}

	public static void test_failed(int row, String message) throws Exception {
		ExcelUtils.setCellData("Failed ", row, 8);
		ExcelUtils.setCellData("Failed " + message, row, 10);
		Log.error("Test Case " + row + " Failed because of Verification" + message);
	}
}
