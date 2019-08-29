package EWAYBILL;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LogOut extends Login
{
	@Test
	public static void ClickOnLogout() throws InterruptedException 
	{
		 WebDriverWait wait = new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//A[@id='idlogout']")));
		driver.findElement(By.xpath("//A[@id='idlogout']")).click();
		
		 WebDriverWait wait1 = new WebDriverWait(driver,15);
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//BUTTON[@data-bb-handler='confirm'][text()='Yes']")));
		
		driver.findElement(By.xpath("//BUTTON[@data-bb-handler='confirm'][text()='Yes']")).click();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
	}

}
