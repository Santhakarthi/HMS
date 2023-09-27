package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {
    //declaration
	@FindBy(name = "username")
	private WebElement UserNameEdit;
	@FindBy(name = "password")
	private WebElement PasswordEdit;
	@FindBy(name = "submit")
	private WebElement SubmitBtn;
	
	//initialization
	public DoctorLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	
	//utilization
	public WebElement getUserNameEdit() {
		return UserNameEdit;
	}

	public WebElement getPasswordEdit() {
		return PasswordEdit;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	public void doctorLogin(String UN,String PWD)
	{
		UserNameEdit.sendKeys(UN);
		PasswordEdit.sendKeys(PWD);
		SubmitBtn.click();
	}
	
}
