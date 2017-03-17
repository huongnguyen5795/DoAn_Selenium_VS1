package com.utc.flowershop.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utc.flowershop.utility.ExcelUtils;
import com.utc.flowershop.utility.Log;

public class Register_Page extends TestBase {
	private static WebElement element = null;
	private static String[] listId = { "tendangnhap", "matkhau", "ho", "ten", "sdt", "email", "diachi" };
	public Register_Page(WebDriver driver) {
		super(driver);
	}
	
	public static WebElement btnLamTrang() throws Exception {
		try {
			element = driver.findElement(By.xpath(".//*[@id='formdangky']/table/tbody/tr[9]/td/input[3]"));
			Log.info("Lam Trang button is found on the Regiter Page");
		} catch (Exception e) {
			Log.error("Lam Trang button is not found on the Regiter Page");
			throw (e);
		}

		return element;
	}
	public static WebElement messMaXN() throws Exception {
		try {
			element = driver.findElement(By.xpath("html/body/div[1]/div/div[3]/table/tbody/tr/td[1]/div/table/tbody/tr/td/center/span"));
			Log.info("Message ma xac nhan is found on the Regiter Page");
		} catch (Exception e) {
			Log.error("Message ma xac nhan is not found on the Regiter Page");
			throw (e);
		}

		return element;
	}
	
	public static WebElement mes_gmail() throws Exception {
		try {
			element = driver.findElement(By.id("loimail"));
			Log.info("Loi gmail message is found on the Regiter Page");
		} catch (Exception e) {
			Log.error("Loi gmail message is not found on the Regiter Page");
			throw (e);
		}

		return element;
	}
	public static WebElement mes_sdt() throws Exception {
		try {
			element = driver.findElement(By.id("loidienthoai"));
			Log.info("Loi dien thoai message is found on the Regiter Page");
		} catch (Exception e) {
			Log.error("Loi dien thoai message is not found on the Regiter Page");
			throw (e);
		}

		return element;
	}

	public static void getDataCustomer(int row) throws Exception {
		for (int i = 0; i < listId.length; i++) {
			setDataTo(row, i + 2, getIdElement(listId[i]));
			Log.info("Send keys Row :" + row + "successfuly");
		}
		String gender = ExcelUtils.getCellData(row, 9);
		dropgioiTinh(gender);

	}
	public static void getDataEmpty(){
		for (int i = 0; i < listId.length; i++) {
			if(getIdElement(listId[i]).getText().equals("")){
				TestBase.bResult=true;
			}else{
				TestBase.bResult=false;
			}
		}
	}

	public static WebElement getIdElement(String idName) {
		WebElement element = driver.findElement(By.id(idName));
		Log.info("Get id element " + idName);
		return element;
	}

	public static void setDataTo(int row, int colum, WebElement element) {
		String result;
		try {
			result = ExcelUtils.getCellData(row, colum);
			Log.info("Get excel row :" + row + ", colm:	" + colum);
			element.sendKeys(result);
		} catch (Exception e) {
			Log.error("Sendkeys not successfuly");
			e.printStackTrace();
		}
	}

	public static String dropgioiTinh(String nameGT) throws Exception {
		try {
			Select dropDown = new Select(driver.findElement(By.name("gioitinh")));
			// dropDown.selectByIndex(iSize);
			dropDown.selectByVisibleText(nameGT);
			Log.info("Gioi tinh dropdown is found on the Regiter Page");
		} catch (Exception e) {
			Log.error("Gioi tinh dropdown is not found on the Regiter Page");
			throw (e);
		}
		return nameGT;
	}


	public static WebElement txtMaXacNhan() throws Exception {
		try {
			element = driver.findElement(By.name("code"));
			Log.info("Ma xax nhan text box is found on the Regiter Page");
		} catch (Exception e) {
			Log.error("Ma xac nhan text box is not found on the Regiter Page");
			throw (e);
		}

		return element;
	}

	public static WebElement btnTrangForm() throws Exception {
		try {
			element = driver.findElement(By.xpath(".//*[@id='formdangky']/table/tbody/tr[9]/td/input[3]"));
			Log.info("Lam trang form text box is found on the Regiter Page");
		} catch (Exception e) {
			Log.error("Lam trang form text box is not found on the Regiter Page");
			throw (e);
		}

		return element;
	}

	public static WebElement btnDangKy() throws Exception {
		try {
			element = driver.findElement(By.xpath(".//*[@id='formdangky']/table/tbody/tr[9]/td/input[4]"));
			Log.info("Submit dang ky button is found on the Regiter Page");
		} catch (Exception e) {
			Log.error("Submit dang ky button is not found on the Regiter Page");
			throw (e);
		}

		return element;
	}

	public static WebElement error_TenDN() throws Exception {
		try {
			element = driver.findElement(By.xpath(".//*[@id='loitendangnhap']"));
			Log.info("Messegae error ten dang nhap is found on the Regiter Page");
		} catch (Exception e) {
			Log.error("Messegae error ten dang nhap is not found on the Regiter Page");
			throw (e);
		}

		return element;
	}

}
