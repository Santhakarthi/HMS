package com.HMS.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HMS.GenericUtilities.WebDriverUtility;

public class AddDoctorPage extends WebDriverUtility {

	@FindBy(name = "Doctorspecialization")
	private WebElement DoctorSpclDD;
	
	@FindBy(name = "docname")
	private WebElement DoctorNameEdt;
	
	@FindBy(name = "clinicaddress")
	private WebElement ClinicAddressEdt;
	
	@FindBy(name = "docfees")
	private WebElement DoctorFeeEdt;
	
	@FindBy(name = "doccontact")
	private WebElement DoctorContactEdt;
	
	@FindBy(name = "docemail")
	private WebElement DoctorMailEdt;
	
	@FindBy(name = "npass")
	private WebElement PasswordEdt;
	
	@FindBy(name = "cfpass")
	private WebElement ConfirmPwdEdt;
	
	@FindBy(name = "submit")
	private WebElement SubmitBtn;
	
	public AddDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDoctorSpclDD() {
		return DoctorSpclDD;
	}

	public WebElement getDoctorNameEdt() {
		return DoctorNameEdt;
	}

	public WebElement getClinicAddressEdt() {
		return ClinicAddressEdt;
	}

	public WebElement getDoctorFeeEdt() {
		return DoctorFeeEdt;
	}

	public WebElement getDoctorContactEdt() {
		return DoctorContactEdt;
	}

	public WebElement getDoctorMailEdt() {
		return DoctorMailEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getConfirmPwdEdt() {
		return ConfirmPwdEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	
	public void AddDoctor(WebDriver driver,HashMap<String, String> map,String dd)
	{

		for (Entry<String, String> s:map.entrySet()) {
			
			
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			
		}
		
		//SubmitBtn.click();
		
	}
}
