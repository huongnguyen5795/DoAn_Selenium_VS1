package com.utc.flowershop.utility;

import java.io.File;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class Utility {
	public static WebDriver driver = null ;
//conhuong cho thui
	public static WebDriver openBrowser(String browserName) throws Exception {
		try {
//			browserName = ExcelUtils.getCellData(1,5);
			if (browserName.equals("Mozilla")) {
				driver = new FirefoxDriver();
				Log.info("New driver instantiated");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 20 seconds");
				driver.manage().window().maximize();
				Log.info("Browser full screen");
				driver.get(Constant.url);
				Log.info("Web application launched successfully");
			}
		} catch (Exception e) {
			Log.error("Class Utils | Method OpenBrowser | Exception desc : " + e.getMessage());
		}
		return driver;
	}

	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			Log.error("Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());
			throw (e);
		}
	}

	public static void waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void takeScreenshot(WebDriver driver,String testCaseName) throws Exception {
		
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constant.pathScreenShots + testCaseName +"_"+ System.currentTimeMillis()+ ".jpg"));
		} catch (Exception e) {
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "
					+ e.getMessage());
			throw new Exception();
		}
	}
	
//	public static String formatDate(){
//		Log.info("nhay vao");
//		long yourmilliseconds = System.currentTimeMillis();
//		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");    
//		Date resultdate = new Date(yourmilliseconds);
//		System.out.println(sdf.format(resultdate));
//		return sdf.format(resultdate);
//	}

}
