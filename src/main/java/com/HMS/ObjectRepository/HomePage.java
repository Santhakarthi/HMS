package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//declaration
	@FindBy(xpath = "//a[text()='Click Here']/ancestor::div/descendant::h3[text()='Patients']")
    private WebElement PatientsLink;
	
	@FindBy(xpath = "//a[text()='Click Here']/ancestor::div/descendant::h3[text()='Doctors Login']")
	private WebElement DoctorsLoginLink;
	
	@FindBy(xpath = "//a[text()='Click Here']/ancestor::div/descendant::h3[text()='Admin Login']")
	private WebElement AdminLoginLink;
	
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
    //utilization
	public WebElement getPatientsLink() {
		return PatientsLink;
	}


	public WebElement getDoctorsLoginLink() {
		return DoctorsLoginLink;
	}


	public WebElement getAdminLoginLink() {
		return AdminLoginLink;
	}
	
	//business Library
	
	
	public void clickOnAdminLink()
	{
		DoctorsLoginLink.click();
	}
	
	public void clickOnDoctorLink()
	{
		DoctorsLoginLink.click();
	}
	
	public void clickOnPatientLink()
	{
		PatientsLink.click();
	}
	
	
	
	
	
	
	
}
