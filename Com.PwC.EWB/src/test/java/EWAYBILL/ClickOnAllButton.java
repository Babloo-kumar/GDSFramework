package EWAYBILL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ClickOnAllButton extends Login

{
	@Test
	public static void ClickOnEWB() throws InterruptedException 
	{
		 
		 Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
		 
	     Actions action = new Actions(driver);
	     action.moveToElement(Element).build().perform();
		
	     Thread.sleep(100);
	     
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//*[@id='lnkGenerate']")).click();
	      
	    Thread.sleep(1000); 
	    
         Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
		 
	     Actions UpdatedVehicle = new Actions(driver);
	     UpdatedVehicle.moveToElement(Element).build().perform();
	     
	     //WebDriverWait wait=new WebDriverWait(driver, 10);
	     //Element=wait.until(ExpectedConditions.elementToBeClickable(By.id("lnkUpdateVehicle")));
	     //Element.click();
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("(//*[text()='Update Vehicle'][text()='Update Vehicle'])[1]")).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	     
         Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
	     Actions Cancel = new Actions(driver);
	     Cancel.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("(//*[text()='Cancel'][text()='Cancel'])[1]")).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	     
         Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
	     Actions Extend = new Actions(driver);
	     Extend.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("(//SPAN[text()='Extend'])[1]")).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	     

         Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
	     Actions UpdateMovement = new Actions(driver);
	     UpdateMovement.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//*[@class='update_movement_left'][text()='Update Movement']")).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	     
	     Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
	     Actions Reject = new Actions(driver);
	     Reject.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("(//*[text()='Reject'])[1]")).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	     
	     Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
	     Actions AllEWB = new Actions(driver);
	     AllEWB.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//*[@id='lnkAllEWB']")).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	     
	     Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
	     Actions Exclude= new Actions(driver);
	     Exclude.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//*[@id='lnkExcluded']")).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	     
	     
	     Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
	     Actions Unmapped= new Actions(driver);
	     Unmapped.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("(//*[text()='Unmapped'])[1]")).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	     
	    /*Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
	     Actions AllEWBCP= new Actions(driver);
	     AllEWBCP.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//*[@id=\"lnkAllEWBCp\"]")).click();
	     Thread.sleep(500);*/
	     
	     
	     Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
	     Actions OflineData= new Actions(driver);
	     OflineData.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("(//SPAN[text()='Offline Data'])[1]")).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	     
	     Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
	     Actions AllCEWB= new Actions(driver);
	     AllCEWB.moveToElement(Element).build().perform();
	     Element = driver.findElement(By.xpath("(//SPAN[text()='Consolidate'])[1]"));
	     Actions AllCEWB1= new Actions(driver);
	     AllCEWB1.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("(//*[text()='Generate'][text()='Generate'])[2]")).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	     
	}
	@Test(priority = 1)
	public static void Data() throws Exception 
	{
		
         Element = driver.findElement(By.xpath(".//*[@id='containerMenuDiv']/div[2]/div/div/ul[2]/li[2]/a"));
		 
	     Actions DataUpload = new Actions(driver);
	     DataUpload.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//*[@id=\"lnkDataUpload\"]")).click();
	     Thread.sleep(2000);
		
         Element = driver.findElement(By.xpath(".//*[@id='containerMenuDiv']/div[2]/div/div/ul[2]/li[2]/a"));
	     Actions DataDownload = new Actions(driver);
	     DataDownload.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//*[@id=\"lnkDataDownload\"]")).click();
	     Thread.sleep(2000);
		
         Element = driver.findElement(By.xpath(".//*[@id='containerMenuDiv']/div[2]/div/div/ul[2]/li[2]/a"));
	     Actions AddNew = new Actions(driver);
	     AddNew.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//*[@id='lnkAddnewnav']")).click();
	     Thread.sleep(2000);
		
	     Element = driver.findElement(By.xpath(".//*[@id='containerMenuDiv']/div[2]/div/div/ul[2]/li[2]/a"));
	     Actions Reconciliation = new Actions(driver);
	     Reconciliation.moveToElement(Element).build().perform();
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//*[text()='Data Reconciliation']")).click();
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
	}
	
	 
	
	
	
	

}
