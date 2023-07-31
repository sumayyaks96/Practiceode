package com.synctric.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.synctric.utilities.WaitUtility;
import com.synctric.utilities.ExcelUtility;
import com.synctric.utilities.PageUtility;

public class InboxPage {
	WebDriver driver;
	public InboxPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='gb_Ae aJh' and @placeholder='Search mail' ]")
	private WebElement searchmail;
	
	@FindBy(xpath="//span[@class='T-Jo J-J5-Ji T-Jo-auq T-Jo-iAfbIe']")
	private WebElement checkbox;
	
	@FindBy(xpath="//span[@id=':1t6']")
	private WebElement selectAll;
	

	@FindBy(xpath="(//div[@class='bAO T-I-J3 J-J5-Ji'])[2]")
	private WebElement markAsRead;
	
	@FindBy(xpath="//td[@class='TC']")
	private WebElement UnreadMessage;
	
	@FindBy(xpath="(//span[@class='Dj'])[2]")
	private WebElement InboxField;
	
	@FindBy(xpath="")
	private WebElement UpdatedUnreadMsgCount;

		public void unreadMessageCount() throws IOException {
		String ExpectedReadMsg =ExcelUtility.getString(0, 2, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"InboxPage");
		String actualReadMsg,actualMsg;
		String searchMsg =ExcelUtility.getString(0, 0, System.getProperty("user.dir") +constants.Constants.EXCELFILE,"InboxPage");
		driver.manage().window().maximize();
		boolean searchDisplayed=searchmail.isDisplayed();
		Assert.assertTrue(searchDisplayed,"search is not displayed");
		PageUtility.enterText(searchmail, searchMsg);
		PageUtility.clickOnElement(checkbox);
		if(checkbox.isSelected()) {
			PageUtility.clickOnElement(selectAll);
			WaitUtility.waitForElementClickable(driver, markAsRead);
			PageUtility.clickOnElement(markAsRead);
			driver.switchTo().alert().accept();
		}
		actualReadMsg=UnreadMessage.getText();
		Assert.assertEquals(ExpectedReadMsg, actualReadMsg,"search not possible");
		PageUtility.clickOnElement(InboxField);
		PageUtility.enterText(searchmail, searchMsg);
		PageUtility.clickOnElement(checkbox);
		actualMsg=UpdatedUnreadMsgCount.getText();
		
		
	
	
	
	
	
		}	

}
