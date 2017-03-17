package com.utc.flowershop.appmodules;

import org.openqa.selenium.WebDriver;
import com.utc.flowershop.pageobject.QuickSearch_Page;

import com.utc.flowershop.utility.ExcelUtils;
import com.utc.flowershop.utility.Log;
import com.utc.flowershop.utility.Utility;

public class QuickSearch_Action {
	private static WebDriver driver;

	public static void testCase001() {
		try {
			getSearchText(1);
			Log.info("Click Tim performed on Submit button");
		} catch (Exception e) {
			Log.error("Click Tim performed on Submit button" + e.getMessage());
		}
	}

	public static void getSearchText(int row) throws Exception {
		String tim = ExcelUtils.getCellData(row, 2);
		QuickSearch_Page.txtTim().sendKeys(tim);
		QuickSearch_Page.btnTim().click();
	}

	public static void test_pass(int row) throws Exception {
		ExcelUtils.setCellData("Pass", row, 3);
		ExcelUtils.setCellData("", row, 5);
		Log.info("Test Case " + row + " Passed because of Verification");

	}

	public static void test_failed(int row, String message) throws Exception {
		Utility.takeScreenshot(driver, ExcelUtils.getCellData(row, 0));
		ExcelUtils.setCellData("Failed ", row, 3);
		ExcelUtils.setCellData("Failed " + message  , row, 3);
		Log.error("Test Case "+ row + " Failed because of Verification" + message);
	}

}
