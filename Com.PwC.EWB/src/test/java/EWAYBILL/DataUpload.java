package EWAYBILL;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class DataUpload extends Login
{
	@Test
	public static void FileUpload() throws InterruptedException, IOException
	{
		
         Element = driver.findElement(By.xpath(".//*[@id='containerMenuDiv']/div[2]/div/div/ul[2]/li[2]/a"));
		 
	     Actions DataUpload = new Actions(driver);
	     DataUpload.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//*[@id=\"lnkDataUpload\"]")).click();
	     Thread.sleep(2000);
		 
	     Select Source = new Select(driver.findElement(By.xpath("//*[@id='dropdownMenu1']")));
	     Source.selectByIndex(4);
	     
	     Select Category = new Select(driver.findElement(By.xpath("//*[@id='dropdownMenu2']")));
	     Category.selectByIndex(2);
	     
	     Select Data_Type = new Select(driver.findElement(By.xpath("//*[@id='dropdownMenu3']")));
	     Data_Type .selectByIndex(2);
	     
	     driver.findElement(By.xpath("//INPUT[@id='dropdownMenu5']")).click();
	     
	     Runtime.getRuntime().exec("E:\\FileUpload\\Fileupload.exe");
	     
	     Thread.sleep(2000);
	     
	     //driver.findElement(By.xpath("//*[@id='upload_data_btn']")).click();
	}
	

}
