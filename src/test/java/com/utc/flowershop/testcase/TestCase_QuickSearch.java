package com.utc.flowershop.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.utc.flowershop.pageobject.TestBase;
import com.utc.flowershop.utility.Constant;
import com.utc.flowershop.utility.ExcelUtils;
import com.utc.flowershop.utility.Log;
import com.utc.flowershop.utility.Utility;

public class TestCase_QuickSearch {
	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("QuickSearch");
		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, "QuickSearch");
		Log.info("Excel sheet opened");
		String browserName = ExcelUtils.getCellData(1, 4);
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

//	@Test(priority = 1)
//	public void quickSearch_TC1() throws Exception {
//		try {
//			QuickSearch_Action.testCase001();
//			
//		} catch (Exception e) {
//			ExcelUtils.setCellData("Fail", 1, 4);
//			Utility.takeScreenshot(driver, ExcelUtils.getCellData(1, 0));
//			Log.error(e.getMessage());
//			throw (e);
//		}
//
//	}

	@AfterMethod
	public void afterMethod() {
		Log.endTestCase("QuickSearch");
		driver.quit();

	}

}
