package users;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import testbase.BaseClass;

public class CreateUser extends BaseClass{
  @Test
  public void testCreateUser() throws InterruptedException {
	  driver.findElement(By.id("container_users")).click();
	  driver.findElement(By.xpath("//div[text()='New User']")).click();
	  String firstName=xlib.getExcelData("AddUser", 1, 0);
	  String lastName=xlib.getExcelData("AddUser", 1, 1);
	  String eMail=xlib.getExcelData("AddUser", 1, 2);
	  driver.findElement(By.id("createUserPanel_firstNameField")).sendKeys(firstName);
	  driver.findElement(By.id("createUserPanel_lastNameField")).sendKeys(lastName);
	  driver.findElement(By.id("createUserPanel_emailField")).sendKeys(eMail);
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
	  driver.findElement(By.xpath("(//span[text()='Close'])[1]")).click();
	  
	  Thread.sleep(3000);
	  System.out.println("Add User");
  }
}
