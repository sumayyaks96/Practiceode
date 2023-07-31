package com.synctric.SampleTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	public WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	public  void initializeBrowser(){
		System.setProperty("webdriver.edge.driver","C:\\Users\\hp\\eclipse-workspace\\SampleTest\\src\\main\\java\\Resources\\msedgedriver.exe");
		driver =new EdgeDriver();
		driver.get("https://mail.google.com/mail/u/0/#inbox/");
	}
	@AfterMethod
	public void browserQuit() {
		driver.quit();
	}
	
}



