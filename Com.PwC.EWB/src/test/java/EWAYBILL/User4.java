package EWAYBILL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class User4 {
public ChromeDriver driver ; 
	
    @BeforeTest
    
    public void LoginAsAdmin() throws InterruptedException, IOException{
	System.setProperty("webdriver.chrome.driver","E://Mobifly_Software//chromedriver_win32//chromedriver.exe" );	 
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
    String BaseURL= "https://preprod.ewb-aws.pwc.co.in/web1";
	driver.navigate().to(BaseURL);

    driver.findElementById("username").sendKeys("Admin4");
	driver.findElementById("password").sendKeys("P@ss1234");
	driver.findElementByXPath(".//*[@id='login']").click();
	
    }
    @Test(priority = 1,invocationCount = 10,description = "Eway Bill Generation..")
	public void EwayBillGeneration() throws InterruptedException, IOException {
    	
		
		ArrayList<String> filesPath = new ArrayList<String>();

		filesPath.add(".//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[1]/td[1]/input[1]");
		filesPath.add(".//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[2]/td[1]/input[1]");
		filesPath.add(".//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[3]/td[1]/input[1]");
		filesPath.add(".//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[4]/td[1]/input[1]");
		filesPath.add(".//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[5]/td[1]/input[1]");
		filesPath.add(".//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[6]/td[1]/input[1]");
		filesPath.add(".//*[@id='table1_wrapper']/div[4]/div[3]/div[2]/div/table/tbody/tr[7]/td[1]/input[1]");
       for(int i=0;i<7;i++) {
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
			this.checkbox(filesPath.get(i));
		
				WebDriverWait wait1 = new WebDriverWait(driver, 20);
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='bootbox-close-button close']")));
				//driver.findElementByXPath("html/body/div[5]/div/div/div[3]/button[2]").click();
				Thread.sleep(1000);
				driver.findElementByXPath(".//*[@class='bootbox-close-button close']").click();
				Thread.sleep(1000);
				
	}
	
			
   }
   
   private void checkbox(String filesPath) throws InterruptedException, IOException {

	   this.GotoEWB();
		Thread.sleep(1000);
		WebDriverWait wait0 = new WebDriverWait(driver, 20);
		wait0.until(ExpectedConditions.presenceOfElementLocated(By.xpath(filesPath)));
		WebElement check1 = driver.findElementByXPath(filesPath);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", check1);
		Thread.sleep(1000);
		driver.findElementByXPath(".//*[@id='btnapply']").click();
		Thread.sleep(2000);
		boolean confirmation = driver.findElement(By.xpath(".//*[@class='bootbox-body']")).getText() != null;
		//System.out.println(confirmation);

   }
		

	private void GotoEWB() throws InterruptedException {
		WebDriverWait wait0 = new WebDriverWait(driver, 10);
		wait0.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@id='containerMenuDiv']/div[2]/div/div/ul[2]/li[1]/a")));
		WebElement ewb = driver.findElementByXPath(".//*[@id='containerMenuDiv']/div[2]/div/div/ul[2]/li[1]/a");
		Actions actions = new Actions(driver);
		actions.moveToElement(ewb).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath(".//*[@id='containerMenuDiv']/div[2]/div/div/ul[2]/li[1]/ul/li[1]/a")));
		WebElement generate = driver
				.findElement(By.xpath(".//*[@id='containerMenuDiv']/div[2]/div/div/ul[2]/li[1]/ul/li[1]/a"));
		generate.click();
		Thread.sleep(1000);

	}


	

@AfterTest(alwaysRun = true)
public void CloseBrowser(){

            driver.close();
}
}







