package EWAYBILL;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllNicAction extends Login

{       
	    @Test
        public static void GenerateGrid() throws Exception 
        {
        	
        	 Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
    		 
             action = new Actions(driver);
             action.moveToElement(Element).build().perform();
             Thread.sleep(100);
             
            driver.findElement(By.xpath("//*[@id=\"lnkGenerate\"]")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
            
            Select bulkgenerate = new Select(driver.findElement(By.xpath(".//*[@id='ddlOperation']")));
    		bulkgenerate.selectByVisibleText("Generate");
    		Thread.sleep(1000);
    		WebDriverWait wait7 = new WebDriverWait(driver, 20);
    		wait7.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#check-box-main")));  
    	  	Element = driver.findElement(By.cssSelector("#check-box-main"));
    		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Element);
    		Thread.sleep(3000);
    		driver.findElement(By.xpath(".//*[@id='btnapply']")).click();
    		Thread.sleep(1000);
            String Updated=  driver.findElement(By.xpath("//div[@class='bootbox-body']")).getText();
    	    WebDriverWait wait1 = new WebDriverWait(driver, 20);
    	    wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='button']")));
    		Thread.sleep(1000);
    		
    	    driver.findElement(By.xpath("//*[@type='button']")).click();
    	    driver.switchTo().frame("rel_xpath_popup");
    	    driver.findElement(By.xpath("(//BUTTON[@type='button'][text()='×'][text()='×'])[5]")).click();
    	    driver.switchTo().defaultContent();
    	    Thread.sleep(1000);
    		Assert.assertEquals(Updated, "E-way bill generation has been initiated"); 
    		
      }
	
	@Test(priority = 1)
    public static void AllEWB() throws Exception 
    
    {
    	
    	/*Element = driver.findElement(By.xpath("//*[@id=\"containerMenuDiv\"]/div[2]/div/div/ul[2]/li[1]/a"));
		 
        action = new Actions(driver);
        action.moveToElement(Element).build().perform();
        Thread.sleep(100);
        */
       driver.findElement(By.xpath("//span[text()='Update Vehicle']")).click();
       driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
    	
    	
    	
    	
    	
    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
