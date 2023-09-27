package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HMS.GenericUtilities.WebDriverUtility;

public class DoctorDashBoardPage extends WebDriverUtility {
	@FindBy(xpath = "//span[text()=' Dashboard ']")
	private WebElement DashBoardLink;
	
	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement  AppointmentHistoryLink;
	
	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement PatientsDD;
	
	
	@FindBy(xpath = "//span[text()=' Search ']")
	private WebElement SearchLink;
    
	public WebElement getAddPatient() {
		return AddPatient;
	}


	@FindBy(xpath = "//span[text()=' Add Patient']")
	private WebElement AddPatient;
	
	
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-dark']")
	private WebElement doctorDD;
	
	public WebElement getLogOutLink() {
		return logOutLink;
	}


	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logOutLink;
	
	public DoctorDashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getDoctorDD() {
		return doctorDD;
	}


	public WebElement getDashBoardLink() {
		return DashBoardLink;
	}


	public WebElement getAppointmentHistoryLink() {
		return AppointmentHistoryLink;
	}


	public WebElement getPatientsDD() {
		return PatientsDD;
	}


	public WebElement getSearchLink() {
		return SearchLink;
	}
	
	
	public void logOut() {
		doctorDD.click();
		logOutLink.click();
	
	}
}









