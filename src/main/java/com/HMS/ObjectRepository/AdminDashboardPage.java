package com.HMS.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
	@FindBy(xpath = "//span[text()=' Doctors ']")
	private WebElement DoctorsLink;
	
	@FindBy(xpath = "//span[text()=' Doctor Specialization ']")
	private WebElement DoctorSpclLink;
	
	@FindBy(xpath = "//span[text()=' Add Doctor']")
	private WebElement AddDoctorLink;
	
	public WebElement getDoctorsLink() {
		return DoctorsLink;
	}

	public WebElement getManageDoctorsLink() {
		return manageDoctorsLink;
	}

	@FindBy(xpath = "//span[text()=' Manage Doctors ']")
	private WebElement manageDoctorsLink;
	
	public WebElement getAdminDD() {
		return adminDD;
	}

	public WebElement getLogOutLink() {
		return logOutLink;
	}

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement adminDD;
	
	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logOutLink;
	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddDoctorLink() {
		return AddDoctorLink;
	}

	public WebElement getDoctorLink() {
		return DoctorsLink;
	}

	public WebElement getDoctorSpclLink() {
		return DoctorSpclLink;
	}
 
	/**
	 * This method will click on doctor link
	 */
	public void clickOnDoctorsLink() {
		DoctorsLink.click();
	}
	
	/**
	 * This method will click on Doctor Specialization link
	 */
	public void clickOnDoctorSpclLink() {
		DoctorSpclLink.click();
		
	}
	
	/**
	 * This method will click on Add Doctor link
	 */
	public void clickOnAddDoctorLink() {
		AddDoctorLink.click();
	}
	
	/**
	 * This method will logout the admin page
	 */
	
	/**
	 * This method will click on Manage doctors link
	 */
	public void clickonMagageDoctors() {
		manageDoctorsLink.click();
	}
	
	
	public void logOut() {
		adminDD.click();
		logOutLink.click();
	}
}
