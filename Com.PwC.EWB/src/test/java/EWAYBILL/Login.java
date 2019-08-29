package EWAYBILL;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
public class Login
{
	public static WebDriver driver;
	public static Boolean element;
	public static Actions action;
	public static WebElement Element;
	public static WebDriverWait wait;
   @BeforeTest
	public static void login() throws InterruptedException 
	{
	    System.out.println("====== Lunch Browser====== ");
    	System.setProperty("webdriver.chrome.driver","E:/PwC/Com.PwC.EWB/Driver/Chrome/chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://qa-win-639340329.ap-south-1.elb.amazonaws.com/web1/");
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys("Admin1");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("P@ss1234");
		driver.findElement(By.xpath(".//*[@id='login']")).click();
		Thread.sleep(2000);
		
	    /*Element = driver.findElement(By.xpath(".//*[@id='containerMenuDiv']/div[2]/div/div/ul[2]/li[2]/a"));
		 
        Actions action = new Actions(driver);
        action.moveToElement(Element).build().perform();
		
        
        driver.findElement(By.xpath(".//*[@id='lnkAddnewnav']")).click();
        Thread.sleep(1000);*/
	}
   
  @AfterTest
   public static void Closebrowser() throws InterruptedException
   {
	   
	    WebDriverWait wait=new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//H1[@class='font-40 font_georgia'][text()='PwC EWB Solution']")));
	   
	   //driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES); 
	    Thread.sleep(1000);
	    	
	   driver.close();
	   System.out.println("=============End of AddNew============");
   }
   

}
