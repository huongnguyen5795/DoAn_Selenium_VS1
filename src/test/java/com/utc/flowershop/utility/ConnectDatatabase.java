package com.utc.flowershop.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.utc.flowershop.pageobject.TestBase;

public class ConnectDatatabase {
	private static Connection connect;
	private static Statement statement;
	
	public static void connectToDB() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/hoa", "root", "");
			Log.info("Connect database susscessfully");
			TestBase.bResult = true;

		} catch (Exception e) {
			Log.error("Connect database not susscessfully" + e.getMessage());
			throw e;
		}
	}

	public static void readTenDN(String tenDN) throws Exception {
		try {
			statement = connect.createStatement();
			ResultSet res = statement.executeQuery("SELECT ten_dn FROM khach_hang ");
			ArrayList<String> listNames = new ArrayList<String>();
			while (res.next()) {
				listNames.add(res.getString("ten_dn"));
			}
			if (checkNameYesOrNo(listNames, tenDN)) {
				Log.info("Ten dang nhap " + tenDN + " ton tai");
				TestBase.bResult = true;
			} else {
				Log.error("Ten dang nhap " + tenDN + " khong ton tai");
				TestBase.bResult = false;
			}
		} catch (Exception e) {
			Log.error("Kiem tra ten dang nhap khong thanh cong" + e.getMessage());
			throw e;
		}
	}

	public static boolean checkNameYesOrNo(ArrayList<String> array, String name) {
		for (int i = 0; i < array.size(); i++) {
			// System.out.println(array.get(i));
			if (array.get(i).equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static void read_First_Last_Name(String ho, String ten) throws Exception {
		try {
			statement = connect.createStatement();
			ResultSet res = statement.executeQuery("SELECT ho_kh, ten_kh FROM khach_hang ");
			ArrayList<String> listFirstName = new ArrayList<String>();
			ArrayList<String> listLastName = new ArrayList<String>();
			while (res.next()) {
				listFirstName.add(res.getString("ho_kh"));
				listLastName.add(res.getString("ten_kh"));
			}
			if ((checkNameYesOrNo(listFirstName, ho)) && (checkNameYesOrNo(listLastName, ten))) {
				Log.info("Ho :" + ho + "ten :" + ten + " da duoc them thanh cong vao CSDL ");
				TestBase.bResult = true;
			} else {
				Log.error("Ho :" + ho + "ten :" + ten + " chua duoc them thanh cong vao CSDL ");
				TestBase.bResult = false;
			}
		} catch (Exception e) {
			Log.error("Kiem tra ho va ten khach hang khong thanh cong" + e.getMessage());
			throw e;
		}
	}

	public static void read_phoneNumber(int sdt) throws Exception {
		try {
			statement = connect.createStatement();
			ResultSet res = statement.executeQuery("SELECT sdt FROM khach_hang ");
			ArrayList<Integer> listPhone = new ArrayList<Integer>();
			while (res.next()) {
				listPhone.add(Integer.parseInt(res.getString("sdt")));
			}
			System.out.println(listPhone);
			if (checkNameYesOrNo(listPhone, sdt)) {
				Log.info("Sdt :" + sdt + " da duoc them thanh cong vao CSDL ");
				TestBase.bResult = true;
			} else {
				Log.error("SDT :" + sdt  + " chua duoc them thanh cong vao CSDL ");
				TestBase.bResult = false;
			}
		} catch (Exception e) {
			Log.error("Kiem tra ho va ten khach hang khong thanh cong" + e.getMessage());
			throw e;
		}

	}
	
	public static void read_gmail(String gmail) throws Exception {
		try {
			statement = connect.createStatement();
			ResultSet res = statement.executeQuery("SELECT email FROM khach_hang ");
			ArrayList<String> listNames = new ArrayList<String>();
			while (res.next()) {
				listNames.add(res.getString("email"));
			}
//			if (checkNameYesOrNo(listNames, tenDN)) {
//				Log.info("Ten dang nhap " + tenDN + " ton tai");
//				TestBase.bResult = true;
//			} else {
//				Log.error("Ten dang nhap " + tenDN + " khong ton tai");
//				TestBase.bResult = false;
//			}
		} catch (Exception e) {
			Log.error("Kiem tra ten dang nhap khong thanh cong" + e.getMessage());
			throw e;
		}
	}

	public static boolean checkNameYesOrNo(ArrayList<Integer> array, int sdt) {
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) == sdt) {
				return true;
			}
		}
		return false;
	}

	public static void closeDB() throws SQLException {
		connect.close();
	}

}
