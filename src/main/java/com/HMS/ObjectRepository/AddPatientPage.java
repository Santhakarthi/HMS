package com.HMS.ObjectRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HMS.GenericUtilities.WebDriverUtility;


public class AddPatientPage extends WebDriverUtility {
	@FindBy(name = "patname")
	private WebElement PatNameEdt;
	
	@FindBy(name = "patcontact")
	private WebElement PatContactEdt;
	
	@FindBy(name = "patemail")
	private WebElement PatEmailEdt;
	
	@FindBy(name = "pataddress")
	private WebElement PatAddressEdt;
	
	@FindBy(name = "patage")
    private WebElement PatAgeEdt;
	
	@FindBy(xpath = "//div[@class='clip-radio radio-primary']/label[@for='rg-male']")
	private WebElement MaleRadioBtn;
	
	@FindBy(xpath = "//div[@class='clip-radio radio-primary']/label[@for='rg-female']")
	private WebElement FemaleRadioBtn;
	
	@FindBy(name = "medhis")
	private WebElement MediHisEdt;
	
	@FindBy(name = "submit")
	private WebElement SubmitBtn;
	
	public AddPatientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	
	public WebElement getPatNameEdt() {
		return PatNameEdt;
	}

	public WebElement getPatContactEdt() {
		return PatContactEdt;
	}

	public WebElement getPatEmailEdt() {
		return PatEmailEdt;
	}

	public WebElement getPatAddressEdt() {
		return PatAddressEdt;
	}


	public WebElement getPatAgeEdt() {
		return PatAgeEdt;
	}

	public WebElement getMaleRadioBtn() {
		return MaleRadioBtn;
	}

	public WebElement getFemaleRadioBtn() {
		return FemaleRadioBtn;
	}


	public WebElement getMediHisEdt() {
		return MediHisEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public void AddPatient(WebDriver driver,HashMap<String, String> map) {

		for(Entry<String, String> s:map.entrySet())
		{
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
//		PatNameEdt.sendKeys(name);
//		PatContactEdt.sendKeys(contact);
//		PatEmailEdt.sendKeys(mail);
		MaleRadioBtn.click();
//		PatAddressEdt.sendKeys(address);
//		PatAgeEdt.sendKeys(age);
//		MediHisEdt.sendKeys(mediHis);
		SubmitBtn.click();
		
	}
}
