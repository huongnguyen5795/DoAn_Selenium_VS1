package com.utc.flowershop.appmodules;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Reporter;

import com.utc.flowershop.pageobject.LogIn_Page;
import com.utc.flowershop.pageobject.TestBase;
import com.utc.flowershop.utility.ExcelUtils;
import com.utc.flowershop.utility.Log;
import com.utc.flowershop.utility.Utility;

public class SignIn_Action {
	public static WebDriver driver;

	public static void testCase1() throws Exception {
		String userName = ExcelUtils.getCellData(1, 2);
		Log.info("User name picked from Excel is " + userName);
		String passWord = ExcelUtils.getCellData(1, 3);
		Log.info("Pass word picked from Excel is " + passWord);
		LogIn_Page.txt_UserName().sendKeys(userName);
		Log.info("User name entered in the Username text box");
		LogIn_Page.txt_Password().sendKeys(passWord);
		Log.info("Pass word entered in the Password text box");
		LogIn_Page.btn_LogIn().click();
		Log.info("Click action performed on Submit button");
		Reporter.log("SignIn Action is successfully perfomred");
		// Thread.sleep(10000);
	}

	public static void testCase2() throws Exception {
		String userName = ExcelUtils.getCellData(2, 2);
		Log.info("User name picked from Excel is " + userName);
		String passWord = ExcelUtils.getCellData(2, 3);
		Log.info("Pass word picked from Excel is " + passWord);
		LogIn_Page.txt_UserName().sendKeys(userName);
		Log.info("User name entered in the Username text box");
		LogIn_Page.txt_Password().sendKeys(passWord);
		Log.info("Pass word entered in the Password text box");
		LogIn_Page.btn_LogIn().click();
		Log.info("Click action performed on Submit button");
		Reporter.log("SignIn Action is not successfully perfomred");
		// Thread.sleep(10000);
	}

	public static void testCase3() throws Exception {
		String userName = ExcelUtils.getCellData(3, 2);
		Log.info("User name picked from Excel is " + userName);
		String passWord = ExcelUtils.getCellData(3, 3);
		Log.info("Pass word picked from Excel is " + passWord);
		LogIn_Page.txt_UserName().sendKeys(userName);
		Log.info("User name entered in the Username text box");
		LogIn_Page.txt_Password().sendKeys(passWord);
		Log.info("Pass word entered in the Password text box");
		LogIn_Page.btn_LogIn().click();
		Log.info("Click action performed on Submit button");
		Reporter.log("SignIn Action is not successfully perfomred");
		// Thread.sleep(10000);
	}

	public static void testCase4() throws Exception {
		String userName = ExcelUtils.getCellData(4, 2);
		Log.info("User name picked from Excel is " + userName);
		String passWord = ExcelUtils.getCellData(4, 3);
		Log.info("Pass word picked from Excel is " + passWord);
		LogIn_Page.txt_UserName().sendKeys(userName);
		Log.info("User name entered in the Username text box");
		LogIn_Page.txt_Password().sendKeys(passWord);
		Log.info("Pass word entered in the Password text box");
		LogIn_Page.btn_LogIn().click();
		Log.info("Click action performed on Submit button");
		Reporter.log("SignIn Action is not successfully perfomred");
		// Thread.sleep(10000);
	}
	
	
	public static void enterUser() throws Exception{
		LogIn_Page.txt_UserName().sendKeys(getUserName_TC6());
		if (getUserName_TC6().length() <= 30) {
			Log.info("User name entered pass in the Username text box");
		}else{
			TestBase.bResult=false;
			Log.error("User name not entered in the Username text box");
		}
		
	}
	public static void enterPass() throws Exception{
		LogIn_Page.txt_Password().sendKeys(getPass_TC6());
		if (getPass_TC6().length() <= 30) {
			Log.info("Pass word entered in the Username text box");
		}else{
			TestBase.bResult=false;
			Log.error("Pass word not entered in the Username text box");
		}
		
	}

	public static void check_text() throws Exception {
		try {

			String tenDN = driver
					.findElement(By
							.xpath("html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/table[1]/tbody/tr[2]/td/form/table/tbody/tr[2]/td[1]/span"))
					.getText();
			String pass = driver
					.findElement(By
							.xpath("html/body/div[1]/div/div[3]/table/tbody/tr/td[2]/table[1]/tbody/tr[2]/td/form/table/tbody/tr[3]/td[1]/span"))
					.getText();

			if (tenDN.equals("Tên ĐN")) {
				Log.info("Check text successfull Tên ĐN ");
				if (pass.equals("Mật Khẩu")) {
					Log.info("Check text successfull Mật Khẩu");
					Reporter.log("Check text successfull form DangNhap ");
					
				} else {
					Log.error("MK Failed because of Verification");
					TestBase.bResult = false;

				}
			} else {
				TestBase.bResult = false;
				Log.error("DN Case Failed because of Verification");
			}

		} catch (Exception e) {
			TestBase.bResult = false;
			ExcelUtils.setCellData("Failed", 7, 4);
			Utility.takeScreenshot(driver, ExcelUtils.getCellData(7, 0));
			Log.error("Check text not  successfull " + e.getMessage());
		}

	}

	public static void check_linkDangKy() throws Exception {
		try {
			if (LogIn_Page.link_dangKy().isDisplayed()) {
				Log.info("Exist link Dang Ky");
				LogIn_Page.link_dangKy().click();
				Log.info("Click Link Dang Ky");
				String titleDangKy = driver.getTitle();
				Log.info("Get title Dang ky");
				if (titleDangKy.equals("dangky")) {
					Log.info("Check successfull link Dang ky");
					Reporter.log("Check text successfull link dang ky ");
					
				}else{
					TestBase.bResult=false;
					Log.error("Check not successfull link Dang ky");	
				}
			}
		} catch (Exception e) {
			TestBase.bResult = false;
			ExcelUtils.setCellData("Fail", 7, 4);
			Utility.takeScreenshot(driver, ExcelUtils.getCellData(7, 0));
			Log.error("Check not successfull link Dang ky " + e.getMessage());
		}
	}

	public static void check_linkFoundPass() throws Exception {
		try {
			if (LogIn_Page.link_foundPass().isDisplayed()) {
				Log.info("Exist link quyen mat khau");
				LogIn_Page.link_foundPass().click();
				Log.info("Click Link quen mat khau");
				String titleTimPass = driver.getTitle();
				Log.info("Get title quyen mat khau");
				if (titleTimPass.equals("timmatkhau")) {
					Log.info("Check successfull link quen pass");
					Reporter.log("Check text successfull link quen pass ");
					
				}else{
					TestBase.bResult=false;
					Log.error("Check not successfull link quen pass");		
				}
			}
		} catch (Exception e) {
			TestBase.bResult = false;
			ExcelUtils.setCellData("Fail", 7, 4);
			Utility.takeScreenshot(driver, ExcelUtils.getCellData(7, 0));
			Log.error("Check not successfull link quen mat khau " + e.getMessage());
		}
	}
	
	public static String getUserName_TC6(){
	 String userName=null;
	 try {
	 userName = ExcelUtils.getCellData(6, 2);
	 Log.info("User name picked from Excel is " + userName);
	 } catch (Exception e) {
	 Log.error("Username not get cell data"+ e.getMessage());
	 }
	
	 return userName;
	 }
	public static String getPass_TC6(){
		 String pass=null;
		 try {
		 pass = ExcelUtils.getCellData(6, 3);
		 Log.info("User name picked from Excel is " + pass);
		 } catch (Exception e) {
		 Log.error("Username not get cell data"+ e.getMessage());
		 }
		
		 return pass;
		 }

}
