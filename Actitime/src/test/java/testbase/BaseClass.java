package testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public ExcelLibrary xlib;

  @BeforeClass
  public void openBrowser() {
	 driver=new FirefoxDriver();
	 driver.manage().window().maximize();
	 driver.get("https://demo.actitime.com/login.do");
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
  }
  @BeforeMethod
  public void login() throws InterruptedException {
	  xlib=new ExcelLibrary();
	  String un=xlib.getExcelData("Login", 1, 0);
	  String pw=xlib.getExcelData("Login", 1, 1);
	  driver.findElement(By.name("username")).sendKeys(un);
	  driver.findElement(By.name("pwd")).sendKeys(pw);
	  driver.findElement(By.xpath("//div[text()='Login ']")).click();
	  Thread.sleep(10000);
	  System.out.println("Login");
  }
  
  @AfterMethod
  public void logout() {
	  driver.findElement(By.id("logoutLink")).click();
	  System.out.println("Logout");
  }
  
  @AfterClass
  public void closeBrowser() {
	  driver.close();
	  System.out.println("Browser Closed");
  }
}
