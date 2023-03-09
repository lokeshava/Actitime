package users;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import testbase.BaseClass;

public class DeleteUser extends BaseClass{
  @Test
  public void testDeleteUser() throws InterruptedException {
	  driver.findElement(By.id("container_users")).click();
	  String firstName=xlib.getExcelData("AddUser", 1, 0);
	  driver.findElement(By.xpath("//span[contains(text(),'"+firstName +"')]")).click();
	  driver.findElement(By.xpath("//div[text()='DELETE']")).click();
	  driver.switchTo().alert().accept();
	  Thread.sleep(10000);
	  System.out.println("Delete User");
  }
}
