package com.HMS.GenericUtilities;


import org.testng.annotations.AfterClass;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.HMS.ObjectRepository.AdminDashboardPage;
import com.HMS.ObjectRepository.AdminLoginPage;

public class BaseClass {
	
	public WebDriverUtility wUtil=new WebDriverUtility();
	public PropertiesUtility pUtil=new PropertiesUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public JavaUtility jUtil=new JavaUtility();
	public DatabaseUtility dbUtil=new DatabaseUtility();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws SQLException {
		dbUtil.connectToDB();
		System.out.println("---connect to db---");
		
	}
	
	//@Parameters("BROWSER")
	
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable {
		String BROWSER = pUtil.getPropertyKeyValue("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {

			driver=new EdgeDriver();
		} else {
			System.out.println("Invalid browser");
		}
         sdriver=driver;
		wUtil.maximizeWindow(driver);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable {
		String URL = pUtil.getPropertyKeyValue("admin_url");
		String USERNAME = pUtil.getPropertyKeyValue("admin_username");
		String PASSWORD = pUtil.getPropertyKeyValue("admin_password");
		driver.get(URL);
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.adminLogin(USERNAME, PASSWORD);
//		DoctorLoginPage dlp=new DoctorLoginPage(driver);
//		dlp.doctorLogin(USERNAME, PASSWORD);	
		
		System.out.println("--login Successfully--");
	}

	@AfterMethod(alwaysRun = true)
	public void configAM() {
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.logOut();
		System.out.println("--Logout successfully--");
	}
	
	@AfterClass(alwaysRun = true)
	public void condigAC() {
		driver.quit();
		System.out.println("---browser closed--");
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws SQLException {
		 dbUtil.closeDB();
		System.out.println("--DB connection closed");
	}
}
