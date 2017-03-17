package com.utc.flowershop.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utc.flowershop.utility.Log;

public class FlowerShop_Page extends TestBase {
	private static WebElement element = null;

	public FlowerShop_Page(WebDriver driver) {
		super(driver);
	}

	public static void getColumTable() {
		WebElement element = driver.findElement(
				By.xpath("html/body/div[1]/div/div[3]/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/form/table/tbody"));
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		System.out.println("Number of rows:" + rows.size());
		for (int rnum = 1; rnum < rows.size()-1 ; rnum++) {
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
			System.out.println("Number of columns:" + columns.size());
			for (int cnum = 0; cnum < columns.size(); cnum++) {
				System.out.println(columns.get(cnum).getText());
			}
		}
	}
	
	public static WebElement linkGioHang() throws Exception {
		try {
			element = driver.findElement(By.linkText("Giỏ Hàng"));
			Log.info(" Gio hang link is found on the Flower Shop");
		} catch (Exception e) {
			Log.error(" Gio hang link is not found on the Flower Shop");
			throw (e);
		}
		return element;
	}

	public static WebElement messNotSignIn() throws Exception {
		try {
			element = driver.findElement(
					By.xpath("html/body/div[1]/div/div[3]/table/tbody/tr/td[1]/div/table/tbody/tr/td/center/span"));
			Log.info(" Message khi khong dang nhap is found on the Flower Shop");
		} catch (Exception e) {
			Log.error(" Message khi khong dang nhap is not found on the Flower Shop");
			throw (e);
		}
		return element;
	}

	public static WebElement linkDangKyTK() throws Exception {
		try {
			element = driver.findElement(By.linkText("Bấm Vào Đây Để Đăng Ký Tài Khoản"));
			Log.info(" Register link is found on the Flower Shop");
		} catch (Exception e) {
			Log.error(" Register link is not found on the Flower Shop");
			throw (e);
		}
		return element;
	}

	public static WebElement linkSanPham() throws Exception {
		try {
			element = driver.findElement(By.linkText("Sản Phẩm"));
			Log.info(" Link San Pham is found on the Flower Shop");
		} catch (Exception e) {
			Log.error(" Link San Pham  is not found on the Flower Shop");
			throw (e);
		}
		return element;
	}

	public static WebElement txtSoLuong() throws Exception {
		try {
			element = driver.findElement(By.name("txtsl0"));
			Log.info(" So luong textbox is found on the Flower Shop");
		} catch (Exception e) {
			Log.error(" So luong textbox  is not found on the Flower Shop");
			throw (e);
		}
		return element;
	}

	public static WebElement link_Update() throws Exception {
		try {
			element = driver.findElement(By.linkText("Cập Nhật Giỏ Hàng"));
			Log.info(" Cap nhat gio hang is found on the Flower Shop");
		} catch (Exception e) {
			Log.error(" Cap nhat gio hang  is not found on the Flower Shop");
			throw (e);
		}
		return element;
	}

	public static WebElement txtTongGioHang() throws Exception {
		try {
			element = driver.findElement(By.xpath("html/body/div[1]/div/div[3]/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/form/table/tbody/tr[3]/td/span[2]"));
			Log.info(" Tong gia tri gio hang is found on the Flower Shop");
		} catch (Exception e) {
			Log.error(" Tong gia tri gio hang  is not found on the Flower Shop");
			throw (e); 
		}
		return element;
	}

	public static WebElement linkDatMua_NgayQuanTrong_TC() throws Exception {
		try {
			element = driver.findElement(By.xpath(
					"html/body/div[1]/div/div[3]/table/tbody/tr/td[1]/div[2]/table/tbody/tr[2]/td/table[1]/tbody/tr/td[2]/table/tbody/tr[2]/td/a[2]"));
			Log.info(" Link Dat Mua Hoa Ngay Quan Trong is found on the San Pham Moi");
		} catch (Exception e) {
			Log.error(" Link Dat Mua Hoa Ngay Quan Trong is not found on the San Pham Moi");
			throw (e);
		}
		return element;
	}

	public static WebElement linkDatMua_HoaCaiAo001_TC() throws Exception {
		try {
			element = driver.findElement(By.xpath(
					"html/body/div[1]/div/div[3]/table/tbody/tr/td[1]/div[2]/table/tbody/tr[2]/td/table[2]/tbody/tr/td[2]/table/tbody/tr[2]/td/a[2]"));
			Log.info(" Link Dat Mua Hoa Cai Ao 001 is found on the San Pham Moi");
		} catch (Exception e) {
			Log.error(" Link Dat Mua Hoa Cai Ao 001is not found on the San Pham Moi");
			throw (e);
		}
		return element;
	}

	public static WebElement linkDatMua_HoaCuoi004_TC() throws Exception {
		try {
			element = driver.findElement(By.xpath(
					"html/body/div[1]/div/div[3]/table/tbody/tr/td[1]/div[2]/table/tbody/tr[2]/td/table[3]/tbody/tr/td[2]/table/tbody/tr[2]/td/a[2]"));
			Log.info(" Link Dat Mua Hoa Cuoi 004 is found on the San Pham Moi");
		} catch (Exception e) {
			Log.error(" Link Dat Mua Hoa Cuoi 004 001is not found on the San Pham Moi");
			throw (e);
		}
		return element;
	}

	public static WebElement linkDatMua_HoaSuKien001_TC() throws Exception {
		try {
			element = driver.findElement(By.xpath(
					"html/body/div[1]/div/div[3]/table/tbody/tr/td[1]/div[2]/table/tbody/tr[2]/td/table[4]/tbody/tr/td[2]/table/tbody/tr[2]/td/a[2]"));
			Log.info(" Link Dat Mua Hoa Su Kien 001 is found on the San Pham Moi");
		} catch (Exception e) {
			Log.error(" Link Dat Mua Hoa Su Kien 001 is not found on the San Pham Moi");
			throw (e);
		}
		return element;
	}

	public static WebElement linkDatMua_HoaCuoi003_TC() throws Exception {
		try {
			element = driver.findElement(By.xpath(
					"html/body/div[1]/div/div[3]/table/tbody/tr/td[1]/div[2]/table/tbody/tr[2]/td/table[5]/tbody/tr/td[2]/table/tbody/tr[2]/td/a[2]"));
			Log.info(" Link Dat Mua Hoa Su Kien 001 is found on the San Pham Moi");
		} catch (Exception e) {
			Log.error(" Link Dat Mua Hoa Su Kien 001 is not found on the San Pham Moi");
			throw (e);
		}
		return element;
	}

	public static WebElement linkDatMua_NgayQuanTrong_SP() throws Exception {
		try {
			element = driver.findElement(By.xpath(
					"html/body/div[1]/div/div[3]/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/table[1]/tbody/tr/td[2]/table/tbody/tr[2]/td/a[2]"));
			Log.info(" Link Dat Mua Hoa Ngay quan trong 001 is found on the San Pham Moi");
		} catch (Exception e) {
			Log.error(" Link Dat Mua Hoa Ngay quan trong 001 is not found on the San Pham Moi");
			throw (e);
		}
		return element;
	}
}
