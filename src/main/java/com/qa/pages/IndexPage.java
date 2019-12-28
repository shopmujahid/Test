package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class IndexPage extends TestBase{

	
	WebDriverWait wdw = new WebDriverWait(driver,20);
	
	//Page Factory or Object Repository
	
	@FindBy(id="inputEmail")
	WebElement email;
	
	@FindBy(id="inputPassword")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	WebElement loginbtn;
	
	@FindBy(xpath="//li[@class='list-group-item justify-content-between']")
	List<WebElement> listElements;
		
	@FindBy(xpath="//button[@id='dropdownMenuButton']")
	WebElement dropDownBtn;
	
	@FindBy(xpath="//a[@class='dropdown-item']")
	List<WebElement> dropDownElements;
	
	@FindBy(xpath="//div[@id='test-4-div']//button[@class='btn btn-lg btn-primary']")
	WebElement btn1;
	
	@FindBy(xpath="//div[@id='test-4-div']//button[@class='btn btn-lg btn-secondary']")
	WebElement btn2;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-primary' and @id ='test5-button']")
	WebElement btn;
	
	@FindBy(id="test5-alert")
	WebElement msg;
	
	@FindBy(xpath="//table[@class='table table-bordered table-dark']//thead/tr/th")
	List<WebElement> columns;
	
	@FindBy(xpath="//table[@class='table table-bordered table-dark']//tbody/tr/td[1]")
	List<WebElement> rows;
	
	public IndexPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public boolean validateEmail()
	{
		return email.isDisplayed();
	}
	
	public boolean validatePass()
	{
		return password.isDisplayed();
	}
	
	public boolean validateloginbtn()
	{
		return loginbtn.isDisplayed();
	}
	
	public void validateLogin(String usr, String pwd)
	{
		email.sendKeys(usr);
		password.sendKeys(pwd);
		loginbtn.click();
	}
	
	public int listItemSize()
	{
		return listElements.size();
	}
	
	public String listItemText(int i)
	{
		return listElements.get(i).getText();
	}
	
	public String getDefaultDropDownValue()
	{
		return dropDownBtn.getText();
	}
	
	public void setDropDown()
	{
		dropDownBtn.click();
		for(int i =0; i<dropDownElements.size(); i++)
		{
			if(dropDownElements.get(i).getText().contains("Option 3"))
			{
				dropDownElements.get(i).click();
				break;
			}
		}
	}
	
	public boolean getBtn1()
	{
		return btn1.isEnabled();
	}
	
	public boolean getBtn2()
	{
		return btn2.isEnabled();
	}
	
	public String clickButton()
	{
		String mesg="";
		
		wdw.until(ExpectedConditions.visibilityOf(btn));
		boolean status = btn.isDisplayed();
		if(status)
		{
			btn.click();
			mesg= msg.getText();
		}
		return mesg;
	}
	
	public boolean getBtnStatus()
	{
		return btn.isDisplayed();
	}
	
	public String getTableCell(int c, int r)
	{
		String value="";
		if((c >0 && c<=columns.size()) && (r>0 && r<=rows.size()))
		{
		value= driver.findElement(By.xpath("//table[@class='table table-bordered table-dark']//tbody/tr["+c+"]/td["+r+"]")).getText();
		}else
		{
			value="Invalid Data";
			
		}
		return value;
		
	}

}
