package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
 @FindBy(name = "username")
 private WebElement UsernameEdit;
 @FindBy(name = "password")
 private WebElement PasswordEdit;
 @FindBy(name = "submit")
 private WebElement SubmitBtn;
 
 
 public AdminLoginPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }

 
public WebElement getUsernameEdit() {
	return UsernameEdit;
}

public WebElement getPasswordEdit() {
	return PasswordEdit;
}

public WebElement getSubmitBtn() {
	return SubmitBtn;
}
 


public void adminLogin(String username,String password) {
	
	UsernameEdit.sendKeys(username);
	PasswordEdit.sendKeys(password);
	SubmitBtn.click();
}
}
