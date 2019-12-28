package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.IndexPage;

public class IndexPageTest extends TestBase{
	
	IndexPage indexPage;
	
	public IndexPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		indexPage = new IndexPage();
		
	}

	@Test (priority=0)
	public void indexPageTest1()
	{
		//Testing Email Address is available
		boolean email = indexPage.validateEmail();
		Assert.assertTrue(email);
		
		//Testing Password is available
		boolean pass = indexPage.validatePass();
		Assert.assertTrue(pass);
		
		//Testing Sign In Button is available
		boolean lgnbtn = indexPage.validateloginbtn();
		Assert.assertTrue(lgnbtn);
		
		//Entering Email Address and Password
		indexPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void indexPageTest2()
	{
		
		//Testing the Size of List Group should be 3
		int i = indexPage.listItemSize();
		Assert.assertEquals(i, 3);
		
		//Testing 2nd Value of ListGroup
		String str = indexPage.listItemText(1);
		Assert.assertEquals(str, "List Item 2 6");
	}
	
	@Test(priority=2)
	public void indexPageTest3()
	{
		//Testing Default value of the Dropdown
		String str = indexPage.getDefaultDropDownValue();
		Assert.assertEquals(str, "Option 1");
		
		
		//Setting Option 3 to the drop down
		indexPage.setDropDown();
	}
	
	@Test(priority=3)
	public void indexPageTest4()
	{
		
		//Testing Button 1 is enabled
		boolean btn1 = indexPage.getBtn1();
		Assert.assertTrue(btn1);
		
		//Testing Button 2 is disabled
		boolean btn2 = indexPage.getBtn2();
		Assert.assertFalse(btn2);
	}
	
	@Test(priority=4)
	public void indexPageTest5()
	{
		//Clicking the button after waiting and testing the message
		String msg = indexPage.clickButton();
		Assert.assertEquals(msg, "You clicked a button!");
		
		//Testing the Button is now visible
		boolean flg = indexPage.getBtnStatus();
		Assert.assertTrue(flg);
	}
	
	@Test(priority=5)
	public void indexPageTest6()
	{
		//This method get the cell value py passing co-ordinates getTableCell(Col,Rows)
		//Asserting that the value of last column and last row
		String value = indexPage.getTableCell(3, 3);
		Assert.assertEquals(value, "Ventosanzap");
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
