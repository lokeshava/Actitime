package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import testbase.BaseClass;

public class DeleteCustomer extends BaseClass{
	@Test
	public void testDeleteCustomer() throws InterruptedException {
		driver.findElement(By.id("container_tasks")).click();
		String custName=xlib.getExcelData("DeleteCustomer", 1, 0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys(custName);
		WebElement custNameLink=driver.findElement(By.xpath("//span[@class='highlightToken']"));
		WebElement custNameSettingsButton=driver.findElement(By.xpath("//span[text()='"+custName+"']/../../..//div[@class='editButton']"));
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(custNameLink).perform();
		act.moveToElement(custNameSettingsButton).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='"+custName+"']/../../..//div[@class='editButton']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='ACTIONS'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='Delete'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();
		Thread.sleep(5000);
		System.out.println("Deleted Customer");
	}
}
