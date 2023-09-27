package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorSpecializationPage {
 @FindBy(name = "doctorspecilization")
 private WebElement DoctorSpclEdt;
 
 @FindBy(name = "submit")
 private WebElement SubmitBtn;
 
 
 public AddDoctorSpecializationPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }


public WebElement getDoctorSpclEdt() {
	return DoctorSpclEdt;
}


public WebElement getSubmitBtn() {
	return SubmitBtn;
}
 
public void AddDoctorSpecialization(String specialization)
{
	DoctorSpclEdt.sendKeys(specialization);
	SubmitBtn.click();
}
 
}
