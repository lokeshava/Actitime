package tasks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import testbase.BaseClass;

public class CreateCustomer extends BaseClass{
  @Test
  public void testCreateCustomer() throws InterruptedException {
	  driver.findElement(By.id("container_tasks")).click();
	  driver.findElement(By.xpath("//div[text()='Add New']")).click();
	  driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
	  String cn=xlib.getExcelData("CreateCustomer", 1, 0);
	  String ds=xlib.getExcelData("CreateCustomer", 1, 1);
	  driver.findElement(By.xpath("(//input[@placeholder='Enter Customer Name'])[2]")).sendKeys(cn);
	  driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(ds);
	  driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
	  Thread.sleep(10000);
	  System.out.println("Create Customer");
  }
}
